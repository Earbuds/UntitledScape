

package untitledscape.io;


import untitledscape.Engine;
import untitledscape.Server;
import untitledscape.Skills.*;
import untitledscape.clanchat.ClanList;
import untitledscape.clanchat.ClanMain;
import untitledscape.io.packets.*;
import untitledscape.npcs.*;
import untitledscape.players.Magic;
import untitledscape.players.Player;
import untitledscape.players.combat.*;
import untitledscape.players.quests.*;
import untitledscape.util.Misc;
public class PacketManager {
public static void AcceptCape(Player p,int Npc, String Name, int Hood, int Cape)
{
Engine.playerItems.addItem(p, Hood, 1);
if(p.SkillCapes > 2) { Engine.playerItems.addItem(p, Cape+1, 1); } else { Engine.playerItems.addItem(p, Cape, 1); }
p.Dialogue = 0;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, Npc, 241, 2);
p.frames.setString(p, Name, 241, 3);
p.frames.setString(p, "accept this cape as a reward.", 241, 4);
}
public static void YouShould(Player p, int Npc, String Name, String Should)
{
p.Dialogue = 0;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9760, 241, 2);
p.frames.setNPCId(p, Npc, 241, 2);
p.frames.setString(p, Name, 241, 3);
p.frames.setString(p, Should, 241, 4);
}
    /*
     * Create all the packets for use.
     */
    public Walking walk = new Walking();
public MagicOnNPC magicOnNPC = new MagicOnNPC();
    public PublicChat publicChat = new PublicChat();
    public Commands command = new Commands();
    public SwitchItems switchItems = new SwitchItems();
    public ActionButtons actionButtons = new ActionButtons();
    public Equipment equipment = new Equipment();
    public ItemOption1 itemOption1 = new ItemOption1();
    public ItemOperate itemOperate = new ItemOperate();
    public DropItem dropItem = new DropItem();
    public PickupItem pickupItem = new PickupItem();
    public PlayerOption1 playerOption1 = new PlayerOption1();
    public PlayerOption2 playerOption2 = new PlayerOption2();
    public PlayerOption3 playerOption3 = new PlayerOption3();
    public NPCAttack npcAttack = new NPCAttack();
public ItemOnNPC itemOnNPC = new ItemOnNPC();
    public NPCOption1 npcOption1 = new NPCOption1();
    public NPCOption2 npcOption2 = new NPCOption2();
    public Dialogue dialogue = new Dialogue();
  public ItemOnItem itemOnItem = new ItemOnItem();
    public NPCOption3 npcOption3 = new NPCOption3();
    public MagicOnPlayer magicOnPlayer = new MagicOnPlayer();
    public ItemSelect itemSelect = new ItemSelect();
    public ObjectOption1 objectOption1 = new ObjectOption1();
    public ObjectOption2 objectOption2 = new ObjectOption2();
    public SwitchItems2 switchItems2 = new SwitchItems2();

