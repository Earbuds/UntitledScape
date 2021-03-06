package untitledscape.Skills.hunter;

import untitledscape.Engine;
import untitledscape.players.Player;

public class Implings {

	public static String[] implingTypes = { "baby", "young", "magpie", "ninja", "dragon" };

	public static int impType;

	// Used in NPCOption1 as a template
	public static void catchImpling(Player p, int hunterlvl, int xp, int jarid, String implingname) {
		if (p.skillLvl[21] >= hunterlvl) {
			if (p.equipment[3] != 11259) {
				p.frames.sendMessage(p, "You need to be wielding a net to catch this impling.");
			} else {
				Engine.npcs[p.clickId].isDead = true;
				Engine.npcs[p.clickId].absX = 1;
				Engine.npcs[p.clickId].absY = 1;

				p.frames.sendMessage(p, "You catch the " + implingname + " impling!");

				p.addSkillXP(xp * p.skillLvl[21], 21);
				Engine.playerItems.addItem(p, jarid, 1);
				p.requestAnim(5209, 0);

			}
		} else {
			p.frames.sendMessage(p, "You need level " + hunterlvl + " Hunting to catch this.");
		}
	}

	public static int getImpTypeByNPCID(int npcID) {
		switch(npcID) {
		
		case 6055: // Baby
			return 0;
			
		case 6056: // Young
			return 1;
			
		case 6062: // Magpie
			return 2;
			
		case 6063: // Ninja
			return 3;
			
		case 6064: // Dragon
			return 4;
		
		default:
			return 0;
		}
	}

	public static int getImpTypeByJarID() {

		return 0;
	}
}
