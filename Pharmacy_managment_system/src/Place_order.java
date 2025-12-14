import javax.swing.*;
import java.util.ArrayList;
import java.lang.*;
import java.util.Objects;

public class Place_order {
    final String Cosmatics_ID ="co";
    final String Drug_ID="dr";
    final String other_ID="ot";

    public Place_order() {
    }

    double search_ID(String id, ArrayList<Drug> list, int quantity){
        for(Drug item : list){
            if (Objects.equals(item.getId(), id)){
                if (id.startsWith("not")){
                    int what = JOptionPane.showConfirmDialog(null, "Do you have prescription ? ");
                    if (what == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(null, "Sorry you must have prescription", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(item.getQuantity() >=  quantity){
                    item.setQuantity((item.getQuantity())-quantity);
                    JOptionPane.showMessageDialog(null, "The medicine is " + item.getName(), "Check", JOptionPane.INFORMATION_MESSAGE);
                    return item.getPrice();
                }
                else {
                    JOptionPane.showMessageDialog(null, "insufficient quantity", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }

            }
        }
        return 0;
    }

    double price(String ID, int quantity, ArrayList<Drug> list){
        double Price =search_ID(ID,list,quantity);

        if (Price == 0){
            return 0;
        }
        else {
            if (ID.startsWith(Cosmatics_ID)){
                return Price*1.2*quantity;
            }
            else {

                return Price*quantity;
            }
        }
    }

}
