package com.inditex.store.service.dataaccess.price.mapper;

import com.inditex.domain.entity.Brand;
import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.*;
import com.inditex.store.service.dataaccess.price.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceDataAccessMapper {


    public Price priceEntityToPrice(PriceEntity priceEntity) {
        return Price
                .builder()
                .id(new PriceId(priceEntity.getId()))
                .priceList(new PriceList(priceEntity.getPriceList()))
                .productId(new ProductId(priceEntity.getProductId()))
                .brandId(new BrandId(priceEntity.getBrandId()))
                .price(new Money(priceEntity.getPrice()))
                .priority(priceEntity.getPriority())
                .build();
    }
}
