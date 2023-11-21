package br.com.fiap.controller;

import java.util.List;

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

import br.com.fiap.dto.DadosSupleUsrDto;
import br.com.fiap.service.DadosSupleUsrService;

@RestController
@RequestMapping("/api/dados-suple-usr")
public class DadosSupleUsrController {

	private final DadosSupleUsrService dadosSupleUsrService;

	public DadosSupleUsrController(DadosSupleUsrService dadosSupleUsrService) {
		this.dadosSupleUsrService = dadosSupleUsrService;
	}

	@GetMapping
	public ResponseEntity<List<DadosSupleUsrDto>> getAllDadosSupleUsr() {
		List<DadosSupleUsrDto> dadosSupleUsrList = dadosSupleUsrService.getAllDadosSupleUsr();
		return ResponseEntity.ok(dadosSupleUsrList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DadosSupleUsrDto> getDadosSupleUsrById(@PathVariable Long id) {
		DadosSupleUsrDto dadosSupleUsr = dadosSupleUsrService.getDadosSupleUsrById(id);
		return ResponseEntity.ok(dadosSupleUsr);
	}

	@PostMapping
	public ResponseEntity<DadosSupleUsrDto> createDadosSupleUsr(@RequestBody DadosSupleUsrDto dadosSupleUsrDto) {
		DadosSupleUsrDto createdDadosSupleUsr = dadosSupleUsrService.createDadosSupleUsr(dadosSupleUsrDto);
		return new ResponseEntity<>(createdDadosSupleUsr, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DadosSupleUsrDto> updateDadosSupleUsr(@PathVariable Long id,
			@RequestBody DadosSupleUsrDto dadosSupleUsrDto) {
		DadosSupleUsrDto updatedDadosSupleUsr = dadosSupleUsrService.updateDadosSupleUsr(id, dadosSupleUsrDto);
		return ResponseEntity.ok(updatedDadosSupleUsr);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDadosSupleUsr(@PathVariable Long id) {
		dadosSupleUsrService.deleteDadosSupleUsr(id);
		return ResponseEntity.noContent().build();
	}
}
