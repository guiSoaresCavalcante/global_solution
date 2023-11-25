package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.dto.*;
import br.com.fiap.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroUsuarioDto dados, UriComponentsBuilder uriBuilder) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(dados);
		service.cadastrar(usuarioEntity);

		var uri = uriBuilder.path("usuario{id}").buildAndExpand(usuarioEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioCriadoDto(usuarioEntity));
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(loginRequest.email());
		} else {
			throw new UsernameNotFoundException("Email ou senha invalidos");
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
