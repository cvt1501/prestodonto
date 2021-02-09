package br.com.prestodonto.prestodonto.dto.request;

import java.io.Serializable;

import br.com.prestodonto.prestodonto.models.Paciente;

public class PacienteRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String quadro;
	
	public PacienteRequestDTO() {};
	
	public PacienteRequestDTO(String name, String quadro) {
		this.name = name;
		this.quadro = quadro;
	};
	
	public Paciente buildPaciente() {
		Paciente paciente = new Paciente();
		
		paciente.setName(this.getName());
		paciente.setQuadro(this.getQuadro());
		
		return paciente;
	}

	public String getName() {
		return name;
	};

	public void setName(String name) {
		this.name = name;
	};

	public String getQuadro() {
		return quadro;
	};

	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((quadro == null) ? 0 : quadro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteRequestDTO other = (PacienteRequestDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quadro == null) {
			if (other.quadro != null)
				return false;
		} else if (!quadro.equals(other.quadro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PacienteRequestDTO [name=" + name + ", quadro=" + quadro + "]";
	}
}
