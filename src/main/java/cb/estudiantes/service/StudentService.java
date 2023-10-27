package cb.estudiantes.service;

import cb.estudiantes.model.Student;
import cb.estudiantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository sr;

    @Override
    public List<Student> allStudents() {
        List<Student> students = sr.findAll();
        return students;
    }

    @Override
    public Student searchByID(Integer idStudent) {
        Student student = sr.findById(idStudent).orElse(null); //con el orELse si no encuentro el objeto alumno regreso nulo
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        sr.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        sr.delete(student);
    }
}
