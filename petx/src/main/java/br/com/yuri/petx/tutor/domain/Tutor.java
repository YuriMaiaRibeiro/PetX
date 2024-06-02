package br.com.yuri.petx.tutor.domain;

import br.com.yuri.petx.pet.domain.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue
    @Column(name = "id_tutor")
    private Integer id;

    @Column( nullable = false)
    private String nome;

    @Column (nullable = false, unique = true)
    private String cpf;

    @Column
    private String telefone;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pet> pets = new ArrayList<>();

}
