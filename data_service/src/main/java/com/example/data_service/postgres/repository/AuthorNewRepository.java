package com.example.data_service.postgres.repository;

import com.example.data_service.postgres.entity.AuthorNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AuthorNewRepository extends JpaRepository<AuthorNew, Long> {
    @Query("SELECT o FROM AuthorNew o JOIN FETCH o.firstName JOIN FETCH o.secondName WHERE o.firstName.value = :Firstname")
    List<AuthorNew> findAllAuthorsByFirstName(@Param("Firstname") String Firstname);
}
