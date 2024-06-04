package server.domain;

import jakarta.persistence.*;
import lombok.*;

/** Método que faz referência à entidades da tabela de relação tb_livro_emprestimo
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_livro_emprestimo")
@Entity(name="tb_livro_emprestimo")
@EqualsAndHashCode(of = "id")
public class LivroEmprestimo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="isbn")
    private long isbn;
    @Column(name="id_emprestimo")
    private int idEmprestimo;
}