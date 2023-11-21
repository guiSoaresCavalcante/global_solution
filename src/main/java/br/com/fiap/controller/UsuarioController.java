package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.AtualizarUsuarioDto;
import br.com.fiap.dto.CadastroUsuarioDto;
import br.com.fiap.dto.ListarUsuarioDto;
import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroUsuarioDto usuario) {
		try {
			Long id = service.cadastrar(usuario);
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody CadastroUsuarioDto loginRequest) {
		String email = loginRequest.email();
		String senha = loginRequest.senha();

		Optional<UsuarioEntity> usuario = service.findByEmailSenha(email, senha);

		if (usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/todos")
	public ResponseEntity<List<ListarUsuarioDto>> listarAtivosEInativos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUsuario(@PathVariable Long id) {
		try {

			return ResponseEntity.ok(service.listarPorId(id));
		} catch (Exception e) {
			ArrayList<String> msg = new ArrayList<String>();
			msg.add("Usuário não encontrado.");
			return ResponseEntity.badRequest().body(msg);
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarUsuarioDto usuarioDto) {
		try {
			service.atualizar(usuarioDto);
			return ResponseEntity.ok("Usuário atualizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Usuário não encontrado");
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		try {
			// service.desativar(id);
			service.deletar(id);
			return ResponseEntity.ok("Usuário deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Usuário não encontrado.");
		}
	}
}
