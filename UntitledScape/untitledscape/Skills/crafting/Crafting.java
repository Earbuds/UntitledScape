package untitledscape.Skills.crafting;

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
		CraftingRecipes.recipes(itemUsed, usedWith, p, pi);
	}
}
