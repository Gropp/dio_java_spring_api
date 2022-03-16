package com.dio.week.dev.AppDio.Controller;


import com.dio.week.dev.AppDio.Entity.IncidenciaExame;
import com.dio.week.dev.AppDio.Repo.IncidenciaExameRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerIncidenciaExame {

    private final IncidenciaExameRepo ierepository;

    public ControllerIncidenciaExame(IncidenciaExameRepo ierepository) {
        this.ierepository = ierepository;
    }

    @GetMapping("/incidenciaexame")
    public ResponseEntity<List<IncidenciaExame>> findAllIncidenciaExame(){
        List<IncidenciaExame> listaIncidenciaExame = ierepository.findAll();
        if (listaIncidenciaExame.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaIncidenciaExame, HttpStatus.OK);
    }

    @GetMapping("/incidenciaexame/{id}")
    public ResponseEntity<?> findByIdIncidenciaExame(@PathVariable long id){
        Optional<IncidenciaExame> incidenciaExameOptional = ierepository.findById(id);
        if(incidenciaExameOptional.isPresent()){
              IncidenciaExame incidenciaExameUnid = incidenciaExameOptional.get();
              return new ResponseEntity<>(incidenciaExameUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidenciaexame/novo")
    public IncidenciaExame newIncidenciaExame(@RequestBody IncidenciaExame newIncidenciaExame){
        return ierepository.save(newIncidenciaExame);
    }

}
