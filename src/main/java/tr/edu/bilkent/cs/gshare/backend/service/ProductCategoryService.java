package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductCategory;
import tr.edu.bilkent.cs.gshare.backend.mapper.ProductCategoryMapper;
import tr.edu.bilkent.cs.gshare.backend.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService
{
	@Autowired
	ProductCategoryRepository repository;

	@Autowired
	ProductCategoryMapper mapper;

	public ProductCategory createProductCategory( ProductCategory model )
	{
		repository.save( model );
		return model;
	}

	public ProductCategory getCategoryById( int id )
	{
		ProductCategory category = repository.findById( id )
				.orElseThrow( () -> new RuntimeException( "Cannot find category with id: " + id ) );
		return category;
	}

	public List<ProductCategory> getAllCategories()
	{
		List<ProductCategory> categories = ( List<ProductCategory> ) repository.findAll();
		return categories;
	}

	public void delete( Integer categoryId )
	{
		repository.deleteById( categoryId );
	}
}
