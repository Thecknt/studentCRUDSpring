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
 public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estudiante;
    private String nombre;
    private String apellido;
    private String telefono;

    private String email;

    @Override
    public String toString() {
       return  "**********************************"+
               "\nDatos del Estudiante N°:" +
               id_estudiante +
               "\nNombre: '" + nombre + '\'' +
               "\nApellido: '" + apellido + '\'' +
               "\nTelefono: " + telefono +
               "\nEmail: " + email +
               "\n**********************************"+
               "\n ";

    }

    //en lombok tambien podria hacer el toString, pero en este caso preferi personalizarlo
}
