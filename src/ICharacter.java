import java.util.Stack;

public interface ICharacter {
	int getMAXHEALTH();
	int getHealth();
	void setHealth(int health);
	
	int getArmor();
	void setArmor(int armor);
	
	int getActionPoint();
	void setActionPoint(int actionPoint);

	Weapon getWeapon();
	void setWeapon(Weapon weapon);
	
	Hand getHand();
	void setHand(Hand hand);
	
	Stack<Card> getDeck();
	void setDeck(Stack<Card> deck);

	void hit(Player enamy);
}
