package main.java.com.si3ri.interfaces;

    import javax.swing.*;
    import javax.swing.border.Border;
    import javax.swing.border.EmptyBorder;
    import java.awt.*;
    import java.awt.event.FocusAdapter;
    import java.awt.event.FocusEvent;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.regex.Pattern;

    public class AthleticRaceInterface extends JFrame {
    private final JTextField cajaTextoNombre;
    private final JButton botonRegistrar;
    private final JTextArea cajaNombresIngresados;
    private final JTextArea cajaResultados;
    private final JButton botonIniciar;
    private final Set<String> nombres = new HashSet<>(); // Variable para almacenar los nombres y la escritura de nombre válido.
    private final Pattern escrituraNombre = Pattern.compile("[A-Z][a-z]+"); // ("[A-Z][a-z]+\\s[A-Z][a-z]+");
    private static final String Placeholder = "Ingresa nombre...";
    private Runner[] runners = new Runner[5];
    private int runnerCount = 0;
    private boolean carreraEnCurso = false;

    public AthleticRaceInterface() {
        super("Carrera Atlética");
        this.setLayout(new BorderLayout());

        // Panel Superior que muestra las características de la etiqueta texto 'Registrar' y componentes inferiores.
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel textoSeccionUno = new JLabel("Registrar corredor: ");
        textoSeccionUno.setFont(new Font("Arial", Font.BOLD, 14));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
        textoSeccionUno.setHorizontalAlignment(JLabel.LEFT);
        panelSuperior.add(textoSeccionUno, BorderLayout.NORTH);

        // Panel Entrada que genera los márgenes/bordes entre componentes y principalmente con la caja de texto.
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 5); // Se agrega espacio entre componentes.

        // Características de la caja de texto para el ingreso de nombres.
        cajaTextoNombre = new JTextField(20);
        cajaTextoNombre.setPreferredSize(new Dimension(100, 40));
        Border bordeOriginal = cajaTextoNombre.getBorder(); // Se obtiene el borde original del JTextField.
        Border bordeInterno = BorderFactory.createEmptyBorder(5, 10, 5, 10); // Crea y se agregan 10 píxeles de padding (margen interno vacío) en cada lado.
        Border bordeCompuesto = BorderFactory.createCompoundBorder(bordeOriginal, bordeInterno); // Se crea el borde compuesto usando el borde original y el borde vacío (interno).
        cajaTextoNombre.setBorder(bordeCompuesto); // Establece el borde compuesto alrededor del JTextField.
        cajaTextoNombre.setText(Placeholder); // Agrega el texto sombrío cuando no está seleccionada la caja de texto.
        cajaTextoNombre.setForeground(Color.GRAY);

        // Organiza la posición y medida de los componentes.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Hace que el campo de texto ocupe el espacio disponible entre los componentes caja de texto y botón 'Registrar'.
        panelEntrada.add(cajaTextoNombre, gbc); // Agrupa la caja de texto con el 'GridBagConstraints (gbc)'.

        // Se añade un componente invisible para proporcionar separación entre la caja de texto y el botón 'Registrar'.
        gbc.gridx = 1;
        gbc.weightx = 0.0;
        panelEntrada.add(Box.createHorizontalStrut(15), gbc); // Se crea un espacio invisible de 15 píxeles.

        // Panel Superior con las características del botón 'Registrar'.
        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setFont(new Font("Arial", Font.PLAIN, 12));
        panelSuperior.add(botonRegistrar);
        Dimension dimensionR = new Dimension(160, 40);
        botonRegistrar.setPreferredSize(dimensionR);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que el botón se estire horizontalmente.
        gbc.weightx = 0.0; // El botón expande su tamaño horizontalmente al engrandecer la pantalla.
        panelEntrada.add(botonRegistrar, gbc); // Agrupa el botón 'Registrar' con el 'GridBagConstraints (gbc)'.
        panelSuperior.add(panelEntrada, BorderLayout.CENTER);

        // Características del 'Placeholder'; el texto sombrío cuando no está activo el cursor.
        cajaTextoNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cajaTextoNombre.getText().equals(Placeholder)) {
                    cajaTextoNombre.setText(""); // Limpia la caja de texto para ingresar un nombre.
                    cajaTextoNombre.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (cajaTextoNombre.getText().isEmpty()) {
                    cajaTextoNombre.setText("");
                    cajaTextoNombre.setForeground(Color.GRAY);
                    cajaTextoNombre.setText(Placeholder); // Muestra el 'Placeholder'.
                }
            }
        });

        // Panel Central con las características para mostrar los nombres ingresados.
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cajaNombresIngresados = new JTextArea(6, 30);
        cajaNombresIngresados.setEditable(false);
        Border borde = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        cajaNombresIngresados.setBorder(borde);
        JScrollPane scroll = new JScrollPane(cajaNombresIngresados);
        panelCentral.add(scroll, BorderLayout.CENTER);
        JLabel textoSeccionDos = new JLabel("Corredores registrados: ");
        textoSeccionDos.setFont(new Font("Arial", Font.BOLD, 14));
        textoSeccionDos.setHorizontalAlignment(JLabel.LEFT);
        panelCentral.add(textoSeccionDos, BorderLayout.NORTH);

        // Panel Inferior para la caja de texto y principalmente para el texto 'Resultados'.
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel textoSeccionTres = new JLabel("Resultados: ");
        textoSeccionTres.setFont(new Font("Arial", Font.BOLD, 14));
        textoSeccionTres.setHorizontalAlignment(JLabel.LEFT);
        panelInferior.add(textoSeccionTres, BorderLayout.NORTH);

        // Panel de las características generales de los botones.
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(new EmptyBorder(0, 5, 0, 0));

        // Características del botón 'Iniciar'.
        botonIniciar = new JButton("Iniciar");
        Dimension dimension = new Dimension(100, 30);
        botonIniciar.setFont(new Font("Arial", Font.PLAIN, 12));
        botonIniciar.setPreferredSize(dimension);
        botonIniciar.setMinimumSize(dimension);
        botonIniciar.setMaximumSize(dimension);
        botonIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBotones.add(botonIniciar);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 13))); // Espacio vertical entre los botones continuos.

        // Características del botón 'Reiniciar'.
        JButton botonReiniciar = new JButton("Reiniciar");
        Dimension dimensionTwo = new Dimension(100, 30); // Dimensiones fijas del botón.
        botonReiniciar.setFont(new Font("Arial", Font.PLAIN, 12));
        botonReiniciar.setPreferredSize(dimensionTwo);
        botonReiniciar.setMinimumSize(dimensionTwo);
        botonReiniciar.setMaximumSize(dimensionTwo);
        botonReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBotones.add(botonReiniciar);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 13)));

        // Características del botón 'Terminar'.
        JButton botonTerminar = new JButton("Terminar");
        Dimension dimensionThree = new Dimension(100, 30);
        botonTerminar.setFont(new Font("Arial", Font.PLAIN, 12));
        botonTerminar.setPreferredSize(dimensionThree);
        botonTerminar.setMinimumSize(dimensionThree);
        botonTerminar.setMaximumSize(dimensionThree);
        botonTerminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBotones.add(botonTerminar);

        // Características de la caja de y que muestra 'Resultados'.
        cajaResultados = new JTextArea(6, 30);
        cajaResultados.setEditable(false); // La caja no puede ser editada manualmente.
        Border bordeThree = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        cajaResultados.setBorder(bordeThree);
        JScrollPane scroll2 = new JScrollPane(cajaResultados);
        panelInferior.add(scroll2, BorderLayout.CENTER);
        panelInferior.add(panelBotones, BorderLayout.EAST);

        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);

        // Action Listeners de las funciones al ser presionados los botones con Lambda.
        botonRegistrar.addActionListener(e -> registrarCorredor());

        botonIniciar.addActionListener(e -> iniciarCarrera());

        botonReiniciar.addActionListener(e -> reiniciarCarrera());

        botonTerminar.addActionListener(e -> System.exit(0));

        // Características generales de la pantalla al ser ejecutada.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null); // Centrar la ventana en la pantalla del dispositivo.
        this.setVisible(true);
    }

    // Funciones del botón 'Registrar'.
    private void registrarCorredor() {
        String nombre = cajaTextoNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La caja de texto no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            cajaTextoNombre.requestFocusInWindow();
            return;
        }

        // Válida la escritura del nombre.
        if (!escrituraNombre.matcher(nombre).matches()) {
            JOptionPane.showMessageDialog(this, "Nombre inválido - Ejemplo del nombre: Luffy", "Alerta", JOptionPane.WARNING_MESSAGE);
            cajaTextoNombre.setText(""); // Limpia la caja de texto.
            cajaTextoNombre.requestFocusInWindow(); // Activa el foco o cursor en la caja de texto.
            return;
        }

        // Verifica si el nombre ya está registrado.
        if (nombres.contains(nombre)) {
            JOptionPane.showMessageDialog(this, "El corredor ya fue registrado", "Alerta", JOptionPane.WARNING_MESSAGE);
            cajaTextoNombre.setText("");
            cajaTextoNombre.requestFocusInWindow();
            return;
        }

        // Verifica el límite de corredores a competir al ingresar más de 5 corredores.
        if (runnerCount >= 5) {
            JOptionPane.showMessageDialog(this, "No se pueden registrar más de 5 corredores", "Error", JOptionPane.ERROR_MESSAGE);
            cajaTextoNombre.setText("");
            cajaTextoNombre.requestFocusInWindow();
            return;
        }

        // Características para 'Registrar' el corredor.
        nombres.add(nombre);
        runners[runnerCount++] = new Runner(nombre);
        cajaTextoNombre.setText("");
        muestraNombres(); // Método que muestra los nombres en listados cuando son agregados.
        cajaTextoNombre.requestFocusInWindow();  // Activa el foco en el campo de texto.
    }

    // Método que muestra en listados los nombres de los corredores al ser agregados.
    private void muestraNombres() {
        StringBuilder sb = new StringBuilder();
        int contador = 1;
        for (String nombre : nombres) {
            sb.append(contador++).append(" - ").append(nombre).append("\n");
        }
        cajaNombresIngresados.setText(sb.toString());
    }

    // Funciones del botón 'Iniciar'.
    private void iniciarCarrera() {
        if (runnerCount < 5) {
            JOptionPane.showMessageDialog(this, "Deben estar registrados los 5 corredores", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (carreraEnCurso) {
            JOptionPane.showMessageDialog(this, "La carrera ya está en curso", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        carreraEnCurso = true; // Se habilita la carrera.
        botonIniciar.setEnabled(false); // Se deshabilita el botón "Iniciar" cuando la carrera comienza.
        botonRegistrar.setEnabled(false); // Se deshabilita el botón "Registrar" cuando la carrera comienza.
        cajaTextoNombre.setEnabled(false); // Se deshabilita la caja de texto cuando la carrera comienza.

        // Se aplica 'for' para ir iterando entre los corredores, que serán mostrados en la caja de 'Resultados'.
        for (int i = 0; i < runnerCount; i++) {
            new Thread(new ThreadRunner(runners[i], cajaResultados)).start();
        }
    }

    // Funciones del botón 'Reiniciar'.
    private void reiniciarCarrera() {
        for (int i = 0; i < runnerCount; i++) {
            if (runners[i] != null) {
                runners[i].stopRunning(); // 'For' para detener los hilos en ejecución.
            }
        }

        try {
            Thread.sleep(200); // Esperar 200 milisegundos para asegurar que los hilos se detengan.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Se restablecen los datos y componentes para una nueva carrera.
        runnerCount = 0;
        runners = new Runner[5];
        nombres.clear();
        cajaNombresIngresados.setText("");
        cajaResultados.setText("");
        carreraEnCurso = false;
        botonIniciar.setEnabled(true);
        botonRegistrar.setEnabled(true);
        cajaTextoNombre.setEnabled(true); // Habilitar la caja de texto al reiniciar la carrera.
        cajaTextoNombre.requestFocusInWindow(); // Activar el foco en la caja de texto.
        ThreadRunner.resetContadorPosiciones(); // Restablecer el contador de posiciones.
    }
}
