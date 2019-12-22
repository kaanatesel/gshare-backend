package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;

import io.swagger.models.auth.In;
import tr.edu.bilkent.cs.gshare.backend.domain.ProductRequest;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductRequestModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductRequestModel;
import tr.edu.bilkent.cs.gshare.backend.service.ProductRequestService;

@RestController
@RequestMapping("productrequest/")
public class ProductRequestContoller
{
	@Autowired
	ProductRequestService service;

	@PostMapping("create/")
	public ProductRequestModel create( CreateProductRequestModel model )
	{
		return service.create( model );
	}

	@GetMapping("findAllByOwnerId/{ownerId}")
	public List<ProductRequest> findAllByOwnerIdAndActive(
			@PathVariable(name = "ownerId", required = true) Integer ownerId )
	{
		return service.findAllByOwnerId( ownerId );
	}

	@GetMapping("findMemberAll/{memberId}")
	public List<ProductRequest> findMemberAll( @PathVariable(name = "memberId", required = true) Integer memberId )
	{
		return service.findMemberAll( memberId );
	}

	@PutMapping("delete/{productRequestId}")
	public void delete( @PathVariable(name = "productRequestId", required = true) Integer productRequestId )
	{
		service.delete( productRequestId );
	}
	
	

}
