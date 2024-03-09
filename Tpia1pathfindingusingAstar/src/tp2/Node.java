package tp2;

public class Node {
    private int x;
    private int y;
    private NodeType type;
    private Node parent;
    private int f;
    private int g;
    private int h;
    
    public Node(int x, int y, NodeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.parent = null;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }
    
    // other methods...
}
