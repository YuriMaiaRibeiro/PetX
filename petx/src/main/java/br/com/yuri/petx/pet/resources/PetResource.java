package br.com.yuri.petx.pet.resources;

import br.com.yuri.petx.pet.domain.Pet;
import br.com.yuri.petx.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pets")
public class PetResource {

    @Autowired
    private PetService service;

    @PostMapping
    public ResponseEntity<Pet> cadastrar(Pet pet){
        return new ResponseEntity<>(service.cadastrar(pet), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Pet> buscar(@PathVariable String nome){
        return service.buscar(nome).map((pet) -> new ResponseEntity<>(pet, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscar(@PathVariable Integer id){
        return service.buscar(id).map((pet) -> new ResponseEntity<>(pet, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<Pet> atualizar(Pet pet){

        if(service.buscar(pet.getId()).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.atualizar(pet), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> remover(@PathVariable Integer id){
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
