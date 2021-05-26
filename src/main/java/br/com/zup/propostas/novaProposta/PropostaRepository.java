package br.com.zup.propostas.novaProposta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    boolean existsByDocumento(String documento);

    List<Proposta> findAllByStatus(Status status);
}
