package com.example.data_service.postgres.repository;

import com.example.data_service.postgres.entity.AuthorNew;
import com.example.data_service.postgres.entity.BookNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookNewRepository extends JpaRepository<AuthorNew, Long> {
    @Query("SELECT o FROM BookNew o " +
            "JOIN FETCH o.authorNew " +
            "JOIN FETCH o.country " +
            "JOIN FETCH o.genre " +
            " WHERE o.country.value = :country")
    List<BookNew> findAllBooksByCountry(@Param("country") String country);
}
