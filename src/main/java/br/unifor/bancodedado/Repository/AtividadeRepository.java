package br.unifor.bancodedado.Repository;

import br.unifor.bancodedado.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
