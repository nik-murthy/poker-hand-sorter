import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nikhil.pokerhandsorter.DetermineHandWinner;
import static com.nikhil.pokerhandsorter.PlayerHandConstants.*;

public class InputValidation {
	
	DetermineHandWinner getHandWinner = new DetermineHandWinner();
	@Test
    void testHigherFlushByCorrectingInputGivenInWrongCase() {
		String individualHand = "2C 3C 4C 5c 6C 3H TH JH 5H 9H";
		assertEquals(PLAYER_1_WINS, getHandWinner.getWinnerOfCurrentHand(individualHand));
    }
	
	@Test
    void testHigherFlushWithIncorrectNumberOfCardsInHand() {
		String individualHand = "2C 3C 4C 5C 6C 3H TH JH 5H";
		assertEquals(INCORRECT_HAND_SIZE_MESSAGE, getHandWinner.getWinnerOfCurrentHand(individualHand));
    }

}
