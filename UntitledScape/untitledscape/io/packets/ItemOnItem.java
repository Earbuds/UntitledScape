package untitledscape.io.packets;

import untitledscape.Engine;
import untitledscape.Skills.Firemaking;
import untitledscape.Skills.crafting.Crafting;
import untitledscape.players.Player;
import untitledscape.players.items.PlayerItems;
import untitledscape.util.Misc;

/**
 * 
 * @author Encouragin <ZLyricale@live.nl>
 */

public class ItemOnItem implements Packet {

	/**
	 * Handles item on item packet.
	 * 
	 * @param Player
	 *            p The player which the packet will be created for.
	 * @param packetId
	 *            the packet id which is activated (Which handles this class)
	 * @param packetSize
	 *            the amount of bytes being received for the packet.
	 */
	public void handlePacket(Player p, int packetId, int packetSize) {
		if (p == null) return;
		/**
		 * These are the correct stream methods for item on item packet.
		 */
		int usedWith = p.stream.readSignedWordBigEndian();
		int itemUsed = p.stream.readSignedWordA();
		PlayerItems pi = new PlayerItems();
		p.wc.resetWoodcutting();
		p.mi.resetMining();
		
		Crafting.craft(itemUsed, usedWith, p, pi);

		// ====================================== FLETCHING
		// ==================================

		if (itemUsed == 946 && usedWith == 1511 || itemUsed == 1511 && usedWith == 946) {
			p.FletchID = 1511;
			p.FletchGet = 882;
			p.FletchXP = 50;
			p.FletchAmount = 28;
			p.FletchThat(p, p.FletchXP, p.FletchID, p.FletchGet);

		}

		if (itemUsed == 946 && usedWith == 1521 || itemUsed == 1521 && usedWith == 946) {
			if (p.skillLvl[9] >= 15) {
				p.FletchID = 1521;
				p.FletchGet = 884;
				p.FletchXP = 75;
				p.FletchAmount = 28;
				p.FletchThat(p, p.FletchXP, p.FletchID, p.FletchGet);
			} else {
				p.frames.sendMessage(p, "You need level 15 fletching to cut this log.");
			}
		}
		if (itemUsed == 946 && usedWith == 1519 || itemUsed == 1519 && usedWith == 946) {
			if (p.skillLvl[9] >= 30) {
				p.FletchID = 1519;
				p.FletchGet = 886;
				p.FletchXP = 100;
				p.FletchAmount = 28;
				p.FletchThat(p, p.FletchXP, p.FletchID, p.FletchGet);
			} else {
				p.frames.sendMessage(p, "You need level 30 fletching to cut this log.");
			}
		}

		if (itemUsed == 946 && usedWith == 1517 || itemUsed == 1517 && usedWith == 946) {
			if (p.skillLvl[9] >= 45) {
				p.FletchID = 1517;
				p.FletchGet = 888;
				p.FletchXP = 150;
				p.FletchAmount = 28;
				p.FletchThat(p, p.FletchXP, p.FletchID, p.FletchGet);
			} else {
				p.frames.sendMessage(p, "You need level 45 fletching to cut this log.");
			}
		}

		if (itemUsed == 946 && usedWith == 1515 || itemUsed == 1515 && usedWith == 946) {
			if (p.skillLvl[9] >= 65) {
				p.FletchID = 1515;
				p.FletchGet = 890;
				p.FletchXP = 200;
				p.FletchAmount = 28;
				p.FletchThat(p, p.FletchXP, p.FletchID, p.FletchGet);
			} else {
				p.frames.sendMessage(p, "You need level 65 fletching to cut this log.");
			}
		}
		if (itemUsed == 946 && usedWith == 1513 || itemUsed == 1513 && usedWith == 946) {
			if (p.skillLvl[9] >= 75) {
				p.FletchID = 1513;
				p.FletchGet = 892;
				p.FletchXP = 250;
				p.FletchAmount = 28;
				p.FletchThat(p, p.FletchXP, p.FletchID, p.FletchGet);
			} else {
				p.frames.sendMessage(p, "You need level 75 fletching to cut this log.");
			}
		}

		// Firemaking

		if ((itemUsed == 590) && (usedWith == 1511) || (itemUsed == 1511) && (usedWith == 590)) { // Normal
																									// Logs
			Firemaking.makeFire(50, 1, 1511, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 1521) || (itemUsed == 1521) && (usedWith == 590)) { // Oak
																									// Logs
			Firemaking.makeFire(75, 15, 1521, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 1519) || (itemUsed == 1519) && (usedWith == 590)) { // Willow
																									// Logs
			Firemaking.makeFire(100, 30, 1519, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 6333) || (itemUsed == 6333) && (usedWith == 590)) { // Teak
																									// Logs
			Firemaking.makeFire(150, 35, 1519, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 1517) || (itemUsed == 1517) && (usedWith == 590)) { // Maple
																									// Logs
			Firemaking.makeFire(175, 45, 1517, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 6332) || (itemUsed == 6332) && (usedWith == 590)) { // Mahogany
																									// Logs
			Firemaking.makeFire(250, 50, 1519, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 1515) || (itemUsed == 1515) && (usedWith == 590)) { // Yew
																									// Logs
			Firemaking.makeFire(300, 60, 1515, p, pi);
		}

		if ((itemUsed == 590) && (usedWith == 1513) || (itemUsed == 1513) && (usedWith == 590)) { // Magic
																									// Logs
			Firemaking.makeFire(500, 75, 1513, p, pi);
		}

	}

}