package cb.estudiantes.repository;

import cb.estudiantes.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//Utilizando JpaRepository esta interfaz me habilita a todas las consultas en vez de generar una por una
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
