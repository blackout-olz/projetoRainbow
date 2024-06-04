package server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Classe que faz referência a entidades na tabela tb_clientes
 * @author xuniro
 * @version 1.0
 */
@Table(name="tb_clientes")
@Entity(name="tb_clientes")
@EqualsAndHashCode(of = "id")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Cliente 
{
    @Id
    private int id;
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    @Column(name="data_nascimento")
    private Calendar dataNascimento;
}
