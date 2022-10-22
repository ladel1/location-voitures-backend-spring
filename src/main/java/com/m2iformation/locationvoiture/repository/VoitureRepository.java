package com.m2iformation.locationvoiture.repository;

import com.m2iformation.locationvoiture.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface VoitureRepository extends JpaRepository<Voiture,Long> {

}
