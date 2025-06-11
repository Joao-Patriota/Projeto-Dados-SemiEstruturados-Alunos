package com.example.dados_semiestruturados.Service;

import com.example.dados_semiestruturados.Entity.Aluno;
import com.example.dados_semiestruturados.Entity.CursoSuperior;
import com.example.dados_semiestruturados.Repository.AlunoRepository;
import com.example.dados_semiestruturados.Repository.CursoSuperiorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoSuperiorService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoSuperiorRepository cursoSuperiorRepository;

    public void cursosSuperiores() {
        List<String> palavrasChave = List.of(
                "SUPERIOR"
        );

        List<Aluno> cursoSuperior = alunoRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getCursoNome() != null ? p.getCursoNome().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Aluno p : cursoSuperior) {
            boolean jaExiste = cursoSuperiorRepository.existsByMatricula(p.getMatricula());
            if (!jaExiste) {
                CursoSuperior curso = new CursoSuperior();
                curso.setNome(p.getNome());
                curso.setMatricula(p.getMatricula());
                curso.setCursoNome(p.getCursoNome());
                curso.setSituacao(p.getSituacao());
                curso.setCota(p.getCota());

                curso.setCampus(p.getCampus());

                cursoSuperiorRepository.save(curso);
            }
        }
    }
}
