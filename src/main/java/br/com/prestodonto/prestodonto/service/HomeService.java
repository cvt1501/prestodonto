package br.com.prestodonto.prestodonto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prestodonto.prestodonto.dto.request.PacienteRequestDTO;
import br.com.prestodonto.prestodonto.models.Paciente;
import br.com.prestodonto.prestodonto.repository.PacienteRepository;

@Service
public class HomeService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	public List<Paciente> listarTodosPacientesAdmin() {
		return this.pacienteRepository.findAll();
	};
	
	public Paciente criarUsuarioAdmin(Paciente paciente) {
		return this.pacienteRepository.save(paciente);
	};
	
	public List<PacienteRequestDTO> listarTodosPacientes() {
		List<Paciente> listaPacientes = this.pacienteRepository.findAll();
		List<PacienteRequestDTO> listaPacientesDTO = new ArrayList<PacienteRequestDTO>();
		
		for (Paciente paciente : listaPacientes) {
			PacienteRequestDTO pacienteDTO = new PacienteRequestDTO();
			
			pacienteDTO.setName(paciente.getName());
			pacienteDTO.setQuadro(paciente.getQuadro());
			
			listaPacientesDTO.add(pacienteDTO);
		};
		
		return listaPacientesDTO;
	};
	
	public List<PacienteRequestDTO> listarTodosPacientesWTermo(String termo) {
		List<Paciente> listaPacientes = this.pacienteRepository.findAll();
		List<PacienteRequestDTO> listaFiltrada = new ArrayList<PacienteRequestDTO>();
		
		for(Paciente paciente : listaPacientes) {
			PacienteRequestDTO pacienteDTO = new PacienteRequestDTO();
			
			pacienteDTO.setName(paciente.getName());
			pacienteDTO.setQuadro(paciente.getQuadro());
			
			if(pacienteDTO.getQuadro().toLowerCase().trim().indexOf(termo.toLowerCase().trim()) != -1) {
				listaFiltrada.add(pacienteDTO);
			};
		};
		
		return listaFiltrada;
	};
	
	public PacienteRequestDTO criarNovoPaciente(PacienteRequestDTO novoPaciente) {
		PacienteRequestDTO paciente = novoPaciente;
		
		this.pacienteRepository.save(paciente.buildPaciente());
		
		return paciente;
	};
	
	public PacienteRequestDTO atualizarPaciente(Long id, PacienteRequestDTO pacienteAtualizado) {
		Paciente paciente = this.pacienteRepository.findById(id).orElseThrow();
		
		paciente.setName(pacienteAtualizado.getName());
		paciente.setQuadro(pacienteAtualizado.getQuadro());
		
		this.pacienteRepository.save(paciente);
		
		return pacienteAtualizado;
	};
}
