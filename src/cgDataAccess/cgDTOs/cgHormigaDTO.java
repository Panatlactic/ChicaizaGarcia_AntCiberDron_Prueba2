package cgDataAccess.cgDTOs;

public class cgHormigaDTO {
    private Integer IdHormiga;
    private Integer IdHormigaTipo;
    private Integer IdAlimentoTipo;
    private Integer IdGenoma;
    private Integer IdSexo;
    private Integer IdEstadoHormiga;
    private String Nombre;
    private String Descripcion;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public cgHormigaDTO () {}

    public cgHormigaDTO(Integer idHormiga, Integer idHormigaTipo, Integer idAlimentoTipo, Integer idGenoma,
            Integer idSexo, Integer idEstadoHormiga, String nombre, String descripcion, String estado,
            String fechaCreacion, String fechaModifica) {
        this.IdHormiga = idHormiga;
        this.IdHormigaTipo = idHormigaTipo;
        this.IdAlimentoTipo = idAlimentoTipo;
        this.IdGenoma = idGenoma;
        this.IdSexo = idSexo;
        this.IdEstadoHormiga = idEstadoHormiga;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }
    public void setIdHormiga(Integer idHormiga) {
        this.IdHormiga = idHormiga;
    }
    public Integer getIdHormigaTipo() {
        return IdHormigaTipo;
    }
    public void setIdHormigaTipo(Integer idHormigaTipo) {
        this.IdHormigaTipo = idHormigaTipo;
    }
    public Integer getIdAlimentoTipo() {
        return IdAlimentoTipo;
    }
    public void setIdAlimentoTipo(Integer idAlimentoTipo) {
        this.IdAlimentoTipo = idAlimentoTipo;
    }
    public Integer getIdGenoma() {
        return IdGenoma;
    }
    public void setIdGenoma(Integer idGenoma) {
        this.IdGenoma = idGenoma;
    }
    public Integer getIdSexo() {
        return IdSexo;
    }
    public void setIdSexo(Integer idSexo) {
        this.IdSexo = idSexo;
    }
    public Integer getIdEstadoHormiga() {
        return IdEstadoHormiga;
    }
    public void setIdEstadoHormiga(Integer idEstadoHormiga) {
        this.IdEstadoHormiga = idEstadoHormiga;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
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
             + "\n IdHormigaTipo: " + getIdHormigaTipo()
             + "\n IdAlimentoTipo: " + getIdAlimentoTipo()
             + "\n IdGenoma: " + getIdGenoma()
             + "\n IdSexo: " + getIdSexo()
             + "\n IdEstadoHormiga: " + getIdEstadoHormiga()
             + "\n Nombre: " + getNombre()
             + "\n Descripcion: " + getDescripcion()
             + "\n Estado: " + getEstado()
             + "\n FechaCreacion: " + getFechaCreacion()
             + "\n FechaModifca: " + getFechaModifica();
    }
}
