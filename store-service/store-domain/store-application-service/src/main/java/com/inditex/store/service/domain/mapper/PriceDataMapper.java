package com.inditex.store.service.domain.mapper;

import com.inditex.domain.entity.Price;
import com.inditex.store.service.domain.dto.price.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceDataMapper {
    public PriceResponse priceToPriceResponse(Price price) {
        return PriceResponse
                .builder()
                .productId(price.getProductId().getValue())
                .priceList(price.getPriceList().getValue())
                .finalPrice(price.getPrice().getAmount())
                .build();
    }
}
