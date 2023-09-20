package com.inditex.store.service.domain;

import com.inditex.domain.entity.Price;
import com.inditex.domain.valueobject.*;
import com.inditex.store.service.domain.dto.price.PriceResponse;
import com.inditex.store.service.domain.mapper.PriceDataMapper;
import com.inditex.store.service.domain.ports.input.service.StoreApplicationService;
import com.inditex.store.service.domain.ports.output.repository.PriceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class StoreApplicationServiceTest {

    @Mock
    private PriceRepository priceRepository;
    private StoreApplicationService underTest;

    private final PriceDataMapper priceDataMapper = new PriceDataMapper();

    private final Long PRODUCT_ID = 35455L;
    private final Integer BRAND_ID = 1;

    private List<Price> pricesList;
    private Price price1,price2,price3,price4;

    @BeforeEach
    public void init() {
        underTest = new StoreApplicationServiceImpl(priceDataMapper, priceRepository);
    }

    @BeforeAll
    public void initData() {
        BrandId brandId = new BrandId(BRAND_ID);
        ProductId productId = new ProductId(PRODUCT_ID);

        price1 = Price
                .builder()
                .id(new PriceId(1L)).brandId(brandId).productId(productId).curr(Currency.EUR)
                .priceList(new PriceList(1L))
                .startDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priority(0)
                .price(new Money(new BigDecimal(35.50)))
                .build();

        price2 = Price
                .builder()
                .id(new PriceId(2L)).brandId(brandId).productId(productId).curr(Currency.EUR)
                .priceList(new PriceList(2L))
                .startDate(LocalDateTime.of(2020, 06, 14, 15, 00, 00))
                .endDate(LocalDateTime.of(2020, 06, 14, 18, 30, 00))
                .priority(1)
                .price(new Money(new BigDecimal(25.45)))
                .build();

        price3 = Price
                .builder()
                .id(new PriceId(3L)).brandId(brandId).productId(productId).curr(Currency.EUR)
                .priceList(new PriceList(3L))
                .startDate(LocalDateTime.of(2020, 06, 15, 00, 00, 00))
                .endDate(LocalDateTime.of(2020, 06, 15, 11, 00, 00))
                .priority(1)
                .price(new Money(new BigDecimal(30.50)))
                .build();

        price4 = Price
                .builder()
                .id(new PriceId(4L)).brandId(brandId).productId(productId).curr(Currency.EUR)
                .priceList(new PriceList(4L))
                .startDate(LocalDateTime.of(2020, 06, 15, 00, 00, 00))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priority(1)
                .price(new Money(new BigDecimal(38.95)))
                .build();
    }

    @Test
    public void test1() {
        //Given
        LocalDateTime dateRequest = LocalDateTime.of(2020, 06, 14, 16, 00, 00,00);
        pricesList = List.of(price1);

        //When
        when(priceRepository.findPrices(any(),any(),any())
        ).thenReturn(pricesList);

        PriceResponse price = underTest.getPrice(PRODUCT_ID,BRAND_ID,dateRequest);

        //Then
        assertEquals(price.getProductId(), PRODUCT_ID);
        assertEquals(price.getBrandId(),BRAND_ID);
        assertEquals(price.getPriceList(),1);
        assertEquals(price.getDateRequest(),dateRequest);
        assertEquals(price.getFinalPrice(),(new BigDecimal(35.50)));
    }

    @Test
    public void test2() {
        //Given
        LocalDateTime dateRequest = LocalDateTime.of(2020, 06, 14, 16, 00, 00,00);
        pricesList = List.of(price1,price2);

        //When
        when(priceRepository.findPrices(any(),any(),any())
        ).thenReturn(pricesList);

        PriceResponse price = underTest.getPrice(PRODUCT_ID,BRAND_ID,dateRequest);

        //Then
        assertEquals(price.getProductId(), PRODUCT_ID);
        assertEquals(price.getBrandId(),BRAND_ID);
        assertEquals(price.getPriceList(),2);
        assertEquals(price.getDateRequest(),dateRequest);
        assertEquals(price.getFinalPrice(),(new BigDecimal(25.45)));
    }

    @Test
    public void test3() {
        //Given
        LocalDateTime dateRequest = LocalDateTime.of(2020, 06, 14, 21, 00, 00,00);
        pricesList = List.of(price1);

        //When
        when(priceRepository.findPrices(any(),any(),any())
        ).thenReturn(pricesList);

        PriceResponse price = underTest.getPrice(PRODUCT_ID,BRAND_ID,dateRequest);

        //Then
        assertEquals(price.getProductId(), PRODUCT_ID);
        assertEquals(price.getBrandId(),BRAND_ID);
        assertEquals(price.getPriceList(),1);
        assertEquals(price.getFinalPrice(),(new BigDecimal(35.50)));
        assertEquals(price.getDateRequest(),dateRequest);
    }

    @Test
    public void test4() {
        //Given
        LocalDateTime dateRequest = LocalDateTime.of(2020, 06, 15, 10, 00, 00,00);
        pricesList = List.of(price1, price3);

        //When
        when(priceRepository.findPrices(any(),any(),any())
        ).thenReturn(pricesList);

        PriceResponse price = underTest.getPrice(PRODUCT_ID,BRAND_ID,dateRequest);

        //Then
        assertEquals(price.getProductId(), PRODUCT_ID);
        assertEquals(price.getBrandId(),BRAND_ID);
        assertEquals(price.getPriceList(),3);
        assertEquals(price.getDateRequest(),dateRequest);
        assertEquals(price.getFinalPrice(),(new BigDecimal(30.50)));
    }

    @Test
    public void test5() {
        //Given
        LocalDateTime dateRequest = LocalDateTime.of(2020, 06, 16, 21, 00, 00,00);
        pricesList = List.of(price1, price4);

        //When
        when(priceRepository.findPrices(any(),any(),any())
        ).thenReturn(pricesList);

        PriceResponse price = underTest.getPrice(PRODUCT_ID,BRAND_ID,dateRequest);

        //Then
        assertEquals(price.getProductId(), PRODUCT_ID);
        assertEquals(price.getBrandId(),BRAND_ID);
        assertEquals(price.getPriceList(),4);
        assertEquals(price.getDateRequest(),dateRequest);
        assertEquals(price.getFinalPrice(),(new BigDecimal(38.95)));
    }
}
