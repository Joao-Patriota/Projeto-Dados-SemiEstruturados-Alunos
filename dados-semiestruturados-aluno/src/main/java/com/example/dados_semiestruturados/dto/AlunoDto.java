package com.example.dados_semiestruturados.dto;

import com.example.dados_semiestruturados.Entity.Campus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AlunoDto {

    private String nome;
    private String matricula;
    private String cursoNome;
    private String situacao;
    private String cota;
    private String campus;



}