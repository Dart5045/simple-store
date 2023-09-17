package com.inditex.domain.entity;

import com.inditex.domain.valueobject.*;

import java.time.LocalDateTime;

public class Product extends BaseEntity<ProductId>{
    private String productName;
    private Money price;
}
