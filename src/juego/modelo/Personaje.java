package juego.modelo;

/**
 * Representa entidades con puntos de vida.
 */
public abstract class Personaje extends EntidadJuego {
    private int vidas;

    protected Personaje(int x, int y, int ancho, int alto, int vidas) {
        super(x, y, ancho, alto);
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }

    public void perderVida() {
        vidas--;
    }
}
