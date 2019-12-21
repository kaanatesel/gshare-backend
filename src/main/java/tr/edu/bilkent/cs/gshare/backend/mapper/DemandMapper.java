package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import tr.edu.bilkent.cs.gshare.backend.domain.Demand;
import tr.edu.bilkent.cs.gshare.backend.model.CreateDemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.DemandModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateDemandModel;

@Mapper
public abstract class DemandMapper
{

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	public abstract Demand getDemandFromCreateDemandModel( CreateDemandModel model );

	public abstract DemandModel getDemandModelFromDemand( Demand demand );

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "requesterId", ignore = true)
	public abstract DemandModel getDemandModelFormUpdateDemandModel( @MappingTarget DemandModel demandModel,
			UpdateDemandModel model );

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "requesterId", ignore = true)
	public abstract Demand getDemandFromUpdateDemandModel( @MappingTarget Demand demand, UpdateDemandModel model );

}
