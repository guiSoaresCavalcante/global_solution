package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fiap.dto.InfoSaudeUsrDto;
import br.com.fiap.service.InfoSaudeUsrService;

@RestController
@RequestMapping("/api/info-saude-usr")
public class InfoSaudeUsrController {

	@Autowired
	InfoSaudeUsrService infoSaudeUsrService;

	@GetMapping
	public ResponseEntity<Page<InfoSaudeUsrDto>> getAllInfoSaudeUsr(Pageable pageable) {
		return ResponseEntity.ok(infoSaudeUsrService.getAllInfoSaudeUsr(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<InfoSaudeUsrDto> getInfoSaudeUsrById(@PathVariable Long id) {
		InfoSaudeUsrDto infoSaudeUsr = infoSaudeUsrService.getInfoSaudeUsrById(id);
		return ResponseEntity.ok(infoSaudeUsr);
	}

	@PostMapping
	public ResponseEntity<InfoSaudeUsrDto> createInfoSaudeUsr(@RequestBody InfoSaudeUsrDto infoSaudeUsrDto) {
		InfoSaudeUsrDto createdInfoSaudeUsr = infoSaudeUsrService.createInfoSaudeUsr(infoSaudeUsrDto);
		return new ResponseEntity<>(createdInfoSaudeUsr, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<InfoSaudeUsrDto> updateInfoSaudeUsr(@PathVariable Long id,
			@RequestBody InfoSaudeUsrDto infoSaudeUsrDto) {
		InfoSaudeUsrDto updatedInfoSaudeUsr = infoSaudeUsrService.updateInfoSaudeUsr(id, infoSaudeUsrDto);
		return ResponseEntity.ok(updatedInfoSaudeUsr);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInfoSaudeUsr(@PathVariable Long id) {
		infoSaudeUsrService.deleteInfoSaudeUsr(id);
		return ResponseEntity.noContent().build();
	}
}
