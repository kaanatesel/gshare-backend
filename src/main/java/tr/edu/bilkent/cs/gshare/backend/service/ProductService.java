package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.Product;
import tr.edu.bilkent.cs.gshare.backend.domain.ProductCategory;
import tr.edu.bilkent.cs.gshare.backend.mapper.ProductMapper;
import tr.edu.bilkent.cs.gshare.backend.model.product.CreateProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.ProductModel;
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

}
