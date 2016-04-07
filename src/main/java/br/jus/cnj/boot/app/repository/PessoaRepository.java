package br.jus.cnj.boot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.cnj.boot.app.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
