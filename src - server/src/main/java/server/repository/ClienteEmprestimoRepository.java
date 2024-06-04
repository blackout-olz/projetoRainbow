package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.domain.ClienteEmprestimo;

public interface ClienteEmprestimoRepository extends JpaRepository<ClienteEmprestimo, Integer> {
    void deleteByIdClienteAndIdEmprestimo(Integer idCliente, Integer idEmprestimo);
}