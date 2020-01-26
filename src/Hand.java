import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Hand {
private List<Card> hand=new ArrayList<Card>();

	public void discard(int index) { //return card
		BattleGround.graveyard.add(hand.remove(index));
	}

	public int pick(int index) { //return cardId
		return hand.get(index).getCardId();
	}
	
	public void draw(Stack<Card> deck) {
		hand.add(deck.pop());
	}
	
	public void display() {
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i));	
		}
	}
	
	public List<Card> getHand() {
		return hand;
	}	
	

}
