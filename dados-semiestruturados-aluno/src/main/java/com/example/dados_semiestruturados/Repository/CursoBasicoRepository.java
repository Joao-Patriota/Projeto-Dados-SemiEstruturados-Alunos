package com.example.dados_semiestruturados.Repository;

import com.example.dados_semiestruturados.Entity.CursoBasico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoBasicoRepository extends JpaRepository<CursoBasico, Long> {
    boolean existsByMatricula(String matricula);
}
