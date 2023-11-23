package br.com.fiap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.DadosSupleUsrDto;
import br.com.fiap.entity.DadosSupleUsr;
import br.com.fiap.repository.DadosSuplementaresUsrRepository;

@Service
public class DadosSupleUsrService {

	@Autowired
	DadosSuplementaresUsrRepository dadosSupleUsrRepository;

	public List<DadosSupleUsrDto> getAllDadosSupleUsr() {
		List<DadosSupleUsr> dadosSupleUsrList = dadosSupleUsrRepository.findAll();
		return dadosSupleUsrList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public DadosSupleUsrDto getDadosSupleUsrById(Long id) {
		DadosSupleUsr dadosSupleUsr = dadosSupleUsrRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("DadosSupleUsr not found for id: " + id));
		return convertToDto(dadosSupleUsr);
	}

	public DadosSupleUsrDto createDadosSupleUsr(DadosSupleUsrDto dadosSupleUsrDto) {
		DadosSupleUsr dadosSupleUsr = convertToEntity(dadosSupleUsrDto);
		DadosSupleUsr savedDadosSupleUsr = dadosSupleUsrRepository.save(dadosSupleUsr);
		return convertToDto(savedDadosSupleUsr);
	}

	public DadosSupleUsrDto updateDadosSupleUsr(Long id, DadosSupleUsrDto dadosSupleUsrDto) {
		DadosSupleUsr existingDadosSupleUsr = dadosSupleUsrRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("DadosSupleUsr not found for id: " + id));

		BeanUtils.copyProperties(dadosSupleUsrDto, existingDadosSupleUsr);
		DadosSupleUsr updatedDadosSupleUsr = dadosSupleUsrRepository.save(existingDadosSupleUsr);
		return convertToDto(updatedDadosSupleUsr);
	}

	public void deleteDadosSupleUsr(Long id) {
		dadosSupleUsrRepository.deleteById(id);
	}

	private DadosSupleUsrDto convertToDto(DadosSupleUsr updatedDadosSupleUsr) {
		DadosSupleUsrDto dto = new DadosSupleUsrDto();
		BeanUtils.copyProperties(updatedDadosSupleUsr, dto);
		return dto;
	}

	private DadosSupleUsr convertToEntity(DadosSupleUsrDto dto) {
		DadosSupleUsr dadosSupleUsr = new DadosSupleUsr();
		BeanUtils.copyProperties(dto, dadosSupleUsr);
		return dadosSupleUsr;
	}

}
