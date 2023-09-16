package com.inditex.store.service.domain;

import com.inditex.domain.entity.Price;
import com.inditex.domain.exception.PriceNotFoundException;
import com.inditex.domain.valueobject.ProductId;
import com.inditex.store.service.domain.dto.create.PriceQuery;
import com.inditex.store.service.domain.dto.create.PriceResponse;
import com.inditex.store.service.domain.mapper.PriceDataMapper;
import com.inditex.store.service.domain.ports.input.service.StoreApplicationService;
import com.inditex.store.service.domain.ports.output.repository.PriceRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Valid
@Slf4j
public class StoreApplicationServiceImpl implements StoreApplicationService {

    private final PriceDataMapper priceDataMapper;

    private final PriceRepository priceRepository;

    public StoreApplicationServiceImpl(PriceDataMapper priceDataMapper, PriceRepository priceRepository) {
        this.priceDataMapper = priceDataMapper;
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse getPrice(PriceQuery priceQuery) {
        Optional<Price> priceResult =
                priceRepository.findByProductId(new ProductId(priceQuery.getProductId()));
        if (priceResult.isEmpty()) {
            log.warn("Could not find price with product id: {}", priceQuery.getProductId());
            throw new PriceNotFoundException("Could not find price with product id: " +
                    priceQuery.getProductId());
        }
        return priceDataMapper.priceToPriceResponse(priceResult.get());
    }
}
