package juego.controlador;

import juego.modelo.Jugador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControlTecladoJuego extends KeyAdapter {
    private final GestorJuego gestorJuego;

    public ControlTecladoJuego(GestorJuego gestorJuego) {
        this.gestorJuego = gestorJuego;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Jugador jugador = gestorJuego.getJugador();
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            jugador.setIzquierda(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            jugador.setDerecha(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Jugador jugador = gestorJuego.getJugador();
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            jugador.setIzquierda(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            jugador.setDerecha(false);
        }
    }
}
