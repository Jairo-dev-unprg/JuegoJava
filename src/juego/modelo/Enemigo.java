package juego.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemigo extends Personaje {
    private final Random random;
    private int velocidad;

    public Enemigo(int x, int y, int velocidad) {
        super(x, y, 35, 35, 1);
        this.random = new Random();
        this.velocidad = velocidad;
    }

    public void aumentarVelocidad() {
        velocidad++;
    }

    @Override
    public void mover(int anchoArea, int altoArea) {
        setY(getY() + velocidad);
        if (getY() > altoArea) {
            setY(-getAlto());
            setX(random.nextInt(Math.max(1, anchoArea - getAncho())));
        }
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        g2d.setColor(new Color(220, 20, 60));
        g2d.fillRect(getX(), getY(), getAncho(), getAlto());
    }
}
