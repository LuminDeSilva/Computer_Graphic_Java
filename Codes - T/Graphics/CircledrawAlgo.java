import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CircledrawAlgo extends JFrame implements MouseListener{
    Graphics g;
    int x1, x2, y1, y2;
    CircledrawAlgo(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        g=getGraphics();
        addMouseListener(this);
    }
    public void mousePressed(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
    }
    public void mouseReleased(MouseEvent m){
        x2=m.getX();
        y2=m.getY();
        int r = (int)Math.sqrt(Math.abs((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
        g.setColor(Color.RED);

        //midpointMethod(x1,y1,x2,y2);
        //bresenhamMethod(x1,y1,x2,y2);
        //midpointMethod(x1,y1,r);
        bresenhamMethod(x1,y1,r);
        
    }
    public void mouseClicked(MouseEvent m){

    }
    public void mouseEntered(MouseEvent m){
        
    }
    public void mouseExited(MouseEvent m){
        
    }

    void midpointMethod(int x1,int y1, int x2, int y2){
        int r = (int)Math.sqrt(Math.abs((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
        int x = 0;
        int y = r;
        int dk = 1-r;
        //System.out.println(x+" "+y+" "+r);
        //g.drawLine(x,y,x,y);
        drawOctants(x1,y1,x,y);
        while (x<y){
            if (dk>=0){
                dk=dk+2*(x-y)+5;
                y--;
            }
            else{
                dk=dk+2*(x)+3;
            }
            x++;
            drawOctants(x1,y1,x,y);
            //System.out.println(x+" "+y+" "+dk);
            //g.drawLine(x,y,x,y);
        }
    }

    void bresenhamMethod(int x1,int y1, int x2, int y2){
        int r = (int)Math.sqrt(Math.abs((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
        int x = 0;
        int y = r;
        int dk = 3-2*r;
        drawOctants(x1,y1,x,y);
        while (x<=y){
            if (dk>=0){
                dk=dk+4*(x-y)+10;
                y--;
            }
            else{
                dk=dk+4*(x)+6;
            }
            x++;
            drawOctants(x1,y1,x,y);
        }
    }

    void midpointMethod(int x1,int y1, int r){
        int x = 0;
        int y = r;
        int dk = 1-r;
        drawOctants(x1,y1,x,y);
        while (x<y){
            if (dk>=0){
                y--;
                dk=dk+2*(x-y)+3;
            }
            else{
                dk=dk+2*(x)+5;
            }
            x++;
            drawOctants(x1,y1,x,y);
        }
    }

    void bresenhamMethod(int x1,int y1, int r){
        int x = 0;
        int y = r;
        int dk = 3-2*r;
        drawOctants(x1,y1,x,y);
        while (x<=y){
            if (dk>=0){
                y--;
                dk=dk+4*(x-y)+6;
            }
            else{
                dk=dk+4*(x)+10;
            }
            x++;
            drawOctants(x1,y1,x,y);
        }
    }
    void drawOctants(int x0,int y0,int x,int y){
        g.drawLine(x0+x,y0+y,x0+x,y0+y);
        g.drawLine(x0+y,y0+x,x0+y,y0+x);
        g.drawLine(x0-x,y0+y,x0-x,y0+y);
        g.drawLine(x0-y,y0+x,x0-y,y0+x);
        g.drawLine(x0-x,y0-y,x0-x,y0-y);
        g.drawLine(x0-y,y0-x,x0-y,y0-x);
        g.drawLine(x0+x,y0-y,x0+x,y0-y);
        g.drawLine(x0+y,y0-x,x0+y,y0-x);
    }
    public static void main(String[] args){
        new CircledrawAlgo();
    }
}