package com.example.data_service.postgres.repository;

import com.example.data_service.postgres.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Long> {
}
