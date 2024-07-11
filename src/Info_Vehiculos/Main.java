package Info_Vehiculos;

import javax.swing.*;

class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new ingreso_vehiculos().datos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
        frame.pack();


    }
}