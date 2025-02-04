package ejem1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/personas")
public class Personas {
    private static final List<Persona> personas = new ArrayList<>();

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void guardar(Persona nuevaPersona) {
        personas.add(nuevaPersona);
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML })
    public List<Persona> listar() {
        return personas;
    }

    @GET
    @Path("/{nombre}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Persona buscar(@PathParam("nombre") String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }

    @GET
    @Path("buscar")
    public ArrayList<Persona> ver(@QueryParam("cadena") String cadena) {
        ArrayList<Persona> coincidencias = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getNombre().toLowerCase().contains(cadena.toLowerCase())) {
                coincidencias.add(persona);
            }
        }
        return coincidencias;
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public void personaFormulario(@FormParam("id") int id, @FormParam("nombre") String nombre,
            @FormParam("casado") Boolean casado, @FormParam("sexo") String sexo) {
        Persona p = new Persona(id, nombre, false, sexo);
        personas.add(p);
    }
}
