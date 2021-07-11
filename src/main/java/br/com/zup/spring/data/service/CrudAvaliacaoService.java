package br.com.zup.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.zup.spring.data.orm.Avaliacao;
import br.com.zup.spring.data.orm.Mentor;
import br.com.zup.spring.data.repository.AvaliacaoRepository;
import br.com.zup.spring.data.repository.MentorRepository;

@Service
public class CrudAvaliacaoService {

	private Boolean system = true;

	private final MentorRepository mentorRepository;
	private final AvaliacaoRepository avaliacaoRepository;
	
	
	public CrudAvaliacaoService( 
	MentorRepository mentorRepository, AvaliacaoRepository avaliacaoRepository) {
		
		this.mentorRepository = mentorRepository;
		this.avaliacaoRepository = avaliacaoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de avaliacao deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;	
			default:
				system = false;
				break;
			}
			
		}
		
	}
	
	private void salvar(Scanner scanner) {
		
		System.out.println("Digite o título: ");
        String titulo = scanner.next();

        System.out.println("Digite a descrição: ");
        String descricao = scanner.next();

        System.out.println("Digite o Id do mentor: ");
        Long idMentor = scanner.nextLong();

        Avaliacao avaliacao = new Avaliacao();
        
        avaliacao.setTitulo(titulo);
        avaliacao.setDescricao(descricao);
        
        Optional<Mentor> mentor = mentorRepository.findById(idMentor);
        avaliacao.setMentor(mentor.get());

        avaliacaoRepository.save(avaliacao);
        System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		
		System.out.println("Digite o id");
        Long id = scanner.nextLong();
        
        System.out.println("Digite o título: ");
        String titulo = scanner.next();

        System.out.println("Digite a descrição: ");
        String descricao = scanner.next();

        System.out.println("Digite o Id do mentor: ");
        Long idMentor = scanner.nextLong();

        
        Avaliacao avaliacao = new Avaliacao();
        
        avaliacao.setId(id);
        avaliacao.setTitulo(titulo);
        avaliacao.setDescricao(descricao);
        
        Optional<Mentor> mentor = mentorRepository.findById(idMentor);
        avaliacao.setMentor(mentor.get());

        avaliacaoRepository.save(avaliacao);
        System.out.println("Salvo");
	}
	
	private void visualizar(Scanner scanner) {
		System.out.println("Qual pagina voce deseja visualizar");
		Integer page = scanner.nextInt();
		
		Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "titulo"));
		Page<Avaliacao> avaliacoes = avaliacaoRepository.findAll(pageable);
		
		System.out.println(avaliacoes);
		System.out.println("Pagina atual " + avaliacoes.getNumber());
		System.out.println("Total elemento " + avaliacoes.getTotalElements());
		avaliacoes.forEach(avaliacao -> System.out.println(avaliacao));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		Long id = scanner.nextLong();
		avaliacaoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
