package com.dio.week.dev.AppDio.Controller;


import com.dio.week.dev.AppDio.Entity.FaixaEtaria;
import com.dio.week.dev.AppDio.Repo.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepo frepository;

    public ControllerFaixaEtaria(FaixaEtariaRepo frepository) {
        this.frepository = frepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
            List<FaixaEtaria> lista = frepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> findByIdFaixaEtaria(@PathVariable long id){
        try{
            Optional<FaixaEtaria> unidOptional = frepository.findById(id);
            if(unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria){
        return frepository.save(newFaixaEtaria);
    }

    @DeleteMapping("/faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id){
        frepository.deleteById(id);
    }
}
