package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import tr.edu.bilkent.cs.gshare.backend.domain.Product;
import tr.edu.bilkent.cs.gshare.backend.model.product.CreateProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.ProductModel;
import tr.edu.bilkent.cs.gshare.backend.model.product.UpdateProductModel;

@Mapper
public abstract class ProductMapper
{

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", ignore = true)
	public abstract Product getProductFromCreateProductModel( CreateProductModel model );

	public abstract ProductModel getProductModelFromProduct( Product model );

	@Mapping(target = "memberId", ignore = true)
	public abstract void getProductModelFromUpdateProductModel( @MappingTarget Product product,
			UpdateProductModel model );
}
