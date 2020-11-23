package com.example.vacinacorona.service.impl;

import com.example.vacinacorona.domain.fasesVacina.FasesVacinaRepository;
import com.example.vacinacorona.domain.vacina.Vacina;
import com.example.vacinacorona.domain.vacina.VacinaRepository;
import com.example.vacinacorona.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinaServiceImpl implements VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private FasesVacinaRepository fasesVacinaRepository;

    @Override
    public Vacina inserir(Vacina vacina){
        Integer maxIdFases = fasesVacinaRepository.selectMaxId();
        Integer maxIdVac = vacinaRepository.selectMaxId();

        if (maxIdFases == null) {
            vacina.getFasesVacina().setId(1L);
        } else {
            vacina.getFasesVacina().setId((long) (maxIdFases + 1));
        }

        if (maxIdVac == null) {
            vacina.setId(1L);
        } else {
            vacina.setId((long) (maxIdVac + 1));
        }

        this.fasesVacinaRepository.save(vacina.getFasesVacina());
        return vacinaRepository.save(vacina);
    }
}
