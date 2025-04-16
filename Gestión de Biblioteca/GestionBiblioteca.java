import java.util.*;
import javax.swing.*;
/*
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
*/
import java.awt.*;
/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/

/***/
public class GestionBiblioteca{
    public static void main(String[] args){
        GestionBiblioteca ventana = new GestionBiblioteca();
        ventana.mostrarOpciones();
    }
        
    private void mostrarOpciones(){
        Biblioteca biblioteca = new Biblioteca("San Martin");
        
        //SOCIOS PREINSTALADOS
        try{
            biblioteca.nuevoSocioEstudiante(232323, "Juan Perez", "Ing.Industrial");
            biblioteca.nuevoSocioDocente(37987233, "Camila Cabello", "Depto Matematicas");
            biblioteca.nuevoSocioDocente(2589756, "Violencia Rivas", "Depto Computacion");
        }
        catch(SocioRegistradoException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
        
        //LIBROS PREINSTALADOS
        biblioteca.nuevoLibro("Vuelve el Perro Arrepentido", 3, "Magoya", 1934);
        biblioteca.nuevoLibro("Fisica Atomica", 5, "Carmen Aguirre", 1734);
        biblioteca.nuevoLibro("Java. Como aprobar un integrador", 9, "Rafael Beltran", 2034);
        biblioteca.nuevoLibro("Metodos de Estudio y Aprendizaje", 2, "William Stalling", 2000);
        biblioteca.nuevoLibro("Aprobar o Morir", 2, "Estudiantes de Sistemas", 2023);
        biblioteca.nuevoLibro("El Arte del Robo", 1, "Insaurralde", 2020);
        
        //Creamos un marco para la ventana de Opciones
        JFrame frame = new JFrame("MENU BIBLIOTECA");
        
        JPanel panelConImagenFondo = new JPanel() {
            private Image imagenFondo = new ImageIcon("F:/Programación Orientada a Objetos/Integrador desarrollo 2/1.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        //Cambia el color de fondo de la ventana
        frame.setContentPane(panelConImagenFondo);
        
        // Crear un botones
        JButton boton0 = new JButton("BIBLIOTECA: " + biblioteca.getNombre());
        JButton boton1 = new JButton("VER LISTA SOCIOS");
        JButton boton2 = new JButton("AGREGAR NUEVO DOCENTE");
        JButton boton3 = new JButton("AGREGAR NUEVO ALUMNO");
        JButton boton4 = new JButton("LISTA DE LIBROS");
        JButton boton5 = new JButton("PRESTAR LIBRO");
        JButton boton6 = new JButton("CONSULTAR QUIÉN TIENE EL LIBRO");
        JButton boton7 = new JButton("DEVOLVER LIBRO");
        JButton boton8 = new JButton("DOCENTES RESPONSABLES");
        JButton boton9 = new JButton("AGREGAR NUEVO LIBRO");
        JButton boton10 = new JButton("LISTA DE TÍTULOS");
        JButton boton11 = new JButton("LISTA DE PRÉSTAMOS VENCIDOS");
        
        //Crear un contenedor con un BoxLayout vertical para poner botones
        Box verticalBox = Box.createVerticalBox();
        
        // Cambia el color de los botones
        boton0.setBackground(Color.WHITE);
        boton1.setBackground(Color.LIGHT_GRAY);
        boton2.setBackground(Color.LIGHT_GRAY);
        boton3.setBackground(Color.LIGHT_GRAY);
        boton4.setBackground(Color.LIGHT_GRAY);
        boton5.setBackground(Color.LIGHT_GRAY);
        boton6.setBackground(Color.LIGHT_GRAY);
        boton7.setBackground(Color.LIGHT_GRAY);
        boton8.setBackground(Color.LIGHT_GRAY);
        boton9.setBackground(Color.LIGHT_GRAY);
        boton10.setBackground(Color.LIGHT_GRAY);
        boton11.setBackground(Color.LIGHT_GRAY);
        
        //Desactivar la posibilidad de hacer clic en el botón 0
        boton0.setEnabled(false);
        
        // Alinea los botones al centro de la ventana
        boton0.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton3.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton4.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton5.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton6.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton7.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton8.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton9.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton10.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        boton11.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        
        //Utiliza BoxLayout para centrar los botones verticalmente
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        //Agrega los componentes a la ventana
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado superior
        frame.add(boton0);
        frame.add(Box.createRigidArea(new Dimension(0, 40))); // Espaciado entre
        frame.add(boton1);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton9);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton2);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton3);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton4);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton10);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton5);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton7);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton6);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton8);
        frame.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre botones
        frame.add(boton11);
        
        //Agregar el contenedor al contenido del marco
        frame.getContentPane().add(verticalBox);
        
        //Configurar el tamaño del marco
        frame.setSize(700, 800);
    

        //Configurar la operación por defecto al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //VISIBILIDAD DE LA VENTANA
        frame.setVisible(true);
        
        // ********************************** BOTONES ****************************************
        
        //BOTON MOSTRAR LISTA DE SOCIOS
        boton1.addActionListener(b ->{
            JOptionPane.showMessageDialog(null, biblioteca.listaDeSocios() + "\n" + "Socios Docentes: " + biblioteca.cantidadDeSociosPorTipo("Docente") + "\n" + "Socios Estudiantes: " + biblioteca.cantidadDeSociosPorTipo("Estudiante"));
        });
        
        //BOTON INGRESAR NUEVO DOCENTE
        boton2.addActionListener(b ->{
            try{
                String dni = JOptionPane.showInputDialog(null, "Ingrese el DNI:");
                String nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre y Apellido:");
                String area = JOptionPane.showInputDialog(null, "Ingrese Area:");
                biblioteca.nuevoSocioDocente(Integer.parseInt(dni),nombre, area);
                JOptionPane.showMessageDialog(null, "Se agregó un nuevo docente. ");
            }
            catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "Los valores no han sido ingresado correctamente.");
            }
            catch(SocioRegistradoException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc.toString());
            }
        });
        
        //BOTON INGRESAR NUEVO ESTUDIANTE
        boton3.addActionListener(b ->{
            try{
                String dni = JOptionPane.showInputDialog(null, "Ingrese el DNI:");
                String nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre y Apellido:");
                String area = JOptionPane.showInputDialog(null, "Ingrese CARRERA:");
                biblioteca.nuevoSocioEstudiante(Integer.parseInt(dni),nombre, area);
                JOptionPane.showMessageDialog(null, "Se agregó un nuevo alumno. ");
            }
            catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "Los valores no han sido ingresado correctamente.");
            }
            catch(SocioRegistradoException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc.toString());
            }
        });
        
        //BOTON LISTADO DE LIBROS
        boton4.addActionListener(b ->{
            JOptionPane.showMessageDialog(null, biblioteca.listaDeLibros());
        });
        
        //BOTON PRESTAR UN LIBRO
        boton5.addActionListener(b ->{
            JOptionPane.showMessageDialog(null, biblioteca.listaDeLibros());
            
            try{
                String numero = JOptionPane.showInputDialog(null, "Indique el numero de libro:");
                String dniSocio = JOptionPane.showInputDialog(null, "Indique el DNI del socio:");
                Calendar fechaActual = Calendar.getInstance();
                // fechaActual.set(Calendar.YEAR, 2023); // PARA TESTEAR VENCIMIENTOS.
                
                if(biblioteca.prestarLibro(fechaActual, biblioteca.buscarSocio(Integer.parseInt(dniSocio)), biblioteca.getLibros().get(Integer.parseInt(numero) - 1))){
                    JOptionPane.showMessageDialog(null, "El libro: " + biblioteca.getLibros().get(Integer.parseInt(numero) - 1).getTitulo() + ", fue prestado a: " + biblioteca.buscarSocio(Integer.parseInt(dniSocio)).getNombre() + ".");
                }
            }
            catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "Los valores no han sido ingresado correctamente.");
            }
            catch(IndexOutOfBoundsException exc){
                JOptionPane.showMessageDialog(null, "El índice no coincide con ningún libro de la biblioteca. ");
            }
            catch(NullPointerException exc){
                JOptionPane.showMessageDialog(null, "El DNI ingresado no corresponde con ningún socio de la biblioteca. ");
            }
            catch(PrestamoRechazadoException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc.toString());
            }
        });
        
        //BOTON CONSULTAR QUIÉN TIENE EL LIBRO
        boton6.addActionListener(b ->{
            JOptionPane.showMessageDialog(null, biblioteca.listaDeLibros());
            
            try{
                String numero = JOptionPane.showInputDialog(null, "Indique el numero de libro:");
                JOptionPane.showMessageDialog(null, "El libro lo tiene: " + biblioteca.quienTieneElLibro(biblioteca.getLibros().get(Integer.parseInt(numero)-1)));
            }
            catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "Los valores no han sido ingresado correctamente.");
            }
            catch(IndexOutOfBoundsException exc){
                JOptionPane.showMessageDialog(null, "El índice no coincide con ningún libro de la biblioteca. ");
            }
            catch(LibroNoPrestadoException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc.toString());
            }
        });
        
        //BOTON DEVOLVER UN LIBRO
        boton7.addActionListener(b ->{
            JOptionPane.showMessageDialog(null, biblioteca.listaDeLibros());
            
            try{
                String numero = JOptionPane.showInputDialog(null, "Indique el número de libro a devolver:");
                biblioteca.devolverLibro(biblioteca.getLibros().get(Integer.parseInt(numero) - 1));
                JOptionPane.showMessageDialog(null, "El libro: " + biblioteca.getLibros().get(Integer.parseInt(numero) - 1).getTitulo() + ", fue devuelto por " + biblioteca.getLibros().get(Integer.parseInt(numero) - 1).ultimoPrestamo().getSocio().getNombre());
            }
            catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "Los valores no han sido ingresado correctamente.");
            }
            catch(IndexOutOfBoundsException exc){
                JOptionPane.showMessageDialog(null, "El índice no coincide con ningún libro de la biblioteca. ");
            }
            catch(LibroNoPrestadoException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc.toString());
            }
        });
        
        //BOTON DOCENTES RESPONSABLES
        boton8.addActionListener(b ->{
            if(biblioteca.listaDeDocentesResponsables().equals("")){
                JOptionPane.showMessageDialog(null, "No hay docentes responsables.");
            }else{
                JOptionPane.showMessageDialog(null, "Docentes Responsables: \n " + biblioteca.listaDeDocentesResponsables());
            }
        });
        
        //BOTON INGRESAR NUEVO LIBRO
        boton9.addActionListener(b ->{
            try{
                String titulo = JOptionPane.showInputDialog(null, "Ingrese título del Libro:");
                String edicion = JOptionPane.showInputDialog(null, "Ingrese edición:");
                String editorial = JOptionPane.showInputDialog(null, "Ingrese editorial:");
                String anio = JOptionPane.showInputDialog(null, "Ingrese año de publicación:");
                biblioteca.nuevoLibro(titulo, Integer.parseInt(edicion), editorial, Integer.parseInt(anio));
                JOptionPane.showMessageDialog(null, " El libro ha sido añadido correctamente.");
            }catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "Los valores no han sido ingresado correctamente.");
            }catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc.toString());
            }
        });
        
        //BOTON LISTADO DE TÍTULOS
        boton10.addActionListener(b ->{
            JOptionPane.showMessageDialog(null, biblioteca.listaDeTitulos());
        });
        
        //BOTON LISTA DE PRÉSTAMOS VENCIDOS
        boton11.addActionListener(b ->{
            String librosPrestadosVencidos = "";
            
            for(Prestamo pres : biblioteca.prestamosVencidos()){
                 librosPrestadosVencidos += pres.getLibro().getTitulo() + " (Prestado a: " + pres.getSocio().getNombre() + ")" + "\n";
            }
            
            if(librosPrestadosVencidos.equals("")){
                JOptionPane.showMessageDialog(null, "No hay libros prestados que estén vencidos. ");
            }
            else{
                JOptionPane.showMessageDialog(null, "Libros prestados vencidos:\n " + librosPrestadosVencidos);
            }
        });
    }
    
}
