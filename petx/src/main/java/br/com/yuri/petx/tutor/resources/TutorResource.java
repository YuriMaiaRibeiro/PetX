package br.com.yuri.petx.tutor.resources;

import br.com.yuri.petx.pet.domain.Pet;
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
    public ResponseEntity<Tutor> cadastrar(@RequestBody Tutor tutor){
        return new ResponseEntity<>(service.cadastrar(tutor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Tutor> buscar(@PathVariable String cpf){
        return service.buscar(cpf).map((tutor) -> new ResponseEntity<>(tutor, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> buscarPets(@PathVariable Integer id){

        // se tutor não existe, responde não encontrado
        if(service.buscar(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service.buscarPets(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscar(@PathVariable Integer id){
        return service.buscar(id).map((tutor) -> new ResponseEntity<>(tutor, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<Tutor> atualizar(@RequestBody Tutor tutor){

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
