package com.inditex.store.service.dataaccess.price.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prices")
public class PriceEntity {
    @Id
    private Double id;
    private String priceName;
    private Double productId;
}
