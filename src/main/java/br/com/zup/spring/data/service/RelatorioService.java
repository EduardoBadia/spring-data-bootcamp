package br.com.zup.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.zup.spring.data.orm.Avaliacao;
import br.com.zup.spring.data.repository.AvaliacaoRepository;

@Service
public class RelatorioService {

	private Boolean system = true;
	
	private final AvaliacaoRepository avaliacaoRepository;

	public RelatorioService(AvaliacaoRepository avaliacaoRepository) {
		
		this.avaliacaoRepository = avaliacaoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual relatorio deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca avaliacao titulo");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaAvaliacaoTitulo(scanner);
				break;
			default:
				system = false;
				break;
			}
		}	
	}
	
	public void buscaAvaliacaoTitulo(Scanner scanner)
	{
		System.out.println("Qual título deseja pesquisar");
		String titulo = scanner.next();
		Avaliacao avaliacao = avaliacaoRepository.findByTitulo(titulo);
		System.out.println(avaliacao);
	}
}
