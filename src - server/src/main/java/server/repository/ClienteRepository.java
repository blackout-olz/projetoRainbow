package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import server.domain.Cliente;
import server.domain.Emprestimo;
import server.domain.Livro;

import java.util.ArrayList;

/** Interface para manipulação de entidades Cliente e sua comunicação com o BD
 * @author xuniro
 * @version 1.0
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer>
{
    Cliente findByCpf(String cpf);
}