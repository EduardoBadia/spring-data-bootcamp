package br.com.zup.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.zup.spring.data.service.CrudAvaliacaoService;
import br.com.zup.spring.data.service.RelatorioService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudAvaliacaoService avaliacaoService;
	private final RelatorioService relatorioService;

	
	public SpringDataApplication(CrudAvaliacaoService avaliacaoService, RelatorioService relatorioService) {
		
		this.avaliacaoService = avaliacaoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\r?\n");

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Avaliação");
			System.out.println("2 - Relatório");
			

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					avaliacaoService.inicial(scanner);
					break;
				case 2:
					relatorioService.inicial(scanner);
					break;	
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}