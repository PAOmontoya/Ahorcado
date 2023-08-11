package com.mycompany.ahorcado;

import javax.swing.JOptionPane;



class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    private String palabraSecreta;
    private StringBuilder palabraAdivinada;
    private int intentosRestantes;

    public JuegoAhorcadoFijo(String palabraSecreta, int maxIntentos) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.palabraAdivinada = new StringBuilder("-".repeat(palabraSecreta.length()));
        this.intentosRestantes = maxIntentos;
    }
    
protected boolean adivinarLetra(char letra){
   letra = Character.toLowerCase(letra);
        boolean letraAdivinada = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada.setCharAt(i, letra);
                letraAdivinada = true;
            }
        }

        if (!letraAdivinada) {
            intentosRestantes--;
        }

        return letraAdivinada; 
}
   
    @Override
    void actualizarPalabraActual(char letra) {
        StringBuilder nuevaPalabraActual = new StringBuilder(palabraActual);
        
          for (int i = 0; i < palabraSecreta.length(); i++) {
              if(verificarLetra(letra)){
              nuevaPalabraActual.setCharAt(i, letra);
              //Jlabel.setText(nuevaPalabraActual);
          } 
        }
          if(!verificarLetra(letra)){
            JOptionPane.showMessageDialog(null, "No se encuentra esa letra en la palabra");
          } }

    @Override
    boolean verificarLetra(char letra) {
        return palabraSecreta.contains(String.valueOf(letra));
    }

    @Override
    boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
       }

    @Override
    public void inicializarPalabraSecreta() {
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


