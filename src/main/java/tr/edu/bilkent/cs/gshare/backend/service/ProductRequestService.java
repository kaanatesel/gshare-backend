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

	public List<ProductRequest> getMemberAll( Integer memberId )
	{
		List<ProductRequest> listProductRequest = repository.findByRequesterId( memberId );
		return listProductRequest;
	}

}
