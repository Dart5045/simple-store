package com.inditex.store.service.domain.ports.output.repository;


import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.BrandId;
import com.inditex.domain.valueobject.ProductId;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository {

    List<Price> findPrices(
            ProductId productId,
            BrandId brandId,
            LocalDateTime dateRequest);
}
