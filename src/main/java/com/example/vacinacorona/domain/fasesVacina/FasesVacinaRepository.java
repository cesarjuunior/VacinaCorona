package com.example.vacinacorona.domain.fasesVacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FasesVacinaRepository extends JpaRepository<FasesVacina, Long> {
    @Query(value = "SELECT max(fas.id) from FasesVacina fas")
    Integer selectMaxId();
}
