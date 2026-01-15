package cgDataAccess.cgDTOs;

public class cgAlimentoPreparadoDTO {
    private Integer IdAlimentoPreparado;
    private String Nombre;
    private String Descripcion;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public cgAlimentoPreparadoDTO () {}

    public cgAlimentoPreparadoDTO(Integer IdAlimentoPreparado, String nombre, String descripcion, String estado,
            String fechaCreacion, String fechaModifica) {
        this.IdAlimentoPreparado = IdAlimentoPreparado;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdAlimentoPreparado() {
        return IdAlimentoPreparado;
    }
    public void setIdAlimentoPreparado(Integer IdAlimentoPreparado) {
        this.IdAlimentoPreparado = IdAlimentoPreparado;
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
             + "\n IdAlimentoPreparado: " + getIdAlimentoPreparado()
             + "\n Nombre: " + getNombre()
             + "\n Descripcion: " + getDescripcion()
             + "\n Estado: " + getEstado()
             + "\n FechaCreacion " + getFechaCreacion()
             + "\n FechaModifica: " + getFechaModifica();
    }
}
