import javax.swing.*;
import java.awt.*;

public class Graphicelement extends JFrame
{
	Graphicelement()
	{
		setTitle("Graphic Elements");
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.drawLine(40,50,500,250);
		
		g.setColor(Color.red);
		g.drawString("Hi",200,100);
		
		g.setColor(Color.blue);
		g.drawRect(40,40,400,200);
		g.fillRect(50,50,50,50);
		
		g.setColor(Color.yellow);
		g.drawOval(40,40,100,100);
		g.fillOval(100,150,60,60);
		
		g.setColor(Color.red);
		g.drawArc(30,170,40,50,90,160);
		g.fillArc(40,100,90,90,180,140);
	}
	public static void main(String[] args)
	{
		new Graphicelement();
	}
}