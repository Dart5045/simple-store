package com.inditex.store.service.dataaccess.brand.repository;

import com.inditex.store.service.dataaccess.brand.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandJpaRepository extends JpaRepository<BrandEntity, Integer> {
}
