package com.example.dados_semiestruturados.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "curso_subsequente")
public class CursoSubsequente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
