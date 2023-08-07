import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BresenhamAlgorithmIntro extends JFrame implements MouseListener
{
	int x1,y1,x2,y2;
	Graphics g;
	BresenhamAlgorithmIntro()
	{
		setTitle("BresenhamLine Algorithm Implementation");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLocationRelativeTo(null);		
		//getContentPane().setBackground(Color.BLACK);
		addMouseListener(this);
		setVisible(true);
		g=getGraphics();
		
	}
	
	public void mouseClicked(MouseEvent me)
	{
		x1=me.getX();
		y1=me.getY();
		getObject(x1,y1);
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
		
	public void Bresenham(int x1,int y1,int x2,int y2)
	{
		int dx,dy,d,x,y,xend,d4mG1,yend;
		dx=Math.abs(x2-x1);
		dy=Math.abs(y2-y1);
		
		d=2*dy-dx;
		
		if(dy<=dx)
		{
			if(x1>x2)
			{
				if(y1>y2)
				{
					x=x2; y=y2; xend=x1;
					g.drawLine(x,y,x,y);
					for(int i=x+1;i<=xend;i++)
					{
						if(d<0)
							d=d+2*dy;
						else{
							y=y+1;
							d=d+2*(dy-dx);							
						}
						g.drawLine(i,y,i,y);
					}
				}
				else
				{
					x=x2; y=y2; xend=x1;
					g.drawLine(x,y,x,y);
					for(int i=x+1;i<=xend;i++)
					{
						if(d<0)
							d=d+2*dy;
						else
						{
							y=y-1;
							d=d+2*(dy-dx);							
						}
						g.drawLine(i,y,i,y);
					}
				}			
			}
			else
			{
				if(y1>y2)
				{
					x=x1; y=y1; xend=x2;
					g.drawLine(x,y,x,y);
					for(int i=x+1;i<=xend;i++)
					{
						if(d<0)
							d=d+2*dy;
						else
						{
							y=y-1;
							d=d+2*(dy-dx);							
						}
						g.drawLine(i,y,i,y);
					}
				}
				else
				{
					x=x1; y=y1; xend=x2;
					g.drawLine(x,y,x,y);
					for(int i=x+1;i<=xend;i++)
					{
						if(d<0)
							d=d+2*dy;
						else
						{
							y=y+1;
							d=d+2*(dy-dx);							
						}
						g.drawLine(i,y,i,y);
					}
				}				
			}		
		}
		else
		{
			System.out.println("Slope is greater than one");
			d4mG1=2*dx-dy;
			if(y1>y2)
			{
				if(x1>x2)
				{
					x=x2; y=y2; yend=y1;
					g.drawLine(x,y,x,y);
					for(int j=y+1; j<=yend;j++)
					{
						if(d4mG1<0)
							d4mG1=d4mG1+2*dx;
						else
						{
							x=x+1;
							d4mG1=d4mG1+2*(dx-dy);
						}
						g.drawLine(x,j,x,j);
					}
				}
				else
				{
					x=x2; y=y2; yend=y1;
					g.drawLine(x,y,x,y);
					for(int j=y+1; j<=yend;j++)
					{
						if(d4mG1<0)
							d4mG1=d4mG1+2*dx;
						else
						{
							x=x-1;
							d4mG1=d4mG1+2*(dx-dy);
						}
						g.drawLine(x,j,x,j);
					}
				}				
			}
			else{
				if(x1>x2)
				{
					x=x1; y=y1; yend=y2;
					g.drawLine(x,y,x,y);
					for(int j=y+1; j<=yend;j++)
					{
						if(d4mG1<0)
							d4mG1=d4mG1+2*dx;
						else
						{
							x=x-1;
							d4mG1=d4mG1+2*(dx-dy);
						}
						g.drawLine(x,j,x,j);
					}
				}
				else
				{
					x=x1; y=y1; yend=y2;
					g.drawLine(x,y,x,y);
					for(int j=y+1; j<=yend;j++)
					{
						if(d4mG1<0)
							d4mG1=d4mG1+2*dx;
						else
						{
							x=x+1;
							d4mG1=d4mG1+2*(dx-dy);
						}
						g.drawLine(x,j,x,j);
					}
				}				
			}
		}		
	}
	public void getObject(int x,int y)
	{				
		g.setColor(Color.red);
		Bresenham(x,y,x+150,y);	
	}
			
	public static void main(String[] args)
	{
		BresenhamAlgorithmIntro ob=new BresenhamAlgorithmIntro();
	}
}