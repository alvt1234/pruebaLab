
import java.util.Random;


public class JuegoAhorcadoAza extends JuegoAhorcadoBase {
    private String[] palabrasPosibles;

    public JuegoAhorcadoAza(String[] palabrasPosibles) {
        this.palabrasPosibles = palabrasPosibles;
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
        Random random = new Random();
        palabraSecreta = palabrasPosibles[random.nextInt(palabrasPosibles.length)];
    }

    @Override
    public void jugar() {
       
    }

}
