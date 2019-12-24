package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponse;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductResponseModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateTypeProductResponseModel;

@Mapper
public abstract class ProductResponseMapper
{

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	public abstract ProductResponse getProductResponseFromCreateProductResponseModel(
			CreateProductResponseModel model );

	public abstract ProductResponseModel getProductResponseModelFromProductResponse( ProductResponse response );

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "productRequestId", ignore = true)
	@Mapping(target = "responseTypeId", ignore = true)
	@Mapping(target = "deadline", ignore = true)
	@Mapping(target = "ownerId", ignore = true)
	@Mapping(target = "lenderId", ignore = true)
	public abstract ProductResponse getProductResponseFromUpdateTypeProductResponseModel(
			UpdateTypeProductResponseModel model );

}
