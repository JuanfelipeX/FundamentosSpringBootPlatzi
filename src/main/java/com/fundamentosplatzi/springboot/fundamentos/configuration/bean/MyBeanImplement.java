package com.fundamentosplatzi.springboot.fundamentos.configuration.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola Implementacion propia del bean");
    }
}
