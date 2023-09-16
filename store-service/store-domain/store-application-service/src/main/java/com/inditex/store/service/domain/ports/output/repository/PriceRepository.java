package com.inditex.store.service.domain.ports.output.repository;


import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.PriceId;
import com.inditex.domain.valueobject.ProductId;

import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findByProductId(ProductId productId);
}
