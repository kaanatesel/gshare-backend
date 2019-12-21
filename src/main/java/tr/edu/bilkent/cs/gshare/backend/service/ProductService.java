package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.Product;
import tr.edu.bilkent.cs.gshare.backend.mapper.ProductMapper;
import tr.edu.bilkent.cs.gshare.backend.model.product.CreateProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.ProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.UpdateProductModel;
import tr.edu.bilkent.cs.gshare.backend.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	ProductRepository repository;

	@Autowired
	ProductMapper mapper;

	public ProductModel createProduct( CreateProductModel model )
	{
		Product product = mapper.getProductFromCreateProductModel( model );
		repository.save( product );
		ProductModel productModel = mapper.getProductModelFromProduct( product );
		return productModel;
	}

	public List<Product> getAllProduct()
	{
		List<Product> list = ( List<Product> ) repository.findAll();
		return list;
	}

	public List<Product> findProductByMemeberId( Integer memberId )
	{
		List<Product> list = repository.findByMemberId( memberId );
		return list;
	}

	public ProductModel updateProduct( UpdateProductModel model )
	{
		Product product = repository.findById( model.getId() )
				.orElseThrow( () -> new RuntimeException( "Cannot find product with id " + +model.getId() ) );

		mapper.getProductModelFromUpdateProductModel( product, model );

		repository.save( product );

		ProductModel prModel = mapper.getProductModelFromProduct( product );
		return prModel;
	}

	public void deleteProduct( Integer productId )
	{
		Product product = repository.findById( productId )
				.orElseThrow( () -> new RuntimeException( "Cannot find product with id " + productId ) );
		repository.delete( product );
	}

	public ProductModel findByProductId( Integer productId )
	{
		Product product = repository.findById( productId )
				.orElseThrow( () -> new RuntimeException( "Cannot find product with id " + productId ) );

		ProductModel model = mapper.getProductModelFromProduct( product );

		return model;
	}

}
