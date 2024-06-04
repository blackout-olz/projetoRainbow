package server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Classe que faz referência a entidades da tabela tb_funcionarios
 * @author xuniro
 * @version 
 */
@Table(name="tb_funcionarios")
@Entity(name="tb_funcionarios")
@EqualsAndHashCode(of = "id")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Funcionario 
{
    @Id
    private int id;
    
    private String nome;
    private String cpf;
    private String passwd;
}
