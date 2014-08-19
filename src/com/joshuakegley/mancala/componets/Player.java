package com.joshuakegley.mancala.componets;

import java.util.HashMap;

public class Player {

	private HashMap<Integer, Integer> playerBoard = new HashMap<Integer, Integer>();
	private int kalaha = 0;
	
	public Player(){
		playerBoard.put(0, 3);
		playerBoard.put(1, 3);
		playerBoard.put(2, 3);
		playerBoard.put(3, 3);
		playerBoard.put(4, 3);
		playerBoard.put(5, 3);
	}
	
	public int totalPits(){
		int amount = 0;
		for(int i = 0; i < 6; i++){
			amount += playerBoard.get(i);
		}
		return amount;
	}
	
	public int getPit(int position){
		return playerBoard.get(position);
	}
	
	public void setPit(int position, int amount){
		playerBoard.put(position, amount);
	}

	public HashMap<Integer, Integer> getPlayerBoard() {
		return playerBoard;
	}

	public int getKalaha() {
		return kalaha;
	}

	public void setKalaha(int amount) {
		kalaha = amount;
	}
	
	public void printPlayerBoard(){
		System.out.println(playerBoard.get(0));
		System.out.println(playerBoard.get(1));
		System.out.println(playerBoard.get(2));
		System.out.println(playerBoard.get(3));
		System.out.println(playerBoard.get(4));
		System.out.println(playerBoard.get(5));
		System.out.println(getKalaha());
		
	}
	
	
}
