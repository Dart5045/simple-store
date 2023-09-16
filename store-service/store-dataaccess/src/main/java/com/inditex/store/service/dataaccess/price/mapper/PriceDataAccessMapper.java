package com.inditex.store.service.dataaccess.price.mapper;

import com.inditex.domain.entity.Brand;
import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.BrandId;
import com.inditex.store.service.dataaccess.price.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceDataAccessMapper {


    public Price priceEntityToPrice(PriceEntity priceEntity) {
        return Price
                .builder()
                .build();
    }
}
