package cb.estudiantes.service;

import cb.estudiantes.model.Estudiante;
import cb.estudiantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository sr;

    @Override
    public List<Estudiante> allStudents() {
        List<Estudiante> estudiantes = sr.findAll();
        return estudiantes;
    }

    @Override
    public Estudiante searchByID(Integer idStudent) {
        Estudiante estudiante = sr.findById(idStudent).orElse(null); //con el orELse si no encuentro el objeto alumno regreso nulo
        if (estudiante != null)
            System.out.println("Estudiante Encontrado. Estos son su datos:");
        else
            System.out.println("No existen coincidencias con el ID ingresado.");
        return estudiante;
    }

    @Override
    public void saveStudent(Estudiante estudiante) {
        try {
            sr.save(estudiante);
            System.out.println("Estudiante Añadido con exito");
        } catch (Exception e) {
            System.out.println("No se pudo añadir al estudiante al registro");
        }
    }

    @Override
    public void deleteStudent(Estudiante estudiante) {
        try {
            sr.delete(estudiante);
            System.out.println("Alumnado eliminado exitosamente!");
        } catch (Exception e) {
            System.out.println("No se ha podido eliminar." +
                    "\nEl Alumno no se encuentra registrado.");
        }
    }
}
