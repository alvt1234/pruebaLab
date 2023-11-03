import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class JuegoAhorcadoSwing {
    private JFrame frame;
    private JPanel panel;
    private JLabel palabraLabel;
    private JLabel intentosLabel;
    private JTextField letraTextField;
    private JButton jugarButton;

    private String palabraSecreta;
    private String palabraActual;
    private int intentos;

    public JuegoAhorcadoSwing() {
        frame = new JFrame("Juego del Ahorcado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        palabraLabel = new JLabel();
        intentosLabel = new JLabel();
        letraTextField = new JTextField();
        jugarButton = new JButton("Jugar");

        panel.add(new JLabel("Palabra: "));
        panel.add(palabraLabel);
        panel.add(new JLabel("Intentos restantes: "));
        panel.add(intentosLabel);
        panel.add(new JLabel("Ingresa una letra: "));
        panel.add(letraTextField);

        jugarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar();
            }
        });

        panel.add(jugarButton);

        frame.add(panel);
        frame.setVisible(true);

        inicializarJuego();
    }

    private void inicializarJuego() {
        ArrayList<String> palabrasPosibles = new ArrayList<>();
        palabrasPosibles.add("manzana");
        palabrasPosibles.add("pera");
        palabrasPosibles.add("uva");
        palabrasPosibles.add("platano");
        palabrasPosibles.add("sandia");
        palabrasPosibles.add("kiwi");
        palabrasPosibles.add("fresa");
        palabrasPosibles.add("mango");
        palabrasPosibles.add("cereza");
        palabrasPosibles.add("piña");

        Random random = new Random();
        palabraSecreta = palabrasPosibles.get(random.nextInt(palabrasPosibles.size()));
        palabraActual = "_".repeat(palabraSecreta.length());
        intentos = 6;

        palabraLabel.setText(palabraActual);
        intentosLabel.setText(String.valueOf(intentos));
    }

    private void jugar() {
        String letra = letraTextField.getText();
        if (letra.length() != 1) {
            JOptionPane.showMessageDialog(frame, "Ingresa una sola letra.");
            return;
        }

        if (palabraSecreta.contains(letra)) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra.charAt(0)) {
                    StringBuilder temp = new StringBuilder(palabraActual);
                    temp.setCharAt(i, letra.charAt(0));
                    palabraActual = temp.toString();
                }
            }
        } else {
            intentos--;
        }

        palabraLabel.setText(palabraActual);
        intentosLabel.setText(String.valueOf(intentos));

        if (intentos == 0) {
            JOptionPane.showMessageDialog(frame, "¡Has perdido! La palabra era: " + palabraSecreta);
            reiniciarJuego();
        } else if (palabraActual.equals(palabraSecreta)) {
            JOptionPane.showMessageDialog(frame, "¡Has ganado! La palabra era: " + palabraSecreta);
            reiniciarJuego();
        }

        letraTextField.setText("");
    }

    private void reiniciarJuego() {
        inicializarJuego();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JuegoAhorcadoSwing();
        });
    }
}
