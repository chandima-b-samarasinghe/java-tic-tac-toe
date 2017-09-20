/**
	Author	: Chandima B Samarasinghe
	Date 	: 29th Aug 2017
**/
import java.util.*;

public class GameObject{
	private int player,moves;
	private int[] mat;

	public GameObject(){mat=new int[9]; reset();}
	private boolean checkRow(int index){
		for(int r=3*(index/3);r<3*(index/3)+3;r++){
			if(mat[r]==0 || mat[r]==player){//other player or 0
				return false;
			}
		}
		return true;
	}
	private boolean checkCol(int index){
		for(int c=index%3;c<=index%3+6;c=c+3){
			if(mat[c]==0 || mat[c]==player){//other player or 0
				return false;
			}
		}
		return true;
	}
	private boolean checkDiagonal(int index){
		if(index%2==0){
			boolean st=true;
			for(int k=0;k<9;k=k+4){ //main diagonal
				if(mat[k]==0 || mat[k]==player){//other player or 0
					st=false;
					break;
				}
			}
			if(st){
				return true; //main diagonal won
			}
			for(int k=2;k<7;k=k+2){ //secondary diagonal
				if(mat[k]==0 || mat[k]==player){//other player or 0
					return false;
				}
			}
			return true;//secondary dia ok
		}else{
			return false;
		}
	}
	public boolean checkWin(int index){
		return (checkCol(index) || checkRow(index) || checkDiagonal(index));
	}
	public boolean isOver(){ return (moves==9);	}
	public int getCurrentPlayer(){return player;}
	public int getPlayedPlayer(){ return (player==1)?2:1;}
	public int togglePlayer(){
		player=(player==1)?2:1;
		return player;
	}
	public void reset(){
		Arrays.fill(mat,0); player=1; moves=0;
	}
	/**
		return values
		0 - valid move, continue
		1 - valid move, player 1 won
		2 - valid move, player 2 won
		3 - valid move, draw game , game over
		4 - invalid move
	**/
	public int play(int index){
		if(isOver()){
			return 5; //which will never runs :)
		}else{
			if(mat[index]==0){//valid move
				mat[index]=player;
				moves++;
				togglePlayer();
				
				boolean status=checkWin(index);
				if(status){//won last played player
						togglePlayer(); //get won player
						return player; //1,2
				}else{//no one win yet
					if(isOver()){ //draw, game over
						return 3;
					}else{
						return 0;
					}
				}
			}else{//invalid move
				return 4;
			}
		}
	}
}