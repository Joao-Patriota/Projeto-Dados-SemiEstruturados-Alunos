package com.example.dados_semiestruturados.Controller;


import com.example.dados_semiestruturados.Service.CursoSuperiorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/superior")
public class CursoSuperiorController {

        @Autowired
        private CursoSuperiorService cursoSuperior;

        @GetMapping("/separar")
        public ResponseEntity<String> separarCursosSuperiores() {
            try {
                cursoSuperior.cursosSuperiores();
                return ResponseEntity.ok("Cursos Superiores separados e salvos na tabela 'curso_superior' com sucesso.");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro ao separar cursos Superiores: " + e.getMessage());
            }
        }
}
