package ejem1;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement // Permite la serialización a XML
public class Persona implements Serializable {
    private int id;
    private String nombre;
    private boolean casado;
    private String sexo;

    // Constructor vacío requerido por JAXB
    public Persona() {}

    // Constructor con parámetros
    public Persona(int id, String nombre, boolean casado, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.casado = casado;
        this.sexo = sexo;
    }

    @XmlElement // Indica que este campo debe ser incluido en la representación XML
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public boolean isCasado() {
        return casado;
    }
    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    @XmlElement
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", casado=" + casado +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
