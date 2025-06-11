package com.example.dados_semiestruturados.Controller;

import com.example.dados_semiestruturados.Service.CursoIntegradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/integrados")
public class CursoIntegradoController {

    @Autowired
    private CursoIntegradoService cursoIntegrado;

    @GetMapping("/separar")
    public ResponseEntity<String> separarCursosIntegrados() {
        try {
            cursoIntegrado.cursosIntegrados();
            return ResponseEntity.ok("Cursos integrados separados e salvos na tabela 'curso_integrado' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar cursos integrados: " + e.getMessage());
        }
    }

}
