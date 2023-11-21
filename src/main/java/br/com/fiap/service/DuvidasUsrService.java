package br.com.fiap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.DuvidasUsrDto;
import br.com.fiap.entity.DuvidasUsr;
import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.repository.DuvidasUsrRepository;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class DuvidasUsrService {

	@Autowired
	DuvidasUsrRepository duvidasUsrRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<DuvidasUsrDto> getAllDuvidasUsr() {
		List<DuvidasUsr> duvidasUsrList = duvidasUsrRepository.findAll();
		return duvidasUsrList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public DuvidasUsrDto getDuvidasUsrById(Long id) {
		DuvidasUsr duvidasUsr = duvidasUsrRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("DuvidasUsr not found for id: " + id));
		return convertToDto(duvidasUsr);
	}

	public DuvidasUsrDto createDuvidasUsr(DuvidasUsrDto duvidasUsrDto) {
		DuvidasUsr duvidasUsr = convertToEntity(duvidasUsrDto);
		DuvidasUsr savedDuvidasUsr = duvidasUsrRepository.save(duvidasUsr);
		return convertToDto(savedDuvidasUsr);
	}

	public DuvidasUsrDto updateDuvidasUsr(Long id, DuvidasUsrDto duvidasUsrDto) {
		DuvidasUsr existingDuvidasUsr = duvidasUsrRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("DuvidasUsr not found for id: " + id));

		BeanUtils.copyProperties(duvidasUsrDto, existingDuvidasUsr);
		DuvidasUsr updatedDuvidasUsr = duvidasUsrRepository.save(existingDuvidasUsr);
		return convertToDto(updatedDuvidasUsr);
	}

	public void deleteDuvidasUsr(Long id) {
		duvidasUsrRepository.deleteById(id);
	}

	private DuvidasUsrDto convertToDto(DuvidasUsr duvidasUsr) {
		DuvidasUsrDto dto = new DuvidasUsrDto();
		BeanUtils.copyProperties(duvidasUsr, dto);
		if (duvidasUsr.getUsuario() != null) {
			dto.setUsuarioId(duvidasUsr.getUsuario().getId());
		}
		return dto;
	}

	private DuvidasUsr convertToEntity(DuvidasUsrDto dto) {
		DuvidasUsr duvidasUsr = new DuvidasUsr();
		BeanUtils.copyProperties(dto, duvidasUsr);
		if (dto.getUsuarioId() != null) {
			UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
					.orElseThrow(() -> new RuntimeException("Usuario not found for id: " + dto.getUsuarioId()));
			duvidasUsr.setUsuario(usuario);
		}
		return duvidasUsr;
	}
}
