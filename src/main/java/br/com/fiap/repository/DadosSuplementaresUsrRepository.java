package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.DadosSupleUsr;

@Repository
public interface DadosSuplementaresUsrRepository extends JpaRepository<DadosSupleUsr, Long> {

}
