import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaLinealGUI {
    private JTextField textField1;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton buscarLinealButton;
    private JButton mostrarButton;
    private JTextArea txtResultado;
    private JPanel pGeneral;

    Lista lista = new Lista();

    public BusquedaLinealGUI() {

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input= textField1.getText().trim();

                try {
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor,txtResultado);
                    textField1.setText(" ");

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Numero no valido");
                }
            }


        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input= textField1.getText();

                try {
                    int valor = Integer.parseInt(input);
                    lista.eliminar(valor,txtResultado);
                    textField1.setText(" ");

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Numero no valido");
                }
            }


        });
        buscarLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText().trim();

                try {
                    int valor = Integer.parseInt(input);
                    int posicion = lista.buscarLineal(valor);

                    if (posicion== -1){
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Elemento"+valor+"encontrado en la posicion "+posicion);

                    }

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Numero no valido");
                }
            }

        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.mostrarLista(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaLinealGUI");
        frame.setContentPane(new BusquedaLinealGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
