package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.InfoSaudeUsr;

@Repository
public interface InfosSaudeUsrRepository extends JpaRepository<InfoSaudeUsr, Long> {

}
