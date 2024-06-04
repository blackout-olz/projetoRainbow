package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.domain.Funcionario;

/** Interface para comunicar entidades Funcionario ao BD
 * @author xuniro
 * @version 1.0
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>
{
    Funcionario findByCpfAndPasswd(String cpf, String passwd);
    Funcionario findByCpf(String cpf);
}
