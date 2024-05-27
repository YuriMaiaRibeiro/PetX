package br.com.yuri.petx.pet.service;

import br.com.yuri.petx.pet.domain.Pet;
import br.com.yuri.petx.pet.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet cadastrar(Pet pet){
        return repository.save(pet);
    }

    public List<Pet> listar(){
        return repository.findAll();
    }

    public Optional<Pet> buscar(String nome){
        return repository.findByNome(nome);
    }

    public Optional<Pet> buscar(Integer id){
        return repository.findById(id);
    }

    public Pet atualizar(Pet pet){
        return repository.save(pet);
    }

    public void remover(Integer id){
        repository.deleteById(id);
    }

}