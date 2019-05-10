package com.nikhil.pokerhandsorter;

import java.util.List;

public class PlayerRank {
	private int rank;
	private int highCard;
	private int highestGroupCard;
	private int highestSecondGroupCard;
	private int highestNonGroupCard;
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
	public int getHighestSecondGroupCard() {
		return highestSecondGroupCard;
	}
	public void setHighestSecondGroupCard(int highestSecondGroupCard) {
		this.highestSecondGroupCard = highestSecondGroupCard;
	}
	public int getHighestNonGroupCard() {
		return highestNonGroupCard;
	}
	public void setHighestNonGroupCard(int highestNonGroupCard) {
		this.highestNonGroupCard = highestNonGroupCard;
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
