package br.com.devinhouse.emanuelle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.emanuelle.dto.ProcessoDTO;
import br.com.devinhouse.emanuelle.repository.ProcessoRepository;


@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repository;
	
	public List<ProcessoDTO> recuperarProcessosMockados() {
		return repository.findAllProcessos();
	}

}
