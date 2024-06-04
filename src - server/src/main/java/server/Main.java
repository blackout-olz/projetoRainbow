package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Classe principal do servidor
 * Inicializa o servidor
 * @author xuniro
 * @version 1.0
 */
@SpringBootApplication
public class Main 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(Main.class, args);
    }
}
