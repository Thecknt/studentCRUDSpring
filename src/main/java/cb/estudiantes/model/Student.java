package cb.estudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
// boilerplate conocido como codigo repetitivo con Lombok evito hacer los getters y setters por ej
@Data  //get y set
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
 public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    private String name;
    private String lastname;
    private String phone;

    private String email;

    @Override
    public String toString() {
       return "Datos del Estudiante N°:" +
               idStudent +
               "\nNombre: '" + name + '\'' +
               "\nApellido: '" + lastname+ '\'' +
               "\nTelefono: " + phone +
               "\nEmail: " + email;
    }

    //en lombok tambien podria hacer el toString, pero en este caso preferi personalizarlo
}
