package cgDataAccess.cgDTOs;

public class cgViewHormigaDTO {
    private Integer IdHormiga;
    private String TipoHormiga;
    private String TipoAlimento;
    private String Genoma;
    private String Sexo;
    private String EstadoHormiga;
    private String Nombre;
    private String Descripcion;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public cgViewHormigaDTO () {}
    
    public cgViewHormigaDTO(Integer idHormiga, String tipoHormiga, String tipoAlimento, String genoma, String sexo,
            String estadoHormiga, String nombre, String descripcion, String estado, String fechaCreacion, String fechaModifica) {
        this.IdHormiga = idHormiga;
        this.TipoHormiga = tipoHormiga;
        this.TipoAlimento = tipoAlimento;
        this.Genoma = genoma;
        this.Sexo = sexo;
        this.EstadoHormiga = estadoHormiga;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
    public Integer getIdHormiga() {
        return IdHormiga;
    }
    public void setIdHormiga(Integer idHormiga) {
        this.IdHormiga = idHormiga;
    }
    public String getTipoHormiga() {
        return TipoHormiga;
    }
    public void setTipoHormiga(String tipoHormiga) {
        this.TipoHormiga = tipoHormiga;
    }
    public String getTipoAlimento() {
        return TipoAlimento;
    }
    public void setTipoAlimento(String tipoAlimento) {
        this.TipoAlimento = tipoAlimento;
    }
    public String getGenoma() {
        return Genoma;
    }
    public void setGenoma(String genoma) {
        this.Genoma = genoma;
    }
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String sexo) {
        this.Sexo = sexo;
    }
    public String getEstadoHormiga() {
        return EstadoHormiga;
    }
    public void setEstadoHormiga(String estadoHormiga) {
        this.EstadoHormiga = estadoHormiga;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        this.Estado = estado;
    }
    public String getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.FechaCreacion = fechaCreacion;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        this.FechaModifica = fechaModifica;
    }

    @Override
    public String toString () {
        return "\n" + getClass().getName()
             + "\n IdHormiga: " + getIdHormiga()
             + "\n TipoHormiga: " + getTipoHormiga()
             + "\n TipoAlimento: " + getTipoAlimento()
             + "\n Genoma: " + getGenoma()
             + "\n Sexo: " + getSexo()
             + "\n EstadoHormiga: " + getEstadoHormiga()
             + "\n Nombre: " + getNombre()
             + "\n Descripcion: " + getDescripcion()
             + "\n Estado: " + getEstado()
             + "\n FechaCreacion: " + getFechaCreacion()
             + "\n FechaModifica: " + getFechaModifica();
    }
}
