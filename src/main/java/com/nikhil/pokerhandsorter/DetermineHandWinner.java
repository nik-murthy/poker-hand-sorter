package com.nikhil.pokerhandsorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.nikhil.pokerhandsorter.PlayerHandConstants.*;


public class DetermineHandWinner {
	
	public String getWinnerOfCurrentHand(String currentHand) {
		//System.out.println("From New Class");
		
		//Determine individual player hands		
		String[] player1Hand = Arrays.copyOfRange(currentHand.split(" "), 0, 5);
		String[] player2Hand = Arrays.copyOfRange(currentHand.split(" "), 5, 10);
		
		//Determine individual player ranks
		PlayerRank player1Rank = getPlayerRank(player1Hand);
		PlayerRank player2Rank = getPlayerRank(player2Hand);
		
		//Evaluate Winner
		if (player1Rank.getRank() > player2Rank.getRank()) {
			//System.out.println("Win: Player 1 rank higher - " + player1Rank.getRank() + " " + player2Rank.getRank());
			return PLAYER_1_WINS;
		} else if (player1Rank.getRank() == player2Rank.getRank()) {
			int commonRank = player1Rank.getRank();
			
			if(commonRank == HIGH_CARD_RANK
					|| commonRank == STRAIGHT_RANK
					|| commonRank == FLUSH_RANK
					|| commonRank == STRAIGHT_FLUSH_RANK) {
				if(player1Rank.getHighCard() > player2Rank.getHighCard()) {
					//System.out.println("Player 1 Wins by high card");
					return PLAYER_1_WINS;
				}
				//If high cards are same then loop through to find the next highest
				if(commonRank == HIGH_CARD_RANK && player1Rank.getHighCard() 
						== player2Rank.getHighCard()) {
					for (int card = 1; card < player1Rank.getSortedCards().size(); card++) {
						//System.out.println("P1 - " + player1Rank.getSortedCards().get(card));
						//System.out.println("P2 - " + player2Rank.getSortedCards().get(card));
						if(player1Rank.getSortedCards().get(card) 
								> player2Rank.getSortedCards().get(card)) {
							//System.out.println("Player 1 Wins by high card (secondary)");
							return PLAYER_1_WINS;
						} else if(player1Rank.getSortedCards().get(card) 
								< player2Rank.getSortedCards().get(card)){
							return PLAYER_2_WINS;
						}
					}
				}
			}
						
			if(commonRank == PAIR_RANK
					|| commonRank == THREE_OF_A_KIND_RANK
					|| commonRank == FOUR_OF_A_KIND_RANK
					|| commonRank ==  TWO_PAIR_RANK
					|| commonRank == FULL_HOUSE_RANK) {
				if(player1Rank.getHighestGroupCard() > player2Rank.getHighestGroupCard()) {
					//System.out.println("Player 1 Wins by highest grouped card");
					return PLAYER_1_WINS;
				}
				//If pairs are the same, then check the next highest card
				if(player1Rank.getHighestGroupCard() 
						== player2Rank.getHighestGroupCard()) {
					
					//Special check only for two pair to determine higher second pair
					if(commonRank ==  TWO_PAIR_RANK) {
						if(player1Rank.getHighestSecondGroupCard() 
								> player2Rank.getHighestSecondGroupCard()) {
							return PLAYER_1_WINS;
						} else {
							return PLAYER_2_WINS;
						}
					}
					
					if(player1Rank.getHighestNonGroupCard() 
							> player2Rank.getHighestNonGroupCard()) {
						//System.out.println("Player 1 Wins by highest non-grouped card");
						return PLAYER_1_WINS;
					}					
				}				
			}			
		} 		
		return PLAYER_2_WINS;
	}
	
