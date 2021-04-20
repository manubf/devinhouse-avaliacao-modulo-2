package br.com.devinhouse.emanuelle.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.emanuelle.dto.ProcessoDTO;
import br.com.devinhouse.emanuelle.service.ProcessoService;



@RestController
@RequestMapping(value = "/processos")
public class ProcessosController {
	@Autowired
	private ProcessoService service;

	@RequestMapping(headers = "api-version=v1",value="/v1"+"/consulta", method = GET  , produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarLIstaProcessos() {
		return service.recuperarProcessosMockados();
	}

//	@RequestMapping(value = "/consulta-xml", method = GET, produces = APPLICATION_ATOM_XML_VALUE)
//	@ResponseBody
//	public ResponseEntity<ProcessoReturnResponseDTO> recuperarListaProcessosXML() {
//
//		ProcessoReturnResponseDTO response = new ProcessoReturnResponseDTO();
//		response.setProcesso(service.recuperarProcessosMockados());
//
//		return new ResponseEntity<ProcessoReturnResponseDTO>(response, HttpStatus.OK);
//	}
	
//	// TODO 2 - Criar uma API que retorne somente os processo de 2020 usando Query
//	// string @RequestParam e o verbo GET
//	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta", method = GET, produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<ProcessoDTO> recuperarListaProcessos(@RequestParam String ano ) {
//	    return service.recuperarProcessosMockados(ano);
//	}


	// TODO 3 - Criar uma API que retorne somente os processo de 2020 usando a
	// @PathVariable e o verbo GET
	
//	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta/ano/{ano}", method = GET, produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<ProcessoDTO> recuperarListaProcessosPath(@PathVariable String ano ) {		
//		return service.recuperarProcessosMockados(ano);
//	}
	

	// TODO 4 - Criar uma API que insira um processo usando o verbo "POST" e o
	// objeto @RequestBody :
	// {
	// "sgOrgaoSetor":"SOFT",
	// "nuProcesso" : 30,
	// "nuAnoProcesso" : "2020",
	// "cdAssunto" : 30,
	// "descricaoAssunto": "Assunto teste 30 DEV In House",
	// "decricao": "Processo teste 30 DEV In House",
	// "cdInteressado": 30,
	// "nmInteressado": "DEV In House"
	// }
//	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/cadastro/processo", consumes = APPLICATION_JSON_VALUE, method = POST, produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<ProcessoDTO> cadastrarProcesso(@RequestBody ProcessoDTO processo) {		
//		return service.cadastrarProcesso(processo);
//	}
	
	// TODO 5 - Criar uma API usando o verbo "PUT" para atualizar o campo
	// "descricao" de um processo usando a @PathVariable e o objeto @RequestBody
	// {
	// "decricao": "Processo teste 30 DEV In House",
	// }
//	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/update/processo/{nuProcesso}", consumes = APPLICATION_JSON_VALUE, method = PUT, produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<ProcessoDTO> atualizarInfoProcesso(@PathVariable Integer nuProcesso, @RequestBody ProcessoDTO newProcesso) {		
//		return service.atualizarProcesso(nuProcesso, newProcesso);
//	}


}
