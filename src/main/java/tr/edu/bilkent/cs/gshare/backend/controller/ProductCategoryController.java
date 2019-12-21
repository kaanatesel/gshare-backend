package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import javax.swing.text.html.ListView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductCategory;
import tr.edu.bilkent.cs.gshare.backend.service.ProductCategoryService;

@RestController
@RequestMapping("productcategory/")
public class ProductCategoryController
{

	@Autowired
	ProductCategoryService service;

	@PostMapping(value = "create")
	public ProductCategory createProductCategory( ProductCategory model )
	{
		return service.createProductCategory( model );
	}

	@GetMapping(value = "{categoryId}/")
	public ProductCategory getCategoryById( @PathVariable(value = "categoryId", required = true) Integer categoryId )
	{
		return service.getCategoryById( categoryId );
	}

	@GetMapping(value = "getAll/")
	public List<ProductCategory> getAllCategories()
	{
		return service.getAllCategories();
	}

	@DeleteMapping(value = "delete/{categoryId}")
	public void deleteCategory( @PathVariable(value = "categoryId", required = true) Integer categoryId )
	{
		service.delete( categoryId );
	}

}
