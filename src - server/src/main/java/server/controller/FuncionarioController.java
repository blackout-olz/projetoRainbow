package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.domain.Emprestimo;
import server.domain.Funcionario;
import server.repository.FuncionarioRepository;

/** Classe controller para Funcionario
 * responde aos endpoints no /funcionario
 * @author xuniro
 * @version 1.0
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController 
{
    @Autowired
    private FuncionarioRepository repository;

    /** Método para realizar o Login de um funcionário no sistema
     * @param cpf - cpf do funcionário
     * @param passwd - senha do funcionário
     * @return ResponseEntity
     */
    @GetMapping("/login")
    ResponseEntity logar(@RequestParam("cpf") String cpf, @RequestParam("passwd") String passwd)
    {
        return ResponseEntity.ok(repository.findByCpfAndPasswd(cpf, passwd));
    }

    /** Método listar, busca no banco de dados todos os funcionarios na tabela
     * Devolve no body um JSON Array com todos os funcionarios
     * @return ResponseEntity
     */
    @GetMapping("/listar")
    public ResponseEntity listar()
    {
        return ResponseEntity.ok(repository.findAll());
    }


    /** Método para inserir um funcionario no banco de dados
     * Pega o JSON enviado no body e o transforma em um objeto da classe funcionario
     * o objeto repository salva no banco de dados
     * @param funcionario -
     * @return ResponseEntity
     */
    @PostMapping("/inserir")
    public ResponseEntity inserir(@RequestBody Funcionario funcionario)
    {
        repository.save(funcionario);
        return ResponseEntity.ok().build();
    }

    /** Método para buscar um funcionario no banco de dados através do seu Id
     * Devolve no body um JSON Object com os dados do funcionario
     * @param id -
     * @return ResponseEntity
     */
    @GetMapping("/buscarPorId")
    public ResponseEntity buscarPorId(@RequestParam("id") int id)
    {
        return ResponseEntity.ok(repository.findById(id));
    }

    /** Método para excluir um funcionario no banco de dados através do seu Id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/excluirPorId")
    public ResponseEntity excluirPorId(@RequestParam("id") int id)
    {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /** Método para alterar um funcionario no banco de dados através do seu Id
     * Parece com o método inserir, a diferença é que a alteração requer que o objeto JSON com as informações do funcionário tenha um Id já existente no banco
     * @param funcionario
     * @return ResponseEntity
     */
    @PutMapping("/alterarPorId")
    public ResponseEntity alterarPorId(@RequestBody Funcionario funcionario)
    {
        return ResponseEntity.ok(repository.save(funcionario));
    }

    /** Método para buscar um funcionário por CPF no banco de dados
     * @param cpf - cpf a ser buscado
     * @return ResponseEntity
     */
    @GetMapping("buscarPorCpf")
    public ResponseEntity buscarPorCpf(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(repository.findByCpf(cpf));
    }
}
