import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FloodFill extends JFrame implements MouseListener{
    Graphics g;
    int x1,x2,y1,y2;
    Color pixel[][]=new Color [500][500];

    FloodFill(){
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
        drawObj(x1,y1);
        FloodFillAlgo(x1,y1,Color.GREEN,Color.BLACK);
    }
    void drawObj(int x1,int y1){
        for(int x=x1;x<x1+100;x++)
            for(int y=y1;y<y1+100;y++)
                setPixel(x,y,Color.GREEN);
    }
    Color getPixel(int x, int y){
        return pixel[x][y];
    }
    void setPixel(int x,int y, Color c){
        g=getGraphics();
        g.setColor(c);
        pixel[x][y]=g.getColor();
        g.drawRect(x,y,1,1);
    }
    
    void FloodFillAlgo(int x, int y, Color oldColor,Color newColor){
        Color pixelColor=getPixel(x,y);
        if(oldColor==newColor)
            return;
        if(pixelColor!=oldColor)
            return;
        if(pixelColor==oldColor){
            setPixel(x,y,newColor);
            FloodFillAlgo(x+1,y,oldColor,newColor);
            FloodFillAlgo(x-1,y,oldColor,newColor);
            FloodFillAlgo(x,y+1,oldColor,newColor);
            FloodFillAlgo(x,y-1,oldColor,newColor);
        }
    }
    public static void main(String[] args){
        new FloodFill();
    }
}