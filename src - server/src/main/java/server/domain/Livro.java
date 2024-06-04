package server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Classe que faz referência à entidades na tabela tb_livros no banco de dados
 * @author xuniro
 * @version 1.0
 */
@Table(name="tb_livros")
@Entity(name="tb_livros")
@EqualsAndHashCode(of = "isbn")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Livro 
{
    @Id
    private long isbn;
    
    private String titulo;
    private String sinopse;
    private String edicao;
    private String idioma;
    @Column(name="ano_lancamento")
    private Calendar anoLancamento;
    @Column(name="qtde_estoque")
    private int qtdeEstoque;
    @Column(name="num_paginas")
    private Integer numPaginas;
    private String dimensoes;
    private String capa;
    private String genero;
    private String categoria;
    private String autor;
    private String editora;
}