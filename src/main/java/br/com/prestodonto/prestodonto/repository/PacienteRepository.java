package br.com.prestodonto.prestodonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prestodonto.prestodonto.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {};
