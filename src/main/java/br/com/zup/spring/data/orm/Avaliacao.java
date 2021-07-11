package br.com.zup.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	
	@ManyToOne
	private Mentor mentor;
	
	public Avaliacao()
	{
		
	}
	
	public Avaliacao(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}	
	
	@Override
	public String toString() {
		return "Avaliacao: " + "id:" + id + "| titulo: " + titulo + "| descricao:" + descricao + "| mentor: " + mentor.getNome();
	}
}
