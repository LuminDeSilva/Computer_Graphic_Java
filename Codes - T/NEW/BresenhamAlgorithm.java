import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BresenhamAlgorithm extends JFrame implements MouseListener
{
	Graphics g;
	int x1,y1,x2,y2;
	
	public BresenhamAlgorithm()
	{
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Bresenham Line Drawing Algorithm");
		getContentPane().setBackground(Color.BLACK);
		
		g=getGraphics();
		addMouseListener(this);
	}
	
	public void Bresenham(int x1,int y1,int x2,int y2)
	{
		int dx,dy,pk,x,y;
		dx=x2-x1;
		dy=y2-y1;
		x=x1;
		y=y1;
		
		pk=2*dy-dx;
		
		for(int i=0;i<=x2;i++)
		{
			if(pk<0)
			{
				pk=pk+2*dy;
				x=x+1;
			}
			else
			{
				pk=pk+2*dy-dx;
				x=x+1;
				y=y+1;
			}
			g.setColor(Color.GREEN);
			g.drawLine(x,y,x,y);
		}
	}
	public void Bresenham1(int x1,int y1,int x2,int y2)
	{
		int dx,dy,x,y,xend,yend,d1,d2;
		dx=Math.abs(x2-x1);
		dy=Math.abs(y2-y1);
		
		d1=2*dy-dx;
		
		if(dy<=dx)
		{
			if(x1>x2)
			{
				if(y1>y2)
				{
					x=x2;
					y=y2;
					xend=x1;
					g.setColor(Color.GREEN);
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
						g.drawLine(i,y,i,y);
					}
				}
				else
				{
					x=x2;
					y=y2;
					xend=x1;
					g.setColor(Color.RED);
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
						g.drawLine(i,y,i,y);
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
					g.setColor(Color.BLUE);
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
						g.drawLine(i,y,i,y);
					}
				}
				else
				{
					x=x1;
					y=y1;
					xend=x2;
					g.setColor(Color.YELLOW);
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
						g.drawLine(i,y,i,y);
					}
				}
			}
		}
		else
		{
			d2=2*dx-dy;
			if(y1>y2)
			{
				if(x1>x2)
				{
					x=x2;
					y=y2;
					yend=y1;
					g.setColor(Color.PINK);
					g.drawLine(x,y,x,y);
					for(int i=y+1;i<=yend;i++)
					{
						if(d2<0)
						{
							d2=d2+2*dx;
						}
						else
						{
							d2=d2+2*(dx-dy);
							x=x+1;
						}
						g.drawLine(x,i,x,i);
					}
				}
				else
				{
					x=x2;
					y=y2;
					yend=y1;
					g.setColor(Color.CYAN);
					g.drawLine(x,y,x,y);
					for(int i=y+1;i<=yend;i++)
					{
						if(d2<0)
						{
							d2=d2+2*dx;
						}
						else
						{
							d2=d2+2*(dx-dy);
							x=x-1;
						}
						g.drawLine(x,i,x,i);
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
					g.setColor(Color.WHITE);
					g.drawLine(x,y,x,y);
					for(int i=y+1;i<=yend;i++)
					{
						if(d2<0)
						{
							d2=d2+2*dx;
						}
						else
						{
							d2=d2+2*(dx-dy);
							x=x-1;
						}
						g.drawLine(x,i,x,i);
					}
				}
				else
				{
					x=x1;
					y=y1;
					yend=y2;
					g.setColor(Color.RED);
					g.drawLine(x,y,x,y);
					for(int i=y+1;i<=yend;i++)
					{
						if(d2<0)
						{
							d2=d2+2*dx;
						}
						else
						{
							d2=d2+2*(dx-dy);
							x=x+1;
						}
						g.drawLine(x,i,x,i);
					}
				}
			}
		}
	}
	
	public void mouseEntered(MouseEvent m){}
	public void mousePressed(MouseEvent m){
		x1=m.getX();
		y1=m.getY();
	}
	public void mouseReleased(MouseEvent m){
		x2=m.getX();
		y2=m.getY();
		
		Bresenham1(x1,y1,x2,y2);
	}
	public void mouseClicked(MouseEvent m){}
	public void mouseExited(MouseEvent m){}
	
	public static void main(String []args)
	{
		BresenhamAlgorithm ba=new BresenhamAlgorithm();
	}
}