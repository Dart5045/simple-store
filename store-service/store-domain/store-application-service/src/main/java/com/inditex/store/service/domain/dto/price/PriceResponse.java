package com.inditex.store.service.domain.dto.price;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PriceResponse {

    @NotNull
    private final Long productId;

    @NotNull
    private final Long priceList;

    @NotNull
    private BigDecimal finalPrice;
}
