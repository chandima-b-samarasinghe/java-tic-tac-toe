/**
	Author	: Chandima B Samarasinghe
	Date 	: 29th Aug 2017
**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends MyFrame{
	JPanel panel,panelButton, panelHeader;
	JLabel labelHeader;
	GameButton[] button=new GameButton[9];
	ControlButton buttonReset;
	GameObject game;
	
	public static void main(String[] args){
		TicTacToe TicTacToe=new TicTacToe();
	}

	public TicTacToe(){
		super("TacTicToe",315,470,false,true);//passing arguments to MyFrame constructor
		init();
	}
	private void init(){
		this.setLayout(null);
		//panel header
		panelHeader=new JPanel(new GridLayout(1,2));
			panelHeader.setLocation(20,40);
			panelHeader.setSize(270,40);
			labelHeader=new JLabel("Player");
				labelHeader.setFont(new Font(
								"Tahoma", //font face
								0, //style (plain=0, bold-1)
								19 //font size
							)
				);
				panelHeader.add(labelHeader);
			buttonReset=new ControlButton("New Game");
				buttonReset.addActionListener(this);
				panelHeader.add(buttonReset);
			add(panelHeader);
		//panel button grid
		panelButton=new JPanel();
			panelButton.setLayout(new GridLayout(3,3));
				panelButton.setLocation(20,100);
				panelButton.setSize(270,270);

				for(int btn=0;btn<9;btn++){
					button[btn]=new GameButton(btn);
					button[btn].addActionListener(this);
					panelButton.add(button[btn]);
				}
			add(panelButton);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); //JFrame pack();
		//Game
		game=new GameObject();
			togglePlayer();

	}

	private void gameHandle(int status,int index){
		MessageBox message;
		switch(status){
			case 0: //continue
				button[index].select(game.getPlayedPlayer());
				break;
			case 1: //player 1 won
				button[index].select(game.getCurrentPlayer());
				message=new MessageBox("Congratz!","Player#1<br>won the<br>GAME!");
				enableButton(false);
				break;
			case 2: //player 2 won
				button[index].select(game.getCurrentPlayer());
				message=new MessageBox("Congratz!","Player#2<br>won the<br>GAME!");
				enableButton(false);
				break;
			case 3: //draw
				button[index].select(game.getPlayedPlayer());
				message=new MessageBox("Ohh!","Drawbr>GAME!");
				enableButton(false);
				break;
			case 4: //invalid move
				message=new MessageBox("Attention!","Invalid Move<br>Try Again!");
				break;
		}
		togglePlayer();
	}
	private void togglePlayer(){
		labelHeader.setText("Turn: Player#"+game.getCurrentPlayer());
	}
	private void resetGame(){
		game.reset();
		resetButton();
		enableButton(true);
	}
	
	private void enableButton(boolean state){
		for(int btn=0;btn<9;btn++){
			button[btn].setEnabled(state);
		}
	}
	private void resetButton(){
		for(int btn=0;btn<9;btn++){
			button[btn].reset();
		}
	}

	public void actionPerformed(ActionEvent event){
		int index=Integer.valueOf(((GameButton)event.getSource()).getName());
		if(index<9){// gameGridButton
			int status=game.play(index);
			gameHandle(status,index);
		}else{ //control button
			MessageBox message=new MessageBox("Reset","Game is resetted<br>Successfully!");
			resetGame();
		}
	}

}