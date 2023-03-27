package org.hmis;

public class Coche {
    private String marca;
    private String modelo;
    private int año;
    private int precio;

    // Constructor por defecto
    public Coche() {}

    
    
    public Coche(String marca, String modelo, int año, int precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.precio = precio;
	}


	// Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
