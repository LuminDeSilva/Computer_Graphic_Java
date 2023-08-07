import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class rotation extends JFrame implements MouseListener
{
	Graphics g;
	double[][] coordinates;
	 
	rotation()
	{
		super("rotateLine");
		setSize(500,500);
		addMouseListener(this);	
		setVisible(true);
		g=getGraphics();
		g.setColor(Color.red);
		coordinates=new double[2][2];	
	}
	
	public static void main(String a[])
	{
		rotation b=new rotation();
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public double[][] traslatePoints(double [][] points,double dx, double dy)
	{
		for(int j=0;j<points[0].length;j++)
		{
			points[0][j]=points[0][j]+dx;
			points[1][j]=points[1][j]+dy;
		}
		return points;
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		 coordinates[0][0]=me.getX();
		 coordinates[1][0]=me.getY();
	}
	public void mouseReleased(MouseEvent me)
	{
		coordinates[0][1]=me.getX();
		coordinates[1][1]=me.getY();
		g.setColor(Color.red);
		drawtri(coordinates);
		rotate(90);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseDragged(MouseEvent me){}
	public void mouseMove(MouseEvent me){}
	
	public void drawtri(double [][]points)
	{	
		g.drawLine((int)points[0][0],(int)points[1][0],(int)points[0][1],(int)points[1][1]);
	}
	
	public void rotate(int angle)
	{
		double teta=Math.toRadians(angle);
		g.setColor(Color.blue);
		double dx=coordinates[0][0];
		double dy=coordinates[1][0];
		coordinates=traslatePoints(coordinates,-dx,-dy);
		coordinates=multipleMatrix(rotateMatrix(teta),coordinates);
		coordinates=traslatePoints(coordinates,dx,dy);
		drawtri(coordinates);
	}
	
	public double [][] rotateMatrix(double teta)
	{
		double r[][]=new double[2][2];
		r[0][0]=Math.cos(teta);
		r[0][1]=-1*Math.sin(teta);
		r[1][0]=Math.sin(teta);
		r[1][1]=Math.cos(teta);
		return r;
	}
	
	public double[][] multipleMatrix(double x[][],double y[][])
	{
		double ans[][]=new double [x.length][y[0].length];
		for(int i=0;i<x.length;i++)
		{
			for (int j=0;j<y[0].length;j++)
			{
				ans[i][j]=0;
				for(int k=0;k<x[0].length;k++)
				{
					ans[i][j]+=x[i][k]*y[k][j];
				}
			}
		}
		return ans;
	}
}