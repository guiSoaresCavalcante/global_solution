package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.AtualizacaoSaudePubDto;
import br.com.fiap.service.AtualizacaoSaudePubService;

@RestController
@RequestMapping("/api/atualizacoes-saude-pub")
public class AtualizacaoSaudePubController {

	@Autowired
	AtualizacaoSaudePubService atualizacaoSaudePubService;

	@GetMapping
	public ResponseEntity<List<AtualizacaoSaudePubDto>> getAllAtualizacoesSaudePub() {
		List<AtualizacaoSaudePubDto> atualizacoesSaudePubList = atualizacaoSaudePubService.getAllAtualizacoesSaudePub();
		return ResponseEntity.ok(atualizacoesSaudePubList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AtualizacaoSaudePubDto> getAtualizacaoSaudePubById(@PathVariable Long id) {
		AtualizacaoSaudePubDto atualizacaoSaudePub = atualizacaoSaudePubService.getAtualizacaoSaudePubById(id);
		return ResponseEntity.ok(atualizacaoSaudePub);
	}

	@PostMapping
	public ResponseEntity<AtualizacaoSaudePubDto> createAtualizacaoSaudePub(
			@RequestBody AtualizacaoSaudePubDto atualizacaoSaudePubDto) {
		AtualizacaoSaudePubDto createdAtualizacaoSaudePub = atualizacaoSaudePubService
				.createAtualizacaoSaudePub(atualizacaoSaudePubDto);
		return new ResponseEntity<>(createdAtualizacaoSaudePub, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AtualizacaoSaudePubDto> updateAtualizacaoSaudePub(@PathVariable Long id,
			@RequestBody AtualizacaoSaudePubDto atualizacaoSaudePubDto) {
		AtualizacaoSaudePubDto updatedAtualizacaoSaudePub = atualizacaoSaudePubService.updateAtualizacaoSaudePub(id,
				atualizacaoSaudePubDto);
		return ResponseEntity.ok(updatedAtualizacaoSaudePub);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAtualizacaoSaudePub(@PathVariable Long id) {
		atualizacaoSaudePubService.deleteAtualizacaoSaudePub(id);
		return ResponseEntity.noContent().build();
	}
}
