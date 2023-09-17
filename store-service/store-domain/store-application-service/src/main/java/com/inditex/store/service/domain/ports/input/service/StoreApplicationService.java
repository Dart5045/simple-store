package com.inditex.store.service.domain.ports.input.service;

import com.inditex.store.service.domain.dto.price.PriceQuery;
import com.inditex.store.service.domain.dto.price.PriceResponse;

import jakarta.validation.Valid;

public interface StoreApplicationService {
    PriceResponse getPrice(@Valid PriceQuery priceQuery);
}
