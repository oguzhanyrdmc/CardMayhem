
public class StoneDeck extends Deck {

	public StoneDeck(Player player,Player enemy) {
		super(player, enemy);
		generateLightsCure();
		generateAxesHealingSalve();
		generateStonesFaith();
		generateBloodsPact();
		generateAxesAnvil();
		generateStonesAnvil();
		generateBloodsAnvil();
		generateLightsAnvil();
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
		generateTankUp();
		generateKnightsRelic();
		generateBlessing();
		generateCover();
		generateAntiMagicAmulet();
		generateSpikedShield();
		generatePurification();
		generateKingSlayer();
		generateHolyWater();
		generateShieldBash();
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
		case 31:
			tankUp(index);
			break;
		case 32:
			knightsRelic(index);
			break;
		case 33:
			blessing(index);
			break;
		case 34:
			cover(index);
			break;
		case 35:
			antiMagicAmulet(index);
			break;
		case 36:
			spikedShield(index);
			break;
		case 37:
			purification(index);
			break;
		case 38:
			kingSlayer(index);
			break;
		case 39:
			holyWater(index);
			break;
		case 40:
			shieldBash(index);
			break;

		}
	}

	@Override
	public void stonesFaith(int index) {
		if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+cardList.get(index).getValue1());
		player.getWeapon().setDurability(player.getWeapon().getDurability() + cardList.get(index).getValue2());
	}

	@Override
	public void stonesAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue1());
		player.getWeapon().setDurability(player.getWeapon().getDurability() + cardList.get(index).getValue2());

	}

	@Override
	public void stonesShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue2());
	}

	@Override
	public void stonesSpell(int index) {
		enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue1() - enemy.getArmor()*cardList.get(index).getValue1()/100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
		player.setArmor(player.getArmor() + player.getWeapon().getDamage());
	}

	public void generateTankUp() {
		cardList.add(new Card(31, "Tank Up", 15, 30, 2, "Gain 15 Armor. Master: 30 instead."));
	}

	public void tankUp(int index) {
		if (BattleGround.turn >= 6)
			player.setArmor(player.getArmor() + cardList.get(index).getValue2());
		else
			player.setArmor(player.getArmor() + cardList.get(index).getValue1());
	}

	public void generateKnightsRelic() {
		cardList.add(new Card(32, "Knight's Relic",3, 2, 4, "Add 3/2 to your weapon."));
	}

	public void knightsRelic(int index) {
		//Þart koþulan tur kontrol edilecek.
		//Fonksiyon sonunda kart elden çýkarýlacak.
		player.getWeapon().setDamage(player.getWeapon().getDamage()+cardList.get(index).getValue1());
		player.getWeapon().setDurability(player.getWeapon().getDurability()+cardList.get(index).getValue2());
	}

	public void generateBlessing() {
		cardList.add(new Card(33, "Blessing", 10, 20, 3, "Restore 10 health. Focus: 20 instead."));
	}

	public void blessing(int index) {
		//Þart koþulan tur kontrol edilecek.
		//Fonksiyon sonunda kart elden çýkarýlacak.
		if (player.getHand().getHand().size() <= 5) {
			if (player.getHealth()+cardList.get(index).getValue2() > player.getMAXHEALTH())		
				player.setHealth(player.getMAXHEALTH());
			else
				player.setHealth(player.getHealth()+cardList.get(index).getValue2());
		}
		else {
			if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
				player.setHealth(player.getMAXHEALTH());
			else
				player.setHealth(player.getHealth()+cardList.get(index).getValue1());
		}
	}

	public void generateCover() {
		cardList.add(new Card(34, "Cover", 1, "Gain armor equal to your opponent's weapon attack twice."));
	}

	public void cover(int index) {
		//Þart koþulan tur kontrol edilecek.
		//Fonksiyon sonunda kart elden çýkarýlacak.
		player.setArmor(player.getArmor()+(enemy.getWeapon().getDamage()*2));
	}

	public void generateAntiMagicAmulet() {
		cardList.add(new Card(35, "Anti-magic Amulet", 25, 6,"Increase armor by %25."));
	}

	public void antiMagicAmulet(int index) {
		//Þart koþulan tur kontrol edilecek.
		//Fonksiyon sonunda kart elden çýkarýlacak.
		player.setArmor(player.getArmor()+(player.getArmor()*cardList.get(index).getValue1()/100));
	}

	public void generateSpikedShield() {
		cardList.add(new Card(36, "Spiked Sield", 25, 40, 5, "Deal %25 of your armor as damage. Stable: %40."));
	}

	public void spikedShield(int index) {
		if (BattleGround.turn >= 12) {
			enemy.setHealth(enemy.getHealth() - (player.getArmor()*cardList.get(index).getValue1()/100 - enemy.getArmor()*cardList.get(index).getValue1()/100));
			enemy.setArmor(enemy.getArmor() - player.getArmor()*cardList.get(index).getValue1()/100);
		}
		else {
			enemy.setHealth(enemy.getHealth() - (player.getArmor()*cardList.get(index).getValue2()/100 - enemy.getArmor()*cardList.get(index).getValue2()/100));
			enemy.setHealth(enemy.getHealth()-player.getArmor()*cardList.get(index).getValue2()/100);
		}
	}

	public void generatePurification() {
		cardList.add(new Card(37, "Purification", 8, "Lose your armor to restore that much health"));
	}

	public void purification(int index) {
		if (player.getHealth()+player.getArmor() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+player.getArmor());
		player.setArmor(0);
	}

	public void generateKingSlayer() {
		cardList.add(new Card(38, "Kingslayer", 2, 6, "If your opponent has more health, double your weapon's attack."));
	}

	public void kingSlayer(int index) {
		if(player.getHealth() > enemy.getHealth())
			player.getWeapon().setDamage(player.getWeapon().getDamage()*cardList.get(index).getValue1());
	}

	public void generateHolyWater() {
		cardList.add(new Card(39, "Holy Water", 10, 30, 9, "If your health is below 10, restore 30 health."));
	}

	public void holyWater(int index) {
		if (player.getHealth() < 10) {
			if (player.getHealth()+cardList.get(index).getValue2() > player.getMAXHEALTH())		
				player.setHealth(player.getMAXHEALTH());
			else
				player.setHealth(player.getHealth()+cardList.get(index).getValue2());
		}
	}

	public void generateShieldBash() {
		cardList.add(new Card(40, "Shield Bash", 10, "Destroy your armor to deal that much damage."));
	}

	public void shieldBash(int index) {
		enemy.setHealth(enemy.getHealth() - (player.getArmor() - enemy.getArmor()*player.getArmor()/100));
		enemy.setArmor(enemy.getArmor()-player.getArmor());
		player.setArmor(0);
	}

}
