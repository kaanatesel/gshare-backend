package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponse;
import tr.edu.bilkent.cs.gshare.backend.mapper.ProductResponseMapper;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateTypeProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.repository.ProductResponseRepository;

@Service
public class ProductResponseService
{
	@Autowired
	ProductResponseMapper mapper;

	@Autowired
	ProductResponseRepository repository;

	public ProductResponseModel create( CreateProductResponseModel model )
	{
		ProductResponse productResponse = mapper.getProductResponseFromCreateProductResponseModel( model );
		repository.save( productResponse );
		ProductResponseModel responseModel = mapper.getProductResponseModelFromProductResponse( productResponse );
		return responseModel;
	}

	public ProductResponseModel findById( Integer proResponseId )
	{
		ProductResponse productResponse = repository.findById( proResponseId )
				.orElseThrow( () -> new RuntimeException( "Cannot find ProductResponse with id " + proResponseId ) );
		ProductResponseModel responseModel = mapper.getProductResponseModelFromProductResponse( productResponse );
		return responseModel;
	}

	public ProductResponseModel updateStatus( UpdateTypeProductResponseModel model )
	{
		ProductResponse productResponse = repository.findById( model.getId() )
				.orElseThrow( () -> new RuntimeException( "Cannot find ProductResponse with id " + model.getId() ) );

		ProductResponseModel responseModel = mapper.getProductResponseModelFromProductResponse( productResponse );
		return responseModel;
	}

	public void delete( Integer productReponseId )
	{
		repository.deleteById( productReponseId );
	}

	public List<ProductResponse> getbyMemberId( Integer memberID )
	{
		List<ProductResponse> ownerList = repository.findByOwnerId( memberID );
		List<ProductResponse> lenderList = repository.findByLenderId( memberID );
		ownerList.addAll( lenderList );
		return ownerList;
	}
}
