package com.inditex.store.service.domain.dto.price;

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
    private final Long productId;

    @NotNull
    private final Integer brandId;
}
