package com.example.dados_semiestruturados.Service;
import com.example.dados_semiestruturados.Entity.Aluno;
import com.example.dados_semiestruturados.Entity.CursoBasico;
import com.example.dados_semiestruturados.Repository.AlunoRepository;
import com.example.dados_semiestruturados.Repository.CursoBasicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoBasicoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoBasicoRepository cursoBasicoRepository;

    public void cursosBasicos() {
        List<String> palavrasChave = List.of(
                "BASICO"
        );

        List<Aluno> cursoBasico = alunoRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getCursoNome() != null ? p.getCursoNome().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Aluno p : cursoBasico) {
            boolean jaExiste = cursoBasicoRepository.existsByMatricula(p.getMatricula());
            if (!jaExiste) {
                CursoBasico curso = new CursoBasico();
                curso.setNome(p.getNome());
                curso.setMatricula(p.getMatricula());
                curso.setCursoNome(p.getCursoNome());
                curso.setSituacao(p.getSituacao());
                curso.setCota(p.getCota());

                curso.setCampus(p.getCampus());

                cursoBasicoRepository.save(curso);
            }
        }
    }
}
