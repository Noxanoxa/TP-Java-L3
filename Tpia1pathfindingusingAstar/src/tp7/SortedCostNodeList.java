package tp7;

import java.util.ArrayList;
import java.util.Collections;

public class SortedCostNodeList {
    private ArrayList<Node> list = new ArrayList<Node>();
    
    public void push(Node node) {
        list.add(node);
        Collections.sort(list);
    }
    
    public Node pop() {
        Node node = list.get(0);
        list.remove(0);
        return node;
    }
    
    public int indexOf(Node node) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isMatch(node)) {
                return i;
            }
        }
        return -1;
    }
    
    public Node nodeAt(int index) {
        return list.get(index);
    }
    
    public void removeAt(int index) {
        list.remove(index);
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
