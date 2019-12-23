package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponseType;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductResponseTypeModel;
import tr.edu.bilkent.cs.gshare.backend.model.ProductResponseTypeModel;

@Mapper
public abstract class ProductResponseTypeMapper
{
	public abstract ProductResponseType getProductResponseTypeFromCreateProductResponseTypeModel(
			CreateProductResponseTypeModel model );

	public abstract ProductResponseTypeModel getProductResponseTypeModelFromProductResponseType(
			ProductResponseType productResponseType );

}
