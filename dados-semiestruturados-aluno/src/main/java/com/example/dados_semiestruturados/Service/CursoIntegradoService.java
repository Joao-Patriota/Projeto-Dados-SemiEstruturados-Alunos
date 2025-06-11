package com.example.dados_semiestruturados.Service;

import com.example.dados_semiestruturados.Entity.Aluno;
import com.example.dados_semiestruturados.Entity.CursoIntegrado;
import com.example.dados_semiestruturados.Repository.AlunoRepository;
import com.example.dados_semiestruturados.Repository.CursoIntegradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoIntegradoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoIntegradoRepository cursoIntegradoRepository;

    public void cursosIntegrados() {
        List<String> palavrasChave = List.of(
                "INTEGRADO"
        );

        List<Aluno> cursoIntegrado = alunoRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getCursoNome() != null ? p.getCursoNome().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Aluno p : cursoIntegrado) {
            boolean jaExiste = cursoIntegradoRepository.existsByMatricula(p.getMatricula());
            if (!jaExiste) {
                CursoIntegrado curso = new CursoIntegrado();
                curso.setNome(p.getNome());
                curso.setMatricula(p.getMatricula());
                curso.setCursoNome(p.getCursoNome());
                curso.setSituacao(p.getSituacao());
                curso.setCota(p.getCota());

                curso.setCampus(p.getCampus());

                cursoIntegradoRepository.save(curso);
            }
        }
    }
}
