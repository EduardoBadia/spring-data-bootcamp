package br.com.zup.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private Integer idade;
	
	@OneToMany(mappedBy="mentor")
	private List<Avaliacao> avaliacoes;

	
	public Mentor() {}
		
	public Mentor(String nome, String email, Integer idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		
		return "Mentor: " + "id:" + id + "| nome: " + nome + "| email: " + email + "| idade:" + idade;
				
	}
}
