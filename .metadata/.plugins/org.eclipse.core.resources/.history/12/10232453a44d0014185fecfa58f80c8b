

package untitledscape.io.packets;


import untitledscape.Engine;
import untitledscape.npcs.*;
import untitledscape.npcs.update.NPCUpdateMasks;
import untitledscape.players.Player;
import untitledscape.util.Misc;


public class NPCAttack implements Packet {

    /**
     * Handles selecting the attack option on NPCs.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int npcId = p.stream.readUnsignedWord();
        NPC n = Engine.npcs[npcId];

        p.attackNPC = npcId;
        p.attackingNPC = true;
        p.requestFaceTo(npcId);
    }
}
