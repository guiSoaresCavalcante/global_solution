package br.com.fiap.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.AtualizarUsuarioDto;
import br.com.fiap.dto.CadastroUsuarioDto;
import br.com.fiap.dto.ListarUsuarioDto;
import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Long cadastrar(CadastroUsuarioDto usuarioDto) {
		if (repository.findByEmail(usuarioDto.email()) != null) {
			throw new IllegalArgumentException("Email já cadastrado");
		}
		UsuarioEntity usuarioEntity = repository.save(new UsuarioEntity(usuarioDto));
		return usuarioEntity.getId();
	}

//    public Page<ListarUsuarioDto> listar(Pageable paginacao) {
//        return repository.findAllByAtivoTrue(paginacao).map(ListarUsuarioDto::new);
//    }
//
//    public Page<ListarUsuarioDto> listarAtivosEInativos(Pageable paginacao) {
//        return repository.findAll(paginacao).map(ListarUsuarioDto::new);
//    }
//    

	public Optional<UsuarioEntity> findByEmailSenha(String email, String senha) {
		return repository.findByEmailAndSenha(email, senha);
	}

	public List<ListarUsuarioDto> listarTodos() {
		List<UsuarioEntity> usuarios = repository.findAll();
		return usuarios.stream().map(this::mapToDtoListarUsuario).collect(Collectors.toList());
	}

	public List<ListarUsuarioDto> listarPorId(Long id) {
		Optional<UsuarioEntity> usuarios = repository.findById(id);
		return usuarios.stream().map(this::mapToDtoListarUsuario).collect(Collectors.toList());
	}

	public void atualizar(AtualizarUsuarioDto usuarioDto) {
		Optional<UsuarioEntity> usuario = repository.findById(usuarioDto.id());
		if (usuario.isPresent()) {
			UsuarioEntity usuarioAtualizado = usuario.get();
			if (usuarioDto.nome() != null) {
				usuarioAtualizado.setNome(usuarioDto.nome());
			}

			if (usuarioDto.email() != null) {
				usuarioAtualizado.setEmail(usuarioDto.email());
			}
		} else {
			throw new IllegalArgumentException("Usuário não encontrado");
		}

	}

	public void desativar(Long id) {
		var usuario = repository.getReferenceById(id);
		if (usuario != null) {
			usuario.setAtivo(false);
		} else {
			throw new IllegalArgumentException("Usuário não encontrado");
		}
	}

	public void deletar(Long id) {
		var usuario = repository.getReferenceById(id);
		if (usuario != null) {
			repository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Usuário não encontrado");
		}
	}

	private ListarUsuarioDto mapToDtoListarUsuario(UsuarioEntity entity) {
		return new ListarUsuarioDto(entity.getId(), entity.getNome(), entity.getEmail(),entity.getDataCadastro());
	}

}
