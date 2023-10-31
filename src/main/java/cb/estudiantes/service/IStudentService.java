package cb.estudiantes.service;

import cb.estudiantes.model.Estudiante;

import java.util.List;

public interface IStudentService {

    public List<Estudiante> allStudents();

    public Estudiante searchByID(Integer idStudent);

    /*Con este metodo internamente puedo modificar o agregar un estudiante
    internamente va a distinguir si le paso un ID sino lo
    hago da por hecho que es un nuevo estudiante.
     */
    public void saveStudent(Estudiante estudiante);

    public void deleteStudent(Estudiante estudiante);
}
