package com.m2iformation.locationvoiture.repository;


import com.m2iformation.locationvoiture.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationRepository extends JpaRepository<Location,Long> {
    @Query("SELECT l FROM Location l WHERE l.client.nom LIKE %?1%")
    public List<Location> findLocationByClientName(String keywors);
    @Query("SELECT l FROM Location l WHERE l.client.id = ?1 AND l.voiture.id = ?2")
    public Location findLocationByIds(Long clientId, Long carId );
}
