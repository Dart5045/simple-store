package com.inditex.domain.entity;

import com.inditex.domain.valueobject.*;

import java.time.LocalDateTime;

public class Product extends AggregateRoot<ProductId>{
    private String productName;
    private Money price;
}
