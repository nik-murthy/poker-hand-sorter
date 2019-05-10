package com.nikhil.pokerhandsorter;

import java.io.*;
import static com.nikhil.pokerhandsorter.PlayerHandConstants.*;

public class PokerHandSorter {
	
	public static void main (String[] args) {
		
		DetermineHandWinner getHandWinner = new DetermineHandWinner();
		String individualHand;
		int player1Wins = 0, player2Wins = 0;

		//High Card
//		individualHand = "AH KH TC 5C 2C 5H AS 4H 3H 7D";
//		System.out.println("High Card - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
		//pair with high card
//		individualHand = "AH KH TC 5C AC 5H AS 4H 3H 4D";
//		System.out.println("pair with high card - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
//		//same pair with high out of pair card
//		individualHand = "AH KH TC 5C AC 5H AS 4H 3H AD";
//		System.out.println("same pair with high out of pair card - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
//		//three of a kind with high card
//		individualHand = "AH KH AC 5C AC 5H AS 4H 4S 4D";
//		System.out.println("three of a kind - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
//		//two pair with high card
//		individualHand = "AH KH KC 5C AC 5H AS QH QC AD";
//		System.out.println("two pair - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
//		//two pair with high with high out of pair card
//		individualHand = "AH KH TC 5C AC 5H AS 4H 3H 4D";
//		System.out.println("two pair with high with high out of pair card - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
//		//four of a kind with high card
//		individualHand = "AH KH AC AS AC 5H 5C 5D 5S 4D";
//		System.out.println("four of a kind - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
//		
		//individualHand = "2S 3D JS 8S TD JD 2C 7S 3C 9C";
		individualHand = "QC KC QH 7H QS 9C 8D TD 3H TC";
		System.out.println("winner - " + getHandWinner.getWinnerOfCurrentHand(individualHand));
		
		
//		try {
//			BufferedReader pokerHandsReader = new BufferedReader(new InputStreamReader(System.in));
//			
//			while ((individualHand = pokerHandsReader.readLine()) != null) {
//				
//				if(getHandWinner.getWinnerOfCurrentHand(individualHand).equals(PLAYER_1_WINS)){
//					//System.out.println("Player 1 Wins current hand");
//					System.out.println("Current Hand - " + individualHand);
//					player1Wins++;
//				} else {
//					//System.out.println("Player 2 Wins current hand");
//					player2Wins++;
//				}				
//			}
//			
//			System.out.println("Player 1 Wins - " + player1Wins);
//			System.out.println("Player 2 Wins - " + player2Wins);
//
//		} catch (Exception exp) {
//			System.out.println(exp.getMessage());
//		}
	}
}
