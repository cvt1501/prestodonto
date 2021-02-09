package br.com.prestodonto.prestodonto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestodonto.prestodonto.dto.request.PacienteRequestDTO;
import br.com.prestodonto.prestodonto.models.Paciente;
import br.com.prestodonto.prestodonto.service.HomeService;

@RestController
public class HomeController {
	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PacienteRequestDTO> getAllPacientes(@RequestParam(name = "Termo", required = false) String termo) {
		if(termo != null) {
			return this.homeService.listarTodosPacientesWTermo(termo);
		} else {
			return this.homeService.listarTodosPacientes();
		}
	};
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PacienteRequestDTO createPaciente(@RequestBody(required = true) PacienteRequestDTO novoPaciente) {
		PacienteRequestDTO paciente = this.homeService.criarNovoPaciente(novoPaciente);
		
		return paciente;
	};
	
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PacienteRequestDTO updatePaciente(@PathVariable(required = true) Long id, @RequestBody(required = true) PacienteRequestDTO pacienteAtulizado) {
		PacienteRequestDTO paciente = this.homeService.atualizarPaciente(id, pacienteAtulizado);
		
		return paciente;
	};
	
	@RequestMapping(value = "/pacientes/admin")
	public List<Paciente> getAllPacientesAdmin() {
		return this.homeService.listarTodosPacientesAdmin();
	};
	
	@RequestMapping(value = "/pacientes/admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Paciente criarUsuarioAdmin(@RequestBody(required = true) Paciente novoPacienteAdmin) {
		return this.homeService.criarUsuarioAdmin(novoPacienteAdmin);
	};
}
