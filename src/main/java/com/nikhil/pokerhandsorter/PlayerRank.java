package com.nikhil.pokerhandsorter;

import java.util.List;

public class PlayerRank {
	private int rank;
	private int highCard;
	private int highestGroupCard;	
	private int highestNonGroupCard;
	private boolean isPair;
	private boolean isTwoPair;
	private boolean isThreeOfAKind;
	private boolean isFourOfAKind; 
	private boolean isStraight;	
	private boolean isFlush;
	private boolean isStraightFlush;
	private boolean isFullHouse;
	private boolean isSameSuit;
	private boolean isConsecutive;
	private List<Integer> sortedCards;

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getHighCard() {
		return highCard;
	}
	public void setHighCard(int highCard) {
		this.highCard = highCard;
	}
	public int getHighestGroupCard() {
		return highestGroupCard;
	}
	public void setHighestGroupCard(int highestGroupCard) {
		this.highestGroupCard = highestGroupCard;
	}
	public int getHighestNonGroupCard() {
		return highestNonGroupCard;
	}
	public void setHighestNonGroupCard(int highestNonGroupCard) {
		this.highestNonGroupCard = highestNonGroupCard;
	}
	public boolean isPair() {
		return isPair;
	}
	public void setPair(boolean isPair) {
		this.isPair = isPair;
	}
	public boolean isTwoPair() {
		return isTwoPair;
	}
	public void setTwoPair(boolean isTwoPair) {
		this.isTwoPair = isTwoPair;
	}
	public boolean isThreeOfAKind() {
		return isThreeOfAKind;
	}
	public void setThreeOfAKind(boolean isThreeOfAKind) {
		this.isThreeOfAKind = isThreeOfAKind;
	} 
	public boolean isFourOfAKind() {
		return isFourOfAKind;
	}
	public void setFourOfAKind(boolean isFourOfAKind) {
		this.isFourOfAKind = isFourOfAKind;
	}
	public boolean isStraight() {
		return isStraight;
	}
	public void setStraight(boolean isStraight) {
		this.isStraight = isStraight;
	}
	public boolean isFlush() {
		return isFlush;
	}
	public void setFlush(boolean isFlush) {
		this.isFlush = isFlush;
	}
	public boolean isStraightFlush() {
		return isStraightFlush;
	}
	public void setStraightFlush(boolean isStraightFlush) {
		this.isStraightFlush = isStraightFlush;
	}
	public boolean isFullHouse() {
		return isFullHouse;
	}
	public void setFullHouse(boolean isFullHouse) {
		this.isFullHouse = isFullHouse;
	}
	public boolean isSameSuit() {
		return isSameSuit;
	}
	public void setSameSuit(boolean isSameSuit) {
		this.isSameSuit = isSameSuit;
	}
	public boolean isConsecutive() {
		return isConsecutive;
	}
	public void setConsecutive(boolean isConsecutive) {
		this.isConsecutive = isConsecutive;
	}	
	public List<Integer> getSortedCards() {
		return sortedCards;
	}
	public void setSortedCards(List<Integer> sortedCards) {
		this.sortedCards = sortedCards;
	}
}
