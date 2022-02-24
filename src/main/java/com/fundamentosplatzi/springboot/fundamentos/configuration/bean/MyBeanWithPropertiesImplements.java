package com.fundamentosplatzi.springboot.fundamentos.configuration.bean;

public class MyBeanWithPropertiesImplements implements MyBeanWithProperties{

    private String nombre;
    private String apellido;

    public MyBeanWithPropertiesImplements(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + " - " + apellido;
    }
}
