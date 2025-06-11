package com.example.dados_semiestruturados.Repository;

import com.example.dados_semiestruturados.Entity.Aluno;
import com.example.dados_semiestruturados.Entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Campus> findByNomeIgnoreCase(String nome);
}