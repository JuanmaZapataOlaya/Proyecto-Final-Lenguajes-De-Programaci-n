import javax.swing.*;  // Importa las clases de la biblioteca Swing para construir la interfaz gráfica.
import java.awt.*;  // Importa las clases del paquete awt para manejar componentes gráficos y eventos.
import java.awt.event.ActionEvent;  // Importa la clase ActionEvent para manejar eventos de acción.
import java.awt.event.ActionListener;  // Importa la interfaz ActionListener para manejar eventos de acción.
import java.io.BufferedReader;  // Importa la clase BufferedReader para leer archivos de texto.
import java.io.File;  // Importa la clase File para representar archivos o directorios en el sistema de archivos.
import java.io.FileReader;  // Importa la clase FileReader para leer caracteres desde un archivo.
import java.io.IOException;  // Importa la clase IOException para manejar excepciones relacionadas con la entrada/salida.
import java.util.HashMap;  // Importa la clase HashMap para almacenar pares clave-valor.
import java.util.regex.Matcher;  // Importa la clase Matcher para realizar operaciones de coincidencia de patrones.
import java.util.regex.Pattern;  // Importa la clase Pattern para representar patrones de expresiones regulares.
//GridBagLayout, gestor de diseño en Java
//FlowLayout,otro gestor de diseño en Java que organiza los componentes en una fila o columna,
//GridBagConstraints, define los parámetros de diseño
//BufferedReader, étodos para leer texto de una secuencia de entrada de caracteres.




// Clase principal que extiende de JFrame para crear la ventana principal de la aplicación.

public class Main extends JFrame {
    private HashMap<String, String> emojiMap;
    private int emojiCount;

    private static final int TAMANO_VENTANA_ANCHO = 400;
    private static final int TAMANO_VENTANA_ALTO = 300;
    private static final int TAMANO_AREA_TEXTO_FILAS = 3;
    private static final int TAMANO_AREA_TEXTO_COLUMNAS = 20;
    private static final int TAMANO_EMOJI = 40;
    private static final int TAMANO_TEXTO_DIALOGO = 30;

