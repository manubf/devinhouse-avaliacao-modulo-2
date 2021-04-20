package br.com.devinhouse.emanuelle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.emanuelle.dto.ProcessoDTO;
import br.com.devinhouse.emanuelle.mock.ProcessoMock;



@Repository
public class ProcessoRepository {
	@Autowired
	private ProcessoMock processoMock;

	public List<ProcessoDTO> findAllProcessos() {
		return processoMock.getAllProcessos();
	}
}
