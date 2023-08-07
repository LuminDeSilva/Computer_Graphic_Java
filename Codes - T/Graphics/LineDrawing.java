import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LineDrawing extends JFrame implements MouseListener
{
    
    int x1,y1,x2,y2;
    Graphics g;
    LineDrawing()
    {
        setSize(600,600);
        setTitle("Line Drawing Algorithm");//Interface title
        setVisible(true);//show to interface
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//interface show in the center

        addMouseListener(this);
        g=getGraphics();
    }
    //create method for line drawing algorithm
    public void LineDrawingAlgorithm(int x1,int y1,int x2,int y2)
    {
        double dx,dy,x,y,step,xinc,yinc;

        dx=x2-x1;
        dy=y2-y1;

        if(Math.abs(dx)>Math.abs(dy))
        {
            step=Math.abs(dx);
        }
        else
        {
            step=Math.abs(dy);
        }

        xinc=dx/step;
        yinc=dy/step;

        x=x1;
        y=y1;

        g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
        for(int i=0;i<=step;i++)
        {
            
            x=x+xinc;
            y=y+yinc;
            g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
        }
    }
    //Mouse Events
    public void mouseClicked(MouseEvent m){
       
    }
    public void mousePressed(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
    }
    public void mouseReleased(MouseEvent m){
        x2=m.getX();
        y2=m.getY();

        g.setColor(Color.RED);

        LineDrawingAlgorithm(x1,y1,x2,y2);
        
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}

    public static void main(String []args)
    {
        new LineDrawing();
    }
}