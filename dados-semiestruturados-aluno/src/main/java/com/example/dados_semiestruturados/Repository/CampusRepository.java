package com.example.dados_semiestruturados.Repository;

import com.example.dados_semiestruturados.Entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
    Optional<Campus> findByNome(String nome);
}