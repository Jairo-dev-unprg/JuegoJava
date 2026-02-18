package juego.vista;

import juego.controlador.ControlTecladoJuego;
import juego.controlador.GestorJuego;
import juego.modelo.EstadoJuego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.CardLayout;

public class VentanaJuego extends JFrame {
    private static final String VISTA_MENU = "menu";
    private static final String VISTA_JUEGO = "juego";
    private static final String VISTA_FIN = "fin";

    private final CardLayout cardLayout;
    private final JPanel contenedor;

    private final GestorJuego gestorJuego;
    private final PanelMenu panelMenu;
    private final PanelJuego panelJuego;
    private final PanelFinJuego panelFinJuego;

    public VentanaJuego() {
        setTitle("Juego Java 2D - POO + Eventos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        gestorJuego = new GestorJuego(700, 500);
        panelMenu = new PanelMenu();
        panelJuego = new PanelJuego(gestorJuego);
        panelFinJuego = new PanelFinJuego();

        contenedor.add(panelMenu, VISTA_MENU);
        contenedor.add(panelJuego, VISTA_JUEGO);
        contenedor.add(panelFinJuego, VISTA_FIN);

        add(contenedor);
        configurarEventos();
        iniciarObservadorEstado();
    }

    private void configurarEventos() {
        panelMenu.getBotonIniciar().addActionListener(e -> {
            gestorJuego.iniciarPartida();
            panelJuego.iniciarBucle();
            panelJuego.requestFocusInWindow();
            cardLayout.show(contenedor, VISTA_JUEGO);
        });

        panelFinJuego.getBotonReiniciar().addActionListener(e -> {
            gestorJuego.reiniciarPartida();
            cardLayout.show(contenedor, VISTA_MENU);
        });

        panelJuego.addKeyListener(new ControlTecladoJuego(gestorJuego));
    }

    private void iniciarObservadorEstado() {
        Timer timerEstado = new Timer(100, e -> {
            if (gestorJuego.getEstado() == EstadoJuego.FIN) {
                panelJuego.detenerBucle();
                panelFinJuego.setPuntajeFinal(gestorJuego.getPuntaje());
                cardLayout.show(contenedor, VISTA_FIN);
            }
        });
        timerEstado.start();
    }

    public static void iniciar() {
        SwingUtilities.invokeLater(() -> {
            VentanaJuego ventana = new VentanaJuego();
            ventana.setVisible(true);
        });
    }
}
