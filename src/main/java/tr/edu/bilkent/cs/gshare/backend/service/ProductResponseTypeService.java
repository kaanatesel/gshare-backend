package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponseType;
import tr.edu.bilkent.cs.gshare.backend.mapper.ProductResponseTypeMapper;
import tr.edu.bilkent.cs.gshare.backend.model.ProductResponseTypeModel;
import tr.edu.bilkent.cs.gshare.backend.repository.ProductReponseTypeRepository;

@Service
public class ProductResponseTypeService
{
	@Autowired
	ProductResponseTypeMapper mapper;

	@Autowired
	ProductReponseTypeRepository repository;

	public ProductResponseType create( ProductResponseType type )
	{
		repository.save( type );
		return type;
	}

	public List<ProductResponseType> findAll()
	{
		List<ProductResponseType> list = ( List<ProductResponseType> ) repository.findAll();
		return list;
	}

	public ProductResponseTypeModel findById( Integer id )
	{
		ProductResponseType responseType = repository.findById( id )
				.orElseThrow( () -> new RuntimeException( "Cannot find product reponse type with id " + id ) );
		ProductResponseTypeModel productResponseTypeModel = mapper
				.getProductResponseTypeModelFromProductResponseType( responseType );
		return productResponseTypeModel;
	}

	public void delete( Integer id )
	{
		repository.deleteById( id );
	}

}
