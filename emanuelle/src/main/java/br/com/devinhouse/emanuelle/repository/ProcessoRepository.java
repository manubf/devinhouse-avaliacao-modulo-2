package br.com.devinhouse.emanuelle.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.devinhouse.emanuelle.dto.ProcessoDTO;

@Repository
public class ProcessoRepository {
	public List<ProcessoDTO> mockrepositorio;

	public void init(List<ProcessoDTO> listProcessos) {

		this.mockrepositorio = listProcessos;
	}

	public List<ProcessoDTO> findAllProcessos() {
		return mockrepositorio;
	}
}
