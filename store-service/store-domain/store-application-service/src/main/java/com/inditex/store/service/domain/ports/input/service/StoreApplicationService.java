package com.inditex.store.service.domain.ports.input.service;

import com.inditex.store.service.domain.dto.price.PriceQuery;
import com.inditex.store.service.domain.dto.price.PriceResponse;

import jakarta.validation.Valid;

import java.time.LocalDateTime;

public interface StoreApplicationService {
    PriceResponse getPrice(Long productId, Integer brandId, LocalDateTime dateRequest);
}
