package br.com.yuri.petx.pet.repositories;

import br.com.yuri.petx.pet.domain.Pet;
import br.com.yuri.petx.tutor.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    public Optional<Pet> findByNome(String nome);
}
