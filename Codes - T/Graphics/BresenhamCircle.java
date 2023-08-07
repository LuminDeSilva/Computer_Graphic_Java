import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  BresenhamCircle extends JFrame implements MouseListener
{
    Graphics g;
    int r,x1,y1,x2,y2;
    
    BresenhamCircle()
    {
        setSize(600,600);
        setTitle("Bresenham Circle Drawing Algorithm");//Interface title
        setVisible(true);//show to interface
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//interface show in the center

        addMouseListener(this);
        g=getGraphics();
    }
    //Mouse Events
    public void mouseClicked(MouseEvent m){}
    public void mousePressed(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
    }
    public void mouseReleased(MouseEvent m){
        x2=m.getX();
        y2=m.getY();
        r=(int)Math.sqrt(Math.abs((x1-x2)*(x1-x2)+(y2-y1)*(y2-y1)));
        //g.setColor(Color.RED);
        BresenhammCircleDrawingAlgorithm(x1,y1,r);
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public void BresenhammCircleDrawingAlgorithm(int xc,int yc,int r)
    {
       int x=0,y=r,d=3-2*r;

        while(x<=y)
        {
            plotCircle(xc,yc,x,y);
            if(d<0)
            {
                d=d+4*x+6;
            }
            else
            {
                d=d+4*(x-y)+10;
                y--;
            }
            x++;
        }
    }
    public void plotCircle(int xc,int yc,int x,int y)
    {
        g.setColor(Color.RED);
        g.drawLine(xc+x,yc+y,xc+x,yc+y);
        g.drawLine(xc-x,yc+y,xc-x,yc+y);

        g.setColor(Color.BLUE);
        g.drawLine(xc+x,yc-y,xc+x,yc-y);
        g.drawLine(xc-x,yc-y,xc-x,yc-y);

        g.setColor(Color.YELLOW);
        g.drawLine(xc+y,yc+x,xc+y,yc+x);
        g.drawLine(xc-y,yc+x,xc-y,yc+x);

        g.setColor(Color.GREEN);
        g.drawLine(xc+y,yc-x,xc+y,yc-x);
        g.drawLine(xc-y,yc-x,xc-y,yc-x);

    }
    

    public static void main(String []args)
    {
        new BresenhamCircle();
    }
}