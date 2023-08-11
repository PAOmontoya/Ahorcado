/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ahorcado;

/**
 *
 * @author josuc
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado {
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos = 6;
    
    abstract void actualizarPalabraActual(char letra);
    abstract boolean verificarLetra (char letra);
    abstract boolean hasGanado();
}
