package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos(botones,texto,marcos...)
    private JButton miFoto, miHobby, misExpectativas;
    private Titulos titulo;
    private JPanel panelBotones, panelDatos;
    private Escucha escucha;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    //metodos(lo que la ventana puede hacer)
    public GUI_Presentacion(){
        initGUI();
        //Configuracion base de la ventana,constructor
        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha= new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Diana,oprime los botones",Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos= new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",
                TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,
                new Font("Calibri",Font.BOLD,20), Color.BLACK));

        panelDatos.addMouseListener(escucha);
        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);
        this.add(panelDatos,BorderLayout.CENTER);


        miFoto= new JButton("Esta soy yo");
        miFoto.addMouseListener(escucha);
        miHobby= new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas= new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones= new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen= new JLabel();
        textoExpectativas= new JTextArea(10,12);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion niGUIPresentacion= new GUI_Presentacion();
            }
        });
}
    private  class Escucha implements  MouseListener, KeyListener{
        private ImageIcon image;
        @Override
        public void keyTyped(KeyEvent e) {
            panelDatos.removeAll();
            if(e.getKeyChar()=='m'){
                textoExpectativas.append("No sé de java pero si de objetos \n"+
                        "quiero aprender un poco de java y de eventos \n" +
                        "y programacion concurrente");
                textoExpectativas.setFont(new Font(Font.DIALOG,Font.BOLD+Font.ITALIC,20));
                textoExpectativas.setBackground(null);
                panelDatos.add(textoExpectativas);

            }

            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();

            if (e.getSource()==miFoto & e.getClickCount()==1){
                image= new ImageIcon(getClass().getResource("/recursos/yo.png"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);

            } else{
                if(e.getSource()==miHobby & e.getClickCount()==2){
                    image= new ImageIcon(getClass().getResource("/recursos/hobby.png"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);

                }
            }
            revalidate();
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
/*
    private class Escucha implements ActionListener {

        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"oprimiste boton");
            panelDatos.removeAll();
            if(e.getSource()==miFoto){
                image= new ImageIcon(getClass().getResource("/recursos/yo.png"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource()==miHobby){
                    image= new ImageIcon(getClass().getResource("/recursos/hobby.png"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }else{
                    textoExpectativas.setText("No sé de java pero si de objetos \n"+
                                              "quiero aprender un poco de java y de eventos \n" +
                                              "y programacion concurrente");
                    textoExpectativas.setFont(new Font(Font.DIALOG,Font.BOLD+Font.ITALIC,20));
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }
    */

}

