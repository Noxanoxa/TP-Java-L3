package graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatriceListener implements ActionListener {
    
    private final Matrice mat;
    private final int x;
    private final int y;
    
    public  MatriceListener(Matrice mat, int x, int y) {
        this.mat = mat;
        this.x = x;
        this.y = y;
    }

    public void actionPerformed(ActionEvent e) {
        mat.setIcon(x,y);
    }
}