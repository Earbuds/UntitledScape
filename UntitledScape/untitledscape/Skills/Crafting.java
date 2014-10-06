package untitledscape.Skills;

import java.util.Random;

import untitledscape.players.Player;
import untitledscape.players.items.PlayerItems;

public class Crafting {

	static Random rand = new Random();

	static boolean wontBeGemDust;
	static boolean willCraftItem;

	public static void craftGem(int xp, int req, int gemid, int cutgemid, String gemname, int animid, Player p, PlayerItems pi) {
		if (req > p.skillLvl[12]) {
			p.frames.sendMessage(p, "You need level " + req + " crafting to cut this gem.");
			return;
		} else {
			p.requestAnim(animid, 0);

			pi.deleteItem(p, gemid, pi.getItemSlot(p, gemid), 1);
			pi.addItem(p, cutgemid, 1);

			p.addSkillXP(xp * p.skillLvl[12], 12);

			p.frames.sendMessage(p, "You cut the " + gemname + ".");
		}
	}

	public static void craftSemipreciousGem(int xp, int req, int gemid, int cutgemid, String gemname, int animid, Player p, PlayerItems pi) {
		if (req > p.skillLvl[12]) {
			p.frames.sendMessage(p, "You need level " + req + " crafting to cut this gem.");
			return;
		} else {
			p.requestAnim(animid, 0);

			wontBeGemDust = calculateChanceOnLevel(p, pi);

			pi.deleteItem(p, gemid, pi.getItemSlot(p, gemid), 1);

			if (!wontBeGemDust) {
				pi.addItem(p, 1633, 1);

				p.addSkillXP(5 * p.skillLvl[12], 12);

				p.frames.sendMessage(p, "You accidentally crush the " + gemname + ".");
				return;
			} else {
				pi.addItem(p, cutgemid, 1);

				p.addSkillXP(xp * p.skillLvl[12], 12);

				p.frames.sendMessage(p, "You cut the " + gemname + ".");
			}
		}
	}

	public static void genericCrafting(int xp, int req, int itemid, int processeditemid, int brokenitemid, String itemname, int animid, Player p, PlayerItems pi) {
		if (req > p.skillLvl[12]) {
			p.frames.sendMessage(p, "You need level " + req + " crafting to work this " + itemname + ".");
			return;
		} else {
			p.requestAnim(animid, 0);

			willCraftItem = calculateChanceOnLevel(p, pi);

			pi.deleteItem(p, itemid, pi.getItemSlot(p, itemid), 1);

			if (!willCraftItem) {
				pi.addItem(p, brokenitemid, 1);

				p.addSkillXP(5 * p.skillLvl[12], 12);

				p.frames.sendMessage(p, "You accidentally break the " + itemname + ".");
				return;
			} else {
				pi.addItem(p, processeditemid, 1);

				p.addSkillXP(xp * p.skillLvl[12], 12);

				p.frames.sendMessage(p, "You successfully worked the " + itemname + ".");
			}
		}
	}

	public static boolean calculateChanceOnLevel(Player p, PlayerItems pi) {
		int chance = (1 - (p.skillLvl[12] / 100)) * 100;

		if (chance < 0) chance = 5;
		if (chance > 80) chance = 80;

		if (rand.nextInt((100 - 0 + 1) + 0) > chance) return true;

		return false;
	}
	
	public static void craft(int itemUsed, int usedWith, Player p, PlayerItems pi) {
		if (usedWith == 1755) {
			switch (itemUsed) {

			case 1625:
				craftSemipreciousGem(15, 0, itemUsed, 1609, "opal", 886, p, pi);
				break;

			case 1627:
				craftSemipreciousGem(45, 13, itemUsed, 1611, "jade", 886, p, pi);
				break;

			case 1629:
				craftSemipreciousGem(90, 16, itemUsed, 1613, "red topaz", 887, p, pi);
				break;

			case 1623:
				Crafting.craftGem(125, 20, itemUsed, 1607, "sapphire", 888, p, pi);
				break;

			case 1621:
				Crafting.craftGem(172, 27, itemUsed, 1605, "emerald", 889, p, pi);
				break;

			case 1619:
				Crafting.craftGem(250, 34, itemUsed, 1603, "ruby", 887, p, pi);
				break;

			case 1617:
				Crafting.craftGem(350, 43, itemUsed, 1601, "diamond", 886, p, pi);
				break;

			case 1631:
				Crafting.craftGem(450, 55, itemUsed, 1615, "dragonstone", 885, p, pi);
				break;

			case 6571:
				Crafting.craftGem(550, 67, itemUsed, 6573, "onyx", 892, p, pi);
				break;

			case 7536:
				Crafting.genericCrafting(75, 15, itemUsed, 7537, 7540, "fresh crab claw", 887, p, pi);
				break;

			case 7538:
				Crafting.genericCrafting(75, 15, itemUsed, 7539, 7541, "fresh crab shell", 887, p, pi);
				break;

			}
		}

		if (itemUsed == 1755) {
			switch (usedWith) {
			case 1625:
				craftSemipreciousGem(15, 0, usedWith, 1609, "opal", 886, p, pi);
				break;

			case 1627:
				craftSemipreciousGem(45, 13, usedWith, 1611, "jade", 886, p, pi);
				break;

			case 1629:
				craftSemipreciousGem(90, 16, usedWith, 1613, "red topaz", 887, p, pi);
				break;

			case 1623:
				Crafting.craftGem(125, 20, usedWith, 1607, "sapphire", 888, p, pi);
				break;

			case 1621:
				Crafting.craftGem(172, 27, usedWith, 1605, "emerald", 889, p, pi);
				break;

			case 1619:
				Crafting.craftGem(250, 34, usedWith, 1603, "ruby", 887, p, pi);
				break;

			case 1617:
				Crafting.craftGem(350, 43, usedWith, 1601, "diamond", 886, p, pi);
				break;

			case 1631:
				Crafting.craftGem(450, 55, usedWith, 1615, "dragonstone", 885, p, pi);
				break;

			case 6571:
				Crafting.craftGem(550, 67, usedWith, 6573, "onyx", 892, p, pi);
				break;
				
			case 7536:
				Crafting.genericCrafting(75, 15, usedWith, 7537, 7540, "fresh crab claw", 887, p, pi);
				break;

			case 7538:
				Crafting.genericCrafting(75, 15, usedWith, 7539, 7541, "fresh crab shell", 887, p, pi);
				break;
			}
		}
	}
}