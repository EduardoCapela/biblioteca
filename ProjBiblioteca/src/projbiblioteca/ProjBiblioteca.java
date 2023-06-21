package projbiblioteca;

import javax.swing.SwingUtilities;

public class ProjBiblioteca {   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BibliotecaGUI bibliotecaGUI = new BibliotecaGUI();
                bibliotecaGUI.setVisible(true);
            }
        });
        
    }
}