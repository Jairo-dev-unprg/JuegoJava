package juego.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

public class PanelMenu extends JPanel {
    private final JButton botonIniciar;

    public PanelMenu() {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Juego 2D - Esquiva Obstáculos", JLabel.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));

        JLabel instrucciones = new JLabel("Mueve al jugador con A/D o flechas. Evita enemigos.", JLabel.CENTER);

        botonIniciar = new JButton("Iniciar Partida");

        add(titulo, BorderLayout.NORTH);
        add(instrucciones, BorderLayout.CENTER);
        add(botonIniciar, BorderLayout.SOUTH);
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }
}
