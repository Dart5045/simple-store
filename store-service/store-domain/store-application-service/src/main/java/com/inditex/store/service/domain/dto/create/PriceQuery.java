package com.inditex.store.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PriceQuery {
    @NotNull
    private final LocalDateTime dateRequest;

    @NotNull
    private final Double productId;

    @NotNull
    private final Double priceList;
}
