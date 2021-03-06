
package untitledscape.io;

import untitledscape.Engine;
import untitledscape.io.packets.*;
import untitledscape.players.Player;
import untitledscape.players.quests.*;

public class Dialogue {

	public void handle(Player p, int id) {
		switch(id) { 
			case 1:
				PacketManager.AcceptCape(p, 2270, "Martin Thwait", 9779, 9777); 
			break;
			case 2:
				PacketManager.YouShould(p, 2270, "Martin Thwait", "steal from these people here, if you know what I mean..."); 
			break;
			case 3:
				PacketManager.AcceptCape(p, 1658, "Robe Store Owner", 9764, 9762); 
			break;
			case 4:
				PacketManager.YouShould(p, 1658, "Robe Store Owner", "High alch, its a great way to level up!"); 
			break;
			case 5:
				PacketManager.AcceptCape(p, 7950, "Melee Tutor", 9755, 9753); 
			break;
			case 6:
				PacketManager.YouShould(p, 7950, "Melee Tutor", "Fight Guards in the main hall..."); 
			break;
			case 7:
				PacketManager.AcceptCape(p, 4288, "Ajjat", 9749, 9747); 
			break;
			case 8:
				PacketManager.YouShould(p, 4288, "Ajjat", "Fight Guards in the main hall..."); 
			break;
			case 9:
				PacketManager.AcceptCape(p, 4297, "Sloane", 9752, 9750); 
			break;
			case 10:
				PacketManager.YouShould(p, 4297, "Sloane", "Fight Guards in the main hall..."); 
			break;
			case 11:
				PacketManager.AcceptCape(p, 961, "Surgeon General Tafani", 9770, 9768); 
			break;
			case 12:
				PacketManager.YouShould(p, 961, "Surgeon General Tafani", "Fight Guards in the main hall..."); 
			break;
			case 13:
				PacketManager.AcceptCape(p, 308, "Master Fisher", 9800, 9798); 
			break;
			case 14:
				Engine.playerItems.addItem(p, 305, 1);
				Engine.playerItems.addItem(p, 307, 1);
				Engine.playerItems.addItem(p, 301, 1);
				Engine.playerItems.addItem(p, 311, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9760, 241, 2);
				p.frames.setNPCId(p, 308, 241, 2);
				p.frames.setString(p, "Master Fisher", 241, 3);
				p.frames.setString(p, "take these supplies, and go fish outside...", 241, 4);
			break;
			case 15:
				PacketManager.AcceptCape(p, 4906, "Woodcutting Tutor", 9809, 9807); 
			break;
			case 16:
				Engine.playerItems.addItem(p, 1359, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9760, 241, 2);
				p.frames.setNPCId(p, 4906, 241, 2);
				p.frames.setString(p, "Woodcutting Tutor", 241, 3);
				p.frames.setString(p, "take this axe, and cut some trees...", 241, 4);
			break;
			case 17:
				PacketManager.AcceptCape(p, 3295, "Dwarf", 9794, 9792); 
			break;
			case 18:
				Engine.playerItems.addItem(p, 1275, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 3295, 241, 2);
				p.frames.setString(p, "Dwarf", 241, 3);
				p.frames.setString(p, "take this pickaxe, and mine some rocks!", 241, 4);
 
			break;
			case 19:
				PacketManager.AcceptCape(p, 802, "Brother Jered", 9761, 9759); 
			break;
			case 20:
				if(p.skillLvl[5] > 69) {
					Engine.playerItems.addItem(p, 536, 28);
				} else {
					Engine.playerItems.addItem(p, 526, 28);
				}
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 802, 241, 2);
				p.frames.setString(p, "Brother Jered", 241, 3);
				p.frames.setString(p, "bury this load of bones I found.", 241, 4);
 
			break;
			case 21:
				PacketManager.AcceptCape(p, 553, "Aubury", 9767, 9765); 
			break;
			case 22:
				PacketManager.YouShould(p, 553, "Aubury", "craft runes at the rune altar. I can teleport you there."); 
			break;
			case 23:
				PacketManager.AcceptCape(p, 682, "Armour salesman", 9758, 9756); 
			break;
			case 24:
				PacketManager.YouShould(p, 682, "Armour salesman", "talk to the Range Tutor..."); 
			break;
			case 25: 
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9760, 241, 2);
				p.frames.setNPCId(p, 1861, 241, 2);
				p.frames.setString(p, "Range Tutor", 241, 3);
				p.frames.setString(p, "and attack enemys with your bow and arrows.", 241, 4);

