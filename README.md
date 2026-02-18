# JuegoJava - Juego 2D en Java (Swing)

Proyecto de ejemplo para un **juego bidimensional (2D)** en Java, desarrollado con enfoque en:

- Programación Orientada a Objetos (POO)
- Interfaces gráficas (Swing)
- Manejo de eventos (teclado y botones)
- Lógica de juego, estados y colisiones

## Estructura del proyecto

```text
src/
  juego/
    Main.java
    modelo/
      EntidadJuego.java
      Personaje.java
      Jugador.java
      Enemigo.java
      EstadoJuego.java
    controlador/
      GestorJuego.java
      ControlTecladoJuego.java
    vista/
      VentanaJuego.java
      PanelMenu.java
      PanelJuego.java
      PanelFinJuego.java
```

## Cómo ejecutar

1. Compilar:

```bash
javac -d out $(find src -name "*.java")
```

2. Ejecutar:

```bash
java -cp out juego.Main
```

## Mecánica del juego

- Pantallas incluidas:
  - Menú principal
  - Área de juego
  - Pantalla de fin de juego
- Control del usuario:
  - Teclas **A/D** o **←/→** para mover al jugador
  - Botones para iniciar y volver al menú
- Reglas:
  - El jugador tiene 3 vidas
  - Si colisiona con enemigos, pierde vidas
  - Cuando las vidas llegan a 0, termina la partida
  - El puntaje aumenta con el tiempo

## POO aplicada

- **Encapsulamiento**: atributos privados con métodos públicos.
- **Herencia**: `Personaje` hereda de `EntidadJuego`; `Jugador` y `Enemigo` heredan de `Personaje`.
- **Polimorfismo**: cada entidad implementa `mover()` y `dibujar()` de forma diferente.
- **Abstracción**: uso de clases abstractas para generalizar comportamiento.

Este proyecto es compatible con ejecución local en Apache NetBeans como aplicación de escritorio Java.
