package ejem1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

/* {
    "id": 1,
    "nombre": "Juan",
    "casado": true,
    "sexo": "Masculino"
  } */

  /*
   [
  {
    "id": 1,
    "nombre": "Juan",
    "casado": true,
    "sexo": "Masculino"
  },
  {
    "id": 2,
    "nombre": "Ana",
    "casado": false,
    "sexo": "Femenino"
  }
]
   */

@Path("/personas")
public class Personas {
    private static final List<Persona> personas = new ArrayList<>();
    private static final List<PersonaGalego> personasGalego = new ArrayList<>();

    @POST
    // http://localhost:8080/tema5maven/rest/personas
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(Persona nuevaPersona) {
        personas.add(nuevaPersona);
        return Response.ok().entity("Persona guardada correctamente!").build();
    }

    @GET
    // http://localhost:8080/tema5maven/rest/personas
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response listar() {
        return Response.ok(personas).build();
    }
    // http://localhost:8080/tema5maven/rest/personas/juan
    @Path("/{nombre}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response buscar(@PathParam("nombre") String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return Response.ok(persona).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("No se ha encontrado a la persona").build();

    }

    @GET
    // http://localhost:8080/tema5maven/rest/personas/buscar?cadena=
    @Path("buscar")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response ver(@QueryParam("cadena") @DefaultValue("a") String cadena) {
        boolean flag = false;
        ArrayList<Persona> coincidencias = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getNombre().toLowerCase().contains(cadena.toLowerCase())) {
                coincidencias.add(persona);
                flag = true;
            }
        }
        if (flag) {
            return Response.ok(coincidencias).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No se ha encontrado a la persona").build();
        }
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personaFormulario(@FormParam("id") int id, @FormParam("nombre") String nombre,
            @FormParam("casado") String casado, @FormParam("sexo") String sexo) {
        boolean isCasado = Boolean.parseBoolean(casado);
        Persona p = new Persona(id, nombre, isCasado, sexo);
        PersonaGalego pg = new PersonaGalego(id, nombre, isCasado, sexo);
        personas.add(p);
        personasGalego.add(pg);
        return Response.ok().entity("Añadido correctamente!").build();
    }

    @POST
    // http://localhost:8080/tema5maven/rest/personas/add
    @Path("add")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response add(List<Persona> multiplesPersonas) {
        for (Persona persona : multiplesPersonas) {
            personas.add(persona);
        }
        return Response.ok().entity("Personas añadidas correctamente!").build();
    }

    @DELETE
    // http://localhost:8080/tema5maven/rest/personas/id?id=1
    @Path("id")
    public Response eliminarId(@QueryParam("id") int id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                personas.remove(persona);
                return Response.ok().entity("Persona eliminada correctamente!").build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("No se ha encontrado a la persona").build();
    }

    @GET
    // http://localhost:8080/tema5maven/rest/personas/xml?id=1
    @Path("xml")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response ej10(@QueryParam("id") int id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                return Response.ok(persona).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("No se ha encontrado a la persona").build();
    }

    @GET
    // http://localhost:8080/tema5maven/rest/personas/galego
    @Path("galego")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response listarGalego() {
        return Response.ok(personasGalego).build();
    }

}
