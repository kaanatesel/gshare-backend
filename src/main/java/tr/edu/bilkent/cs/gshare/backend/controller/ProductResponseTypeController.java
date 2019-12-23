package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponseType;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductResponseTypeModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductResponseTypeModel;
import tr.edu.bilkent.cs.gshare.backend.service.ProductResponseTypeService;

@RestController
@RequestMapping("productresponsetype/")
public class ProductResponseTypeController
{
	@Autowired
	ProductResponseTypeService service;

	@PostMapping("create/")
	public ProductResponseType create( ProductResponseType type )
	{
		return service.create( type );
	}

	@GetMapping("findAll/")
	public List<ProductResponseType> findAll()
	{
		return service.findAll();
	}

	@GetMapping("findbyid/{id}")
	public ProductResponseTypeModel findById( @PathVariable(name = "id", required = true) Integer id )
	{
		return service.findById( id );
	}

	@DeleteMapping("delete/{id}")
	public void delete( @PathVariable(name = "id", required = true) Integer id )
	{
		service.delete( id );
	}
}
