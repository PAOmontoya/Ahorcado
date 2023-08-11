
package com.mycompany.ahorcado;
//Nicole

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
      
      
      
      
    public JuegoAhorcadoAzar() {
        jugar();
        
        
    }
    
    @Override
    void actualizarPalabraActual(char letra) {//Actualiza la palabra actualizada a medida que el jugador adivina letras.
        StringBuilder nuevaPalabraActual = new StringBuilder(palabraActual);
        
          for (int i = 0; i < palabraSecreta.length(); i++) {
              if(verificarLetra(letra)){
              nuevaPalabraActual.setCharAt(i, letra);
              //Jlabel.setText(nuevaPalabraActual);
          } 
        }
          if(!verificarLetra(letra)){
            JOptionPane.showMessageDialog(null, "No se encuentra esa letra en la palabra");
          }
    }
        

    @Override
    boolean verificarLetra(char letra) {// Verifica si la letra ingresada por el jugador es correcta.
        
        return palabraSecreta.contains(String.valueOf(letra));
    }

    @Override
    boolean hasGanado() {//Verifica si el jugador ha ganado el juego
          return palabraActual.equals(palabraSecreta);
        
        }

    @Override
    public void inicializarPalabraSecreta() {//incializa la palabra a usar
        AdminPalabrasSecretas admin =new  AdminPalabrasSecretas();
        admin.seleccionarPalabraAlAzar();
        
         }

    @Override
    public void jugar() {
        gameMenu game=new gameMenu();
        inicializarPalabraSecreta();
        inicializarPalabraSecreta();

        while (intentos > 0 && !hasGanado()) {
            char letraIngresada = game.letraGUESS.charAt(0);
            if (verificarLetra(letraIngresada)) {
                actualizarPalabraActual(letraIngresada);
            } else {
                intentos--;
            }
        }

        if(hasGanado()){
            JOptionPane.showMessageDialog(null, "¡HAS GANADO, FELICIDADES!");
        }else{
            JOptionPane.showMessageDialog(null, "Has perdido, se acabaron los intentos");
        }
        }
    
}
