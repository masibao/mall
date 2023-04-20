package com.macro.mall.search.domain;

import com.macro.mall.search.index.MappingProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@Data
public class Product {

    private Long id;
    private String productSn;
    private Long brandId;
    private String brandName;
    private Long productCategoryId;
    private String productCategoryName;
    private String pic;
    private String name;
    private String subTitle;
    private String keywords;
    private BigDecimal price;
    private Integer sale;
    private Integer newStatus;
    private Integer recommandStatus;
    private Integer stock;
    private Integer promotionType;
    private Integer sort;

    /**
     * 构造mapping
     * @return
     */
    public static Map<String,Object> buildMapping() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("id", new MappingProperty(MappingProperty.INTEGER));
        properties.put("productSn", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("brandId", new MappingProperty(MappingProperty.LONG));
        properties.put("brandName", new MappingProperty(MappingProperty.TEXT));
        properties.put("productCategoryId", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("productCategoryName", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("pic", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("price", new MappingProperty(MappingProperty.DOUBLE));
        properties.put("name", new MappingProperty(MappingProperty.TEXT));
        properties.put("subTitle", new MappingProperty(MappingProperty.TEXT));
        properties.put("keywords", new MappingProperty(MappingProperty.TEXT));
        properties.put("sale", new MappingProperty(MappingProperty.INTEGER));
        properties.put("newStatus", new MappingProperty(MappingProperty.INTEGER));
        properties.put("recommandStatus", new MappingProperty(MappingProperty.INTEGER));
        properties.put("stock", new MappingProperty(MappingProperty.INTEGER));
        properties.put("promotionType", new MappingProperty(MappingProperty.INTEGER));
        properties.put("sort", new MappingProperty(MappingProperty.INTEGER));
        return properties;
    }
}