	private PlayerRank getPlayerRank(String[] playerHand) {
		
		//Separate player card number and suit
		List<String> cardSuit = new ArrayList<String>(); 
		List<Integer> cardNumber= new ArrayList<Integer>();
		char cardNumberValue;
		
		PlayerRank playerRank = new PlayerRank();
		for(String currentCard : playerHand) {
			/* Add exception handling here */
			//Assign numeric values to cards T through A
			cardNumberValue = currentCard.charAt(0);
			if(T_CARD_NAME == cardNumberValue) {
				cardNumber.add(Integer.valueOf(T_CARD_VALUE));				
			} else if(J_CARD_NAME == cardNumberValue) {
				cardNumber.add(Integer.valueOf(J_CARD_VALUE));
			} else if(Q_CARD_NAME == cardNumberValue) {
				cardNumber.add(Integer.valueOf(Q_CARD_VALUE));
			} else if(K_CARD_NAME == cardNumberValue) {
				cardNumber.add(Integer.valueOf(K_CARD_VALUE));
			} else if(A_CARD_NAME == cardNumberValue) {
				cardNumber.add(Integer.valueOf(A_CARD_VALUE));
			} else {
				cardNumber.add(Integer.parseInt(
						String.valueOf(cardNumberValue)));
			}			
			cardSuit.add(String.valueOf(
					currentCard.charAt(1)));			
		}
		
		
		//Determine if suit is same for all cards
		if(cardSuit.stream().distinct().count() == 1) {
			playerRank.setSameSuit(true);
		}
		
		//Check if card numbers are distinct and sort for use next		
		long distinctCardCount = cardNumber.stream().distinct().count();		
		Collections.sort(cardNumber, Collections.reverseOrder());
		
		//Group cards by their count - useful for rank 2 onwards
		//map key - number on the card
		//map value - number of times the same card number appears
		Map<Integer, Long> cardNumberMap = cardNumber.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		if(distinctCardCount == 5) {
			//Check for consecutive cards
			//Set high card			
			playerRank.setHighCard(cardNumber.get(0));
			playerRank.setSortedCards(cardNumber);
			playerRank.setConsecutive(true);
			for (int index = cardNumber.size() - 1; index > 0; index--) {
				//System.out.println(cardNumber.get(index) - cardNumber.get(index - 1));
				if((cardNumber.get(index) - cardNumber.get(index - 1)) != -1) {
					playerRank.setConsecutive(false);
					break;
				}				
			}
			if(playerRank.isSameSuit() && playerRank.isConsecutive()) {
				if(playerRank.getHighCard() == A_CARD_VALUE) {
					playerRank.setRank(ROYAL_FLUSH_RANK);
				} else {
					playerRank.setRank(STRAIGHT_FLUSH_RANK);
				}								
			}
			if(playerRank.isSameSuit() && !playerRank.isConsecutive()) {
				playerRank.setRank(FLUSH_RANK);
			}
			if (!playerRank.isSameSuit() && playerRank.isConsecutive()) {
				playerRank.setRank(STRAIGHT_RANK);
			}
			if(!playerRank.isSameSuit() && !playerRank.isConsecutive()) {
				playerRank.setRank(HIGH_CARD_RANK);
			}
		} else if (distinctCardCount == 4) {
			//Pair found
			//set pair high card
			playerRank.setRank(PAIR_RANK);
			determineHighCards(cardNumberMap, playerRank, 2);			
		} else if (distinctCardCount == 3) {
			//Three of a kind or 2 pairs found
			//set high card
			if(cardNumberMap.containsValue(Long.valueOf(3))) {
				playerRank.setRank(THREE_OF_A_KIND_RANK);
				determineHighCards(cardNumberMap, playerRank, 3);				
			} else {
				playerRank.setRank(TWO_PAIR_RANK);
				determineHighCards(cardNumberMap, playerRank, 2);
				//This logic only required for 2 pairs to determine the second highest pair
				playerRank.setHighestSecondGroupCard(cardNumber.get(cardNumber.size() - 2));
			}					
		} else if (distinctCardCount == 2) {
			//four of a kind or full house found
			//set high card
			if(cardNumberMap.containsValue(Long.valueOf(4))) {
				playerRank.setRank(FOUR_OF_A_KIND_RANK);
				determineHighCards(cardNumberMap, playerRank, 4);
			} else {
				playerRank.setRank(FULL_HOUSE_RANK);
				determineHighCards(cardNumberMap, playerRank, 3);
			}			
		}		
		return playerRank;		
	}
	
	private void determineHighCards(Map<Integer, Long> cardNumberMap, PlayerRank playerRank, int cardCount) {
				
		int highestNonGroupCard = 0;
		int highestGroupCard = 0;
		int highestSecondGroupCard = 0;
		for(Integer highCard : cardNumberMap.keySet()) {
			if (cardNumberMap.get(highCard) == cardCount && highCard > highestGroupCard) {
				highestGroupCard = highCard;
			} else if(highCard > highestNonGroupCard) {
				highestNonGroupCard = highCard;
			}
		}
		playerRank.setHighestGroupCard(highestGroupCard);
		playerRank.setHighestNonGroupCard(highestNonGroupCard);
	}
}
