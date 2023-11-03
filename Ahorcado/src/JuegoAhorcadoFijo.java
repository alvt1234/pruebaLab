

public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{

    private String palabrasecreta;

    public JuegoAhorcadoFijo(String palabrasecreta) {
        this.palabrasecreta = palabrasecreta;
        this.intentos = 6; 
        this.palabraActual = "_".repeat(palabraSecreta.length());
    }

   
    @Override
    public void actualizarPalabraActual(char letra){
       String nuevaPalabraActual = "";
    for (int i = 0; i < palabraSecreta.length(); i++) {
        if (palabraSecreta.charAt(i) == letra) {
            nuevaPalabraActual += letra;
        } else {
            nuevaPalabraActual += palabraActual.charAt(i);
        }
    }
    palabraActual = nuevaPalabraActual;  
    }

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
       
    }

    @Override
    public void jugar() {
       
    }
}
        

