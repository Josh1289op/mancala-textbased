package com.joshuakegley.mancala.componets;


public class Board {
	
	//if placed last marble/item in hand in kahala, set true
	public boolean landedInKahala;
	
	public Player player;
	public Player opponent;
	public boolean gameOver = false;
	
	public Board(Player player, Player opponent){
		this.player = player;
		this.opponent = opponent;
	
	}
	
	
	public void move(int position){
		landedInKahala = false;
		int amount = player.getPit(position);
		System.out.println(amount);
		player.setPit(position, 0);
		
		
		for(int i = amount; i > 0; i--){
			position++;
			System.out.println("Position: " + position + "    Amount: " + amount + "    Iteration: " + i);
		
			switch(position){
			case 14:
				position = 0;
			case 0:
			case 1:
			case 2:		
			case 3:
			case 4:
			case 5:
				if(player.getPit(position) == 0 && amount == 1){
					player.setKalaha(player.getKalaha() + opponent.getPit(5 - position) + 1);
					opponent.setPit(5 - position, 0);
				}else{
					player.setPit(position, player.getPit(position) + 1);
				}
				break;
			case 6:
				player.setKalaha(player.getKalaha() + 1);
				if(i == 1){
					landedInKahala = true;
					System.out.println("Landed In Kalaha, Free Turn");
				}
				break;
			case 7:
				opponent.setPit(0, opponent.getPit(0) + 1);
				break;
			case 8:
				opponent.setPit(1, opponent.getPit(1) + 1);
				break;
			case 9:
				opponent.setPit(2, opponent.getPit(2) + 1);
				break;
			case 10:
				opponent.setPit(3, opponent.getPit(3) + 1);
				break;
			case 11:
				opponent.setPit(4, opponent.getPit(4) + 1);
				break;
			case 12:
				opponent.setPit(5, opponent.getPit(5) + 1);
				break;
			case 13:
				opponent.setKalaha(opponent.getKalaha() + 1);
				break;
			default:
				System.out.println("I should never reach this Case");
				break;
				
			}
			amount--;
			
			
		}
		isEmpty();
	}
	/*
	 * If all pits are empty, calculate winner
	 */
	public void isEmpty(){
		if(player.totalPits() == 0 && opponent.totalPits() == 0){
			mostKahala().setKalaha(opponent.totalPits() +  player.getKalaha());
			gameOver = true;
		}else{
			return;
		}
	}
	/*
	 * winner determined by most in kahala
	 */
	public Player mostKahala(){
		if(player.getKalaha() > opponent.getKalaha()){
			return player;
		}
		else{
			return opponent;
		}
		
	}
	

}
