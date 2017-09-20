/**
	Author	: Chandima B Samarasinghe
	Date 	: 29th Aug 2017
**/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameButton extends JButton{
	boolean isSelected=false;
	public GameButton(int btn){
		super("");
		setName(String.valueOf(btn));
		setFont(new Font(
					"Tahoma", //font face
					1, //style (plain=0, bold-1)
					24 //font size
					)
		);
		setBackground(Color.white);
	}
	public void reset(){
		setBackground(Color.white);
		setText("");
		isSelected=false;
	}
	public void setEnable(boolean state){
		setEnabled(state);
	}
	public boolean select(int player){
		if(isSelected){
			return false;
		}else{
			setBackground(
				(player==1)? Color.yellow:Color.green
			);
			setText(String.valueOf(player));
			isSelected=true;
			return true;
		}
	}
	public boolean isSelected(){return isSelected;}
}