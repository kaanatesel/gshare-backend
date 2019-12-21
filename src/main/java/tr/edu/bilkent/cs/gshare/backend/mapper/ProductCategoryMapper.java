package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductCategory;
import tr.edu.bilkent.cs.gshare.backend.model.CreateProductCategoryModel;

@Mapper
public abstract class ProductCategoryMapper
{

	public abstract ProductCategory getProductCategoryFromCreateProductCategoryModel(
			CreateProductCategoryModel model );

}
