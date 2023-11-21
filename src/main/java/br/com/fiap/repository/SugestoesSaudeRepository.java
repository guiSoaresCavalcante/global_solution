package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.SugestoesSaude;

@Repository
public interface SugestoesSaudeRepository extends JpaRepository<SugestoesSaude, Long> {

}
