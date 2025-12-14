import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class Capacity extends JFrame {
    private JLabel Cap_lapel;
    private JTextField Cap_Field;
    private JButton Submit_button;
    private JPanel Capacity_Panel;
    private JLabel Titel;
    public int T_cap;

    public Capacity() {
        JFrame frame = new JFrame("Capacity");
        this.setSize(480, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = Cap_Field.getText();
                try {
                    if (e.getSource() == Submit_button) {
                        T_cap = Integer.parseInt(text);
                        new convertor(T_cap);
                        dispose();
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }



            }

        });
        this.add(Capacity_Panel);
        this.setVisible(true);
    }
}
