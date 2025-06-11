package com.example.dados_semiestruturados.Service;

import com.example.dados_semiestruturados.Entity.Aluno;
import com.example.dados_semiestruturados.Entity.CursoSubsequente;
import com.example.dados_semiestruturados.Repository.AlunoRepository;
import com.example.dados_semiestruturados.Repository.CursoSubsequenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoSubsequenteService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoSubsequenteRepository cursoSubsequenteRepository;

    public void cursosSubsequentes() {
        List<String> palavrasChave = List.of(
                "SUBSEQUENTE"
        );

        List<Aluno> cursoSubsequente = alunoRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getCursoNome() != null ? p.getCursoNome().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Aluno p : cursoSubsequente) {
            boolean jaExiste = cursoSubsequenteRepository.existsByMatricula(p.getMatricula());
            if (!jaExiste) {
                CursoSubsequente curso = new CursoSubsequente();
                curso.setNome(p.getNome());
                curso.setMatricula(p.getMatricula());
                curso.setCursoNome(p.getCursoNome());
                curso.setSituacao(p.getSituacao());
                curso.setCota(p.getCota());

                curso.setCampus(p.getCampus());

                cursoSubsequenteRepository.save(curso);
            }
        }
    }
}
