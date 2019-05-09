package com.nikhil.pokerhandsorter;

import java.util.Arrays;


public class DetermineHandWinner {
	
	public String getWinnerOfCurrentHand(String currentHand) {
		//System.out.println("From New Class");
		
		//Determine individual player hands		
		String[] player1Hand = Arrays.copyOfRange(currentHand.split(" "), 0, 5);
		String[] player2Hand = Arrays.copyOfRange(currentHand.split(" "), 5, 10);
		
		//System.out.println("Player 1 Hand - " + Arrays.toString(player1Hand));
		//System.out.println("Player 2 Hand - " + Arrays.toString(player2Hand));
		
		PlayerRank player1Rank = getPlayerRank(player1Hand);
		PlayerRank player2Rank = getPlayerRank(player2Hand);
		
		return currentHand;
	}
	
	private PlayerRank getPlayerRank(String[] playerHand) {
		
		PlayerRank playerRank = new PlayerRank();
		for(String currentCard : playerHand) {
			
		}
		
		return playerRank;
		
	}

}
