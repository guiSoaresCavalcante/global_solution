package br.com.fiap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.SugestoesSaudeDto;
import br.com.fiap.entity.SugestoesSaude;
import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.repository.SugestoesSaudeRepository;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class SugestoesSaudeService {

	@Autowired
	SugestoesSaudeRepository sugestoesSaudeRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<SugestoesSaudeDto> getAllSugestoesSaude() {
		List<SugestoesSaude> sugestoesSaudeList = sugestoesSaudeRepository.findAll();
		return sugestoesSaudeList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public SugestoesSaudeDto getSugestoesSaudeById(Long id) {
		SugestoesSaude sugestoesSaude = sugestoesSaudeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("SugestoesSaude not found for id: " + id));
		return convertToDto(sugestoesSaude);
	}

	public SugestoesSaudeDto createSugestoesSaude(SugestoesSaudeDto sugestoesSaudeDto) {
		SugestoesSaude sugestoesSaude = convertToEntity(sugestoesSaudeDto);
		SugestoesSaude savedSugestoesSaude = sugestoesSaudeRepository.save(sugestoesSaude);
		return convertToDto(savedSugestoesSaude);
	}

	public SugestoesSaudeDto updateSugestoesSaude(Long id, SugestoesSaudeDto sugestoesSaudeDto) {
		SugestoesSaude existingSugestoesSaude = sugestoesSaudeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("SugestoesSaude not found for id: " + id));

		BeanUtils.copyProperties(sugestoesSaudeDto, existingSugestoesSaude);
		SugestoesSaude updatedSugestoesSaude = sugestoesSaudeRepository.save(existingSugestoesSaude);
		return convertToDto(updatedSugestoesSaude);
	}

	public void deleteSugestoesSaude(Long id) {
		sugestoesSaudeRepository.deleteById(id);
	}

	private SugestoesSaudeDto convertToDto(SugestoesSaude sugestoesSaude) {
		SugestoesSaudeDto dto = new SugestoesSaudeDto();
		BeanUtils.copyProperties(sugestoesSaude, dto);
		if (sugestoesSaude.getUsuario() != null) {
			dto.setUsuarioId(sugestoesSaude.getUsuario().getId());
		}
		return dto;
	}

	private SugestoesSaude convertToEntity(SugestoesSaudeDto dto) {
		SugestoesSaude sugestoesSaude = new SugestoesSaude();
		BeanUtils.copyProperties(dto, sugestoesSaude);
		if (dto.getUsuarioId() != null) {
			UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
					.orElseThrow(() -> new RuntimeException("Usuario not found for id: " + dto.getUsuarioId()));
			sugestoesSaude.setUsuario(usuario);
		}
		return sugestoesSaude;
	}
}
