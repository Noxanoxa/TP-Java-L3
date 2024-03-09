package graph;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Matrice extends JFrame  {

    private static final long serialVersionUID = 1L;
    
    private final int width;
    private final int height;
    
    private final JLabel[] horizon;
    private final JLabel[] vertical;
    private final JButton[][] centre;

    private final ImageIcon ZERO = new ImageIcon("0.jpg");
    private final ImageIcon ONE = new ImageIcon("1.jpg");
    
    public Matrice(int width, int height) {
        this.width = width;
        this.height = height;
        
        horizon = new JLabel[width];
        vertical = new JLabel[height];
        centre = new JButton[width][height];
        
        initFrame();
        fillContent();
        
        this.setVisible(true);
    }
    
    private void initFrame() {
        this.setSize(700, 700);
        this.setTitle("Matrice du graphe");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel createColumnHeader(int x) {
        horizon[x] = new JLabel("H" + (x + 1));
        return horizon[x];
    }

    private JLabel createRowHeader(int y) {
        vertical[y] = new JLabel("V" + (y + 1));
        return vertical[y];
    }
    
    private JButton createCell(int x, int y) {
        centre[x][y] = new JButton();
        centre[x][y].addActionListener(new MatriceListener(this,x,y));
        return centre[x][y];
    }
    
    public void fillContent() {

        this.setLayout(new GridLayout(width+1, height+1));
        
        this.add(new JLabel());
        
        for (int x = 0; x < width; x++)
            this.add(createColumnHeader(x));
        
        for (int y = 0; y < height; y++) {
            this.add(createRowHeader(y));
            for (int x=0; x<width; x++)
                this.add(createCell(x,y));
        }
    }
    
    public void setIcon(int x, int y) {
        centre[x][y].setIcon(ONE);
    }
}