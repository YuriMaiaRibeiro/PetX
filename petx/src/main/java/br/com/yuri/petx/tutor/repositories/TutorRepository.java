package br.com.yuri.petx.tutor.repositories;

import br.com.yuri.petx.tutor.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    public Optional<Tutor> findByCpf(String cpf);
}
