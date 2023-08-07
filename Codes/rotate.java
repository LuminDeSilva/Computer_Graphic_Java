import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class rotate extends JFrame implements MouseListener
{
	Graphics g;
	double[][] cordinates;
	
	rotate()
	{
		super("Rotation");
		setSize(300,300);
		addMouseListener(this);
		setVisible(true);
		g=getGraphics();
		cordinates=new double[2][2];
	}
	
	public static void main(String[] args)
	{
		rotate b=new rotate();
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseMove(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mousePressed(MouseEvent e)
	{
		cordinates[0][0]=e.getX();
		cordinates[1][0]=e.getY();
	}
	public void mouseReleased(MouseEvent e)
	{
		cordinates[0][1]=e.getX();
		cordinates[1][1]=e.getY();
		g.setColor(Color.red);
		draw(cordinates);
		rotat(90);
	}
	
	//Connecs DDA algorithm with declared coordinates
	public void draw(double[][] x)
	{
		DDA((int)x[0][0],(int)x[1][0],(int)x[0][1],(int)x[1][1]);
	}
	
	//Function which use the process to rotate the object
	public void rotat(int angle)
	{
		double theta=Math.toRadians(angle);
		g.setColor(Color.blue);
		double dx=cordinates[0][0];
		double dy=cordinates[1][0];
		cordinates=translation(cordinates,-dx,-dy);	//Takes the object to another place
		cordinates=multipleMatrix(equation(theta),cordinates);	//Rotate the object
		cordinates=translation(cordinates,dx,dy);	//Puts back to the same position
		draw(cordinates);
	}
	
	//Function use to change the location
	public double[][] translation(double[][] point,double x,double y)
	{
		for(int i=0;i<point[0].length;i++)
		{
			point[0][i]=point[0][i]+x;
			point[1][i]=point[1][i]+y;
		}
		return point;
	}
	
	//Equation to rotate the object
	public double[][] equation(double x)
	{
		double[][] equ=new double[2][2];
		equ[0][0]=Math.cos(x);
		equ[0][1]=-1*Math.sin(x);
		equ[1][0]=Math.sin(x);
		equ[1][1]=Math.cos(x);
		return equ;
	}
	
	//Function to calculate the equation with the coordinates
	public double[][] multipleMatrix(double[][] x,double[][] y)
	{
		double[][] ans=new double[x.length][y[0].length];
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<y[0].length;j++)
			{
				ans[i][j]=0;
				for(int k=0;k<x[0].length;k++)
				{
					ans[i][j]+=x[i][k]+y[k][j];
				}
			}
		}
		return ans;
	}
	
	//Basic DDA algorithm
	public void DDA(int x1,int y1,int x2,int y2)
	{
		int dx,dy;
		double xinc,yinc,steps,x,y;
		dx=x2-x1;
		dy=y2-y1;
		if(Math.abs(dx)>Math.abs(dy))
			steps=Math.abs(dx);
		else
			steps=Math.abs(dy);
		xinc=dx/steps;
		yinc=dy/steps;
		x=x1;
		y=y1;
		
		for(int i=1;i<=steps;i++)
		{
			x=x+xinc;
			y=y+yinc;
			g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		}
	}
}