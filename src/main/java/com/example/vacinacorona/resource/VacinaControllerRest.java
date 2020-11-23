package com.example.vacinacorona.resource;

import com.example.vacinacorona.domain.vacina.Vacina;
import com.example.vacinacorona.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"/vacina"})
public class VacinaControllerRest {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping
    public ResponseEntity<Vacina> inserir(@RequestBody Vacina vacina) throws Exception {
        Vacina vacinaResponse = vacinaService.inserir(vacina);
        return ResponseEntity.status(HttpStatus.OK).body(vacinaResponse);
    }
}