    public Main() {
        setTitle("Emoji Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(TAMANO_VENTANA_ANCHO, TAMANO_VENTANA_ALTO);
        setLocationRelativeTo(null);

        inicializarEmojiMap();
        emojiCount = 0;

    
        JLabel titleLabelBottom = new JLabel("EAFIT Lenguajes de Programacion");
        titleLabelBottom.setFont(new Font("Algerian", Font.BOLD, 18));
        titleLabelBottom.setForeground(Color.BLUE);
        titleLabelBottom.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabelBottom, BorderLayout.NORTH);
        
        ImageIcon logo = new ImageIcon("png/logo.png");
        Image image = logo.getImage(); 
        Image newImage = image.getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        logo = new ImageIcon(newImage);
        JLabel logoLabel = new JLabel(logo);
        add(logoLabel, BorderLayout.SOUTH); 

        JPanel panel = new JPanel(new GridBagLayout());

        JTextArea textoArea = new JTextArea(TAMANO_AREA_TEXTO_FILAS, TAMANO_AREA_TEXTO_COLUMNAS);
        panel.add(new JScrollPane(textoArea), createConstraints(0, 0, 2, 1));

        JButton mostrarButton = new JButton("Mostrar Texto y Emojis");
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTextoYEmojis(textoArea.getText());
            }
        });
        panel.add(mostrarButton, createConstraints(0, 1, 1, 1));

        add(panel);

        setVisible(true);
    }


    private GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight) {
        // Declaración de un método llamado createConstraints que devuelve un objeto de tipo GridBagConstraints.
        // Este método se utiliza para crear y configurar las restricciones de diseño para componentes en un GridBagLayout.

        GridBagConstraints constraints = new GridBagConstraints();
        // Crea un nuevo objeto GridBagConstraints que se utilizará para especificar cómo se colocarán y redimensionarán los componentes en un GridBagLayout.


        constraints.gridx = gridx;
// Establece la posición en la cuadrícula horizontal (columna) donde se colocará el componente.
// El valor gridx indica la columna en la cuadrícula.

        constraints.gridy = gridy;
// Establece la posición en la cuadrícula vertical (fila) donde se colocará el componente.
// El valor gridy indica la fila en la cuadrícula.

        constraints.gridwidth = gridwidth;
// Establece el número de celdas en el eje horizontal (columnas) que el componente ocupará.
// El valor gridwidth indica cuántas columnas ocupará el componente.

        constraints.gridheight = gridheight;
// Establece el número de celdas en el eje vertical (filas) que el componente ocupará.
// El valor gridheight indica cuántas filas ocupará el componente.

        constraints.fill = GridBagConstraints.BOTH;
// Establece cómo el componente debe expandirse para llenar el espacio disponible.
// GridBagConstraints.BOTH indica que el componente se expandirá tanto horizontal como verticalmente.

        constraints.insets = new Insets(2, 2, 2, 2);
// Establece los márgenes internos alrededor del componente en píxeles.
// En este caso, se establece un margen de 2 píxeles en la parte superior, derecha, inferior e izquierda del componente.

        return constraints;
// Devuelve el objeto GridBagConstraints configurado con las restricciones especificadas.

    }

    private void inicializarEmojiMap() {
        // Declaración de un método privado llamado inicializarEmojiMap, que no devuelve ningún valor.

        emojiMap = new HashMap<>();

        emojiMap.put(":)", "001-emoji.png");
        emojiMap.put("B-)", "002-emoticonos.png");
        emojiMap.put("B-)", "002-emoticonos.png");
        emojiMap.put("<_>", "003-feliz.png");
        emojiMap.put("_>", "003-feliz.png");
        emojiMap.put(":o", "004-conmocionado.png");
        emojiMap.put(":D", "005-sonriente.png");
        emojiMap.put("8-)", "006-feliz-1.png");
        emojiMap.put(":thinking:", "007-pensando.png");
        emojiMap.put(":confused:", "008-confuso.png");
        emojiMap.put(":(", "009-triste.png");
        emojiMap.put(":lol:", "010-risa.png");
        emojiMap.put(":angry:", "011-enojado.png");
        emojiMap.put(":shocked:", "012-conmocionado-1.png");
        emojiMap.put(":worried:", "013-preocuparse.png");
        emojiMap.put("8)", "014-sonrisa.png");
        emojiMap.put(")", "014-sonrisa.png");
        emojiMap.put("8,()", "015-emoji-1.png");
        emojiMap.put(",()", "015-emoji-1.png");
        emojiMap.put("+_+", "016-estrella.png");
        emojiMap.put("+_+", "016-estrella.png");
        emojiMap.put("v8)", "017-partido.png");
        emojiMap.put(";)", "018-guino.png");
        emojiMap.put("8D", "019-entusiasta.png");
        emojiMap.put(":like:", "020-me-gusta.png");
        emojiMap.put(":alien:", "021-cabeza-alienigena.png");
        emojiMap.put(":cat:", "022-gato.png");
        emojiMap.put(":alien2:", "023-cabeza-alienigena-1.png");
        emojiMap.put(":zzz:", "024-emoji-2.png");
        emojiMap.put("B^)", "025-nerd.png");
        emojiMap.put(":superhero:", "026-superhombre.png");
        emojiMap.put(":cool:", "027-fresco.png");
        emojiMap.put(":thumbsdown:", "028-pulgares-abajo.png");
        emojiMap.put(":dog:(:", "029-triste-1.png");
        emojiMap.put(":clown:", "030-payaso.png");
        emojiMap.put(":like2:", "031-me-gusta-1.png");
        emojiMap.put(":cry:", "032-llorar.png");
        emojiMap.put(":thinking2:", "033-pensando-1.png");
        emojiMap.put(":lick:", "034-relamerse.png");
        emojiMap.put(":angry2:", "035-enojado-1.png");
        emojiMap.put(":hug:", "036-abrazar.png");
        emojiMap.put(":swear:", "037-jurar.png");
        emojiMap.put(":bee:):", "038-sonriente-1.png");
        emojiMap.put(":pray:", "039-orar.png");
        emojiMap.put(":robot1:", "040-robot.png");
        emojiMap.put(":robot2:", "041-robot-1.png");
        emojiMap.put(":sick:", "042-enfermo.png");
        emojiMap.put(":hand:", "043-mano.png");
        emojiMap.put(":3dglasses:", "044-gafas-3d.png");
        emojiMap.put(":eat:", "045-como.png");
        emojiMap.put("grand:)", "047-feliz-2.png");
        emojiMap.put(":ghost:", "048-fantasma.png");
        emojiMap.put(":ghost2:", "049-fantasma-1.png");
        emojiMap.put(":dinolove:", "050-enamorado.png");
        emojiMap.put(":dinoangry:", "051-enojado-2.png");
        emojiMap.put(":dinoworker:", "052-obrero.png");
        emojiMap.put(":dinodizzy:", "053-mareado.png");
        emojiMap.put(":dinothinking:", "054-pensar.png");
        emojiMap.put(":dinosurprised:", "055-sorpresa.png");
        emojiMap.put(":poop:", "056-caca.png");
        emojiMap.put(":mask:", "057-mascara-medica.png");
        emojiMap.put("8,D", "058-riendo.png");
        emojiMap.put("8(:", "059-triste-2.png");
        emojiMap.put(":dog:", "060-perro.png");
        emojiMap.put(":dog2:", "061-perro-1.png");
        emojiMap.put(":dog3:", "062-perro-2.png");
        emojiMap.put(":dog4:", "063-perro-3.png");
        emojiMap.put(":dog5:", "064-perro-4.png");
        emojiMap.put(":dog6:", "065-perro-5.png");
        emojiMap.put(":dog7:", "066-perro-6.png");
    }


    private void mostrarTextoYEmojis(String texto) {
        JPanel emojiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        int palabrasEnDiccionario = 0;
        emojiCount = 0;


        // String[] palabras = texto.split("\\s|[:;8]|(?<=[:\\)\\>\\+])(?=[a-z])");   Emoji simple en donde quiera / No sirven los complicados

        String[] palabras = texto.split("\\s|(?=[:;8][\\)])|(?=[:;8][\\w+]+[:])|(?<=[\\)\\()])(?=[a-z])|(?<=[:])(?=[\\w+]+[$|\\s])");
        
        for (String palabra : palabras) {
            String nombreArchivo = emojiMap.getOrDefault(palabra, null);

            if (nombreArchivo != null) {
                emojiCount++;
                ImageIcon icono = new ImageIcon("png/" + nombreArchivo);
                Image imagenEscalada = icono.getImage().getScaledInstance(TAMANO_EMOJI, TAMANO_EMOJI, Image.SCALE_SMOOTH);
                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
                JLabel emojiLabel = new JLabel(iconoEscalado);
                emojiPanel.add(emojiLabel);
            } else {
                if (esPalabraEnDiccionario(palabra)) {
                    palabrasEnDiccionario++;
                }
                JLabel textoLabel = new JLabel(palabra + " ");
                textoLabel.setFont(new Font("Arial", Font.PLAIN, TAMANO_TEXTO_DIALOGO));
                emojiPanel.add(textoLabel);
            }
        }
    
        JPanel contadorPanel = new JPanel(new GridLayout(2, 1));
        contadorPanel.add(new JLabel("Palabras encontradas en el Diccionario: " + palabrasEnDiccionario));
        JLabel emojiCountLabel = new JLabel("Contador de Emojis: " + emojiCount);
        emojiCountLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        contadorPanel.add(emojiCountLabel);
    
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(emojiPanel, BorderLayout.CENTER);
        mainPanel.add(contadorPanel, BorderLayout.SOUTH);
    
        JOptionPane.showMessageDialog(this, mainPanel, "Texto, Emojis y Contadores", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    

    private boolean esPalabraEnDiccionario(String palabra) {
        File diccionarioFile = new File("diccionario.txt");

        if (diccionarioFile.exists() && diccionarioFile.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(diccionarioFile))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (contienePalabraEnLinea(linea, palabra)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private boolean contienePalabraEnLinea(String linea, String palabra) {
        String regex = "\\b" + quitarDiacriticos(palabra) + "(\\S*)?\\b";
        // Usamos "\\S*" para permitir cero o más caracteres que no sean un espacio en blanco, lo que permitirá emojis justo después de la palabra.
    
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(quitarDiacriticos(linea));
    
        return matcher.find();
    }
    

    private String quitarDiacriticos(String input) {
        return java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }


  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
