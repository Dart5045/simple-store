package com.inditex.store.service.dataaccess.price.repository;

import com.inditex.store.service.dataaccess.price.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Double> {
    Optional<PriceEntity> findByProductId(Double value);
}
