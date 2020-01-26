import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class Deck {
	protected List<Card> cardList;
	protected Player player;
	protected Player enemy;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getEnemy() {
		return enemy;
	}

	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}

	public Deck(Player player, Player enemy) {

		this.cardList = new ArrayList<Card>();
		this.player = player;
		this.enemy = enemy;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public void generateLightsCure() {
		cardList.add(new Card(1, "Light's Cure", 5, 5, 1, "Restore 5 Health. Light: Gain 5 armor,too"));
	}

	public void lightCure(int index) {
		if (player.getHealth() + cardList.get(index).getValue1() > player.getMAXHEALTH())
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth() + cardList.get(index).getValue1());
	}

	public void generateAxesHealingSalve() {
		cardList.add(new Card(2, "Axes Healing Salve", 5, 3, 1, "Restore 5 health. Axe: Gain 3 attack,too"));
	}

	public void axesHealingSalve(int index) {
		if (player.getHealth() + cardList.get(index).getValue1() > player.getMAXHEALTH())
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth() + cardList.get(index).getValue1());
	}

	public void generateStonesFaith() {
		cardList.add(new Card(3, "Stones Faith", 5, 1, 1, "Restore 5 health. Stone: Add 1 Durability"));
	}

	public void stonesFaith(int index) {
		if (player.getHealth() + cardList.get(index).getValue1() > player.getMAXHEALTH())
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth() + cardList.get(index).getValue1());
	}

	public void generateBloodsPact() {
		cardList.add(new Card(4, "Bloods Pact", 5, 5, 1, "Restore 5 health. Blood: Deal 5 damege"));
	}

	public void bloodsPact(int index) {
		if (player.getHealth() + cardList.get(index).getValue1() > player.getMAXHEALTH())
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth() + cardList.get(index).getValue1());
	}

	public void generateAxesAnvil() {
		cardList.add(new Card(5, "Axes Anvil", 2, 3, 2, "Add 2 attack to your weapon. Axe: 3 instead"));
	}

	public void axesAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue1());
	}

	public void generateStonesAnvil() {
		cardList.add(new Card(6, "Stones Anvil", 2, 1, 2, "Add 2 attack to your weapon. Stone: 1 durability too."));
	}

	public void stonesAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue1());
	}

	public void generateLightsAnvil() {
		cardList.add(new Card(7, "Light's Anvil", 2, 5, 2, "Add 2 Attack to your weapon. Light:Gain 5 Armor, too"));
	}

	public void lightsAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue1());
	}

	public void generateBloodsAnvil() {
		cardList.add(new Card(8, "Bloods Anvil", 2, 2, 2, "Add 2 Attack to your weapon. Blood: 2 durability, too"));
	}

	public void bloodAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue1());
	}

	public void generateBloodsShield() {
		cardList.add(new Card(9, "Bloods Shield", 10, 15, 3, "Gain 10 Armor. Blood: 15 instead"));
	}

	public void bloodsShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateLightsShield() {
		cardList.add(new Card(10, "Light's Shield", 10, 3, "Gain 10 Armor. Light: Draw a card"));
	}

	public void lightsShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateStonesShield() {
		cardList.add(new Card(11, "Stones Shield", 10, 30, 3, "Gain 10 Armor. Stone: 30 instead"));
	}

	public void stonesShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateAxesShield() {
		cardList.add(new Card(12, "Axes Shiled", 10, 2, 3, "Gain 10 Armor. Axe: 2 Attack,too"));
	}

	public void axesShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateBloodsSpell() {
		cardList.add(new Card(13, "Blood's Shield", 5, 8, 4, "Deal 5 damage. Blood: Deal 8 instead"));
	}

	public void bloodsSpell(int index) {
		enemy.setHealth(enemy.getHealth()
				- (cardList.get(index).getValue1() - enemy.getArmor() * cardList.get(index).getValue1() / 100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
	}

	public void generateAxesSpell() {
		cardList.add(new Card(14, "Axes Spell", 5, 4, "Deal 5 damege, Axe: Deal your weapons halved damage instead"));
	}

	public void axesSpell(int index) {
		enemy.setHealth(enemy.getHealth()
				- (cardList.get(index).getValue1() - enemy.getArmor() * cardList.get(index).getValue1() / 100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
	}

	public void generateLightsSpell() {
		cardList.add(new Card(15, "Light's Spell", 5, 10, 4, "Deal 5 damage Light: 10 instead"));
	}

	public void lightsSpell(int index) {
		enemy.setHealth(enemy.getHealth()
				- (cardList.get(index).getValue1() - enemy.getArmor() * cardList.get(index).getValue1() / 100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
	}

	public void generateStonesSpell() {
		cardList.add(new Card(16, "Stone's Spell", 5, 4,
				"Deal 5 damege, Stone: Gain armor equal to your weapons attack, too"));
	}

	public void stonesSpell(int index) {
		enemy.setHealth(enemy.getHealth()
				- (cardList.get(index).getValue1() - enemy.getArmor() * cardList.get(index).getValue1() / 100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
	}

	public void generateDarkPact() {
		cardList.add(new Card(17, "Dark Pact", 1, "Shuffle your hand to your deck, Draw that many."));
	}

	public void darkPact(int index) {
		List<Card> list = new ArrayList<Card>();

		if (player.deck.size() != 0) {
			while (!player.deck.isEmpty()) {
				list.add(player.deck.pop());
			}

			while (!list.isEmpty()) {
				player.deck.push(list.get((int) (Math.random() * list.size())));
			}
		}
	}

	public void generateAwakenDead() {
		cardList.add(new Card(18, "Awaken the Dead", 2, 2, "Add random 2 cards to your hand from graveyard"));
	}

	public void awakenDead(int index) {
		for (int i = 0; i < cardList.get(index).getValue1(); i++) {
			BattleGround.graveyard
					.add(player.getHand().getHand().remove((int) Math.random() * player.getHand().getHand().size()));
		}
	}

	public void generateDevilsFortune() {
		cardList.add(new Card(19, "Devil Fortune", 1, 3, "Add 1 action point to your hand"));
	}

	public void devilsFortune(int index) {
		player.setActionPoint(player.getActionPoint() + cardList.get(index).getValue1());
	}

	public void generateVoidPact() {
		cardList.add(new Card(20, "Void Pact", 4, "Discard your hand fully heal your have"));
	}

	public void voidPact(int index) {
		while (!player.getHand().getHand().isEmpty()) {
			BattleGround.graveyard.add(player.getHand().getHand().remove(0));
		}
		player.setHealth(player.getMAXHEALTH());
	}
}
