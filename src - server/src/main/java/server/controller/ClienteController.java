package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.domain.*;
import server.repository.ClienteEmprestimoRepository;
import server.repository.ClienteRepository;
import server.repository.EmprestimoRepository;
import server.repository.LivroEmprestimoRepository;

import java.util.ArrayList;
import java.util.Calendar;

/** Classe controller para Cliente
 * responde aos endpoints no /cliente
 * @author xuniro
 * @version 1.0
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
    @Autowired
    ClienteRepository repository;

    @Autowired
    EmprestimoRepository emprRepository;

    @Autowired
    ClienteEmprestimoRepository clEmprRepository;

    @Autowired
    LivroEmprestimoRepository liEmprRepository;

    /** Método listar, busca no banco de dados todos os clientes na tabela
     * Devolve no body um JSON Array com todos os clientes
     * @return ResponseEntity
     */
    @GetMapping("/listar")
    public ResponseEntity listar()
    {       
        return ResponseEntity.ok(repository.findAll());
    }
    
    
    /** Método para inserir um cliente no banco de dados
     * Pega o JSON enviado no body e o transforma em um objeto da classe cliente
     * o objeto repository salva no banco de dados o cliente
     * @param cliente
     * @return ResponseEntity
     */
    @PostMapping("/inserir")
    public ResponseEntity inserir(@RequestBody Cliente cliente)
    {
        repository.save(cliente);
        return ResponseEntity.ok().build();
    }
    
    /** Método para buscar um cliente no banco de dados através do seu Id
     * Devolve no body um JSON Object com os dados do cliente
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/buscarPorId")
    public ResponseEntity buscarPorId(@RequestParam("id") int id)
    {
        return ResponseEntity.ok(repository.findById(id));
    }
    
    /** Método para excluir um cliente no banco de dados através do seu Id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/excluirPorId")
    public ResponseEntity excluirPorId(@RequestParam("id") int id)
    {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    /** Método para alterar um cliente no banco de dados através do seu Id
     * Parece com o método inserir, a diferença é que a alteração requer que o objeto JSON com as informações do cliente tenha um Id já existente no banco
     * @param cliente
     * @return ResponseEntity
     */
    @PutMapping("/alterarPorId")
    public ResponseEntity alterarPorId(@RequestBody Cliente cliente)
    {
        return ResponseEntity.ok(repository.save(cliente));
    }

    /** Método para fazer uma reserva de livros do cliente
     * @param idCliente - id do Cliente
     * @param livros - lista de livros a serem reservados
     * @return ResponseEntity
     */
    @PostMapping("/reservar")
    public ResponseEntity reservar(@RequestParam("idCliente") int idCliente,
                                   @RequestBody ArrayList<Livro> livros) {
        ClienteEmprestimo ce = new ClienteEmprestimo();
        Emprestimo e = new Emprestimo();
        e.setDataEmprestimo(Calendar.getInstance());
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(e.getDataEmprestimo().getTimeInMillis() + 1296000000);
        e.setDataDevolucao(c);
        int idEmprestimo = emprRepository.save(e).getId();

        ce.setIdCliente(idCliente);
        ce.setIdEmprestimo(idEmprestimo);
        clEmprRepository.save(ce);

        for (Livro l : livros)
        {
            LivroEmprestimo le = new LivroEmprestimo();
            le.setIsbn(l.getIsbn());
            le.setIdEmprestimo(idEmprestimo);
            liEmprRepository.save(le);
        }

        return ResponseEntity.ok().build();
    }

    /** Método para devolver livros em uma reserva
     * @param idCliente - id do cliente que está devolvendo
     * @param idEmprestimo - id do empréstimo a ser devolvido
     * @param isbn - id do livro devolvido
     * @return
     */
    @DeleteMapping("/devolver")
    @Transactional
    public ResponseEntity devolver(@RequestParam("idCliente") int idCliente,
                                   @RequestParam("idEmprestimo") int idEmprestimo,
                                   @RequestParam("isbn") long isbn) {
        LivroEmprestimo liempr = new LivroEmprestimo();
        liempr.setIsbn(isbn);
        liempr.setIdEmprestimo(idEmprestimo);
        liEmprRepository.deleteByIsbnAndIdEmprestimo(isbn, idEmprestimo);

        if (liEmprRepository.findByIdEmprestimo(idEmprestimo).isEmpty()) {
            clEmprRepository.deleteByIdClienteAndIdEmprestimo(idCliente, idEmprestimo);
            emprRepository.deleteById(idEmprestimo);
        }

        return ResponseEntity.ok().build();
    }

    /** Método para contar quantos clientes tem registrados no banco
     * @return ResponseEntity
     */
    @GetMapping("/contar")
    public ResponseEntity contarCliente() {
        return ResponseEntity.ok(repository.count());
    }

    /** Método para buscar um cliente no banco de dados através do CPF
     * @param cpf - cpf a ser buscado
     * @return ResponseEntity
     */
    @GetMapping("buscarPorCpf")
    public ResponseEntity buscarPorCpf(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(repository.findByCpf(cpf));
    }
}
