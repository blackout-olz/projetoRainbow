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

/** Classe que faz referência a entidades na tabela tb_emprestimos
 * @author xuniro
 * @version 1.0
 */
@Table(name="tb_emprestimos")
@Entity(name="tb_emprestimos")
@EqualsAndHashCode(of = "id")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Emprestimo 
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="data_emprestimo")
    private Calendar dataEmprestimo;
    @Column(name="data_devolucao")
    private Calendar dataDevolucao;
}
