package br.com.yuri.petx.pet.domain;

import br.com.yuri.petx.tutor.domain.Tutor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue
    @Column(name = "id_pet")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String raca;

    @Column
    private String cor;

    @Column
    private int idade;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private Tutor tutor;
}
