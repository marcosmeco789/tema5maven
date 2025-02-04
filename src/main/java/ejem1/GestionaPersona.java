package ejem1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/persona")
public class GestionaPersona {
    private static Persona persona;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persona leer() {
        return persona;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void guardar(Persona nuevaPersona) {
        persona = nuevaPersona;
    }
}