package com.nikhil.pokerhandsorter;

import java.io.*;

public class PokerHandSorter {
	
	public static void main (String[] args) {
		
		DetermineHandWinner getHandWinner = new DetermineHandWinner();
		String winnerOfCurrentHand, individualHand;
		
		try {
			BufferedReader pokerHandsReader = new BufferedReader(new InputStreamReader(System.in));
			
			while ((individualHand = pokerHandsReader.readLine()) != null) {
				System.out.println("Current Hand - " + individualHand);
				winnerOfCurrentHand = getHandWinner.getWinnerOfCurrentHand(individualHand);
				
			}

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
	}

}
