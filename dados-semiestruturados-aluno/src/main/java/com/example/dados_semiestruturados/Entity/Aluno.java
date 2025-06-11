package com.example.dados_semiestruturados.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluno {

    @Id
    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "curso_nome")
    private String cursoNome;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "cota")
    private String cota;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;
}