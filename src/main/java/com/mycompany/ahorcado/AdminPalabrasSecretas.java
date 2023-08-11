/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ahorcado;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author josuc
 */
public class AdminPalabrasSecretas {
    private ArrayList <String> palabrasSecretas;
    
    public AdminPalabrasSecretas () {
        this.palabrasSecretas = new ArrayList<>();
    }
    
    public void agregarPalabra(String palabra) {
        this.palabrasSecretas.add(palabra);
    }
    
    public String seleccionarPalabraAlAzar() {
        Random random = new Random();
        int posicionRandom = random.nextInt(0, palabrasSecretas.size());
        return palabrasSecretas.get(posicionRandom);
    }

    public ArrayList<String> getPalabrasSecretas() {
        return palabrasSecretas;
    }
    
    
}
