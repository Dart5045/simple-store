package com.inditex.store.service.application.exception.rest;

import com.inditex.store.service.domain.dto.price.PriceQuery;
import com.inditex.store.service.domain.dto.price.PriceResponse;
import com.inditex.store.service.domain.ports.input.service.StoreApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/store"   , produces = "application/vnd.api.v1+json")
public class StoreController {
    private final StoreApplicationService storeApplicationService;

    public StoreController(StoreApplicationService storeApplicationService) {
        this.storeApplicationService = storeApplicationService;
    }

    @PostMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestBody PriceQuery priceQuery)
    {
        log.info("Getting Price for product id :{} ",priceQuery.getProductId());
        PriceResponse priceResponse = storeApplicationService.getPrice(priceQuery);
        return  ResponseEntity.ok(priceResponse);
    }
}
