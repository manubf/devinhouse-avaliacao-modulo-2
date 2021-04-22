package br.com.devinhouse.emanuelle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.devinhouse.emanuelle.dto.ProcessoDTO;
import br.com.devinhouse.emanuelle.repository.ProcessoRepository;

@Configuration
public class Initialize implements CommandLineRunner {
	@Autowired
	ProcessoRepository repository;

	@Override
	public void run(String... args) {

		List<ProcessoDTO> listProcessos = new ArrayList<ProcessoDTO>();
		int qtdProcessos = 40;
		for (int i = 0; i < qtdProcessos; i++) {
			ProcessoDTO dto = new ProcessoDTO();
			dto.setId(i + 1);
			dto.setCdAssunto(i + 1);
			dto.setCdInteressado(i + 1);
			dto.setDescricao("Processo " + (i + 1) + "de testes DEV In House ");
			dto.setDescricaoAssunto("Assunto " + (i + 1) + " de testes DEV In House ");
			dto.setNmInteressado("Jão Antonio ::: " + i);
			dto.setNuAnoProcesso(i <= 20 ? "2020" : "2021");
			dto.setNuProcesso(i + 1);
			dto.setSgOrgaoProcesso("SOFT");
			dto.setChaveProcesso(dto.getSgOrgaoProcesso() + " " + dto.getNuProcesso() + "/" + dto.getNuAnoProcesso());
			listProcessos.add(dto);
		}
		repository.init(listProcessos);

	}
}
