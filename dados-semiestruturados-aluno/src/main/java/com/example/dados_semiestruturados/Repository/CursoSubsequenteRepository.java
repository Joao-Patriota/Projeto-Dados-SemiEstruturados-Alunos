package com.example.dados_semiestruturados.Repository;

import com.example.dados_semiestruturados.Entity.CursoSubsequente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoSubsequenteRepository extends JpaRepository<CursoSubsequente, Long> {
    boolean existsByMatricula(String matricula);
}
