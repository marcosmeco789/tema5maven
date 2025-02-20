package ejem1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/deportistas")
public class Deportistas {

    private Connection conexion;

    public void abrirConexion(String bd, String servidor, String usuario,
            String password) {
        try {
            String url = String.format("jdbc:mariadb://localhost:3306/ad_tema6?useServerPrepStmts=true", "usuario",
                    "contraseña");
            // Establecemos la conexión con la BD
            Class.forName("org.mariadb.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, usuario, password);
            if (this.conexion != null) {
                System.out.println("Conectado a " + bd + " en " + servidor);
            } else {
                System.out.println("No conectado a " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Código error: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej2() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas;");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }
        conexion.close();
        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };

        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response ej3(@PathParam("id") int id) throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas where id = " + id + ";");
        Deportista d = new Deportista();
        while (rs.next()) {
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
        }
        conexion.close();
        return Response.ok(d).build();
    }

    @GET
    @Path("/deporte/{nombreDeporte}")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej4(@PathParam("nombreDeporte") String nombreDeporte) throws SQLException {

        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement()
                .executeQuery("select * from deportistas where deporte = '" + nombreDeporte + "';");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }
        conexion.close();
        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };

        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/activos")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej5() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas where activo = 1;");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }
        conexion.close();
        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };

        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/retirados")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej6() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas where activo = 0;");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }
        conexion.close();
        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };

        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/masculinos")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej7() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas where genero = 'Masculino';");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }
        conexion.close();
        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };

        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/femeninos")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej8() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas where genero = 'Femenino';");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }
        conexion.close();
        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };

        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/xg")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej9() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();

        ResultSet rs = conexion.createStatement().executeQuery("select * from deportistas where genero = 'Masculino'");
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }

        rs = conexion.createStatement().executeQuery("select * from deportistas where genero = 'Femenino'");
        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);

        }
        conexion.close();

        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };
        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/deporte/{nombreDeporte}/activos")
    @Produces(MediaType.APPLICATION_XML)
    public Response ej10(@PathParam("nombreDeporte") String nombreDeporte) throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        String query = "SELECT * from deportistas WHERE deporte = '" + nombreDeporte + "' AND activo = 1";
        ResultSet rs = this.conexion.createStatement().executeQuery(query);
        ArrayList<Deportista> deportistas = new ArrayList<>();

        while (rs.next()) {
            Deportista d = new Deportista();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            d.setActivo(rs.getBoolean(3));
            d.setGenero(rs.getString(4));
            d.setDeporte(rs.getString(5));
            deportistas.add(d);
        }

        GenericEntity<ArrayList<Deportista>> deportistaEntity = new GenericEntity<ArrayList<Deportista>>(deportistas) {
        };
        return Response.ok(deportistaEntity).build();
    }

    @GET
    @Path("/sdepor")
    public Response ej11() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        String query = "SELECT COUNT(DISTINCT id) FROM deportistas;";

        ResultSet rs = this.conexion.createStatement().executeQuery(query);

        int numero = 0;
        if (rs.next()) {
            numero = rs.getInt(1);
        }

        conexion.close();
        return Response.ok(numero).build();
    }

    @GET
    @Path("/deportes")
    @Produces(MediaType.TEXT_PLAIN)
    public Response ej12() throws SQLException {
        abrirConexion("ad_tema6", "localhost", "root", "");
        String query = "select distinct deporte from deportistas order by deporte ASC";
        ArrayList<String> deportesOrdenados = new ArrayList<>();

        ResultSet rs = this.conexion.createStatement().executeQuery(query);

        while (rs.next()) {
            deportesOrdenados.add(rs.getString(1));

        }
        conexion.close();

        String result = String.join(", ", deportesOrdenados);
        return Response.ok(result).build();
    }

    @POST
    @Path("/")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response ej13(Deportista d) throws SQLException {

        String query = "INSERT INTO deportistas (nombre, activo, genero, deporte) VALUES (?, ?, ?, ?)";
        abrirConexion("ad_tema6", "localhost", "root", "");
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, d.getNombre());
        ps.setBoolean(2, d.isActivo());
        ps.setString(3, d.getGenero());
        ps.setString(4, d.getDeporte());
        ps.executeUpdate();
        conexion.close();
        return Response.ok().entity("Añadido correctamente!").build();

    }

    @POST
    @Path("/")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personaFormulario(@FormParam("nombre") String nombre,
            @FormParam("activo") Boolean activo, @FormParam("genero") String genero,
            @FormParam("deporte") String deporte) throws SQLException {

        String query = "INSERT INTO deportistas (nombre, activo, genero, deporte) VALUES (?, ?, ?, ?)";
        abrirConexion("ad_tema6", "localhost", "root", "");
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setBoolean(2, activo);
        ps.setString(3, genero);
        ps.setString(4, deporte);
        ps.executeUpdate();
        conexion.close();

        return Response.ok().entity("Añadido correctamente!").build();
    }

    @POST
    @Path("/adds")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response ej15(ArrayList<Deportista> multiplesDeportistas) throws SQLException {
        if (multiplesDeportistas == null || multiplesDeportistas.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("La lista de deportistas no puede estar vacía")
                    .build();
        }

        String query = "INSERT INTO deportistas (nombre, activo, genero, deporte) VALUES (?, ?, ?, ?)";
        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            for (Deportista d : multiplesDeportistas) {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, d.getNombre());
                ps.setBoolean(2, d.isActivo());
                ps.setString(3, d.getGenero());
                ps.setString(4, d.getDeporte());
                ps.executeUpdate();
            }
            return Response.ok().entity("Añadido correctamente!").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al añadir deportistas").build();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @PUT
    @Path("/")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response ej16(Deportista d) throws SQLException {
        String query = "UPDATE deportistas SET nombre = ?, activo = ?, genero = ?, deporte = ? WHERE id = ?";
        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            PreparedStatement ps = this.conexion.prepareStatement(query);

            ps.setString(1, d.getNombre());
            ps.setBoolean(2, d.isActivo());
            ps.setString(3, d.getGenero());
            ps.setString(4, d.getDeporte());
            ps.setInt(5, d.getId());
            ps.executeUpdate();

            conexion.close();
            return Response.ok().entity("modificado correctamente").build();
        } catch (SQLException e) {
            conexion.close();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al modificar deportistas")
                    .build();
        }

    }

    @DELETE
    @Path("/del/{id}")
    public Response ej17(@PathParam("id") int id) throws SQLException {
        String query = "DELETE FROM deportistas WHERE id = ?";
        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            PreparedStatement ps = this.conexion.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
            conexion.close();
            return Response.ok().entity("Eliminador correctamente").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al eliminar deportista")
                    .build();
        }

    }

    // file y fileinput stream
    @GET
    @Path("/img/{id}/{num}")
    @Produces("image/jpg")
    public Response ej18(@PathParam("id") int id, @PathParam("num") int num) throws SQLException {
        String query = "SELECT path, nombre FROM imagenes WHERE nombre LIKE ?";
        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            PreparedStatement ps = this.conexion.prepareStatement(query);
            ps.setString(1, id + "_" + num + "_%");
            ResultSet rs = ps.executeQuery();

            String ruta = "";
            if (rs.next()) {
                ruta = rs.getString("path") + "/" + rs.getString("nombre");
                conexion.close();
            } else {
                conexion.close();
                return Response.status(Response.Status.NOT_FOUND).entity("Imagen no encontrada").build();
            }

            File f = new File(ruta);
            if (!f.exists()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Imagen no encontrada").build();
            }

            try (FileInputStream fi = new FileInputStream(f)) {
                byte[] imageData = fi.readAllBytes();
                return Response.ok(imageData).build();
            } catch (IOException e) {
                e.printStackTrace();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al leer la imagen").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al mostrar imagen").build();
        }
    }
    

    public static void main(String[] args) {
        Deportistas dp = new Deportistas();

        dp.abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            dp.ej3(0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
