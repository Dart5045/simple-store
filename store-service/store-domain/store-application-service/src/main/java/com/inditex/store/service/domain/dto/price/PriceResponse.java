package com.inditex.store.service.domain.dto.price;

import com.inditex.domain.valueobject.PriceList;
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
    private final Integer brandId;

    @NotNull
    private BigDecimal finalPrice;

    @NotNull
    private final LocalDateTime dateRequest;

    @NotNull
    private final Long priceList;
}
