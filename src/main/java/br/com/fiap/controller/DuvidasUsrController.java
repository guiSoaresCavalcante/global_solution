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

import br.com.fiap.dto.DuvidasUsrDto;
import br.com.fiap.service.DuvidasUsrService;

@RestController
@RequestMapping("/api/duvidas-usr")
public class DuvidasUsrController {

	private final DuvidasUsrService duvidasUsrService;

	public DuvidasUsrController(DuvidasUsrService duvidasUsrService) {
		this.duvidasUsrService = duvidasUsrService;
	}

	@GetMapping
	public ResponseEntity<List<DuvidasUsrDto>> getAllDuvidasUsr() {
		List<DuvidasUsrDto> duvidasUsrList = duvidasUsrService.getAllDuvidasUsr();
		return ResponseEntity.ok(duvidasUsrList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DuvidasUsrDto> getDuvidasUsrById(@PathVariable Long id) {
		DuvidasUsrDto duvidasUsr = duvidasUsrService.getDuvidasUsrById(id);
		return ResponseEntity.ok(duvidasUsr);
	}

	@PostMapping
	public ResponseEntity<DuvidasUsrDto> createDuvidasUsr(@RequestBody DuvidasUsrDto duvidasUsrDto) {
		DuvidasUsrDto createdDuvidasUsr = duvidasUsrService.createDuvidasUsr(duvidasUsrDto);
		return new ResponseEntity<>(createdDuvidasUsr, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DuvidasUsrDto> updateDuvidasUsr(@PathVariable Long id,
			@RequestBody DuvidasUsrDto duvidasUsrDto) {
		DuvidasUsrDto updatedDuvidasUsr = duvidasUsrService.updateDuvidasUsr(id, duvidasUsrDto);
		return ResponseEntity.ok(updatedDuvidasUsr);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDuvidasUsr(@PathVariable Long id) {
		duvidasUsrService.deleteDuvidasUsr(id);
		return ResponseEntity.noContent().build();
	}
}
