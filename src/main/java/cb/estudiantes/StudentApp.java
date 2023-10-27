package cb.estudiantes;

import cb.estudiantes.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//Implemento el CommandLineRunner para que se ejecute en la terminal.
@SpringBootApplication
public class StudentApp implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    //Ahora configuro el logger para poder ver la info en consola,
    //y ya no necesito usar el sout.
    private static final Logger logger = LoggerFactory.getLogger(StudentApp.class);

    //para hacer un salto de linea, ya no uso \n
    String newLine = System.lineSeparator();

    public static void main(String[] args) {
        logger.info("Iniciando la Aplicacion...");
        //Levanto Spring
        SpringApplication.run(StudentApp.class, args);
        logger.info("Aplicacion Finalizada...");
    }

    @Override
    public void run(String... args) throws Exception {
//En este metodo ejecuto la logica, para no tener que extraer del main.
        logger.info(newLine + "Ejecutando metodo Run - final" + newLine);

        boolean exit = false;
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        while (!exit) {
            showMenu();
            exit = choice(input);
            logger.info(newLine);
        }
    }

    private void showMenu() {
        logger.info(newLine);
        logger.info("""
                ***************Bienvenido al menu de Estudiantes***************
                *                    1) Listar Estudiantes                    *
                *                    2) Buscar Estudiante                     *
                *                    3) Agregar Estudiante                    *
                *                    4) Modificar Estudiante                  *
                *                    5) Eliminar Estudiante                   *
                *                    6) Salir                                 *
                ***************************************************************
                *                    Seleccione una opcion:                   *
                ***************************************************************
                """);
    }

    private boolean choice(Scanner input){
int choice = input.nextInt();
boolean exit = false;
switch (choice){
    case 1 -> { //Listar todos los alumnos
        
    }
}
        return exit;
    }
}
