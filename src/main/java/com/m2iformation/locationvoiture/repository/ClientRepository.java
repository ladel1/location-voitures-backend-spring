package com.m2iformation.locationvoiture.repository;

import com.m2iformation.locationvoiture.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ClientRepository extends JpaRepository<Client,Long> {
}
