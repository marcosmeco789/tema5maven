package ejem1;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Deportista {
    private int id;
    private String nombre;
    private String deporte;
    private boolean activo;
    private String genero;
    
    public Deportista(int id, String nombre, boolean activo, String genero, String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.genero = genero;
        this.deporte = deporte;
        }

        public int getId() {
        return id;
    }

    public Deportista() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}