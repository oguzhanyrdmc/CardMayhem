import java.util.ArrayList;
import java.util.List;

public class Stone extends Player {

	private StoneDeck stoneDeck;

	public Stone(String nick) {
		super("Stone", nick, 80, 10, 1, new Weapon(2, 2));
		this.stoneDeck = new StoneDeck(getThisplayer(), getEnemy());
		createDeckStack();
	}

	public StoneDeck getStoneDeck() {
		return stoneDeck;
	}

	public void setStoneDeck(StoneDeck stoneDeck) {
		this.stoneDeck = stoneDeck;
	}

	public void PlayCard(int index) {
		try {
			int cardID = getHand().pick(index);
			getHand().discard(index);
			stoneDeck.effect(cardID);	
			setActionPoint(getActionPoint() - 1);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
	}

	public void createDeckStack() {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			temp.add(i);
		}

		while (!temp.isEmpty()) {
			int ran = (int) (Math.random() * temp.size());
			deck.add(this.stoneDeck.getCardList().get(temp.remove(ran)));
		}
	}

	@Override
	public void hit(Player enemy) {
		enemy.setHealth(
				enemy.getHealth() - (getWeapon().getDamage() - enemy.getArmor() * getWeapon().getDamage() / 100));
		if ((enemy.getArmor() - getWeapon().getDamage() * 11 / 10) < 0)
			enemy.setArmor(0);
		else {
			enemy.setArmor(enemy.getArmor() - getWeapon().getDamage() * 11 / 10);
		}
		if(getWeapon().getDurability() - 1==0)
			getWeapon().setDurability(0);
		else
			getWeapon().setDurability(getWeapon().getDurability() - 1);
		setActionPoint(getActionPoint() - 1);
		getWeapon().setHit(true);
	}

}
