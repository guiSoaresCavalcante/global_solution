package br.com.fiap.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.fiap.dto.SugestoesSaudeDto;
import br.com.fiap.service.SugestoesSaudeService;

@RestController
@RequestMapping("/api/sugestoes-saude")
public class SugestoesSaudeController {

	private final SugestoesSaudeService sugestoesSaudeService;

	public SugestoesSaudeController(SugestoesSaudeService sugestoesSaudeService) {
		this.sugestoesSaudeService = sugestoesSaudeService;
	}

	@GetMapping
	public ResponseEntity<Page<SugestoesSaudeDto>> getAllSugestoesSaude(Pageable pageable) {
		return ResponseEntity.ok(sugestoesSaudeService.getAllSugestoesSaude(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<SugestoesSaudeDto> getSugestoesSaudeById(@PathVariable Long id) {
		SugestoesSaudeDto sugestoesSaude = sugestoesSaudeService.getSugestoesSaudeById(id);
		return ResponseEntity.ok(sugestoesSaude);
	}

	@PostMapping
	public ResponseEntity<SugestoesSaudeDto> createSugestoesSaude(@RequestBody SugestoesSaudeDto sugestoesSaudeDto) {
		SugestoesSaudeDto createdSugestoesSaude = sugestoesSaudeService.createSugestoesSaude(sugestoesSaudeDto);
		return new ResponseEntity<>(createdSugestoesSaude, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SugestoesSaudeDto> updateSugestoesSaude(@PathVariable Long id,
			@RequestBody SugestoesSaudeDto sugestoesSaudeDto) {
		SugestoesSaudeDto updatedSugestoesSaude = sugestoesSaudeService.updateSugestoesSaude(id, sugestoesSaudeDto);
		return ResponseEntity.ok(updatedSugestoesSaude);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSugestoesSaude(@PathVariable Long id) {
		sugestoesSaudeService.deleteSugestoesSaude(id);
		return ResponseEntity.noContent().build();
	}
}