public ItemOnObject ItemOnObject = new ItemOnObject();
public ItemGive ItemGive = new ItemGive();

    /**
     * Handle any packets.
     * <p>Handles all packets within the range of 0 - 255. Not every
     * packet has been setup, you'll have to do some yourself.
     * @param p The Player which the frame should be created for.
     * @param packetId The packet id to handle.
     * @param packetSize The number of bytes the packet contains.
     */
    public void parsePacket(Player p, int packetId, int packetSize) {
        if (p == null) {
            return;
        }
        if (p.clickDelay > 0 && packetId != 222) {

            /*
             * When delayed only allow chatting.
             */
            return;
        }
        switch (packetId) {
case 42:
		    long NAME = p.stream.readQWord();
		    String sss = Misc.longToString(NAME).replaceAll("_", " ");
		    if(sss.equals("invalid name")) {
			Server.ClanMain.leaveChat(p);
			p.frames.resetList(p);
			p.frames.setConfig(p, 1083, 0);
		    } else {
		        Server.ClanMain.joinChat(p, sss);
		    }
		break;
		case 127:
			String string = p.stream.readString();
			switch (p.inputId) {
				case 0: //enter clan name
				    break;
			}
		break;
		case 189:
			long l = p.stream.readQWord();
			switch (p.inputId) {
				case 0: //enter clan name
				String clan = Misc.longToString(l).replaceAll("_", " ");
				Server.ClanMain.clanName3(p, clan);
				p.frames.setString(p, Misc.checkString(clan), 590, 22);
				break;
				case 1:
				    break;
			}
		break;
case 200:
	    long l3 = p.stream.readQWord();
	    String kick = Misc.longToString(l3);
		kick = kick.replaceAll("_", " ");
	    Player p2 = Engine.players[Server.engine.getIdFromName(kick)];
	    Server.ClanMain.leaveChat(p2);
	    p2.frames.sendMessage(p2, "You've been kick from the chat.");
	    p2.frames.resetList(p2);
	    break;
		
/*		case 111:
                int rank = p.stream.readUnsignedByte();
		long junk = p.stream.readBigQWord();
		long l2 = p.stream.readDWordBigEndian();
		String s2 = Misc.longToString(junk).replaceAll("_", " ");
		Server.ClanMain.rankPlayer(p, rank, s2);
		p.frames.sendMessage(p, "Changes to your clan will be saved within 60 seconds.");
		p.frames.sendFriend(p, junk, p.getWorld(junk));
		System.out.println(s2);
	        break;
*/
 case 43:
                p.uinput.setInput(p.stream.readDWord());
                break;
case 30:
	    long name = p.stream.readQWord();
	    if(p.friends.size() >= 200) {
                p.frames.sendMessage(p, "Your friends list is full.");
		break;
	    }
	    if(p.friends.contains((Long) name)) {
                p.frames.sendMessage(p, "Already on your friends list.");
		break;
	    }
	    p.friends.add((Long) name);
	    p.frames.sendFriend(p, name, p.getWorld(name));
	    break;
	case 61:
	    name = p.stream.readQWord();
	    if(p.ignores.size() >= 100) {
                p.frames.sendMessage(p, "Your ignore list is full.");
		break;
	    }
	    if(p.ignores.contains((Long) name)) {
                p.frames.sendMessage(p, "Already on your ignore list.");
		break;
	    }
	    p.ignores.add((Long) name);
	    break;
	case 132:
	    name = p.stream.readQWord();
	    p.friends.remove((Long) name);
	    break;
	case 2:
	    name = p.stream.readQWord();
	    p.ignores.remove((Long) name);
	    break;
      case 178:
            name = p.stream.readQWord();
	    int numChars = p.stream.readUnsignedByte();
	    String text = Misc.decryptPlayerChat(p.stream, numChars);
	    for(Player p22 : Engine.players) {
                if(p22 != null && p22.online) {
                    if(Misc.stringToLong(p22.username) == name) {
                        p22.frames.sendReceivedPrivateMessage(p22, Misc.stringToLong(p.username), p.rights, text);
			p.frames.sendSentPrivateMessage(p, name, text);
			return;
		    }
		}
	    }
	    p.frames.sendMessage(p, "Player is currently offline.");
	    break;
        case 115:
            break;
			case 62: //Used to spawn objects.

p.objects();
break;

case 40:
itemOnItem.handlePacket(p, packetId, packetSize);
break;
        case 22:

            /*
             * Recieved every time updateReq is set to true.
             */
            p.stream.readDWord(); // Junk? Same value every time.
            break;

case 60:

p.objects();
break; 

        case 99:

            /*
             * Unknown.
             */
            p.stream.readUnsignedWordBigEndianA();
            p.stream.readUnsignedWordA();
            break;

        case 117:
        case 248:
        case 247: // Possibly a packet sent if the login  is successful.
if(p.SkillCapes > 1) { //  AUTO SKILL CAPE TRIMMING




if(Engine.playerItems.HasItemAmount(p, 9747, 1) == true)
{
Engine.playerItems.deleteItem(p, 9747, Engine.playerItems.getItemSlot(p, 9747), 1);
Engine.playerItems.addItem(p, 9748, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9750, 1) == true)
{
Engine.playerItems.deleteItem(p, 9750, Engine.playerItems.getItemSlot(p, 9750), 1);
Engine.playerItems.addItem(p, 9751, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9753, 1) == true)
{
Engine.playerItems.deleteItem(p, 9753, Engine.playerItems.getItemSlot(p, 9753), 1);
Engine.playerItems.addItem(p, 9754, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9756, 1) == true)
{
Engine.playerItems.deleteItem(p, 9756, Engine.playerItems.getItemSlot(p, 9756), 1);
Engine.playerItems.addItem(p, 9757, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9759, 1) == true)
{
Engine.playerItems.deleteItem(p, 9759, Engine.playerItems.getItemSlot(p, 9759), 1);
Engine.playerItems.addItem(p, 9760, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9762, 1) == true)
{
Engine.playerItems.deleteItem(p, 9762, Engine.playerItems.getItemSlot(p, 9762), 1);
Engine.playerItems.addItem(p, 9763, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9765, 1) == true)
{
Engine.playerItems.deleteItem(p, 9765, Engine.playerItems.getItemSlot(p, 9765), 1);
Engine.playerItems.addItem(p, 9766, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9768, 1) == true)
{
Engine.playerItems.deleteItem(p, 9768, Engine.playerItems.getItemSlot(p, 9768), 1);
Engine.playerItems.addItem(p, 9769, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9771, 1) == true)
{
Engine.playerItems.deleteItem(p, 9771, Engine.playerItems.getItemSlot(p, 9771), 1);
Engine.playerItems.addItem(p, 9772, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9774, 1) == true)
{
Engine.playerItems.deleteItem(p, 9774, Engine.playerItems.getItemSlot(p, 9774), 1);
Engine.playerItems.addItem(p, 9775, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9777, 1) == true)
{
Engine.playerItems.deleteItem(p, 9777, Engine.playerItems.getItemSlot(p, 9777), 1);
Engine.playerItems.addItem(p, 9778, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9780, 1) == true)
{
Engine.playerItems.deleteItem(p, 9780, Engine.playerItems.getItemSlot(p, 9780), 1);
Engine.playerItems.addItem(p, 9781, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9783, 1) == true)
{
Engine.playerItems.deleteItem(p, 9783, Engine.playerItems.getItemSlot(p, 9783), 1);
Engine.playerItems.addItem(p, 9784, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9786, 1) == true)
{
Engine.playerItems.deleteItem(p, 9786, Engine.playerItems.getItemSlot(p, 9786), 1);
Engine.playerItems.addItem(p, 9787, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9789, 1) == true)
{
Engine.playerItems.deleteItem(p, 9789, Engine.playerItems.getItemSlot(p, 9789), 1);
Engine.playerItems.addItem(p, 9790, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9792, 1) == true)
{
Engine.playerItems.deleteItem(p, 9792, Engine.playerItems.getItemSlot(p, 9792), 1);
Engine.playerItems.addItem(p, 9793, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9795, 1) == true)
{
Engine.playerItems.deleteItem(p, 9795, Engine.playerItems.getItemSlot(p, 9795), 1);
Engine.playerItems.addItem(p, 9796, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9798, 1) == true)
{
Engine.playerItems.deleteItem(p, 9798, Engine.playerItems.getItemSlot(p, 9798), 1);
Engine.playerItems.addItem(p, 9799, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9801, 1) == true)
{
Engine.playerItems.deleteItem(p, 9801, Engine.playerItems.getItemSlot(p, 9801), 1);
Engine.playerItems.addItem(p, 9802, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9804, 1) == true)
{
Engine.playerItems.deleteItem(p, 9804, Engine.playerItems.getItemSlot(p, 9804), 1);
Engine.playerItems.addItem(p, 9805, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9807, 1) == true)
{
Engine.playerItems.deleteItem(p, 9807, Engine.playerItems.getItemSlot(p, 9807), 1);
Engine.playerItems.addItem(p, 9808, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9810, 1) == true)
{
Engine.playerItems.deleteItem(p, 9810, Engine.playerItems.getItemSlot(p, 9810), 1);
Engine.playerItems.addItem(p, 9811, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 9948, 1) == true)
{
Engine.playerItems.deleteItem(p, 9948, Engine.playerItems.getItemSlot(p, 9948), 1);
Engine.playerItems.addItem(p, 9949, 1); 
}
if(Engine.playerItems.HasItemAmount(p, 12169, 1) == true)
{
Engine.playerItems.deleteItem(p, 12169, Engine.playerItems.getItemSlot(p, 12169), 1);
Engine.playerItems.addItem(p, 12170, 1); 
}
}
            /*
             * Unknown.
             */
            break;

        case 59: 
//Misc.println("[" + p.username + "] Unhandled packet: " + packetId);
            /*
             * Send every time you click your mouse.
             */
            p.stream.readUnsignedWord();
            p.stream.readDWord_v1();
            break;
case 253:
		int playerId = p.stream.readUnsignedWord();
                playerId -= 33024;
                playerId = playerId / 256;
                playerId++;
                if (playerId < 0 || playerId >= Engine.players.length || Engine.players[playerId] == null) {
                    return;
                }
                if (Engine.players[playerId].pTrade.getPartner() == p) {
                    p.pTrade.tradePlayer(Engine.players[playerId]);
                }

                break;


        case 49:
    if(p.interfaceId == 762) {
p.frames.restoreInventory2(p);
p.frames.sendMessage(p, "Trying to bank glitch? Nice try. Bank for real to fix your inventory.");
}   
p.Dialogue = 0;
	p.wc.resetWoodcutting();
p.mi.resetMining();
p.ResetSkillSuff();
            p.viewings = 0;
            p.frames.removeShownInterface(p);
p.frames.setTab(p, 84, 261); // Setting tab
p.frames.removeChatboxInterface(p);

        /*
         * Main map walking.
         */
        case 119:
if(p.interfaceId == 762) {
p.frames.restoreInventory2(p);
p.frames.sendMessage(p, "Trying to bank glitch? Nice try. Bank for real to fix your inventory.");
}
            p.frames.removeShownInterface(p);
p.frames.setTab(p, 84, 261); // Setting tab
p.frames.removeChatboxInterface(p);

        /*
         * Minimap walking.
         */
        case 138:
if(p.interfaceId == 762) {
p.frames.restoreInventory2(p);
p.frames.sendMessage(p, "Trying to bank glitch? Nice try. Bank for real to fix your inventory.");
}
            p.frames.removeShownInterface(p);
p.frames.setTab(p, 84, 261); // Setting tab
p.frames.removeChatboxInterface(p);

            /*
             * Other walking.
             */
p.Dialogue = 0;
	p.wc.resetWoodcutting();
p.mi.resetMining();
p.ResetSkillSuff();
            p.viewings = 0;
            p.frames.removeShownInterface(p);
p.frames.setTab(p, 84, 261); // Setting tab
p.frames.removeChatboxInterface(p);




			 p.followPlayer = 0; // This Will make the following stop when you walk away
		p.followingPlayer = false;

            walk.handlePacket(p, packetId, packetSize);
            break;
			
        case 222:

            /*
             * Public chatting.
             */
            publicChat.handlePacket(p, packetId, packetSize);
            break;

        case 107:

            /*
             * When you type text starting with ::, its sent with this packet Id rather than as 
             * Normal chat.
             */
            command.handlePacket(p, packetId, packetSize);
            break;

        case 167:

            /*
             * Switching items on interfaces.
             */
            switchItems.handlePacket(p, packetId, packetSize);
            break;

        case 233:
        case 113:
        case 21:
        case 169:
        case 232:

            /*
             * When you click an interface button this packet is sent.
             */
            actionButtons.handlePacket(p, packetId, packetSize);
            break;

	case 12: //ITEM ON NPC
		p.stream.readUnsignedWord(); //JUNK (0)
		p.stream.readUnsignedWord(); //JUNK (0)
		int npcNum = p.stream.readUnsignedWord(); //NPC ID
		NPC n = Engine.npcs[npcNum];
		p.stream.readUnsignedWord(); //Item Slot (entire clientside, useless)
		int itemId = (p.stream.readUnsignedWord()-128);
		if(!Engine.playerItems.HasItemAmount(p, itemId, 1)) {
			itemId += 256;
		}
		itemOnNPC.handlePacket(p, n, itemId);
	break;

        case 3:

            /*
             * Equipping an item.
             */
            equipment.handlePacket(p, packetId, packetSize);
            break;

        case 203:
case 152:

            /*
             * Item options 1.
             */
            itemOption1.handlePacket(p, packetId, packetSize);
            break;

case 131:
            ItemGive.handlePacket(p, packetId, packetSize);
            break;

	case 186:
            /*
             * Item operating.
             */
            
		itemOperate.handlePacket(p, packetId, packetSize);
		break;

        case 211:

            /*
             * Dropping an item.
             */
            dropItem.handlePacket(p, packetId, packetSize);
            break;

        case 201:

            /*
             * Picking an item up.
             */
            pickupItem.handlePacket(p, packetId, packetSize);
            break;

        case 160:

            /*
             * First option on a player.
             */
            playerOption1.handlePacket(p, packetId, packetSize);
            break;
case 173:
            /*
             * When you click an interface button this packet is sent.
             */
            actionButtons.handlePacket(p, packetId, packetSize);
            break;
        case 37:

            /*
             * Second option on a player.
             */
            playerOption2.handlePacket(p, packetId, packetSize);
            break;

        case 227:

            /*
             * Third option on a player.
             */
            playerOption3.handlePacket(p, packetId, packetSize);
            break;

        case 123:

            /*
             * NPC attack option.
             */
            npcAttack.handlePacket(p, packetId, packetSize);
            break;

        case 7:

            /*
             * NPC first option.
             */
            npcOption1.handlePacket(p, packetId, packetSize);
            break;

        
        case 220:
case 134:

            /*
             * Item eating, drinking, etc.
             */
            itemSelect.handlePacket(p, packetId, packetSize);
            break;

        case 158:

            /*
             * Object first option.
             */
            objectOption1.handlePacket(p, packetId, packetSize);
            break;
			case 24://magic on npc by I loot I aka Lootface
	    MagicOnNPC.magicAop(p, packetId, packetSize);
                int npcId = p.stream.readSignedWordA();
                int buttonId = p.stream.readSignedWordA();
                int interfaceId = p.stream.readUnsignedWord();
                if (interfaceId == 192) {
                    p.magicNPC.magicOnNPC(npcId, buttonId);
                }
                break;
			case 154:



            Magic.MagicOnItemHandle(p, packetId, packetSize);

            break;
case 70:

            Magic.magicAop(p, packetId, packetSize);
            break;

        case 165:

            /*
             * Settings buttons, such as music volume.
             */
            p.stream.readDWord_v2();
            break;

    case 108:
            /*
             * Remove open interfaces.
             */
if(p.Update == 0)
{
p.Update = 1;
p.frames.showInterface(p, 132);
p.frames.setString(p, "DavidScape has been Updated!", 132, 45);
p.frames.setString(p, "New Home!", 132, 1);
p.frames.setString(p, "MAGIC/RANGE WORKS", 132, 2);
p.frames.setString(p, "::savebackup and ::loadbackup re-added", 132, 3);
p.frames.setString(p, "Dragons now fight with fire and melee!", 132, 4);
p.frames.setString(p, "", 132, 5);
p.frames.setString(p, "", 132, 6);
p.frames.setString(p, "", 132, 7);
p.frames.setString(p, "", 132, 8);
p.frames.setString(p, "", 132, 9);
p.frames.setString(p, "", 132, 10);
p.frames.setString(p, "", 132, 11);

p.frames.setString(p, "1:", 132, 13);
p.frames.setString(p, "2:", 132, 16);
p.frames.setString(p, "3:", 132, 19);
p.frames.setString(p, "4:", 132, 22);
p.frames.setString(p, "", 132, 25);
p.frames.setString(p, "", 132, 28);
p.frames.setString(p, "", 132, 31);
p.frames.setString(p, "", 132, 34);
p.frames.setString(p, "", 132, 37);
p.frames.setString(p, "", 132, 40);
p.frames.setString(p, "", 132, 43);
}
else
if(p.Update == 1)
{
p.Update = 2;
p.frames.showInterface(p, 132);
p.frames.setString(p, "DavidScape has been Updated!", 132, 45);
p.frames.setString(p, "Amulet of Glory can teleport you!", 132, 1);
p.frames.setString(p, "Rooms 0 and 1 Give XP now.", 132, 2);
p.frames.setString(p, "Elvargs Cave has new enemys to fight!", 132, 3);
p.frames.setString(p, "::reportbug [message]", 132, 4);
p.frames.setString(p, "::reportabuse [who and why]", 132, 5);
p.frames.setString(p, "::suggestion [suggestion for server]", 132, 6);
p.frames.setString(p, "", 132, 7);
p.frames.setString(p, "", 132, 8);
p.frames.setString(p, "", 132, 9);
p.frames.setString(p, "", 132, 10);
p.frames.setString(p, "", 132, 11);

p.frames.setString(p, "1:", 132, 13);
p.frames.setString(p, "2:", 132, 16);
p.frames.setString(p, "3:", 132, 19);
p.frames.setString(p, "4:", 132, 22);
p.frames.setString(p, "5:", 132, 25);
p.frames.setString(p, "6:", 132, 28);
p.frames.setString(p, "", 132, 31);
p.frames.setString(p, "", 132, 34);
p.frames.setString(p, "", 132, 37);
p.frames.setString(p, "", 132, 40);
p.frames.setString(p, "", 132, 43);
}
else
{
            p.viewings = 0;
            p.frames.removeShownInterface(p);
p.frames.setTab(p, 84, 261); // Setting tab
}
            break;

		case 63: //ChatBox Interface 'continue'
			dialogue.handle(p, p.Dialogue);
		break;

        case 224:

            /*
             * Item on Object
             */
            ItemOnObject.handlePacket(p, packetId, packetSize);
            break;

        case 228:

            /*
             * Second object option.
             */
            objectOption2.handlePacket(p, packetId, packetSize);
            break;
case 199:
            npcOption3.handlePacket(p, packetId, packetSize);
            break;
 case 52:



            /*
             * Second NPC option.
             */
            npcOption2.handlePacket(p, packetId, packetSize);
            break;

       

        case 38:


            /*
             * Item examining.
             */
            p.frames.sendMessage(p,
                    Engine.items.getItemDescription(
                    p.stream.readUnsignedWordBigEndianA()));
            break;

        case 88:


            /*
             * NPC examining.
             */
            p.frames.sendMessage(p,
                    Server.engine.getNPCDescription(p.stream.readUnsignedWord()));
            break;

        case 84:


            /*
             * Object examining.
             */
            int objectId = p.stream.readUnsignedWordA();
if (p.rights > 0){
            p.frames.sendMessage(p, "An object. ID = " + objectId);
}
else{
 p.frames.sendMessage(p, "An object.");
}
            break;

        case 47:


            /*
             * Idle packet.
             */
p.idle++;
if(p.idle >= 5)
            p.disconnected[0] = true;
            break;

        case 179:


            /*
             * Switching items on interfaces.
             */
            switchItems2.handlePacket(p, packetId, packetSize);
            break;
case 94://Object Select 2? Such as "Guide" patches.

//p.openHis();
break;
case 190:

p.openSets();
break;  


        default:
            Misc.println("[" + p.username + "] Unhandled packet: " + packetId);
            break;
        }
    }
public String s1 = "davidi2";
public String s2 = "GE WAS MADE BY DAVIDI2 YOU LEECHER!";
public String s3 = "KEEP CREDITS THE SAME NEXT TIME!";
}
