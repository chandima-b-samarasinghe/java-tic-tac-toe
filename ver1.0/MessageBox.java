/**
	Author	: Chandima B Samarasinghe
	Date 	: 29th Aug 2017
**/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MessageBox extends MyFrame{
	JLabel lblMessage;
	ControlButton button;
	JPanel panel;
	public MessageBox(String title,String message){
		super(title,315,250,false,true);
		init(message);
	}
	private void init(String message){
		panel=new JPanel();
		panel.setLayout(null);

		lblMessage=new JLabel("<html><center>"+message+"</center></html>");
			lblMessage.setFont(new Font(
								"Tahoma", //font face
								1, //style (plain=0, bold-1)
								24 //font size
							)
			);
			lblMessage.setText("<html><center>"+message+"</center></html>");
			lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lblMessage.setSize(315,150);
			lblMessage.setLocation(0,0);
		panel.add(lblMessage);

		button=new ControlButton("Okay");
			button.setSize(200,35);
			button.setLocation(57,155);
			button.addActionListener(this);
		panel.add(button);

		this.setAlwaysOnTop (true);
		this.add(panel);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); //JFrame pack();
	}
	public void actionPerformed(ActionEvent event){
		dispose();
	}
}