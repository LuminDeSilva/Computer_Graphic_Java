import javax.swing.*;

public class Secondframe
{
	public static void main(String[] args)
	{
		JFrame frm=new JFrame();
		frm.setSize(400,300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocation(new java.awt.Point(600,300));
		frm.setTitle("My Second Frame");
		
		JButton btn=new JButton("Button");
		btn.setBounds(150,100,100,50);
		
		frm.add(btn);
		frm.setLayout(null);
		frm.setVisible(true);
	}
}