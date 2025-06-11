package com.example.dados_semiestruturados.Repository;

import com.example.dados_semiestruturados.Entity.CursoSuperior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoSuperiorRepository extends JpaRepository<CursoSuperior, Long> {
    boolean existsByMatricula(String matricula);
}
