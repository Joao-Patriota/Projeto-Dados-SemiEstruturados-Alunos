package com.example.dados_semiestruturados.Controller;

import com.example.dados_semiestruturados.Service.CursoBasicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basico")
public class CursoBasicoController {
    @Autowired
    private CursoBasicoService cursoBasicos;

    @GetMapping("/separar")
    public ResponseEntity<String> separarCursosBasicos() {
        try {
            cursoBasicos.cursosBasicos();
            return ResponseEntity.ok("Cursos Basicos separados e salvos na tabela 'curso_basico' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar cursos Basicos: " + e.getMessage());
        }
    }
}
