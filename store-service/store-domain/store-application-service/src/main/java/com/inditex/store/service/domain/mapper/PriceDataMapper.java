package com.inditex.store.service.domain.mapper;

import com.inditex.domain.entity.Price;
import com.inditex.store.service.domain.dto.price.PriceResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PriceDataMapper {
    public PriceResponse priceToPriceResponse(Price price,  LocalDateTime dateRequest) {
        return PriceResponse
                .builder()
                .productId(price.getProductId().getValue())
                .brandId(price.getBrandId().getValue())
                .finalPrice(price.getPrice().getAmount())
                .priceList(price.getPriceList().getValue())
                .dateRequest(dateRequest)
                .build();
    }
}
