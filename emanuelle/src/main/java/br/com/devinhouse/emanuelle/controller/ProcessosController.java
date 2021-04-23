package br.com.devinhouse.emanuelle.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.emanuelle.dto.ProcessoDTO;
import br.com.devinhouse.emanuelle.service.ProcessoService;

@RestController
@RequestMapping(value = "/processos")
public class ProcessosController {

	@Autowired
	private ProcessoService service;

	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/consulta", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarLIstaProcessos() {
		return service.recuperarProcessos();
	}

	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/update/processo/{nuProcesso}", method = PUT, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProcessoDTO atualizarInfoProcesso(@PathVariable Integer nuProcesso, @RequestBody ProcessoDTO newProcesso) {
		return service.atualizarProcesso(nuProcesso, newProcesso);
	}

	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/consultachave", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessos(@RequestParam String chaveProcesso) {
		return service.recuperarProcessos(chaveProcesso);
	}

	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/consultaid", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProcessoDTO recuperarProcessoId(@RequestParam Integer id) {
		return service.recuperarProcessos(id);
	}

	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/cadastro/processo", consumes = APPLICATION_JSON_VALUE, method = POST, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ProcessoDTO>> cadastrarProcesso(@RequestBody ProcessoDTO processo) {
		if (service.verificaId(processo)) {
			return ResponseEntity.badRequest().build();
		} else {
			List<ProcessoDTO> cadastrado = service.cadastrarProcesso(processo);
			return ResponseEntity.ok(cadastrado);
		}
	}

	@RequestMapping(headers = "api-version=v1", value = "/v1"+"/excluir/processo", method = DELETE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> exclusaoProcesso(@RequestParam Integer id) {
		return service.excluirProcesso(id);
	}
}
