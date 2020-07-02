package sahfer.FormacionDeportiva.Domain;

public class SesionList {
    private long id = 0;
    private String fecha = "10:12";
    private String equipo = "isaacTeam";
    private String Categoria = "categ 12";
    private int nTareas = 7;
    private int nJugadores = 8;
    private String tipoPartido = "match";

    public SesionList (String equipo, String tipoPartido) {
        this.equipo = equipo;
        this.tipoPartido = tipoPartido;
    }
    public SesionList (String equipo) {
        this.equipo = equipo;
    }

    public String getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(String tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getnTareas() {
        return nTareas;
    }

    public void setnTareas(int nTareas) {
        this.nTareas = nTareas;
    }

    public int getnJugadores() {
        return nJugadores;
    }

    public void setnJugadores(int nJugadores) {
        this.nJugadores = nJugadores;
    }
}