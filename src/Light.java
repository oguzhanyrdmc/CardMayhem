import java.util.ArrayList;
import java.util.List;

public class Light extends Player {

	public LightDeck lightDeck;

	public Light(String nick) {
		super("Light",nick, 40, 40, 1,new Weapon(1, 2));
		this.lightDeck = new LightDeck(getThisplayer(), getEnemy());
		createDeckStack();
	}

	public LightDeck getLightDeck() {
		return lightDeck;
	}
	
	public void PlayCard(int index) {
		try {
			int cardID = getHand().pick(index);
			getHand().discard(index);
			lightDeck.effect(cardID);	
			setActionPoint(getActionPoint() - 1);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	public void setLightDeck(LightDeck lightDeck) {
		this.lightDeck = lightDeck;
	}
	
	public void createDeckStack() {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			temp.add(i);
		}
		
		while (!temp.isEmpty()) {
			int ran = (int) (Math.random() * temp.size());
			deck.add(this.lightDeck.getCardList().get(temp.remove(ran)));
		}
	}

}
