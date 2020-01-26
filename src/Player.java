import java.util.Stack;

public abstract class Player implements ICharacter {
	private String name;
	private String nick;
	private int health;
	private int armor;
	private int actionPoint;
	private Weapon weapon;
	private Hand hand;
	protected Stack<Card> deck;
	private final int MAXHEALTH;
	
	private Player enemy;
	private Player thisplayer;

	public Player(String name, String nick, int health, int armor, int actionPoint, Weapon weapon) {
		this.name = name;
		this.nick = nick;
		this.health = health;
		this.armor = armor;
		this.actionPoint = actionPoint;
		this.weapon = weapon;
		this.hand = new Hand();
		this.deck = new Stack<Card>();
		this.MAXHEALTH = health;
		this.enemy = null;
		this.thisplayer = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getActionPoint() {
		return actionPoint;
	}

	public void setActionPoint(int actionPoint) {
		this.actionPoint = actionPoint;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	public void setDeck(Stack<Card> deck) {
		this.deck = deck;
	}

	public int getMAXHEALTH() {
		return MAXHEALTH;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Player getEnemy() {
		return enemy;
	}

	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}

	public Player getThisplayer() {
		return thisplayer;
	}

	public void setThisplayer(Player thisplayer) {
		this.thisplayer = thisplayer;
	}

	@Override
	public void hit(Player enemy) {
		enemy.setHealth(enemy.getHealth() - (getWeapon().getDamage() - enemy.getArmor()*getWeapon().getDamage() / 100));
		if (enemy.getArmor() - getWeapon().getDamage() < 0)
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
