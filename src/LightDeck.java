
public class LightDeck extends Deck {
	

	public LightDeck(Player player,Player enemy) {
		super(player, enemy);
		generateLightsCure();
		generateAxesHealingSalve();
		generateStonesFaith();
		generateBloodsPact();
		generateAxesAnvil();
		generateStonesAnvil();
		generateLightsAnvil();
		generateBloodsAnvil();
		generateBloodsShield();
		generateLightsShield();
		generateStonesShield();
		generateAxesShield();
		generateBloodsSpell();
		generateAxesSpell();
		generateLightsSpell();
		generateStonesSpell();
		generateDarkPact();
		generateAwakenDead();
		generateDevilsFortune();
		generateVoidPact();
		generateColdAura();
		generateEnlightenment();
		generateFirebolt();
		generateMagesWill();
		generateGemstuddedStaff();
		generateArchmagesFavor();
		generateCryonicState();
		generateShiningOfSkies();
		generateRapidMagic();
		generateTwistingDarkness();
	}

	public void effect(int index) {
		switch (index) {
		case 1:
			lightCure(index);
			break;
		case 2:
			axesHealingSalve(index);
			break;
		case 3:
			stonesFaith(index);
			break;
		case 4:
			bloodsPact(index);
			break;
		case 5:
			axesAnvil(index);
			break;
		case 6:
			stonesAnvil(index);
			break;
		case 7:
			lightsAnvil(index);
			break;
		case 8:
			bloodAnvil(index);
			break;
		case 9:
			bloodsShield(index);
			break;
		case 10:
			lightsShield(index);
			break;
		case 11:
			stonesShield(index);
			break;
		case 12:
			axesShield(index);
			break;
		case 13:
			bloodsSpell(index);
			break;
		case 14:
			axesSpell(index);
			break;
		case 15:
			lightsSpell(index);
			break;
		case 16:
			stonesSpell(index);
			break;
		case 17:
			darkPact(index);
			break;
		case 18:
			awakenDead(index);
			break;
		case 19:
			devilsFortune(index);
			break;
		case 20:
			voidPact(index);
			break;
		case 21:
			coldAura(index);
			break;
		case 22:
			enlightenment(index);
			break;
		case 23:
			firebolt(index);
			break;
		case 24:
			magesWill(index);
			break;
		case 25:
			gemstuddedStaff(index);
			break;
		case 26:
			archmagesFavor(index);
			break;
		case 27:
			cryonicState(index);
			break;
		case 28:
			shiningOfSkies(index);
			break;
		case 29:
			rapidMagic(index);
			break;
		case 30:
			twistingDarkness(index);
			break;
		}
	}

	@Override
	public void lightCure(int index) {
		if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+cardList.get(index).getValue1());
		player.setArmor(player.getArmor()+cardList.get(index).getValue2());
	}

	@Override
	public void lightsAnvil(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue2());
	}

	@Override
	public void lightsShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue2());
	}

	@Override
	public void lightsSpell(int index) {
		enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue2()));
	}

	public void generateColdAura() {
		cardList.add(new Card(21, "Cold Aura", 20, 3, "Gain 20 armor until next turn"));
	}

	public void coldAura(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateEnlightenment() {
		cardList.add(new Card(22, "Englightenment", 15, 25, 2, "Restore: 15 Health  Master: 25 Health"));
	}

	public void enlightenment(int index) {
		if (BattleGround.turn >= 12) {
			if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
				player.setHealth(player.getMAXHEALTH());
			else
				player.setHealth(player.getHealth()+cardList.get(index).getValue1());
		}
		else
			if (player.getHealth()+cardList.get(index).getValue2() > player.getMAXHEALTH())		
				player.setHealth(player.getMAXHEALTH());
			else
				player.setHealth(player.getHealth()+cardList.get(index).getValue2());		
	}

	public void generateFirebolt() {
		cardList.add(new Card(23, "Firebolt", 8, 12, 4, "Deal 8 damage to your opponent  Stable: 12 instead"));
	}

	public void firebolt(int index) {
		if (BattleGround.turn >= 12)
			enemy.setHealth(enemy.getHealth()-cardList.get(index).getValue2());
		else
			enemy.setHealth(enemy.getHealth()-cardList.get(index).getValue1());
	}

	public void generateMagesWill() {
		cardList.add(new Card(24, "Mage's Will", 10, 3, "Gain 10 armor Focus: deal damage instead"));

	}

	public void magesWill(int index) {
		if (player.getHand().getHand().size() <= 5 )
			enemy.setHealth(enemy.getHealth()-cardList.get(index).getValue1());
		else
			player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateGemstuddedStaff() {
		cardList.add(new Card(25, "Gemstudded Staff", 2, 1, "Add 2 durability to your staff"));
	}

	public void gemstuddedStaff(int index) {
		player.getWeapon().setDurability(player.getWeapon().getDurability() + cardList.get(index).getValue1());
	}

	public void generateArchmagesFavor() {
		cardList.add(new Card(26, "Archmage's Favor", 3, 1, 9,"Add 3 Attack to your staff."));
	}

	public void archmagesFavor(int index) { 
		player.getWeapon().setDamage(player.getWeapon().getDamage()+cardList.get(index).getValue1());
	}

	public void generateCryonicState() {
		cardList.add(new Card(27, "Cyronic State", 2, 8, "Fully restore your health. Discard two cards from your hand"));
	}

	public void cryonicState(int index) {
		player.getHand().discard(cardList.get(index).getValue1());
		player.setHealth(player.getMAXHEALTH());
	}

	public void generateShiningOfSkies() {
		cardList.add(new Card(28, "Shining Of Skies", 3, 7, "Gain 3 armor for each card in your hand"));

	}

	public void shiningOfSkies(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1() * (player.getHand().getHand().size()));
	}

	public void generateRapidMagic() {
		cardList.add(new Card(29, "Rapid Magic", 3, 6, "Deal 3 damage for each card in your opponent's hand"));
	}

	public void rapidMagic(int index) {
		enemy.setHealth(enemy.getHealth() - cardList.get(index).getValue1() * (enemy.getHand().getHand().size()));
	}

	public void generateTwistingDarkness() {
		cardList.add(new Card(30, "Twisting Darkness", 10, "Deal damage equal to your lost health"));
	}

	public void twistingDarkness(int index) {
		enemy.setHealth(enemy.getHealth()-(player.getMAXHEALTH()-player.getHealth()));
	}

}
