package com.inditex.store.service.domain;

import com.inditex.domain.entity.Price;
import com.inditex.domain.exception.PriceNotFoundException;
import com.inditex.domain.valueobject.BrandId;
import com.inditex.domain.valueobject.PriceList;
import com.inditex.domain.valueobject.ProductId;
import com.inditex.store.service.domain.dto.price.PriceQuery;
import com.inditex.store.service.domain.dto.price.PriceResponse;
import com.inditex.store.service.domain.mapper.PriceDataMapper;
import com.inditex.store.service.domain.ports.input.service.StoreApplicationService;
import com.inditex.store.service.domain.ports.output.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Validated
@Slf4j
public class StoreApplicationServiceImpl implements StoreApplicationService {

    private final PriceDataMapper priceDataMapper;

    private final PriceRepository priceRepository;

    public StoreApplicationServiceImpl(PriceDataMapper priceDataMapper, PriceRepository priceRepository) {
        this.priceDataMapper = priceDataMapper;
        this.priceRepository = priceRepository;
    }


    @Override
    public PriceResponse getPrice(Long productId, Integer brandId, LocalDateTime dateRequest) {
        List<Price> priceList =  priceRepository.findPrices(
                new ProductId(productId),
                new BrandId(brandId),
                dateRequest);
        if (priceList.isEmpty()) {
            log.warn("Could not find price with product id: {}", productId);
            throw new PriceNotFoundException("Could not find price with product id: " +
                    productId);
        }
        Price reducePrice = priceList
                .stream()
                .reduce(Price::compare)
                .orElse(priceList.get(0));
        return priceDataMapper.priceToPriceResponse(reducePrice, dateRequest);
    }
}
