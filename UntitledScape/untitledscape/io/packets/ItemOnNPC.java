package untitledscape.io.packets;

import untitledscape.Engine;
import untitledscape.npcs.NPC;
import untitledscape.players.Player;

/**
 * @author David 
 */

public class ItemOnNPC {
	
	public void handlePacket(Player p, NPC n, int itemId) {
		switch(itemId) {
			case 995:
				p.frames.sendMessage(p, "If you want to give your money away, throw a drop party!");
			break;
			default:
				p.frames.sendMessage(p, "Nothing interesting happens.");
			break;
		}
	}
}