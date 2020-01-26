import java.util.ArrayList;
import java.util.List;

public class Axe extends Player {

	private AxeDeck axedeck;

	public Axe(String nick) {
		super("Axe", nick, 60, 20, 1, new Weapon(2, 2));
		this.axedeck = new AxeDeck(getThisplayer(), getEnemy());
		createDeckStack();
	}

	public AxeDeck getAxedeck() {
		return axedeck;
	}

	public void setAxedeck(AxeDeck axedeck) {
		this.axedeck = axedeck;
	}

	public void PlayCard(int index) {
		try {
			int cardID = getHand().pick(index);
			getHand().discard(index);
			axedeck.effect(cardID);	
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
			deck.add(this.axedeck.getCardList().get(temp.remove(ran)));
		}
	}

	@Override
	public void hit(Player enemy) {
			if (enemy.getArmor() == 0) {
				enemy.setHealth(enemy.getHealth() - ((getWeapon().getDamage() * 11 / 10)
						- (enemy.getArmor() * getWeapon().getDamage() * 11 / 10 / 100)));
			} else {
				enemy.setHealth(
						enemy.getHealth() - (getWeapon().getDamage() - enemy.getArmor() * getWeapon().getDamage() / 100));
				if (enemy.getArmor() - getWeapon().getDamage() < 0)
					enemy.setArmor(0);
				else
					enemy.setArmor(enemy.getArmor() - getWeapon().getDamage());
			}
			if(getWeapon().getDurability() - 1==0)
				getWeapon().setDurability(0);
			else
				getWeapon().setDurability(getWeapon().getDurability() - 1);
			setActionPoint(getActionPoint() - 1);
			getWeapon().setHit(true);
	}

}
