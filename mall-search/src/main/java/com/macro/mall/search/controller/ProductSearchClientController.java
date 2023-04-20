package com.macro.mall.search.controller;

import com.macro.mall.search.constant.EsConstant;
import com.macro.mall.search.domain.Product;
import com.macro.mall.search.index.MappingProperty;
import com.macro.mall.search.operation.EsIndexOperation;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductSearchClientController {
    @Resource
    private RestHighLevelClient restHighLevelClient;
    @Resource
    private EsIndexOperation esIndexOperation;

    @GetMapping("/createIndex")
    public String createIndex(String indexName) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("id", new MappingProperty(MappingProperty.INTEGER));
        properties.put("companyName", new MappingProperty(MappingProperty.TEXT));
        properties.put("tel", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("tax", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("mobile", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("responsible", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("contact", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("position", new MappingProperty(MappingProperty.TEXT));
        properties.put("address", new MappingProperty(MappingProperty.TEXT));
        properties.put("postCode", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("economicType", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("registeredCapital", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("operationMode", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("annualSales", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("buildDate", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("numberOfWorkers", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("email", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("mainBusiness", new MappingProperty(MappingProperty.TEXT));
        properties.put("mainProduct", new MappingProperty(MappingProperty.TEXT));
        properties.put("website", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("createdDt", new MappingProperty(MappingProperty.DATE));
        properties.put("createdBy", new MappingProperty(MappingProperty.KEYWORD));
        properties.put("updatedDt", new MappingProperty(MappingProperty.DATE));
        properties.put("updatedBy", new MappingProperty(MappingProperty.KEYWORD));
        boolean company = esIndexOperation.createIndex(indexName, properties);
        return company ? "success" : "fail";
    }

    @GetMapping("/createProductIndex")
    public String createProductIndex(String indexName) {
        boolean company = esIndexOperation.createIndex(indexName, Product.buildMapping());
        return company ? "success" : "fail";
    }

    @GetMapping("/deleteIndex")
    public Boolean deleteIndexCompany(String index) {
        return esIndexOperation.deleteIndex(index);
    }



}
