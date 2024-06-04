package server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

/** Classe usada para transferência de dados, usada especificamente para carregar a tabela de empréstimos no front
 */
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ClienteLivroEmprestimoDTO {
    private int idEmprestimo;
    private int idCliente;
    private long isbn;
    private String nome;
    private String titulo;
    private Calendar dataEmprestimo;
    private Calendar dataDevolucao;
}
