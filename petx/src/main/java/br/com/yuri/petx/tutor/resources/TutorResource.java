package br.com.yuri.petx.tutor.resources;

import br.com.yuri.petx.tutor.domain.Tutor;
import br.com.yuri.petx.tutor.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tutores")
public class TutorResource {

    @Autowired
    private TutorService service;

    @PostMapping
    public ResponseEntity<Tutor> cadastrar(Tutor pet){
        return new ResponseEntity<>(service.cadastrar(pet), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Tutor> buscar(@PathVariable String cpf){
        return service.buscar(cpf).map((tutor) -> new ResponseEntity<>(tutor, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscar(@PathVariable Integer id){
        return service.buscar(id).map((tutor) -> new ResponseEntity<>(tutor, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<Tutor> atualizar(Tutor tutor){

        if(service.buscar(tutor.getId()).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.atualizar(tutor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutor> remover(@PathVariable Integer id){
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
