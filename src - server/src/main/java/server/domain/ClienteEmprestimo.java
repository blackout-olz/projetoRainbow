package server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/** Classe que faz referencia a entidades da tabela de relação tb_cliente_emprestimo
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_cliente_emprestimo")
@Entity(name="tb_cliente_emprestimo")
@EqualsAndHashCode(of = "id")
public class ClienteEmprestimo {
    @Id
    private int id;

    @Column(name="id_cliente")
    private int idCliente;
    @Column(name="id_emprestimo")
    private int idEmprestimo;
}
