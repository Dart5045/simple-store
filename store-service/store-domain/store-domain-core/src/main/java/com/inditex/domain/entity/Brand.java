package com.inditex.domain.entity;

import com.inditex.domain.valueobject.BrandId;

public class Brand extends BaseEntity<BrandId>{
    private final String brandName;

    public Brand(BrandId brandId, String brandName) {
        super.setId(brandId);
        this.brandName=brandName;
    }
}
