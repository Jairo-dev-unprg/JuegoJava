package juego.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

public class PanelFinJuego extends JPanel {
    private final JLabel etiquetaResultado;
    private final JButton botonReiniciar;

    public PanelFinJuego() {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Fin del Juego", JLabel.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));

        etiquetaResultado = new JLabel("Puntaje: 0", JLabel.CENTER);
        etiquetaResultado.setFont(new Font("SansSerif", Font.PLAIN, 20));

        botonReiniciar = new JButton("Volver al menú");

        add(titulo, BorderLayout.NORTH);
        add(etiquetaResultado, BorderLayout.CENTER);
        add(botonReiniciar, BorderLayout.SOUTH);
    }

    public void setPuntajeFinal(int puntaje) {
        etiquetaResultado.setText("Puntaje final: " + puntaje);
    }

    public JButton getBotonReiniciar() {
        return botonReiniciar;
    }
}
