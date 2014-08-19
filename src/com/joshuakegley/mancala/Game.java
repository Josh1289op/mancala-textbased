package com.joshuakegley.mancala;

import java.util.Scanner;

import com.joshuakegley.mancala.componets.Board;
import com.joshuakegley.mancala.componets.Player;

public class Game {

	public static Scanner s = new Scanner(System.in);
	public Player pOne = new Player();
	public Player pTwo = new Player();
	
	public static void main(String args[]){
		

		boolean pOneTurn = false;
		Board board;
		Game game = new Game();
		
		System.out.println("Welcome to Mancala!!!");
		if(game.goesFirst() == 0){
			System.out.println("Player one goes first!");
			board = new Board(game.pOne, game.pTwo);
			pOneTurn = true;
		}
		else{
			board = new Board(game.pTwo, game.pOne);
			System.out.println("Player two goes first!");

		}	
		
		
		while(!board.gameOver){
			System.out.println(game.printBoard());
			System.out.print("Enter Position to Move:");
			int i = s.nextInt();
			board.move(i);
			if(((pOneTurn && board.landedInKahala) || (!pOneTurn && !board.landedInKahala)) && !board.gameOver){
				System.out.println("Player One's Turn: ");
				pOneTurn = true;
				board = new Board(game.pOne, game.pTwo);
			}else if(!board.gameOver){
				System.out.println("Player Two's Turn: ");
				pOneTurn = false;
				board = new Board(game.pTwo, game.pOne);
			}

		}
		System.out.println(game.printBoard());
		System.out.println("Game Over");
		if(board.mostKahala() == game.pOne){
			System.out.println("Player One is the Winner");
		}else if(board.mostKahala() == game.pTwo){
			System.out.println("Player Two is the Winner");
		}else{
			System.out.println("I broke it");
		}
	
	}
	

	public int goesFirst(){
		int i = (int)Math.round(Math.random());
		return i;
	}
	
	public String printBoard(){
		String board = new String();

		board += "\n\n--[0]--[1]--[2]--[3]--[4]--[5]--\n";
		board += "-----------Player Two-----------\n";
		board += "--(" + pTwo.getPit(5) + ")--(" + pTwo.getPit(4) + ")--(" + pTwo.getPit(3) + ")--(" + pTwo.getPit(2) + ")--(" + pTwo.getPit(1) + ")--(" + pTwo.getPit(0) + ")--";		
		board += "\n(" + pTwo.getKalaha() + ")--------------------------(" + pOne.getKalaha() + ")\n";
		board += "--(" + pOne.getPit(0) + ")--(" + pOne.getPit(1) + ")--(" + pOne.getPit(2) + ")--(" + pOne.getPit(3) + ")--(" + pOne.getPit(4) + ")--(" + pOne.getPit(5) + ")--\n";
		board += "-----------Player One-----------\n";
		board += "--[0]--[1]--[2]--[3]--[4]--[5]--\n\n";

		return board;
	}
	
}
