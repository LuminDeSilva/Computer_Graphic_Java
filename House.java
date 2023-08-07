import java.awt.*;
import javax.swing.*;

class House extends JFrame
{
	House()
	{
		setTitle("House");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		
		g.drawLine(250,50,450,150);
		g.drawLine(50,150,450,150);
		g.drawLine(250,50,50,150);
		
		g.drawRect(100,150,300,200);
		
		g.fillRect(220,250,50,100);
		
		g.fillRect(140,180,60,60);
		g.fillRect(300,180,60,60);
		
		g.setColor(Color.white);
		
		g.fillRect(150,190,40,40);
		g.fillRect(310,190,40,40);
		
		g.fillOval(260,300,5,5);
		
		g.setColor(Color.black);
		g.drawLine(170,190,170,230);
		g.drawLine(150,210,190,210);
		
		g.drawLine(330,190,330,230);
		g.drawLine(310,210,350,210);
		
	}
	
	public static void main(String[] args)
	{
		new House();
	}
}