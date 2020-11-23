package com.example.vacinacorona.domain.vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    @Query(value = "SELECT max(vac.id) from Vacina vac")
    Integer selectMaxId();
}
