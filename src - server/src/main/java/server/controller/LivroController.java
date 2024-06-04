package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.domain.Livro;
import server.domain.LivroEmprestimo;
import server.repository.LivroEmprestimoRepository;
import server.repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;

/** Classe controller para o Livro
 * É a classe que responde aos endpoints /livro
 * @author xuniro
 * @version 1.0
 */
@RestController
@RequestMapping("/livro")
public class LivroController 
{
    @Autowired
    LivroRepository repository;

    @Autowired
    LivroEmprestimoRepository liEmprRepository;

    /** Método listar, busca no banco de dados todos os livros na tabela
     * Devolve no body um JSON Array com todos os livros
     * @return ResponseEntity
     */
    @GetMapping("/listar")
    public ResponseEntity listar()
    {       
        return ResponseEntity.ok(repository.findAll());
    }
    
    
    /** Método para inserir um livro no banco de dados
     * Pega o JSON enviado no body e o transforma em um objeto da classe Livro
     * o objeto repository salva no banco de dados o livro
     * @param livro
     * @return ResponseEntity
     */
    @PostMapping("/inserir")
    public ResponseEntity inserir(@RequestBody Livro livro)
    {
        repository.save(livro);
        return ResponseEntity.ok().build();
    }
    
    /** Método para buscar um livro no banco de dados através do seu ISBN
     * Devolve no body um JSON Object com os dados do livro
     * @param isbn
     * @return ResponseEntity
     */
    @GetMapping("/buscarPorId")
    public ResponseEntity buscarPorId(@RequestParam("isbn") long isbn)
    {
        return ResponseEntity.ok(repository.findById(isbn));
    }
    
    /** Método para excluir um livro no banco de dados através do seu ISBN
     * @param isbn
     * @return ResponseEntity
     */
    @DeleteMapping("/excluirPorId")
    public ResponseEntity excluirPorId(@RequestParam("isbn") long isbn)
    {
        repository.deleteById(isbn);
        return ResponseEntity.ok().build();
    }
    
    /** Método para alterar um livro no banco de dados através do seu ISBN
     * Parece com o método inserir, a diferença é que a alteração requer que o objeto JSON com as informações do livro tenha um ISBN já existente no banco
     * @param livro
     * @return ResponseEntity
     */
    @PutMapping("/alterarPorId")
    public ResponseEntity alterarPorId(@RequestBody Livro livro)
    {
        return ResponseEntity.ok(repository.save(livro));
    }

    /** Método para contar quantos livros existem no banco de dados (emprestados ou não)
     * @param empr - boolean dizendo se a contantagem deve ser de livros emprestados ou não
     * @return ResponseEntity
     */
    @GetMapping("/contar")
    public ResponseEntity contarLivros(@RequestParam("emprestados") boolean empr) {
        if (empr) {
            return ResponseEntity.ok(liEmprRepository.count());
        } else {
            List<Livro> livros = repository.findAll();
            int count = 0;
            for (Livro l : livros)
                count += l.getQtdeEstoque();
            return ResponseEntity.ok(count);
        }
    }
}