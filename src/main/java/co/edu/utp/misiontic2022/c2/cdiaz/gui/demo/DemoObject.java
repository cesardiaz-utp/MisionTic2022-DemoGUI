package co.edu.utp.misiontic2022.c2.cdiaz.gui.demo;

public class DemoObject {
    private Integer id;
    private String nombre;

    public DemoObject(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
}
