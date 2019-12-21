package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductRequest;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductRequestModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductRequestModel;

@Mapper
public abstract class ProductRequestMapper
{

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	public abstract ProductRequest getProductRequestFromCreateProductRequestModel( CreateProductRequestModel model );

	public abstract ProductRequestModel getProductRequestModelFromProductRequest( ProductRequest request );
}
