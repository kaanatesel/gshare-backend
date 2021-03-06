package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.Demand;
import tr.edu.bilkent.cs.gshare.backend.mapper.DemandMapper;
import tr.edu.bilkent.cs.gshare.backend.model.CreateDemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.DemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateActiveDemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateDemandModel;
import tr.edu.bilkent.cs.gshare.backend.repository.DemandRepository;

@Service
public class DemandService
{
	@Autowired
	DemandRepository repository;

	@Autowired
	DemandMapper mapper;

	public DemandModel create( CreateDemandModel model )
	{
		Demand demand = mapper.getDemandFromCreateDemandModel( model );
		repository.save( demand );
		DemandModel demandModel = mapper.getDemandModelFromDemand( demand );
		return demandModel;
	}

	public DemandModel findByIdAndActive( Integer demandId )
	{
		Demand demand = repository.findByIdAndActive( demandId, true )
				.orElseThrow( () -> new RuntimeException( "Cannot find demand with id " + demandId ) );
		DemandModel model = mapper.getDemandModelFromDemand( demand );
		return model;
	}

	public List<Demand> findAll()
	{
		Iterable<Demand> demandList = repository.findAll();
		List<Demand> list = new ArrayList<Demand>();
		demandList.forEach( list::add );
		return list;
	}

	public List<Demand> findAllByCategoryId( Integer categoryId )
	{
		List<Demand> demandsList = repository.findAllByCategoryIdAndActive( categoryId, true );
		return demandsList;
	}

	public List<Demand> findAllByMemberId( Integer requesterId )
	{
		List<Demand> demandList = repository.findAllByRequesterIdAndActive( requesterId, true );
		return demandList;
	}

	public DemandModel updateDemand( UpdateDemandModel model )
	{
		Demand demand = repository.findByIdAndActive( model.getId(), true )
				.orElseThrow( () -> new RuntimeException( "Cannot find demand with id " + model.getId() ) );

		mapper.getDemandFromUpdateDemandModel( demand, model );

		repository.save( demand );
		DemandModel demandModel = mapper.getDemandModelFromDemand( demand );
		return demandModel;
	}

	public void deleteDemand( Integer demandId )
	{
		Demand demand = repository.findByIdAndActive( demandId, true )
				.orElseThrow( () -> new RuntimeException( "Cannot find demand with id " + demandId ) );
		demand.setActive( false );
	}

	public List<Demand> findAllByMemberIdAndDisactive( Integer memberId )
	{
		List<Demand> demandList = repository.findAllByRequesterIdAndActive( memberId, false );
		return demandList;
	}

	public DemandModel updateActive( UpdateActiveDemandModel model )
	{
		Demand demand = repository.findById( model.getId() )
				.orElseThrow( () -> new RuntimeException( "Cannot find demand with id " + model.getId() ) );
		demand.setActive( model.getActive() );
		repository.save( demand );
		DemandModel demandModel = mapper.getDemandModelFromDemand( demand );
		return demandModel;
	}
}
