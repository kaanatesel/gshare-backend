package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponse;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateTypeProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.service.ProductResponseService;

@RestController
@RequestMapping("productresponse/")
public class ProductResponseController
{
	@Autowired
	ProductResponseService service;

	@PostMapping("create/")
	public ProductResponseModel create( CreateProductResponseModel model )
	{
		return service.create( model );
	}

	@GetMapping("getById/{proResponseId}")
	public ProductResponseModel getById( @PathVariable(name = "proResponseId", required = true) Integer proResponseId )
	{
		return service.findById( proResponseId );
	}

	@PutMapping("updateStatus/")
	public ProductResponseModel updateStatus( UpdateTypeProductResponseModel model )
	{
		return service.updateStatus( model );
	}

	@DeleteMapping("delete/{productReponseId}")
	public void delete( @PathVariable(name = "productReponseId", required = true) Integer productReponseId )
	{
		service.delete( productReponseId );
	}

	@GetMapping("getByMemberId/{memberID}")
	public List<ProductResponse> getByMemberId( @PathVariable(name = "memberID", required = true) Integer memberID )
	{
		return service.getbyMemberId( memberID );
	}
}
