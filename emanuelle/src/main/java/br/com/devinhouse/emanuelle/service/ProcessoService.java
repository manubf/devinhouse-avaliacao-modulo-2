package br.com.devinhouse.emanuelle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.devinhouse.emanuelle.dto.ProcessoDTO;
import br.com.devinhouse.emanuelle.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repository;

	public List<ProcessoDTO> recuperarProcessos() {
		return repository.findAllProcessos();
	}
	
	public List<ProcessoDTO> recuperarProcessos(String chaveProcesso){
		List<ProcessoDTO> todosProcessos = repository.findAllProcessos();
		List<ProcessoDTO> listProcessosFiltradosChave = new ArrayList<ProcessoDTO>();
		
		for (ProcessoDTO processoDTO : todosProcessos) {
			if (chaveProcesso.equals(processoDTO.getChaveProcesso())) {
				listProcessosFiltradosChave.add(processoDTO);
			}
		}
		return listProcessosFiltradosChave;
	}
	
	public List<ProcessoDTO> recuperarProcessos(Integer id){
		List<ProcessoDTO> todosProcessos = repository.findAllProcessos();
		List<ProcessoDTO> listProcessosFiltradosId = new ArrayList<ProcessoDTO>();
		
		for (ProcessoDTO processoDTO : todosProcessos) {
			if (id.equals(processoDTO.getId())) {
				listProcessosFiltradosId.add(processoDTO);
			}
		}
		return listProcessosFiltradosId;
	}
	
	public boolean verificaId(ProcessoDTO newprocesso) {
		List<ProcessoDTO> todosProcessos = repository.findAllProcessos();
			
		for (ProcessoDTO processoDTO : todosProcessos) {
			if (processoDTO.getId().equals(newprocesso.getId())) {
				
				return true;
			}
		}
		return false;
	}

//	public List<ProcessoDTO> atualizarProcesso(Integer nuProcesso, ProcessoDTO newProcesso) {
	public ProcessoDTO atualizarProcesso(Integer nuProcesso, ProcessoDTO newProcesso) {
		List<ProcessoDTO> todosProcessos = repository.findAllProcessos();
		//List<ProcessoDTO> processosAlterados = new ArrayList<ProcessoDTO>();
		ProcessoDTO processoAlterado = new ProcessoDTO();
		for (ProcessoDTO processoDTO : todosProcessos) {

			if (nuProcesso.equals(processoDTO.getNuProcesso())) {
				if (newProcesso.getCdAssunto() != null) {
					processoDTO.setCdAssunto(newProcesso.getCdAssunto());
				}
				if (newProcesso.getNuProcesso() != null) {
					processoDTO.setNuProcesso(newProcesso.getNuProcesso());
				}
				if (newProcesso.getCdInteressado() != null) {
					processoDTO.setCdInteressado(newProcesso.getCdInteressado());
				}
				if (newProcesso.getChaveProcesso() != null) {
					processoDTO.setChaveProcesso(newProcesso.getChaveProcesso());
				}
				if (newProcesso.getDescricao() != null) {
					processoDTO.setDescricao(newProcesso.getDescricao());
				}
				if (newProcesso.getDescricaoAssunto() != null) {
					processoDTO.setDescricaoAssunto(newProcesso.getDescricaoAssunto());
				}
				if (newProcesso.getId() != null) {
					processoDTO.setId(newProcesso.getId());
				}
				if (newProcesso.getNmInteressado() != null) {
					processoDTO.setNmInteressado(newProcesso.getNmInteressado());
				}
				if (newProcesso.getNuAnoProcesso() != null) {
					processoDTO.setNuAnoProcesso(newProcesso.getNuAnoProcesso());
				}
				if (newProcesso.getSgOrgaoProcesso() != null) {
					processoDTO.setSgOrgaoProcesso(newProcesso.getSgOrgaoProcesso());
				}

				processoAlterado = processoDTO;

			}

		}
		return processoAlterado;
	}

	public List<ProcessoDTO> cadastrarProcesso(ProcessoDTO processo) {
		List<ProcessoDTO> todosProcessos = repository.findAllProcessos();
		todosProcessos.add(processo);
		return todosProcessos;
	}

	public List<ProcessoDTO> excluirProcesso(Integer id) {
		List<ProcessoDTO> todosProcessos = repository.findAllProcessos();
		int indice = 0;
				
		for (ProcessoDTO processoDTO : todosProcessos) {
			if (id.equals(processoDTO.getId())) {
				todosProcessos.remove(indice);
				return todosProcessos;
			}
			indice++;
		}
		return todosProcessos;
	}

}
