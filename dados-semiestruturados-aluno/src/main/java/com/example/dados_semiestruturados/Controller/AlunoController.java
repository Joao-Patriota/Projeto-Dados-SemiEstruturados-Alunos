package com.example.dados_semiestruturados.Controller;

import com.example.dados_semiestruturados.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/importar")
    public ResponseEntity<String> importarArquivoLocal(@RequestParam String campus) {
        try {
            alunoService.importarCsv(campus.toUpperCase().trim());
            return ResponseEntity.ok("Dados do campus '" + campus + "' importados com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao importar dados do campus '" + campus + "': " + e.getMessage());
        }
    }
}