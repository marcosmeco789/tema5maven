package ejem1;

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

    // EJ11: Contar deportistas (/sdepor): Cuenta el número de deportistas distintos
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
    @Produces(MediaType.APPLICATION_XML)
    public Response ej12() throws SQLException{
        String query = "select distinct deporte from deportistas order by deporte ASC";
        

        ResultSet rs = this.conexion.createStatement().executeQuery(query);

        while (rs.next()) {
            rs.getString(0);

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
