package com.example.dados_semiestruturados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoBasicoDto{
    private String nome;
    private String matricula;
    private String cursoNome;
    private String situacao;
    private String cota;
    private String campus;
}
