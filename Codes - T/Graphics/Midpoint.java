import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  Midpoint extends JFrame implements MouseListener
{
    
    int xc,yc,x,y,r=100;
    Graphics g;
    Midpoint()
    {
        setSize(600,600);
        setTitle("");//Interface title
        setVisible(true);//show to interface
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//interface show in the center

        addMouseListener(this);
        g=getGraphics();
    }
    
    public void Circle()
    {
       int  x=0,y=r,p=1-r;

        while(x<=y)
        {
            plotCircle(xc,yc,x,y);
            if(p<0)
            {
                p=p+(2*x)+3;
            }
            else
            {
                p=p+2*(x-y)+5;
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
    //Mouse Events
    public void mouseClicked(MouseEvent m){}
    public void mousePressed(MouseEvent m){
        xc=m.getX();
        yc=m.getY();
    }
    public void mouseReleased(MouseEvent m){
        Circle();
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}

    public static void main(String []args)
    {
        new Midpoint();
    }
}