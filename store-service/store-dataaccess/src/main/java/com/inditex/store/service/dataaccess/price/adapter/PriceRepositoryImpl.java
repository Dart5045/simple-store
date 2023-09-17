package com.inditex.store.service.dataaccess.price.adapter;


import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.PriceList;
import com.inditex.domain.valueobject.ProductId;
import com.inditex.store.service.dataaccess.price.entity.PriceEntity;
import com.inditex.store.service.dataaccess.price.mapper.PriceDataAccessMapper;
import com.inditex.store.service.dataaccess.price.repository.PriceJpaRepository;
import com.inditex.store.service.domain.ports.output.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceJpaRepository studentJpaRepository;
    private final PriceDataAccessMapper priceDataAccessMapper;

    public PriceRepositoryImpl(PriceJpaRepository studentJpaRepository, PriceDataAccessMapper priceDataAccessMapper) {
        this.studentJpaRepository = studentJpaRepository;
        this.priceDataAccessMapper = priceDataAccessMapper;
    }


    @Override
    public List<Price> findPrices(
            ProductId productId,
            PriceList priceList,
            LocalDateTime dateRequest) {

        List<PriceEntity> priceEntities = studentJpaRepository.findPrices(
                productId.getValue(),
                priceList.getValue(),
                dateRequest
        );
        return priceEntities.stream()
                .map(priceDataAccessMapper::priceEntityToPrice)
                .collect(Collectors.toList());
    }
}
