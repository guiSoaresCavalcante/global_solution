package br.com.fiap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.AtualizacaoSaudePubDto;
import br.com.fiap.entity.AtualizacaoSaudePub;
import br.com.fiap.entity.UsuarioEntity;
import br.com.fiap.repository.AtualizacaoSaudePubRepository;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class AtualizacaoSaudePubService {

	@Autowired
	AtualizacaoSaudePubRepository atualizacaoSaudePubRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<AtualizacaoSaudePubDto> getAllAtualizacoesSaudePub() {
		List<AtualizacaoSaudePub> atualizacoesSaudePubList = atualizacaoSaudePubRepository.findAll();
		return atualizacoesSaudePubList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public AtualizacaoSaudePubDto getAtualizacaoSaudePubById(Long id) {
		AtualizacaoSaudePub atualizacaoSaudePub = atualizacaoSaudePubRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("AtualizacaoSaudePub not found for id: " + id));
		return convertToDto(atualizacaoSaudePub);
	}

	public AtualizacaoSaudePubDto createAtualizacaoSaudePub(AtualizacaoSaudePubDto atualizacaoSaudePubDto) {
		AtualizacaoSaudePub atualizacaoSaudePub = convertToEntity(atualizacaoSaudePubDto);
		AtualizacaoSaudePub savedAtualizacaoSaudePub = atualizacaoSaudePubRepository.save(atualizacaoSaudePub);
		return convertToDto(savedAtualizacaoSaudePub);
	}

	public AtualizacaoSaudePubDto updateAtualizacaoSaudePub(Long id, AtualizacaoSaudePubDto atualizacaoSaudePubDto) {
		AtualizacaoSaudePub existingAtualizacaoSaudePub = atualizacaoSaudePubRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("AtualizacaoSaudePub not found for id: " + id));

		BeanUtils.copyProperties(atualizacaoSaudePubDto, existingAtualizacaoSaudePub);
		AtualizacaoSaudePub updatedAtualizacaoSaudePub = atualizacaoSaudePubRepository
				.save(existingAtualizacaoSaudePub);
		return convertToDto(updatedAtualizacaoSaudePub);
	}

	public void deleteAtualizacaoSaudePub(Long id) {
		atualizacaoSaudePubRepository.deleteById(id);
	}

	private AtualizacaoSaudePubDto convertToDto(AtualizacaoSaudePub atualizacaoSaudePub) {
		AtualizacaoSaudePubDto dto = new AtualizacaoSaudePubDto();
		BeanUtils.copyProperties(atualizacaoSaudePub, dto);
		if (atualizacaoSaudePub.getUsuarios() != null) {
			dto.setUsuarioIds(
					atualizacaoSaudePub.getUsuarios().stream().map(UsuarioEntity::getId).collect(Collectors.toList()));
		}
		return dto;
	}

	private AtualizacaoSaudePub convertToEntity(AtualizacaoSaudePubDto dto) {
		AtualizacaoSaudePub atualizacaoSaudePub = new AtualizacaoSaudePub();
		BeanUtils.copyProperties(dto, atualizacaoSaudePub);
		if (dto.getUsuarioIds() != null) {
			List<UsuarioEntity> usuarios = usuarioRepository.findAllById(dto.getUsuarioIds());
			atualizacaoSaudePub.setUsuarios(usuarios);
		}
		return atualizacaoSaudePub;
	}
}
