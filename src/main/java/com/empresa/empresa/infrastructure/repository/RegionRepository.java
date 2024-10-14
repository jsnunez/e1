package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
