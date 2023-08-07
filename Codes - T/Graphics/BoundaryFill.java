import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BoundaryFill extends JFrame implements MouseListener{
    Graphics g;
    int x,y,radius,p,xcenter,ycenter,x1,x2,y1,y2;
    Color pixel[][]=new Color [500][500];

    BoundaryFill(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        g=getGraphics();
        getContentPane().setBackground(Color.WHITE);
    }
    public void mouseEntered(MouseEvent m){

    }
    public void mouseExited(MouseEvent m){

    }
    public void mousePressed(MouseEvent m){

    }
    public void mouseReleased(MouseEvent m){

    }
    public void mouseClicked(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
        CircleDraw(x1,y1,50);
        BoundaryFillAlgo(x1,y1,Color.RED,Color.YELLOW);
    }
    void CircleDraw(int x,int y,int r){
        int x1=0;
        int y1=r;
        int dk=3-2*r;
        PlotCircle(x1, y1, x, y);
        while(x1<=y1){
            if(dk<0){
                dk=dk+(4*x1)+6;
            }
            else{
                dk=dk+4*(x1-y1)+10;
                y1--;
            }
            x1++;
            PlotCircle(x1,y1, x, y);
        }
    }
    void PlotCircle(int x, int y, int x0, int y0){
        setPixel(x0+x,y0+y,Color.RED);
        setPixel(x0+y,y0+x,Color.RED);
        setPixel(x0-x,y0+y,Color.RED);
        setPixel(x0-y,y0+x,Color.RED);
        setPixel(x0-x,y0-y,Color.RED);
        setPixel(x0-y,y0-x,Color.RED);
        setPixel(x0+x,y0-y,Color.RED);
        setPixel(x0+y,y0-x,Color.RED);
    }
    Color getPixel(int x, int y){
        return pixel[x][y];
    }
    void setPixel(int x,int y, Color c){
        g=getGraphics();
        g.setColor(c);
        pixel[x][y]=g.getColor();
        g.drawOval(x,y,1,1);
    }
    void BoundaryFillAlgo(int x, int y, Color borderColor,Color fillColor){
        if((getPixel(x,y)!=borderColor)&&(getPixel(x,y)!=fillColor)){
            setPixel(x,y,fillColor);
            BoundaryFillAlgo(x+1,y,borderColor,fillColor);
            BoundaryFillAlgo(x-1,y,borderColor,fillColor);
            BoundaryFillAlgo(x,y+1,borderColor,fillColor);
            BoundaryFillAlgo(x,y-1,borderColor,fillColor);
        }
    }
    public static void main(String[] args){
        new BoundaryFill();
    }
}