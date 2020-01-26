import java.util.ArrayList;
import java.util.List;

public class Blood extends Player {

	private BloodDeck bloodDeck;

	public Blood(String nick) {
		super("Blood", nick, 30, 20, 1,new Weapon(1, 2));
		this.bloodDeck = new BloodDeck(getThisplayer(), getEnemy());
		createDeckStack();
	}

	public BloodDeck getBloodDeck() {
		return bloodDeck;
	}

	public void setBloodDeck(BloodDeck bloodDeck) {
		this.bloodDeck = bloodDeck;
	}
	
	public void PlayCard(int index) {
		try {
			int cardID = getHand().pick(index);
			getHand().discard(index);
			bloodDeck.effect(cardID);	
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
			deck.add(this.bloodDeck.getCardList().get(temp.remove(ran)));
		}
	}

	@Override
	public void hit(Player enemy) {
		enemy.setHealth(enemy.getHealth() - (getWeapon().getDamage() - enemy.getArmor()*getWeapon().getDamage()/100));
		if (getHealth()+getWeapon().getDamage() > getMAXHEALTH())		
			setHealth(getMAXHEALTH());
		else
			setHealth(getHealth()+getWeapon().getDamage());
		if (enemy.getArmor() - getWeapon().getDamage()<0)
			enemy.setArmor(0);
		else
			enemy.setArmor(enemy.getArmor() - getWeapon().getDamage());
		if(getWeapon().getDurability() - 1==0)
			getWeapon().setDurability(0);
		else
			getWeapon().setDurability(getWeapon().getDurability() - 1);	
		setActionPoint(getActionPoint() - 1);
		getWeapon().setHit(true);
	}


}
