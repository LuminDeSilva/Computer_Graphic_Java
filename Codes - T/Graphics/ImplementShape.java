import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ImplementShape extends JFrame implements MouseListener{
    //2018ICTS61
    Graphics g;
    int x1,x,y1,y;
    public ImplementShape(){
        setSize(600, 600);
        setTitle("Bresenham");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        g=getGraphics();
        addMouseListener(this);
    }
    public void mouseEntered(MouseEvent m){
    }
    public void mouseExited(MouseEvent m){
    }
    public void mouseClicked(MouseEvent m){
        BresenhamMethod(100, 250, 300, 250);
        BresenhamMethod(100, 250, 175, 200);
        BresenhamMethod(175, 200, 375, 200);
        BresenhamMethod(300, 250, 375, 200);
        BresenhamMethod(100, 250, 100, 350);
        BresenhamMethod(175, 250, 175, 300);
        BresenhamMethod(375, 200, 375, 300);
        BresenhamMethod(300, 250, 300, 350);
    }
    public void mousePressed(MouseEvent m){
    }
    public void mouseReleased(MouseEvent m){
    }
    void BresenhamMethod(int x1,int y1,int x2,int y2){
        int x,y,xend,yend,dx,dy,d1,d2;
        //drawLine(0, 0, 100, 100);
        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);
        //g.setColor(Color.white);
        if(dy<=dx){
            //m<0
            g.setColor(Color.red);
            d1=2*(dy-dx);
            if(x1>x2){
                if(y1>y2){
                    x=x2;
                    y=y2;
                    xend=x1;
                    g.drawLine(x,y,x,y);
                    for(int i=x+1;i<=xend;i++){
                        if(d1<0){
                            d1=d1+2*dy;
                        }
                        else{
                            d1=d1+2*(dy-dx);
                            y=y+1;
                        }
                        g.drawLine(i,y,i,y);
                    }
                } 
                else{
                    x=x2;
                    y=y2;
                    xend=x1;
                    g.drawLine(x,y,x,y);
                    for(int i=x+1;i<=xend;i++){
                        if(d1<0){
                            d1=d1+2*dy;
                        }
                        else{
                            d1=d1+2*(dy-dx);
                            y=y-1;
                        }
                        g.drawLine(i,y,i,y);
                    }
                }
            }
            else{
                if(y1>y2){
                    x=x1;
                    y=y1;
                    xend=x2;
                    g.drawLine(x,y,x,y);
                    for(int i=x+1;i<=xend;i++){
                        if(d1<0){
                            d1=d1+2*dy;
                        }
                        else{
                            d1=d1+2*(dy-dx);
                            y=y-1;
                        }
                        g.drawLine(i,y,i,y);
                    }
                }
                else{
                    x=x1;
                    y=y1;
                    xend=x2;
                    g.drawLine(x,y,x,y);
                    for(int i=x+1;i<=xend;i++){
                        if(d1<0){
                            d1=d1+2*dy;
                        }
                        else{
                            d1=d1+2*(dy-dx);
                            y=y+1;
                        }
                        g.drawLine(i,y,i,y);
                    }
                }
            }
        }
        else{
            g.setColor(Color.blue);
            d2=2*(dx-dy);
            if(y1>y2){
                if (x1>x2){
                    x=x2;
                    y=y2;
                    yend=y1;
                    g.drawLine(x,y,x,y);
                    for(int i=y+1;i<=yend;i++){
                        if(d2<0){
                            d2=d2+2*dx;
                        }
                        else{
                            d2=d2+2*(dx-dy);
                            x=x+1;
                        }
                        g.drawLine(x, i, x, i);
                    }
                }else{
                    x=x2;
                    y=y2;
                    yend=y1;
                    g.drawLine(x,y,x,y);
                    for(int i=y+1;i<=yend;i++){
                        if(d2<=0){
                            d2=d2+2*dx;
                        }
                        else{
                            d2=d2+2*(dx-dy);
                            x=x-1;
                        }
                        g.drawLine(x, i, x, i);
                    }
                }
            }else{
                if (x1>x2){
                    x=x1;
                    y=y1;
                    yend=y2;
                    g.drawLine(x,y,x,y);
                    for(int i=y+1;i<=yend;i++){
                        if(d2<0){
                            d2=d2+2*dx;
                        }
                        else{
                            d2=d2+2*(dx-dy);
                            x=x-1;
                        }
                        g.drawLine(x, i, x, i);
                    }
                }else{
                    x=x1;
                    y=y1;
                    yend=y2;
                    g.drawLine(x,y,x,y);
                    for(int i=y+1;i<=yend;i++){
                        if(d2<=0){
                            d2=d2+2*dx;
                        }
                        else{
                            d2=d2+2*(dx-dy);
                            x=x+1;
                        }
                        g.drawLine(x, i, x, i);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new ImplementShape();
        
    }
}
