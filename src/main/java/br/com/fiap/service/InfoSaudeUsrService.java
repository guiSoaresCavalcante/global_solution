package br.com.fiap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.InfoSaudeUsrDto;
import br.com.fiap.entity.InfoSaudeUsr;
import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.repository.InfosSaudeUsrRepository;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class InfoSaudeUsrService {

	@Autowired
	InfosSaudeUsrRepository infoSaudeUsrRepository;

	@Autowired
	UsuarioRepository usuarioRepository;


	public Page<InfoSaudeUsrDto> getAllInfoSaudeUsr(Pageable pageable) {
		return infoSaudeUsrRepository.findAll(pageable).map(InfoSaudeUsrDto::new);
	}

	public InfoSaudeUsrDto getInfoSaudeUsrById(Long id) {
		InfoSaudeUsr infoSaudeUsr = infoSaudeUsrRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("InfoSaudeUsr not found for id: " + id));
		return convertToDto(infoSaudeUsr);
	}

	public InfoSaudeUsrDto createInfoSaudeUsr(InfoSaudeUsrDto infoSaudeUsrDto) {
		InfoSaudeUsr infoSaudeUsr = convertToEntity(infoSaudeUsrDto);
		InfoSaudeUsr savedInfoSaudeUsr = infoSaudeUsrRepository.save(infoSaudeUsr);
		return convertToDto(savedInfoSaudeUsr);
	}

	public InfoSaudeUsrDto updateInfoSaudeUsr(Long id, InfoSaudeUsrDto infoSaudeUsrDto) {
		InfoSaudeUsr existingInfoSaudeUsr = infoSaudeUsrRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("InfoSaudeUsr not found for id: " + id));

		BeanUtils.copyProperties(infoSaudeUsrDto, existingInfoSaudeUsr);
		InfoSaudeUsr updatedInfoSaudeUsr = infoSaudeUsrRepository.save(existingInfoSaudeUsr);
		return convertToDto(updatedInfoSaudeUsr);
	}

	public void deleteInfoSaudeUsr(Long id) {
		infoSaudeUsrRepository.deleteById(id);
	}

	private InfoSaudeUsrDto convertToDto(InfoSaudeUsr infoSaudeUsr) {
		InfoSaudeUsrDto dto = new InfoSaudeUsrDto();
		BeanUtils.copyProperties(infoSaudeUsr, dto);
		if (infoSaudeUsr.getUsuario() != null) {
			dto.setUsuarioId(infoSaudeUsr.getUsuario().getId());
		}
		return dto;
	}

	private InfoSaudeUsr convertToEntity(InfoSaudeUsrDto dto) {
		InfoSaudeUsr infoSaudeUsr = new InfoSaudeUsr();
		BeanUtils.copyProperties(dto, infoSaudeUsr);
		if (dto.getUsuarioId() != null) {
			UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
					.orElseThrow(() -> new RuntimeException("Usuario not found for id: " + dto.getUsuarioId()));
			infoSaudeUsr.setUsuario(usuario);
		}
		return infoSaudeUsr;
	}
}
