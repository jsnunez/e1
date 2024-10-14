package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Region;

public interface IRegionService {
    Optional<Region> findById(Long id);
    List<Region> getAll();
    Region save(Region region);
    Region update(Long id, Region region);
    void deleteById(Long id);
}

