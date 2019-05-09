package com.nikhil.pokerhandsorter;

public class PlayerRank {
	private int rank;
	private char highCard;
	private boolean isPair;
	private boolean isTwoPair;
	private boolean isThreeOfAKind;
	private boolean isFourOfAKind; 
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public char getHighCard() {
		return highCard;
	}
	public void setHighCard(char highCard) {
		this.highCard = highCard;
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

}
