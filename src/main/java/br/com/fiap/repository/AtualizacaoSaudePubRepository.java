package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.AtualizacaoSaudePub;

@Repository
public interface AtualizacaoSaudePubRepository extends JpaRepository<AtualizacaoSaudePub, Long> {

}
