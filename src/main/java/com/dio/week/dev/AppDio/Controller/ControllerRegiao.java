package com.dio.week.dev.AppDio.Controller;

import com.dio.week.dev.AppDio.Entity.Regiao;
import com.dio.week.dev.AppDio.Repo.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerRegiao {

    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    /* Mapeando a URL pega regiao */
    @GetMapping("/regiao")
    public List<Regiao> getRegiao() {
        return repository.findAll();
    }

    /* Mapeando a URL pega o id */
    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id) {
        Optional regiaoEscolhidaOptional = repository.findById(id);
        if (regiaoEscolhidaOptional.isPresent()) {
            Object regiaoEscolhida = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public Regiao putRegiao(@RequestBody Regiao newRegiao){
        return repository.save(newRegiao);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
