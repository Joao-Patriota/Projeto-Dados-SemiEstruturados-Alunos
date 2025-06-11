package com.example.dados_semiestruturados.Controller;

import com.example.dados_semiestruturados.Service.CursoSubsequenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subsequente")
public class CursoSubsequenteController {
    @Autowired
    private CursoSubsequenteService cursoSubsequentes;

    @GetMapping("/separar")
    public ResponseEntity<String> separarCursosSubsequentes() {
        try {
            cursoSubsequentes.cursosSubsequentes();
            return ResponseEntity.ok("Cursos Subsequentes separados e salvos na tabela 'curso_subsenquente' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar cursos Subsequentes: " + e.getMessage());
        }
    }
}
