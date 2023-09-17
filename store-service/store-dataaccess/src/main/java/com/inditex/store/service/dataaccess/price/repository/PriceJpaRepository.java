package com.inditex.store.service.dataaccess.price.repository;

import com.inditex.domain.entity.Price;
import com.inditex.store.service.dataaccess.price.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Double> {
    @Query(value = "FROM PriceEntity e WHERE productId= :productId AND priceList= :priceList AND startDate <= :dateRequest AND endDate >= :dateRequest")
    List<PriceEntity> findPrices(
            Long productId,
            Long priceList,
            @Param("dateRequest") LocalDateTime dateRequest);
}
