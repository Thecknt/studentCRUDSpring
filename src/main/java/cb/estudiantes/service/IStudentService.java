package cb.estudiantes.service;

import cb.estudiantes.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> allStudents();

    public Student searchByID(Integer idStudent);

    /*Con este metodo internamente puedo modificar o agregar un estudiante
    internamente va a distinguir si le paso un ID sino lo
    hago da por hecho que es un nuevo estudiante.
     */
    public void saveStudent(Student student);

    public void deleteStudent(Student student);
}
