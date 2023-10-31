package cb.estudiantes;

import cb.estudiantes.model.Estudiante;
import cb.estudiantes.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
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

    private boolean choice(Scanner input) {
        int choice = input.nextInt();
        boolean exit = false;
        switch (choice) {
            case 1 -> { //Listar todos los alumnos
                logger.info(newLine + "Listado de Alumnos: " + newLine);
                List<Estudiante> estudiantes = studentService.allStudents();
                estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + newLine)));
            }
            case 2 -> {
                //Buscar estudiante:
                logger.info("Ingrese el ID del alumno que desea Buscar: ");
                Integer idStudent = input.nextInt();
                var student = studentService.searchByID(idStudent);
                System.out.println("");
                System.out.println(student);
            }
            case 3 -> {

                System.out.println("Ingrese Los datos del nuevo alumno: ");
                Estudiante student = new Estudiante();
                System.out.print("Ingrese el nombre del Alumno: ");
                String name = input.next();
                student.setNombre(name);
                System.out.print("Ingrese el apellido: ");
                String lastname = input.next();
                student.setApellido(lastname);
                System.out.print("Ingrese un telefono de contacto: ");
                String phone = input.next();
                student.setTelefono(phone);
                System.out.print("Ingrese un email de contacto: ");
                String email = input.next();
                student.setEmail(email);
                studentService.saveStudent(student);
            }
            case 4 -> {
                System.out.print("Ingrese el N° de ID que le fue asignado: ");
                try {
                    Integer idStudent = input.nextInt();
                    Estudiante student = studentService.searchByID(idStudent);

                    if (student != null) {
                        System.out.println("¿Que campo desea modificar?");

                        System.out.println("""
                                ***********************
                                * 1) Nombre           *
                                * 2) Apellido         *
                                * 3) Telefono         *
                                * 4) Email            *
                                * 5) Salir            *
                                ***********************
                                 """);
                        int choiceSubMenu = input.nextInt();
                        switch (choiceSubMenu) {
                            case 1 -> {
                                System.out.println();
                                System.out.print("Ingrese el NUEVO Nombre: ");
                                String name = input.next();
                                student.setNombre(name);
                                System.out.println("Nombre cambiado con exito!");
                            }
                            case 2 -> {
                                System.out.print("Ingrese el NUEVO apellido: ");
                                String lastname = input.next();
                                student.setApellido(lastname);
                                System.out.println("Apellido cambiado con exito!");
                            }
                            case 3 -> {
                                System.out.print("Ingrese el NUEVO telefono: ");
                                String phone = input.next();
                                student.setTelefono(phone);
                                System.out.println("Telefono cambiado con exito!");
                            }
                            case 4 -> {
                                System.out.print("Ingrese el NUEVO email: ");
                                String email = input.next();
                                student.setEmail(email);
                                System.out.println("Email cambiado con exito!");
                            }
                            case 5 -> {
                                System.out.println(" <-- Regresando al menu anterior...");
                            }
                            default -> {
                                System.out.println("Opcion invalida");
                            }
                        }
                        studentService.saveStudent(student);
                    }
                } catch (Exception e) {
                    System.out.println("Ingreso un caracter Invalido.");
                }
                break;
            }

            case 5 -> {

                System.out.print("Ingrese el N° de ID que le fue asignado: ");
                Integer idStudent = input.nextInt();
                List<Estudiante> estudiantes = studentService.allStudents();
                estudiantes.forEach((estudiante -> {
                    if (estudiante.getId_estudiante() == idStudent) {
                        studentService.deleteStudent(estudiante);
                        //System.out.println("Estudiante eliminado con exito!");
                    }
                }));
            }
            case 6 -> {
                System.out.println("Gracias por utilizar la App :)");
                exit = true;
            }
            default -> System.out.println("Opcion Invalida. Reintente nuevamente!");
        }
        return exit;
    }
}
