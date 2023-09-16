package com.inditex.domain.entity;

import com.inditex.domain.valueobject.Money;
import com.inditex.domain.valueobject.PriceList;
import com.inditex.domain.valueobject.ProductId;

public class PriceListDetail extends AggregateRoot<PriceList>{
    private String description;
    private int percentDiscount;
}
