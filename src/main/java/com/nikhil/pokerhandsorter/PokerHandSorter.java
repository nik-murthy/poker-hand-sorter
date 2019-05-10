package com.nikhil.pokerhandsorter;

import java.io.*;
import static com.nikhil.pokerhandsorter.PlayerHandConstants.*;

public class PokerHandSorter {
	
	public static void main (String[] args) {
		
		DetermineHandWinner getHandWinner = new DetermineHandWinner();
		String individualHand;
		int player1Wins = 0, player2Wins = 0;
		try {
			BufferedReader pokerHandsReader = new BufferedReader(new InputStreamReader(System.in));
			
			while ((individualHand = pokerHandsReader.readLine()) != null) {
				
				if(getHandWinner.getWinnerOfCurrentHand(individualHand).equals(PLAYER_1_WINS)){
					player1Wins++;
				} else if (getHandWinner.getWinnerOfCurrentHand(individualHand).equals(PLAYER_2_WINS)) {
					player2Wins++;
				} else if(getHandWinner.getWinnerOfCurrentHand(individualHand).equals(INCORRECT_HAND_SIZE_MESSAGE)) {
					System.out.println(INCORRECT_HAND_SIZE_MESSAGE);
				}
			}
			System.out.println("Player 1 Wins - " + player1Wins);
			System.out.println("Player 2 Wins - " + player2Wins);
		} catch (IOException exp) {
			System.out.println(FILE_IO_ERROR_MESSAGE);
		}
	}
}
