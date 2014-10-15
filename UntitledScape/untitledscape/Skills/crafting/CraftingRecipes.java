package untitledscape.Skills.crafting;

import untitledscape.players.Player;
import untitledscape.players.items.PlayerItems;

public class CraftingRecipes {
	
	public static void recipes(int itemUsed, int usedWith, Player p, PlayerItems pi) {
		if (usedWith == 1755) {
			switch (itemUsed) {

			case 1625:
				Crafting.craftSemipreciousGem(15, 0, itemUsed, 1609, "opal", 886, p, pi);
				break;

			case 1627:
				Crafting.craftSemipreciousGem(45, 13, itemUsed, 1611, "jade", 886, p, pi);
				break;

			case 1629:
				Crafting.craftSemipreciousGem(90, 16, itemUsed, 1613, "red topaz", 887, p, pi);
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
				Crafting.craftSemipreciousGem(15, 0, usedWith, 1609, "opal", 886, p, pi);
				break;

			case 1627:
				Crafting.craftSemipreciousGem(45, 13, usedWith, 1611, "jade", 886, p, pi);
				break;

			case 1629:
				Crafting.craftSemipreciousGem(90, 16, usedWith, 1613, "red topaz", 887, p, pi);
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
		
		if (usedWith == 11690) {
			switch (itemUsed) {
			case 11702:
				Crafting.craftGodsword(100, usedWith, itemUsed, 11694, "Armadyl", p, pi);
				
			case 11704:
				Crafting.craftGodsword(100, usedWith, itemUsed, 11696, "Bandos", p, pi);
				
			case 11706:
				Crafting.craftGodsword(100, usedWith, itemUsed, 11696, "Saradomin", p, pi);
				
			case 11708:
				Crafting.craftGodsword(100, usedWith, itemUsed, 11696, "Zamorak", p, pi);
			}
		}
		
		if (itemUsed == 11690) {
			switch (usedWith) {
			case 11702:
				Crafting.craftGodsword(100, itemUsed, usedWith, 11694, "Armadyl", p, pi);
				
			case 11704:
				Crafting.craftGodsword(100, itemUsed, usedWith, 11696, "Bandos", p, pi);
				
			case 11706:
				Crafting.craftGodsword(100, itemUsed, usedWith, 11696, "Saradomin", p, pi);
				
			case 11708:
				Crafting.craftGodsword(100, itemUsed, usedWith, 11696, "Zamorak", p, pi);
			}
		}
	}

}
