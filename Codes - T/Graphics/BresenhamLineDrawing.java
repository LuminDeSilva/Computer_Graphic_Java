import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BresenhamLineDrawing extends JFrame implements MouseListener
{
    Graphics g;
    int x1,y1,x2,y2;
    BresenhamLineDrawing()
    {
        setSize(600,600);
        setTitle("Bresenham Line Drawing");//Interface title
        setVisible(true);//show to interface
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//interface show in the center

        addMouseListener(this);
        g=getGraphics();
    }
    public void BresenhamLineDrawingAlgorithm(int x1,int y1,int x2,int y2)
    {
        int dx,dy,xend,yend,x,y,d1,d2;
        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);

        if(dy<=dx)
        {
            d1=2*(dy-dx);
            if(x1>x2)
            {
                if(y1>y2)
                {
                    x=x2;
                    y=y2;
                    xend=x1;
                    g.drawLine(x,y,x,y);

                    for(int i=x+1;i<=xend;i++)
                    {
                        if(d1<0)
                        {
                            d1=d1+2*dy;
                        }
                        else
                        {
                            d1=d1+2*(dy-dx);
                            y=y+1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
                else
                {
                    x=x2;
                    y=y2;
                    xend=x1;
                    g.drawLine(x,y,x,y);

                    for(int i=x+1;i<=xend;i++)
                    {
                        if(d1<0)
                        {
                            d1=d1+2*dy;
                        }
                        else
                        {
                            d1=d1+2*(dy-dx);
                            y=y-1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
            }
            else
            {
                if(y1>y2)
                {
                    x=x1;
                    y=y1;
                    xend=x2;
                    g.drawLine(x,y,x,y);

                    for(int i=x+1;i<=xend;i++)
                    {
                        if(d1<0)
                        {
                            d1=d1+2*dy;
                        }
                        else
                        {
                            d1=d1+2*(dy-dx);
                            y=y-1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
                else
                {
                    x=x1;
                    y=y1;
                    xend=x2;
                    g.drawLine(x,y,x,y);

                    for(int i=x+1;i<=xend;i++)
                    {
                        if(d1<0)
                        {
                            d1=d1+2*dy;
                        }
                        else
                        {
                            d1=d1+2*(dy-dx);
                            y=y+1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
            }
        }
        else
        {
            d2=2*(dy-dx);
            if(y1>y2)
            {
                if(x1>x2)
                {
                    x=x2;
                    y=y2;
                    yend=y1;
                    g.drawLine(x,y,x,y);

                    for(int i=y+1;i<=yend;i++)
                    {
                        if(d2<0)
                        {
                            d2=d2+2*dy;
                        }
                        else
                        {
                            d2=d2+2*(dy-dx);
                            x=x+1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
                else
                {
                    x=x2;
                    y=y2;
                    yend=y1;
                    g.drawLine(x,y,x,y);

                    for(int i=y+1;i<=yend;i++)
                    {
                        if(d2<0)
                        {
                            d2=d2+2*dy;
                        }
                        else
                        {
                            d2=d2+2*(dy-dx);
                            x=x-1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
            }
            else
            {
                if(x1>x2)
                {
                    x=x1;
                    y=y1;
                    yend=y2;
                    g.drawLine(x,y,x,y);

                    for(int i=y+1;i<=yend;i++)
                    {
                        if(d2<0)
                        {
                            d2=d2+2*dy;
                        }
                        else
                        {
                            d2=d2+2*(dy-dx);
                            x=x-1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
                else
                {
                    x=x1;
                    y=y1;
                    yend=y2;
                    g.drawLine(x,y,x,y);

                    for(int i=y+1;i<=yend;i++)
                    {
                        if(d2<0)
                        {
                            d2=d2+2*dy;
                        }
                        else
                        {
                            d2=d2+2*(dy-dx);
                            x=x+1;
                        }
                        g.drawLine(x,y,x,y);
                    }
                }
            }
        }
    }
    public void mouseClicked(MouseEvent m){}
    public void mousePressed(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
    }
    public void mouseReleased(MouseEvent m){
        x2=m.getX();
        y2=m.getY();

        g.setColor(Color.RED);

        BresenhamLineDrawingAlgorithm(100,100,200,300);
        
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public static void main(String []args)
    {
        new BresenhamLineDrawing();
    }
}