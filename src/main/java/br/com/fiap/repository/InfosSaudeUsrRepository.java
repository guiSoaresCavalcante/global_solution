package br.com.fiap.repository;

import br.com.fiap.dto.InfoSaudeUsrDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.InfoSaudeUsr;

@Repository
public interface InfosSaudeUsrRepository extends JpaRepository<InfoSaudeUsr, Long> {

    Page<InfoSaudeUsr> findAll(Pageable pageable);
}
