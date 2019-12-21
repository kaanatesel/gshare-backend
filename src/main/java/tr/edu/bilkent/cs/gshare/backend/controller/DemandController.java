package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.domain.Demand;
import tr.edu.bilkent.cs.gshare.backend.model.CreateDemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.DemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateDemandModel;
import tr.edu.bilkent.cs.gshare.backend.service.DemandService;

@RestController
@RequestMapping("demand/")
public class DemandController
{
	@Autowired
	DemandService service;

	@PostMapping("create/")
	public DemandModel createDemand( CreateDemandModel model )
	{
		return service.create( model );
	}

	@GetMapping("{demandId}/")
	public DemandModel findByIdAndActive( @PathVariable(name = "demandId", required = true) Integer demandId )
	{
		return service.findByIdAndActive( demandId );
	}

	@GetMapping("findAll/")
	public List<Demand> findAll()
	{
		return service.findAll();
	}

	@GetMapping("findAllByCategoryId/{categoryId}")
	public List<Demand> findAllByCategoryId( @PathVariable(name = "categoryId", required = true) Integer categoryId )
	{
		return service.findAllByCategoryId( categoryId );
	}

	@GetMapping("findAllByMemberId/{memberId}")
	public List<Demand> findAllByMemberId( @PathVariable(name = "memberId", required = true) Integer memberId )
	{
		return service.findAllByMemberId( memberId );
	}

	@PutMapping("update/{demandId}")
	public DemandModel updateDemand( UpdateDemandModel model )
	{
		return service.updateDemand( model );
	}

	@PutMapping("deleteDemand/{demandId}")
	public void deleteDemand( @PathVariable(name = "demandId", required = true) Integer demandId )
	{
		service.deleteDemand( demandId );
	}

}
