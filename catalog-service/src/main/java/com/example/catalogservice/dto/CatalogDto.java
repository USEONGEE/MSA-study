package com.example.catalogservice.dto;

import com.example.catalogservice.entity.Catalog;
import lombok.Data;

import java.io.Serializable;

@Data
public class CatalogDto implements Serializable {
    private String productId;
    private String productName;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public static CatalogDto of (Catalog catalog) {
        CatalogDto catalogDto = new CatalogDto();
        catalogDto.setProductId(catalog.getProductId());
        catalogDto.setProductName(catalog.getProductName());
        catalogDto.setUnitPrice(catalog.getUnitPrice());
        catalogDto.setQty(catalog.getStock());

        return catalogDto;
    }
}
