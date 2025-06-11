package com.example.dados_semiestruturados.util;

import com.example.dados_semiestruturados.dto.AlunoDto;

import java.util.Arrays;

public class TratamentoDeDados {

    public static AlunoDto tratarDados(String[] campos, String campusPadrao) {
        try {
            String nome = campos[0].trim();
            String matricula = campos[1].trim();
            String cursoNome = campos[2].trim().toUpperCase();
            String situacao = campos[3].trim().isEmpty() ? "NÃO INFORMADO" : campos[3].trim().toUpperCase();
            String cota = campos[4].trim().isEmpty() ? "NÃO INFORMADO" : campos[4].trim().toUpperCase();

            String campus = extrairNomeCampus(cursoNome);

            if (!campus.equalsIgnoreCase(campusPadrao)) {
                return null;
            }

            return new AlunoDto(nome, matricula, cursoNome, situacao, cota, campus);
        } catch (Exception e) {
            System.out.println("Erro ao tratar os dados: " + Arrays.toString(campos));
            return null;
        }
    }

    private static String extrairNomeCampus(String cursoNome) {
        int inicio = cursoNome.indexOf('(');
        int fim = cursoNome.indexOf(')');
        if (inicio != -1 && fim != -1 && fim > inicio) {
            return cursoNome.substring(inicio + 1, fim).trim();
        }
        return "CAMPUS DESCONHECIDO";
    }
}