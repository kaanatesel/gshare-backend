package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductRequest;
import tr.edu.bilkent.cs.gshare.backend.mapper.ProductRequestMapper;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductRequestModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductRequestModel;
import tr.edu.bilkent.cs.gshare.backend.repository.ProductRequestRepository;

@Service
public class ProductRequestService
{
	@Autowired
	ProductRequestMapper mapper;

	@Autowired
	ProductRequestRepository repository;

	public ProductRequestModel create( CreateProductRequestModel model )
	{
		ProductRequest productRequest = mapper.getProductRequestFromCreateProductRequestModel( model );
		repository.save( productRequest );
		ProductRequestModel productRequestModel = mapper.getProductRequestModelFromProductRequest( productRequest );
		return productRequestModel;
	}

	public List<ProductRequest> findMemberAll( Integer memberId )
	{
		List<ProductRequest> listRequestOwner = repository.findByOwnerIdAndActive( memberId, true );
		List<ProductRequest> listRequestRequester = repository.findByRequesterIdAndActive( memberId, true );
		listRequestOwner.addAll( listRequestRequester );
		return listRequestOwner;
	}

	public List<ProductRequest> findAllByOwnerId( Integer requesterId )
	{
		List<ProductRequest> listProductRequest = repository.findByRequesterIdAndActive( requesterId, true );
		return listProductRequest;
	}

	public void delete( Integer productRequestId )
	{
		ProductRequest request = repository.findById( productRequestId )
				.orElseThrow( () -> new RuntimeException( "Cannot find product request with id" + productRequestId ) );
		request.setActive( false );
		repository.save( request );
	}

}
