package com.example.vacinacorona.service.impl;

import com.example.vacinacorona.domain.pesquisador.Pesquisador;
import com.example.vacinacorona.domain.voluntario.Voluntario;
import com.example.vacinacorona.domain.voluntario.VoluntarioDTO;
import com.example.vacinacorona.domain.voluntario.VoluntarioRepository;
import com.example.vacinacorona.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Override
    public List<Voluntario> buscarTodos() throws Exception {
        return voluntarioRepository.findAll();
    }

    @Override
    public Optional<Voluntario> buscarPeloId(Long codigo) throws Exception {
        return voluntarioRepository.findById(codigo);
    }

    @Override
    public Voluntario incluir(Voluntario voluntario){
        Integer maxId = voluntarioRepository.selectMaxId();

        if (maxId == null) {
            voluntario.setIdVoluntario(1L);
        } else {
            voluntario.setIdVoluntario((long) (maxId + 1));
        }

        return voluntarioRepository.save(voluntario);
    }

    @Override
    public void excluir(Long id){
        voluntarioRepository.deleteById(id);
    }

    @Override
    public Optional<Voluntario> alterar(Voluntario voluntario) throws Exception {
        Optional<Voluntario> pesquisadorEntity = buscarPessoaPeloCodigo(voluntario, voluntario.getIdVoluntario());
        return pesquisadorEntity;
    }

    private Optional<Voluntario> buscarPessoaPeloCodigo(Voluntario pesquisador, Long codigo) {
        return voluntarioRepository.findById(codigo).map(p -> {
            p.setNome(pesquisador.getNome());
            p.setIdade(pesquisador.getIdade());
            p.setComorbidades(pesquisador.getComorbidades());
            return voluntarioRepository.save(p);
        });
    }
}
