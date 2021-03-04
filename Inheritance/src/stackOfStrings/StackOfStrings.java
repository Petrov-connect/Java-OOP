package stackOfStrings;
//created by J.M.

import java.util.ArrayList;

public class StackOfStrings {

    private final ArrayList<String> data;

    public StackOfStrings(ArrayList<String> data) {
        this.data = data;
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        return isEmpty() ? null : this.data.remove(this.data.size()-1);
    }

    public String peek() {
        return isEmpty() ? null : this.data.get(this.data.size()-1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

}
