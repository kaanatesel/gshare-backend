package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tr.edu.bilkent.cs.gshare.backend.domain.Product;
import tr.edu.bilkent.cs.gshare.backend.model.product.CreateProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.ProductModel;

@Mapper
public abstract class ProductMapper
{

	@Mapping(target = "id", ignore = true)
	public abstract Product getProductFromCreateProductModel( CreateProductModel model );

	public abstract ProductModel getProductModelFromProduct( Product model );
}