			break;
			case 26:
				PacketManager.AcceptCape(p, 4946, "Ignatius Vulcan", 9806, 9804); 
			break;
			case 27:
				Engine.playerItems.addItem(p, 590, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 4946, 241, 2);
				p.frames.setString(p, "Ignatius Vulcan", 241, 3);
				p.frames.setString(p, "take this tinderbox, and light some logs!", 241, 4); 
			break;
			case 28:
				PacketManager.AcceptCape(p, 575, "Hickton", 9785, 9783); 
			break;
			case 29:
				Engine.playerItems.addItem(p, 946, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9760, 241, 2);
				p.frames.setNPCId(p, 575, 241, 2);
				p.frames.setString(p, "Hickton", 241, 3);
				p.frames.setString(p, "take this knife, and carve some logs.", 241, 4); 
			break;
			case 30:
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9840, 241, 2);
				p.frames.setNPCId(p, 494, 241, 2);
				p.frames.setString(p, "Banker", 241, 3);
				p.frames.setString(p, "Yeah noob...what were you thinking?", 241, 4);
			break;
			case 31:
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9840, 241, 2);
				p.frames.setNPCId(p, 495, 241, 2);
				p.frames.setString(p, "Banker", 241, 3);
				p.frames.setString(p, "Yeah noob...what were you thinking?", 241, 4);
			break;
			case 32:
				PacketManager.AcceptCape(p, 437, "Cap'n Izzy No-Beard", 9773, 9771); 
			break;
			case 33:
				PacketManager.YouShould(p, 437, "Cap'n Izzy No-Beard", "do this agility course alot..."); 
			break;
			case 34:
				PacketManager.AcceptCape(p, 805, "Master Crafter", 9782, 9780); 
			break;
			case 35:
				PacketManager.YouShould(p, 805, "Master Crafter", "buy some crafting suplies from the crafting tutor."); 
			break;
			case 36:
				PacketManager.AcceptCape(p, 455, "Kaqemeex", 9776, 9774); 
			break;
			case 37:
				if(p.skillLvl[5] > 69) {
					Engine.playerItems.addItem(p, 207, 28);
				} else {
					Engine.playerItems.addItem(p, 199, 28);
				}
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 455, 241, 2);
				p.frames.setString(p, "Kaqemeex", 241, 3);
				p.frames.setString(p, "clean these leaves for me.", 241, 4);
			break;
			case 38:
				PacketManager.AcceptCape(p, 5113, "Hunting Expert", 9950, 9948); 
			break;
			case 39:
				Engine.playerItems.addItem(p, 11259, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9760, 241, 2);
				p.frames.setNPCId(p, 5113, 241, 2);
				p.frames.setString(p, "Hunting Expert", 241, 3);
				p.frames.setString(p, "take this net, and catch the implings around here.", 241, 4);
			break;
			case 40:
				PacketManager.AcceptCape(p, 847, "Head Chef", 9803, 9801); 
			break;
			case 41:
				PacketManager.YouShould(p, 847, "Head Chef", "cook fish at the cooking range right there..."); 
			break;
			case 42:
				PacketManager.AcceptCape(p, 604, "Thurgo", 9797, 9795); 
			break;
			case 43:
				PacketManager.YouShould(p, 604, "Thurgo", "use your ores with pottery oven to smelt them..."); 
			break;
			case 44:
				PacketManager.AcceptCape(p, 1599, "Duradel", 9788, 9786); 
			break;
			case 45:
				PacketManager.YouShould(p, 1599, "Duradel", "kill monsters from the slayer task I give you..."); 
			break;
			case 50:
				p.Dialogue = 0;
				if(p.skillLvl[19] < 40) {
					Engine.playerItems.addItem(p, 5096, 1);
					p.frames.showChatboxInterface(p, 241);
					p.frames.animateInterfaceId(p, 9760, 241, 2);
					p.frames.setNPCId(p, 3299, 241, 2);
					p.frames.setString(p, "Master Gardener", 241, 3);
					p.frames.setString(p, "I need you to plant this Marigold seed on the flower patch.", 241, 4);
				}
				if(p.skillLvl[19] < 60 && p.skillLvl[19] > 39) {
					Engine.playerItems.addItem(p, 5283, 1);
					p.frames.showChatboxInterface(p, 241);
					p.frames.animateInterfaceId(p, 9760, 241, 2);
					p.frames.setNPCId(p, 3299, 241, 2);
					p.frames.setString(p, "Master Gardener", 241, 3);
					p.frames.setString(p, "I need you to plant this Apple seed on the herb patch.", 241, 4);
				}
				if(p.skillLvl[19] < 80 && p.skillLvl[19] > 59) {
					Engine.playerItems.addItem(p, 5100, 1);
					p.frames.showChatboxInterface(p, 241);
					p.frames.animateInterfaceId(p, 9760, 241, 2);
					p.frames.setNPCId(p, 3299, 241, 2);
					p.frames.setString(p, "Master Gardener", 241, 3);
					p.frames.setString(p, "I need you to plant this Limpwurt seed on the flower patch.", 241, 4);
				}
				if(p.skillLvl[19] > 79) {
					Engine.playerItems.addItem(p, 5288, 1);
					p.frames.showChatboxInterface(p, 241);
					p.frames.animateInterfaceId(p, 9760, 241, 2);
					p.frames.setNPCId(p, 3299, 241, 2);
					p.frames.setString(p, "Master Gardener", 241, 3);
					p.frames.setString(p, "I need you to plant this Papaya seed on the herb patch.", 241, 4);
				}
			break;
			case 51:
				PacketManager.AcceptCape(p, 3299, "Master Gardener", 9812, 9810); 
			break;
			case 52:
				PacketManager.AcceptCape(p, 4247, "Estate Agent", 9791, 9789); 
			break;
			case 53:
				PacketManager.YouShould(p, 4247, "Estate Agent", "go in your house, turn building mode on, and build!"); 
			break;
			case 54:
				PacketManager.AcceptCape(p, 6970, "Pikkupstix", 12171, 12169); 
			break;
			case 55:
				PacketManager.YouShould(p, 6970, "Pikkupstix", "purchase my pouches and summon them for xp!"); 
			break;
			case 100:
				p.Dialogue = 101;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 198, 241, 2);
				p.frames.setString(p, "Guildmaster", 241, 3);
				p.frames.setString(p, "Well then speak to Oziach in Edgeville.", 241, 4);
			break;
			case 101:
				p.Dialogue = 0;
				p.DragonSlayer = 1;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 198, 241, 2);
				p.frames.setString(p, "Guildmaster", 241, 3);
				p.frames.setString(p, "He should have a mighty quest for you!", 241, 4); 
			break;
			case 102:
				p.Dialogue = 103;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 198, 241, 2);
				p.frames.setString(p, "Guildmaster", 241, 3);
				p.frames.setString(p, "You will need a map, ship, and somthing to", 241, 4);
			break;
			case 103:
				p.Dialogue = 104;
				p.DragonSlayer = 3;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 198, 241, 2);
				p.frames.setString(p, "Guildmaster", 241, 3);
				p.frames.setString(p, "protect you from dragon fire breath.", 241, 4);
			break;
			case 104:
				p.Dialogue = 0;
				p.frames.setString(p, "How can I find a route to Crandor?", 458, 1);
				p.frames.setString(p, "Where can I find the right ship?", 458, 2);
				p.frames.setString(p, "How can I protect myself from the dragon's breath?", 458, 3);
				p.frames.showChatboxInterface(p, 458);
				p.Smithing = false;
				p.Cooking = false;
				p.TalkAgent = false;
				p.DecorChange = false;
				p.Choice = 1;
			break;
			case 105:
				p.Dialogue = 106;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 747, 241, 2);
				p.frames.setString(p, "Oziach", 241, 3);
				p.frames.setString(p, "There is somthing you could do...", 241, 4);
			break;
			case 106:
				p.Dialogue = 107;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 747, 241, 2);
				p.frames.setString(p, "Oziach", 241, 3);
				p.frames.setString(p, "Kill Elvarg the dragon on crandor island.", 241, 4);
			break;
			case 107:
				p.Dialogue = 0;
				p.DragonSlayer = 2;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 747, 241, 2);
				p.frames.setString(p, "Oziach", 241, 3);
				p.frames.setString(p, "Go back to the guild master, he can help.", 241, 4);
			break;
			case 108:
				p.Dialogue = 0;
				Engine.playerItems.addItem(p, 1538, 1);
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 746, 241, 2);
				p.frames.setString(p, "Oracle", 241, 3);
				p.frames.setString(p, "Well here it is...good thing I didnt loose it.", 241, 4);
 
			break;
			case 109:
				p.setCoords(3048, 3208, 1);
				p.Dialogue = 0;
				p.BoatTimer = 6;
				p.frames.showInterface(p, 544);
				p.frames.removeChatboxInterface(p);
			break;
			case 110:
				p.Dialogue = 0;
				p.QuestPoints += 2;
				p.DragonSlayer = 5;
				p.addSkillXP(180650 ,0);
				p.addSkillXP(180650 ,2);
				p.frames.showInterface(p, 277);
				p.frames.setString(p, "Congratulations!", 277, 3);
				p.frames.setString(p, "You have completed the Dragon Slayer quest!", 277, 4);
				p.frames.setString(p, "Quest Points:", 277, 6);
				p.frames.setString(p, ""+				p.QuestPoints, 277, 7);
				p.frames.setString(p, "2 Quest Points", 277, 10);
				p.frames.setString(p, "Ability to wear rune platebody", 277, 11);
				p.frames.setString(p, "Ability to wear dragon chainbody", 277, 12);
				p.frames.setString(p, "180,650 Strength XP", 277, 13);
				p.frames.setString(p, "180,650 Attack XP", 277, 14);
				p.frames.setString(p, "", 277, 15);
				p.frames.setString(p, "", 277, 16);
				p.frames.setString(p, "", 277, 17);
				p.frames.removeChatboxInterface(p);
			break;
			case 111:
				Engine.playerItems.addItem(p, 9814, 1);
				Engine.playerItems.addItem(p, 9813, 1);
				p.Dialogue = 0;
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9850, 241, 2);
				p.frames.setNPCId(p, 2567, 241, 2);
				p.frames.setString(p, "Wise Old Man", 241, 3);
				p.frames.setString(p, "Take this cape as a reward!", 241, 4);
			break;
			case 112:
				LegendsQuest.continue1(p);
			break;
			case 113:
				LegendsQuest.willYouHelp(p);
			break;
			case 114:
				LegendsQuest.getReply(p, getTwoChoiceAnswer(p));
			break;
			case 115:
				LegendsQuest.goodLuck(p);
			break;
			case 116:
				LegendsQuest.itsYou(p);
			break;
			case 117:
				LegendsQuest.iWantToKnow(p);
			break;
			case 118:
				LegendsQuest.iWontTalk(p);
			break;
			case 119:
				LegendsQuest.maybeIShould(p);
			break;
			case 120:
				LegendsQuest.maligniusNeeds(p);
			break;
			case 121:
				LegendsQuest.maligniusNeeds2(p);
			break;
			case 122:
				if(getTwoChoiceAnswer(p)) {
					if(p.skillLvl[8] > 98) {
						NPCOption1.GetSkillCape(p, 15, 4906, "Woodcutting Tutor", "Woodcutting"); 
					}
					else {
						NPCOption1.OnlyLevel(p, 16, 4906, "Woodcutting Tutor", 8, "Woodcutting");
					}
				}
				else {
					LegendsQuest.woodcutTutor(p);
				}
			break;
			case 123:
				LegendsQuest.woodcutTutor2(p);
			break;
			case 124:
				LegendsQuest.woodcutTutor3(p);
			break;
			default:
				p.Dialogue = 0;
				p.frames.removeChatboxInterface(p);
			break;
		}
	}

	boolean getTwoChoiceAnswer(Player p) {
		p.stream.readUnsignedWord(); //JUNK
		return (p.stream.readUnsignedWord()/256 == 2);
	}

}
	

