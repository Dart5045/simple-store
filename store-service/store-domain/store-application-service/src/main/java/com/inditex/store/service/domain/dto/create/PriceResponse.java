package com.inditex.store.service.domain.dto.create;

import com.inditex.domain.valueobject.Money;
import com.inditex.domain.valueobject.ProductId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class PriceResponse {

    @NotNull
    private final ProductId productId;

    @NotNull
    private final LocalDateTime startDate;

    @NotNull
    private final LocalDateTime endDate;

    @NotNull
    private Money price;
}
