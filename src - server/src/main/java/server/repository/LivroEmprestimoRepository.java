package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.domain.LivroEmprestimo;

import java.util.ArrayList;

public interface LivroEmprestimoRepository extends JpaRepository<LivroEmprestimo, Integer> {
    void deleteByIsbnAndIdEmprestimo(Long isbn, Integer idEmpresimo);
    ArrayList<LivroEmprestimo> findByIdEmprestimo(Integer idEmprestimo);
}
