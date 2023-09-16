package com.inditex.store.service.dataaccess.price.adapter;


import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.ProductId;
import com.inditex.store.service.dataaccess.price.mapper.PriceDataAccessMapper;
import com.inditex.store.service.dataaccess.price.repository.PriceJpaRepository;
import com.inditex.store.service.domain.ports.output.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceJpaRepository studentJpaRepository;
    private final PriceDataAccessMapper priceDataAccessMapper;

    public PriceRepositoryImpl(PriceJpaRepository studentJpaRepository, PriceDataAccessMapper priceDataAccessMapper) {
        this.studentJpaRepository = studentJpaRepository;
        this.priceDataAccessMapper = priceDataAccessMapper;
    }


    @Override
    public Optional<Price> findByProductId(ProductId productId) {
        return studentJpaRepository.findByProductId(productId.getValue())
                .map(priceDataAccessMapper::priceEntityToPrice);
    }
}
