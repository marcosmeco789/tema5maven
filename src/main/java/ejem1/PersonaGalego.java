package ejem1;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement // Permite la serialización a XML
public class PersonaGalego implements Serializable {
    private int id;
    private String nome;
    private boolean casado;
    private String sexo;

    // Constructor vacío requerido por JAXB
    public PersonaGalego() {}

    // Constructor con parámetros
    public PersonaGalego(int id, String nome, boolean casado, String sexo) {
        this.id = id;
        this.nome = nome;
        this.casado = casado;
        this.sexo = sexo;
    }

    
    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement // mal, no es getnome, es getNombre y se pone un atributo xml q esta en los apuntes
    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
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
                ", nome='" + nome + '\'' +
                ", casado=" + casado +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
