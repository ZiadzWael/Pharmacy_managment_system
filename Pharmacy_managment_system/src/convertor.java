import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class convertor extends JFrame {

    private JPanel panelmain;
    private JLabel name_Add_label;
    private JTextField name_A_Field;
    private JTextField ID_A_Field;
    private JTextField quantity_Add_Field;
    private JTextField price_Add_Field;
    private JRadioButton cosmeticsRadioButton;
    private JRadioButton drugsRadioButton;
    private JRadioButton otherRadioButton;
    private JRadioButton notAllowedRadioButton;
    private final ButtonGroup addGroup;
    private JButton addNewToTheButton;
    private JButton buyNowButton;
    private JButton addButton;
    private JPanel Add_panel;
    private JPanel Order_panel;
    private JTabbedPane Remove;
    private JLabel ID_Remove_label;
    private JTextField ID_R_Field;
    private JButton Remove_Button;
    private JLabel ID_order_label;
    private JTextField Id_O_Feild;
    private JLabel Quantity_O_label;
    private JTextField Quantity_O_field;
    private JLabel Catogry_Label_Add;
    private JLabel Price_Label_Add;
    private JLabel Quantity_A_Label;
    private JLabel ID_A_Label;
    private JButton endTheDayButton;
    static int Capacity_Max;
    static int Quantity_stat;
    public static ArrayList<Drug> Cosmetic_list = new ArrayList<>();
    public static ArrayList<Drug> Drug_list = new ArrayList<>();
    public static ArrayList<Drug> Other_list = new ArrayList<>();
    public static ArrayList<Drug> Notallowed_list = new ArrayList<>();
    static double total_price_per_day = 0;
    double total_price_per_order = 0;
    double Price_f = 0;


    public convertor(int Capacity) {
        Capacity_Max = Capacity;
        Quantity_stat = Capacity;
        JFrame frame = new JFrame("Home");
        this.setSize(480, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addGroup = new ButtonGroup();
        addGroup.add(cosmeticsRadioButton);
        addGroup.add(drugsRadioButton);
        addGroup.add(otherRadioButton);
        addGroup.add(notAllowedRadioButton);
        this.add(Remove);
        this.setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Name_A = name_A_Field.getText();
                    String ID_A = ID_A_Field.getText();
                    int Quantity_A = Integer.parseInt(quantity_Add_Field.getText());
                    double Price_A = Double.parseDouble(price_Add_Field.getText());
                    Drug drug_obj = new Drug(Name_A, ID_A, Price_A, Quantity_A);
                    if (Quantity_stat > 0) {
                        if (e.getSource() == addButton) {
                            Quantity_stat-=Quantity_A;
                            if (cosmeticsRadioButton.isSelected()) {
                                Cosmetic_list.add(drug_obj);
                            }
                            if (drugsRadioButton.isSelected()) {
                                Drug_list.add(drug_obj);
                            }
                            if (otherRadioButton.isSelected()) {
                                Other_list.add(drug_obj);
                            }
                            if (notAllowedRadioButton.isSelected()) {
                                Notallowed_list.add(drug_obj);
                            }
                            name_A_Field.setText("");
                            ID_A_Field.setText("");
                            price_Add_Field.setText("");
                            quantity_Add_Field.setText("");
                            addGroup.clearSelection();
                            JOptionPane.showMessageDialog(null, drug_obj.toString(), "Medicine has been added", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "The Storage is Full", "Error", JOptionPane.ERROR_MESSAGE);

                    }


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid Number", "Error", JOptionPane.ERROR_MESSAGE);
                    addGroup.clearSelection();

                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


        Remove_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String ID_R = ID_R_Field.getText();
                    Remove_clas Remove_obj = new Remove_clas();
                    if (e.getSource() == Remove_Button) {
                        if (ID_R.startsWith("dr")){
                            Remove_obj.search(ID_R, Drug_list);
                            JOptionPane.showMessageDialog(null,"The Drug with This ID "+ID_R+" has been Removed", "Medicine has been Removed", JOptionPane.INFORMATION_MESSAGE);

                        }
                        if (ID_R.startsWith("co")){
                            Remove_obj.search(ID_R, Cosmetic_list);
                            JOptionPane.showMessageDialog(null,"The Cosmetic with This ID "+ID_R+" has been Removed", "Medicine has been Removed", JOptionPane.INFORMATION_MESSAGE);

                        }
                        if (ID_R.startsWith("ot")){
                            Remove_obj.search(ID_R, Other_list);
                            JOptionPane.showMessageDialog(null,"The Other type of Drug with This ID "+ID_R+" has been Removed", "Medicine has been Removed", JOptionPane.INFORMATION_MESSAGE);

                        }
                        if (ID_R.startsWith("not")){
                            Remove_obj.search(ID_R, Notallowed_list);
                            JOptionPane.showMessageDialog(null,"This Not allowed Drug with This ID "+ID_R+" has been Removed", "Medicine has been Removed", JOptionPane.INFORMATION_MESSAGE);

                        }
                        ID_A_Field.setText("");
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        endTheDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == endTheDayButton){

                    JOptionPane.showMessageDialog(null,"The Total price for Today = " + total_price_per_day, "The Total price", JOptionPane.INFORMATION_MESSAGE);
                    total_price_per_day = 0;
                    total_price_per_order = 0;
                }
            }
        });
        addNewToTheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID_R = Id_O_Feild.getText();
                    String ID_Order = Id_O_Feild.getText();
                    String Quantity_R_str = Quantity_O_field.getText();
                    Place_order Place_order_obj = new Place_order();
                    if (ID_R.startsWith("dr")){
                        int Quantity_Order = Integer.parseInt(Quantity_R_str);
                        Price_f = Place_order_obj.price(ID_Order, Quantity_Order, Drug_list);
                        Quantity_stat+=Quantity_Order;
                    }
                    else if (ID_R.startsWith("co")){
                        int Quantity_Order = Integer.parseInt(Quantity_R_str);
                        Price_f = Place_order_obj.price(ID_Order, Quantity_Order, Cosmetic_list);
                        Quantity_stat+=Quantity_Order;
                    }
                    else if (ID_R.startsWith("ot")){
                        int Quantity_Order = Integer.parseInt(Quantity_R_str);
                        Price_f = Place_order_obj.price(ID_Order, Quantity_Order, Other_list);
                        Quantity_stat+=Quantity_Order;
                    }
                    else if (ID_R.startsWith("not")){

                        int Quantity_Order = Integer.parseInt(Quantity_R_str);
                        Price_f = Place_order_obj.price(ID_Order, Quantity_Order, Notallowed_list);
                        Quantity_stat+=Quantity_Order;
                    }
                    total_price_per_order += Price_f;
                    total_price_per_day += Price_f;
                    if(e.getSource()==addNewToTheButton){
                        if (Price_f!=0){
                            JOptionPane.showMessageDialog(null, "The Medicine has been added to the cart", "Buy", JOptionPane.INFORMATION_MESSAGE);
                            Id_O_Feild.setText("");
                            Quantity_O_field.setText("");
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "The Medicine is Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid", "Error", JOptionPane.ERROR_MESSAGE);
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "There is no enough quantity", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buyNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(e.getSource() == buyNowButton) {
                        JOptionPane.showMessageDialog(null, "You are buying now! \n" + "The Total price = " + total_price_per_order , "Buy", JOptionPane.INFORMATION_MESSAGE);
                        total_price_per_order = 0;
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid", "Error", JOptionPane.ERROR_MESSAGE);
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, e.getSource(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}

