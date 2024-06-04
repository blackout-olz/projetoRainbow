package server.controller;

import lombok.Getter;
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
import server.domain.Emprestimo;
import server.repository.EmprestimoRepository;

/** Classe controller para Emprestimo
 * responde aos endpoints no /emprestimo
 * @author xuniro
 * @version 1.0
 */
@RestController
@RequestMapping("/emprestimo")
@Getter
public class EmprestimoController 
{
    @Autowired
    EmprestimoRepository repository;

    /** Método listar, busca no banco de dados todos os emprestimos na tabela
     * Devolve no body um JSON Array com todos os emprestimos
     * @return ResponseEntity
     */
    @GetMapping("/listar")
    public ResponseEntity listar()
    {       
        return ResponseEntity.ok(repository.findAll());
    }
    
    
    /** Método para inserir um emprestimo no banco de dados
     * Pega o JSON enviado no body e o transforma em um objeto da classe emprestimo
     * o objeto repository salva no banco de dados o emprestimo
     * @param emprestimo
     * @return ResponseEntity
     */
    @PostMapping("/inserir")
    public ResponseEntity inserir(@RequestBody Emprestimo emprestimo)
    {
        repository.save(emprestimo);
        return ResponseEntity.ok().build();
    }
    
    /** Método para buscar um emprestimo no banco de dados através do seu Id
     * Devolve no body um JSON Object com os dados do emprestimo
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/buscarPorId")
    public ResponseEntity buscarPorId(@RequestParam("id") int id)
    {
        return ResponseEntity.ok(repository.findById(id));
    }
    
    /** Método para excluir um emprestimo no banco de dados através do seu Id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/excluirPorId")
    public ResponseEntity excluirPorId(@RequestParam("id") int id)
    {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    /** Método para alterar um emprestimo no banco de dados através do seu Id
     * Parece com o método inserir, a diferença é que a alteração requer que o objeto JSON com as informações do emprestimo tenha um Id já existente no banco
     * @param emprestimo
     * @return ResponseEntity
     */
    @PutMapping("/alterarPorId")
    public ResponseEntity alterarPorId(@RequestBody Emprestimo emprestimo)
    {
        return ResponseEntity.ok(repository.save(emprestimo));
    }

    /** Método para carregar a tabela de empréstimos no FrontEnd
     * @return ResponseEntity
     */
    @GetMapping("/carregartabelaemprestimo")
    public ResponseEntity carregarTabelaEmprestimo() {
        return ResponseEntity.ok(repository.carregarTabelaEmprestimos());
    }

    /** Método para contar quantos empréstimos tem no banco de dados
     * @return ResponseEntity
     */
    @GetMapping("/contar")
    public ResponseEntity contarEmprestimo() {
        return ResponseEntity.ok(repository.count());
    }
}