package com.example.vacinacorona.service.impl;

import com.example.vacinacorona.domain.efeitosColaterais.EfeitosColateraisRepository;
import com.example.vacinacorona.domain.empresa.EmpresaRepository;
import com.example.vacinacorona.domain.fasesVacina.FasesVacinaRepository;
import com.example.vacinacorona.domain.governo.GovernoRepository;
import com.example.vacinacorona.domain.paisTeste.PaisTesteRepository;
import com.example.vacinacorona.domain.vacina.Vacina;
import com.example.vacinacorona.domain.vacina.VacinaRepository;
import com.example.vacinacorona.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacinaServiceImpl implements VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private FasesVacinaRepository fasesVacinaRepository;

    @Autowired
    private EfeitosColateraisRepository efeitosColateraisRepository;

    @Autowired
    private GovernoRepository governoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PaisTesteRepository paisTesteRepository;

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

        /*vacina.getPaisesTeste().forEach(paisTeste -> {
            this.paisTesteRepository.inserir(paisTeste.getNome(), paisTeste.getNumParticipantes());
        });

        vacina.getEfeitosColaterais().forEach(efeitosColaterais -> {
            this.efeitosColateraisRepository.inserir(efeitosColaterais.getDescricao(), efeitosColaterais.getComum(),
                    efeitosColaterais.getIncomum(), efeitosColaterais.getRaro());
        });

        this.governoRepository.inserir(vacina.getGoverno().getNome());
        this.empresaRepository.inserir(vacina.getEmpresa().getNomeEmpresa());
        this.fasesVacinaRepository.inserir(vacina.getFasesVacina().getId(), vacina.getFasesVacina().getFase1(),
                vacina.getFasesVacina().getFase2(),vacina.getFasesVacina().getFase3(),vacina.getFasesVacina().getFase4());
        Long idGoverno = this.governoRepository.selectMaxId();
        Long idEmpresa = this.empresaRepository.selectMaxId();

        this.vacinaRepository.inserir(vacina.getId(), vacina.getNomeVacina(), vacina.getEstoque(), vacina.getFasesVacina().getId(),
                idGoverno, idEmpresa);*/

        return this.vacinaRepository.save(vacina);
    }

    @Override
    public List<Vacina> consultar() throws Exception {
        return vacinaRepository.findAll();
    }

    @Override
    public Optional<Vacina> consultarPorId(Long id) throws Exception {
        return this.vacinaRepository.findById(id);
    }

    @Override
    public void deletarVacina(Long id) throws Exception {
        this.vacinaRepository.deleteById(id);
    }

    @Override
    public Vacina atualizarVacina(Vacina vacina) throws Exception {
        return this.vacinaRepository.save(vacina);
    }
}
