package juego.vista;

import juego.controlador.GestorJuego;
import juego.modelo.Enemigo;
import juego.modelo.Jugador;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PanelJuego extends JPanel {
    private final GestorJuego gestorJuego;
    private final Timer timer;

    public PanelJuego(GestorJuego gestorJuego) {
        this.gestorJuego = gestorJuego;
        this.timer = new Timer(16, e -> {
            gestorJuego.actualizar();
            repaint();
        });

        setBackground(new Color(245, 245, 245));
        setFocusable(true);
    }

    public void iniciarBucle() {
        timer.start();
    }

    public void detenerBucle() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Jugador jugador = gestorJuego.getJugador();
        jugador.dibujar(g2d);

        for (Enemigo enemigo : gestorJuego.getEnemigos()) {
            enemigo.dibujar(g2d);
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2d.drawString("Vidas: " + jugador.getVidas(), 10, 20);
        g2d.drawString("Puntaje: " + gestorJuego.getPuntaje(), 10, 40);
    }
}
