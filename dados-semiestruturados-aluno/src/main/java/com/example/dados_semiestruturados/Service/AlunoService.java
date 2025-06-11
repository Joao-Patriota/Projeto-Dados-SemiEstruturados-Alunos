package com.example.dados_semiestruturados.Service;

import com.example.dados_semiestruturados.Entity.Aluno;
import com.example.dados_semiestruturados.Entity.Campus;
import com.example.dados_semiestruturados.Repository.AlunoRepository;
import com.example.dados_semiestruturados.Repository.CampusRepository;
import com.example.dados_semiestruturados.dto.AlunoDto;
import com.example.dados_semiestruturados.util.TratamentoDeDados;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CampusRepository campusRepository;

    public void importarCsv(String campusPadrao) {
        try (
                InputStream is = getClass().getClassLoader().getResourceAsStream("alunos.csv");
                InputStreamReader isr = new InputStreamReader(is);
                CSVReader reader = new CSVReader(isr)
        ) {
            String[] linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readNext()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                try {
                    AlunoDto dto = TratamentoDeDados.tratarDados(linha, campusPadrao);
                    if (dto != null && dto.getCampus().equalsIgnoreCase(campusPadrao)) {
                        Aluno aluno = converterDtoParaEntidade(dto);
                        alunoRepository.save(aluno);
                    }

                } catch (Exception e) {
                    System.out.println("Erro ao tratar os dados: " + Arrays.toString(linha));
                    e.printStackTrace();
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Erro ao ler o arquivo CSV com OpenCSV", e);
        }
    }

    public Aluno converterDtoParaEntidade(AlunoDto dto) {
        Campus campus = campusRepository.findByNome(dto.getCampus())
                .orElseGet(() -> {
                    Campus novoCampus = new Campus();
                    novoCampus.setNome(dto.getCampus());
                    return campusRepository.save(novoCampus);
                });

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setCursoNome(dto.getCursoNome());
        aluno.setSituacao(dto.getSituacao());
        aluno.setCota(dto.getCota());
        aluno.setCampus(campus);

        return aluno;
    }
}