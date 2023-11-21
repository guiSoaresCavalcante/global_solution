package br.com.fiap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);
    UsuarioEntity findByEmail(String email);
    Optional<UsuarioEntity> findByEmailAndSenha(String email, String senha);
    Optional<UsuarioEntity> findById(Long id);
    List<UsuarioEntity> findAll();
}
