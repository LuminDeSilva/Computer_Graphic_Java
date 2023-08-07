import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BoundaryFill4 extends JFrame implements MouseListener
{
	int x1,y1;
	Graphics g;
	Color[][]pixels=new Color[800][800];
	
	BoundaryFill4()
	{
		setTitle("Boundary Fill");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseListener(this);		
		g=getGraphics();
	}

	public Color getPixel(int x,int y)
	{
		return pixels[x][y];
	}

	public void setPixel(int x,int y,Color c)
	{
		g.setColor(c);
		pixels[x][y]=g.getColor();
		g.drawOval(x,y,1,1);
	}

	public void boundaryFill(int x,int y,Color ic,Color bc)
	{
		Color qc=getPixel(x,y);
		if(qc!=ic && qc!=bc)
		{
			setPixel(x,y,ic);
			boundaryFill(x,y-1,ic,bc);
			boundaryFill(x,y+1,ic,bc);
			boundaryFill(x-1,y,ic,bc);
			boundaryFill(x+1,y,ic,bc);
		}
	}
	public void DDA(int x1,int y1,int x2,int y2)
	{
		int dx,dy;
		double steps,xinc,yinc,x,y;
		dx=x2-x1;
		dy=y2-y1;

		if(Math.abs(dx)>Math.abs(dy))
		{
			steps=Math.abs(dx);
		}
		else
		{
			steps=Math.abs(dy);
		}

		xinc=dx/steps;
		yinc=dy/steps;

		x=x1;
		y=y1;

		setPixel((int)Math.round(x),(int)Math.round(y),Color.blue);

		for(int i=1;i<=steps;i++)
		{
			x=x+xinc;
			y=y+yinc;
			setPixel((int)Math.round(x),(int)Math.round(y),Color.blue);
		}
	}

	public void mouseClicked(MouseEvent e)
	{
		x1=e.getX();
		y1=e.getY();
		DDA(x1,y1,x1+40,y1);
		DDA(x1,y1,x1,y1+40);
		DDA(x1,y1+40,x1+40,y1+40);
		DDA(x1+40,y1,x1+40,y1+40);
		boundaryFill(x1+1,y1+1,Color.magenta,Color.blue);
	}
	
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	public static void main(String[] args)
	{
		new BoundaryFill4();
	}
}