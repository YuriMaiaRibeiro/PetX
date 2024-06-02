package br.com.yuri.petx.tutor.service;


import br.com.yuri.petx.pet.domain.Pet;
import br.com.yuri.petx.tutor.domain.Tutor;
import br.com.yuri.petx.tutor.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {


    @Autowired
    private TutorRepository repository;

    public Tutor cadastrar(Tutor Tutor){
        return repository.save(Tutor);
    }

    public List<Tutor> listar(){
        return repository.findAll();
    }

    public Optional<Tutor> buscar(String cpf){
        return repository.findByCpf(cpf);
    }

    public Optional<Tutor> buscar(Integer id){
        return repository.findById(id);
    }

    public Tutor atualizar(Tutor Tutor){
        return repository.save(Tutor);
    }

    public void remover(Integer id){
        repository.deleteById(id);
    }

    public List<Pet> buscarPets(Integer id){

        Tutor tutor = repository.findById(id).orElse(new Tutor());

        return tutor.getPets();
    }
}
