package com.inditex.store.service.dataaccess.brand.mapper;

import com.inditex.domain.entity.Brand;
import com.inditex.domain.valueobject.BrandId;
import com.inditex.store.service.dataaccess.brand.entity.BrandEntity;
import org.springframework.stereotype.Component;

@Component
public class BrandDataAccessMapper {

    public Brand brandEntityToBrand(BrandEntity brandEntity) {
        return new Brand(new BrandId(brandEntity.getId()),
                brandEntity.getBrandName());
    }
}
