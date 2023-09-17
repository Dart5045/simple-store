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
@Table(name = "prices_list_description")
public class PriceListDescriptionEntity {
    @Id
    private Double id;
    private String priceListName;
}
