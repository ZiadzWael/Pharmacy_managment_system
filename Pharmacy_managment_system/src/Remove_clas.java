import java.util.ArrayList;

public class Remove_clas {
    public Remove_clas() {
    }

    void search(String ID, ArrayList<Drug> list) {
        list.removeIf(item -> item.getId().equals(ID));
    }
}