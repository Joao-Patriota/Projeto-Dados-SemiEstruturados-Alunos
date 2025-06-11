package com.example.dados_semiestruturados.Repository;


import com.example.dados_semiestruturados.Entity.CursoIntegrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoIntegradoRepository extends JpaRepository<CursoIntegrado, Long> {
    boolean existsByMatricula(String matricula);
}
