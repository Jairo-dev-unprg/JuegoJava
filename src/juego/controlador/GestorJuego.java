package juego.controlador;

import juego.modelo.Enemigo;
import juego.modelo.EstadoJuego;
import juego.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Lógica principal del juego: estados, reglas, puntaje y colisiones.
 */
public class GestorJuego {
    private final int ancho;
    private final int alto;
    private final Random random;
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private int puntaje;
    private EstadoJuego estado;

    public GestorJuego(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.random = new Random();
        this.estado = EstadoJuego.MENU;
        reiniciarPartida();
    }

    public void iniciarPartida() {
        estado = EstadoJuego.JUGANDO;
    }

    public void reiniciarPartida() {
        jugador = new Jugador(ancho / 2 - 22, alto - 70);
        enemigos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enemigos.add(crearEnemigoAleatorio(i * -90));
        }
        puntaje = 0;
        estado = EstadoJuego.MENU;
    }

    private Enemigo crearEnemigoAleatorio(int y) {
        int x = random.nextInt(Math.max(1, ancho - 35));
        int velocidad = 2 + random.nextInt(3);
        return new Enemigo(x, y, velocidad);
    }

    public void actualizar() {
        if (estado != EstadoJuego.JUGANDO) {
            return;
        }

        jugador.mover(ancho, alto);

        for (Enemigo enemigo : enemigos) {
            enemigo.mover(ancho, alto);

            if (enemigo.getLimites().intersects(jugador.getLimites())) {
                jugador.perderVida();
                enemigo.setY(-enemigo.getAlto());
                enemigo.setX(random.nextInt(Math.max(1, ancho - enemigo.getAncho())));

                if (jugador.getVidas() <= 0) {
                    estado = EstadoJuego.FIN;
                    return;
                }
            }
        }

        puntaje++;
        if (puntaje % 400 == 0) {
            for (Enemigo enemigo : enemigos) {
                enemigo.aumentarVelocidad();
            }
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public EstadoJuego getEstado() {
        return estado;
    }
}
