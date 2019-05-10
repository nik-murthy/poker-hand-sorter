import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nikhil.pokerhandsorter.DetermineHandWinner;

public class PokerHandSorterTestForPlayer2Wins {

DetermineHandWinner getHandWinner = new DetermineHandWinner();
	
	@Test
    void testHighCardFirst() {
		String individualHand = "5H QS 4H 3H 7D AH KH TC 5C 2C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHighCardSecond() {
		String individualHand = "5H AS 4H 3H 7D AH KH TC 5C 2C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHighCardThird() {
		String individualHand = "5H AS 4H 3H KD AH KH TC 5C 2C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHighCardFourth() {
		String individualHand = "4H AS TH 3H KD AH KH TC 5C 2C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHighCardLast() {
		String individualHand = "5H AS TH 2H KD AH KH TC 5C 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testOnePair() {
		String individualHand = "5H AS TH 2H KD AH KH AC 5C 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherPair() {
		String individualHand = "5H 5S TH 2H KD AH KH AC 5C 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testSamePairNonPairHighCard() {
		String individualHand = "5H AS TH 2H AD AH KH AC 5C 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testTwoPair() {
		String individualHand = "5H AS TH TD AD AH KH AC KC 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testThreeOfAKind() {
		String individualHand = "5H AS TH 2H QD AH AD AC 2C 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherThreeOfAKind() {
		String individualHand = "5H TS TH 2H TD AH AD AC 2S 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testFourOfAKind() {
		String individualHand = "4H TS TH 2H TD 5H 5D 5C 5S 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherFourOfAKind() {
		String individualHand = "4H 4S 4C 2H 4D 5H 5D 5C 5S 3C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testStraight() {
		String individualHand = "2H 5D 5C 5S 3C 3H 4S 5H 6H 7D";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherStraight() {
		String individualHand = "2H 3D 4C 5S 6C 3H 4S 5H 6H 7D";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }	

	@Test
    void testFlush() {
		String individualHand = "2H 3D 4C 5S 6C 3H TH JH 5H 9H";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	@Test
    void testHigherFlush() {
		String individualHand = "3H TH JH 5H 9H 2C 3C 4C 5C 6C";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testStraightFlush() {
		String individualHand = "2H 3D 4C 5S 6C 3H 4H 5H 6H 7H";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherStraightFlush() {
		String individualHand = "2S 3S 4S 5S 6S 3H 4H 5H 6H 7H";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testFullHouse() {
		String individualHand = "2H 3D 4C 5S 6C 8H 4H 8S 8C 4S";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherFullHouse() {
		String individualHand = "2H 2D 4C 4S 4D 8H 4H 8S 8C 4S";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testRoyalFlush() {
		String individualHand = "8H 4H 8S 8C 4S TH JH QH KH AH";
		assertEquals("P2", getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
}
