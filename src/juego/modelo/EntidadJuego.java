package juego.modelo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Clase base para cualquier entidad dibujable del juego.
 */
public abstract class EntidadJuego {
    private int x;
    private int y;
    private int ancho;
    private int alto;

    protected EntidadJuego(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Rectangle getLimites() {
        return new Rectangle(x, y, ancho, alto);
    }

    public abstract void mover(int anchoArea, int altoArea);

    public abstract void dibujar(Graphics2D g2d);
}
