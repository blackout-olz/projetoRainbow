package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.domain.Livro;

/** Interface para manipulação de entidades Livro e suas interações com o banco de dados
 * @author xuniro
 * @version 1.0
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {}