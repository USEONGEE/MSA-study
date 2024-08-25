package com.example.catalogservice.vo;

import com.example.catalogservice.dto.CatalogDto;
import com.example.catalogservice.entity.Catalog;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private Date createdAt;


    public static ResponseCatalog of(Catalog catalog) {
        ResponseCatalog responseCatalog = new ResponseCatalog();
        responseCatalog.setProductId(catalog.getProductId());
        responseCatalog.setUnitPrice(catalog.getUnitPrice());
        responseCatalog.setStock(catalog.getStock());
        responseCatalog.setProductName(catalog.getProductName());
        responseCatalog.setCreatedAt(catalog.getCreatedAt());

        return responseCatalog;
    }

}
