package com.inditex.store.service.domain.mapper;

import com.inditex.domain.entity.Price;
import com.inditex.store.service.domain.dto.create.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceDataMapper {
    public PriceResponse priceToPriceResponse(Price price) {
        return PriceResponse
                .builder()
                //.productId(price.getId())
                .build();
    }
}
