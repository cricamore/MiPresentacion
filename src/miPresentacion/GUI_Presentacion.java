package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton mifoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JTextArea textoExpectativas, textoHobby;
    private JLabel labelImagen;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion(){
        initGUI();

        //Configuracion base de la ventana
        this.setTitle("Mi Presentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Cristian, oprime los botones...",Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Calibri",Font.PLAIN,20),Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        mifoto = new JButton("Este soy yo");
        mifoto.addActionListener(escucha);
        miHobby = new JButton("Este es mi Hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(mifoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10, 12);
        textoHobby = new JTextArea(10, 12);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener{
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"oprimiste boton");
            panelDatos.removeAll();
            if(e.getSource()==mifoto){
                image = new ImageIcon(getClass().getResource("/recursos/micara.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource()==miHobby){
                    image = new ImageIcon(getClass().getResource("/recursos/postres.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);

                    textoHobby.setText("Mi pasatiempo favorito es hacer postres. Es uno de mis hobbies \n" +
                            "favoritos desde hace más de 10 años y me la paso haciendo recetas \n" +
                            "que encuentro principalmente en internet.");
                    textoHobby.setFont(new Font("Arial",Font.BOLD,17));
                    textoHobby.setBackground(null);

                    panelDatos.add(textoHobby);

                }else{
                    textoExpectativas.setText("Es mi primera vez viendo el lenguaje de programación de java, y espero \n" +
                            "que este curso sea de gran ayuda para mi, para aprender adecuadamente \n" +
                            "sobre los eventos, divertirme programando y dar cada vez mas \n" +
                            "lo mejor de mi en este semestre que apenas comienza.");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setFont(new Font("Arial",Font.BOLD,15));
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }

}
