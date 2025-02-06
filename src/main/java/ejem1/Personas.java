package ejem1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/personas")
public class Personas {
    private static final List<Persona> personas = new ArrayList<>();
    private static final List<PersonaGalego> personasGalego = new ArrayList<>();

    

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
    //http://localhost:8080/tema5maven/rest/personas/buscar?cadena=
    @Path("buscar")
    public ArrayList<Persona> ver(@QueryParam("cadena") @DefaultValue("a") String cadena) {
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
            @FormParam("casado") String casado, @FormParam("sexo") String sexo) {
        boolean isCasado = Boolean.parseBoolean(casado);
        Persona p = new Persona(id, nombre, isCasado, sexo);
        PersonaGalego pg = new PersonaGalego(id, nombre, isCasado, sexo);
        personas.add(p);
        personasGalego.add(pg);
    }

    @POST
    @Path("add")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void add(List<Persona> multiplesPersonas){
        for (Persona persona : multiplesPersonas) {
            personas.add(persona);
        }
    }

    @DELETE
    @Path("id")
    public void eliminarId(@QueryParam("id") int id){
        for (Persona persona : personas) {
            if (persona.getId()== id) {
                personas.remove(persona);
            }
        }
    }

    @GET
    //http://localhost:8080/tema5maven/rest/personas/xml?id=1
    @Path("xml")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Persona ej10(@QueryParam("id") int id){
        for (Persona persona : personas) {
            if (persona.getId()== id) {
                return persona;
            }
        }
        return null;
    }


    @GET
    //http://localhost:8080/tema5maven/rest/personas/galego
    @Path("galego")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<PersonaGalego> listarGalego() {
        return personasGalego;
    }

}
