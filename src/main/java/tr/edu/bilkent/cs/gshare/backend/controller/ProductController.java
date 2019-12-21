package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.domain.Product;
import tr.edu.bilkent.cs.gshare.backend.model.product.CreateProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.ProductModel;
import tr.edu.bilkent.cs.gshare.backend.service.ProductService;

@RestController
@RequestMapping("product/")
public class ProductController
{
	@Autowired
	ProductService service;

	@PostMapping("create/")
	public ProductModel createProduct( CreateProductModel model )
	{
		return service.createProduct( model );
	}

	@GetMapping("getAll/")
	public List<Product> getAllProduct()
	{
		return service.getAllProduct();
	}
}
