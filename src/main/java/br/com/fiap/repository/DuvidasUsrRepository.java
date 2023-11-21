package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.DuvidasUsr;

@Repository
public interface DuvidasUsrRepository extends JpaRepository<DuvidasUsr, Long> {

}
