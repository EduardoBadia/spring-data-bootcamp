package br.com.zup.spring.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.zup.spring.data.orm.Avaliacao;

public interface AvaliacaoRepository extends PagingAndSortingRepository<Avaliacao, Long>{

	Avaliacao findByTitulo(String titulo);
}
