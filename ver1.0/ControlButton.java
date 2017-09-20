/**
	Author	: Chandima B Samarasinghe
	Date 	: 29th Aug 2017
**/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ControlButton extends GameButton{
	public ControlButton(String text){
		super(10);
		setText(text);
		setFont(new Font(
					"Tahoma", //font face
					0, //style (plain=0, bold-1)
					18 //font size
					)
		);
		setBackground(Color.white);
	}	
}