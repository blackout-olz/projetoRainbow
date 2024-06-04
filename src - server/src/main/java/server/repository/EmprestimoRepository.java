package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.domain.Emprestimo;
import server.dto.ClienteLivroEmprestimoDTO;

import java.util.List;

/** Interface para manipulação de entidades Emprestimo e sua comunicação com o BD
 * @author xuniro
 * @version 1.0
 */
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>
{
    @Query("select NEW server.dto.ClienteLivroEmprestimoDTO(e.id, c.id, l.isbn, c.nome, l.titulo, e.dataEmprestimo, e.dataDevolucao) " +
            "from tb_emprestimos e " +
            "inner join tb_cliente_emprestimo tce " +
            "on e.id = tce.idEmprestimo " +
            "inner join tb_clientes c " +
            "on c.id = tce.idCliente " +
            "inner join tb_livro_emprestimo tle " +
            "on e.id = tle.idEmprestimo " +
            "inner join tb_livros l " +
            "on l.isbn = tle.isbn")
    List<ClienteLivroEmprestimoDTO> carregarTabelaEmprestimos();
}
