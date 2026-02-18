package juego.modelo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Jugador extends Personaje {
    private int velocidad;
    private boolean izquierda;
    private boolean derecha;

    public Jugador(int x, int y) {
        super(x, y, 45, 45, 3);
        this.velocidad = 6;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    @Override
    public void mover(int anchoArea, int altoArea) {
        int nuevoX = getX();

        if (izquierda) {
            nuevoX -= velocidad;
        }
        if (derecha) {
            nuevoX += velocidad;
        }

        if (nuevoX < 0) {
            nuevoX = 0;
        }
        if (nuevoX + getAncho() > anchoArea) {
            nuevoX = anchoArea - getAncho();
        }
        setX(nuevoX);
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        g2d.setColor(new Color(70, 130, 180));
        g2d.fillRoundRect(getX(), getY(), getAncho(), getAlto(), 10, 10);
    }
}
