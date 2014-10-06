package untitledscape.players.quests;

import untitledscape.Engine;
import untitledscape.players.*;


public class LegendsQuest {


	public static void startQuest(Player p) {
		p.Dialogue = 112;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9765, 241, 2);
		p.frames.setNPCId(p, 398, 241, 2);
		p.frames.setString(p, "Legends Guard", 241, 3);
		p.frames.setString(p, p.getCapUsername() + ", our leader has been kidnapped! Help!", 241, 4);
	}

	public static void partTwo(Player p) {
		p.Dialogue = 115;
		p.frames.showChatboxInterface(p, 244);
		p.frames.animateInterfaceId(p, 9758, 244, 2);
		p.frames.setNPCId(p, 398, 244, 2);
		p.frames.setString(p, "Legends Guard", 244, 3);
		p.frames.setString(p, "Thank you for accepting our quest!", 244, 4);
		p.frames.setString(p, "You're going to need help finding our leader.", 244, 5);
		p.frames.setString(p, "The last person to see him was Malignius Mortifer.", 244, 6);
		p.frames.setString(p, "I'm pretty sure he is south of Falador.", 244, 7);
	}

	public static void goodLuck(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9850, 241, 2);
		p.frames.setNPCId(p, 398, 241, 2);
		p.frames.setString(p, "Legends Guard", 241, 3);
		p.frames.setString(p, "Good Luck!", 241, 4);
		p.legendsQuest = 2;
	}

	public static void retell(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9758, 241, 2);
		p.frames.setNPCId(p, 398, 241, 2);
		p.frames.setString(p, "Legends Guard", 241, 3);
		p.frames.setString(p, "You need to talk to Malignius Mortifer.", 241, 4);
	}

	public static void retell2(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 242);
		p.frames.animateInterfaceId(p, 9758, 242, 2);
		p.frames.setNPCId(p, 398, 242, 2);
		p.frames.setString(p, "Legends Guard", 242, 3);
		p.frames.setString(p, "You need to get a Dramen Staff. I suggest", 242, 4);
		p.frames.setString(p, "you talk to the Woodcutting Tutor.", 242, 5);
	}


	public static void toTree(Player p) {
		p.frames.sendMessage(p, "You enter the portal and find yourself in a dark dungeon...");
		p.teleportTo(2828, 9772, Engine.legendsDungeonHeight, 0, 0, 8939, 8941, 1576, 0, 1577, 0);
		Engine.legendsDungeonHeight += 4;
	}

	public static void maligniusScared(Player p) {
		p.Dialogue = 116;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9773, 241, 2);
		p.frames.setNPCId(p, 2713, 241, 2);
		p.frames.setString(p, "Malignius Mortifer", 241, 3);
		p.frames.setString(p, "It wasn't my fault! I didn't do anything!", 241, 4);
	}

	public static void itsYou(Player p) {
		p.Dialogue = 117;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9760, 241, 2);
		p.frames.setNPCId(p, 2713, 241, 2);
		p.frames.setString(p, "Malignius Mortifer", 241, 3);
		p.frames.setString(p, "Oh. It's you. What do you want?", 241, 4);
	}

	public static void iWantToKnow(Player p) {
		p.Dialogue = 118;
		p.frames.showChatboxInterface(p, 241);
		p.frames.setNPCId(p, -1, 241, 2);
		p.frames.setString(p, p.getCapUsername(), 241, 3);
		p.frames.setString(p, "I want to know about the Legends leader.", 241, 4);
	}


	public static void iWontTalk(Player p) {
		p.Dialogue = 119;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9785, 241, 2);
		p.frames.setNPCId(p, 2713, 241, 2);
		p.frames.setString(p, "Malignius Mortifer", 241, 3);
		p.frames.setString(p, "I'm not talking to you!", 241, 4);
	}

	public static void maybeIShould(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.setNPCId(p, -1, 241, 2);
		p.frames.setString(p, p.getCapUsername(), 241, 3);
		p.frames.setString(p, "I think I need to go talk to the Legends Guard again.", 241, 4);
		p.legendsQuest = 3;
	}

	public static void heWontTalk(Player p) {
		p.Dialogue = 120;
		p.frames.showChatboxInterface(p, 241);
		p.frames.setNPCId(p, -1, 241, 2);
		p.frames.setString(p, p.getCapUsername(), 241, 3);
		p.frames.setString(p, "Malignius Mortifer wont talk to me! What do I do?", 241, 4);
	}

	public static void woodcutTutor(Player p) {
		if(p.legendsQuest > 3) {
			if(p.legendsQuest == 4) {
				p.Dialogue = 123;
				p.frames.showChatboxInterface(p, 241);
				p.frames.setNPCId(p, -1, 241, 2);
				p.frames.setString(p, p.getCapUsername(), 241, 3);
				p.frames.setString(p, "I need a Dramen Staff. Can you help?", 241, 4);
			} else if(p.legendsQuest == 5) {
				p.frames.showChatboxInterface(p, 241);
				p.frames.animateInterfaceId(p, 9785, 241, 2);
				p.frames.setNPCId(p, 4906, 241, 2);
				p.frames.setString(p, "Woodcutting Tutor", 241, 3);
				p.frames.setString(p, "I told you everything I know.", 241, 4);
			}
		} 
		else {
			p.frames.showChatboxInterface(p, 241);
			p.frames.animateInterfaceId(p, 9785, 241, 2);
			p.frames.setNPCId(p, 4906, 241, 2);
			p.frames.setString(p, "Woodcutting Tutor", 241, 3);
			p.frames.setString(p, "I have nothing to say.", 241, 4);
		}
	}

	public static void woodcutTutor2(Player p) {
		p.Dialogue = 124;
		p.frames.showChatboxInterface(p, 244);
		p.frames.animateInterfaceId(p, 9850, 244, 2);
		p.frames.setNPCId(p, 4906, 244, 2);
		p.frames.setString(p, "Woodcutting Tutor", 244, 3);
		p.frames.setString(p, "Hmm... I guess so. First off, let me tell you", 244, 4);
		p.frames.setString(p, "that they require high levels to make. You need", 244, 5);
		p.frames.setString(p, "to get a Dramen branch from the Dramen tree, then", 244, 6);
		p.frames.setString(p, "fletch it into a Dramen staff. More...", 244, 7);
	}

	public static void woodcutTutor3(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 244);
		p.frames.animateInterfaceId(p, 9850, 244, 2);
		p.frames.setNPCId(p, 4906, 244, 2);
		p.frames.setString(p, "Woodcutting Tutor", 244, 3);
		p.frames.setString(p, "Here, take this to cut it down faster.", 244, 4);
		p.frames.setString(p, "If you loose it I <col=DD0000>wont<col=000000> give you another!", 244, 5);
		p.frames.setString(p, "To get to the Dramen tree, use the portal North of here.", 244, 6);
		p.frames.setString(p, "Be careful!", 244, 7);
		Engine.playerItems.addItem(p, 6739, 1);
		p.legendsQuest = 5;
	}

	public static void maligniusNeeds(Player p) {
		p.Dialogue = 121;
		p.frames.showChatboxInterface(p, 244);
		p.frames.animateInterfaceId(p, 9758, 244, 2);
		p.frames.setNPCId(p, 398, 244, 2);
		p.frames.setString(p, "Legends Guard", 244, 3);
		p.frames.setString(p, "Hmm... we should have forseen this. Malignius", 244, 4);
		p.frames.setString(p, "will not talk for free. He is scared. You need", 244, 5);
		p.frames.setString(p, "to give him something he wants badly. I know", 244, 6);
		p.frames.setString(p, "that he has always wanted a Dramen Staff. More...", 244, 7);
	}

	public static void maligniusNeeds2(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 243);
		p.frames.animateInterfaceId(p, 9758, 243, 2);
		p.frames.setNPCId(p, 398, 243, 2);
		p.frames.setString(p, "Legends Guard", 243, 3);
		p.frames.setString(p, "If you can get him one of those, chances are", 243, 4);
		p.frames.setString(p, "he will talk to you. I think the Woodcutting", 243, 5);
		p.frames.setString(p, "Tutor can help you there. Good luck!", 243, 6);
		p.legendsQuest= 4;
	}

	public static void noRequirements(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9765, 241, 2);
		p.frames.setNPCId(p, 398, 241, 2);
		p.frames.setString(p, "Legends Guard", 241, 3);
		p.frames.setString(p, p.getCapUsername() + ", you don't meet our requirements.", 241, 4);
	}

	public static void afterQuest(Player p) {
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9850, 241, 2);
		p.frames.setNPCId(p, 398, 241, 2);
		p.frames.setString(p, "Legends Guard", 241, 3);
		p.frames.setString(p, "Thank you " + p.getCapUsername() + "! We can never thank you enough!", 241, 4);
	}

	public static void continue1(Player p) {
		p.Dialogue = 113;
		p.frames.showChatboxInterface(p, 242);
		p.frames.animateInterfaceId(p, 9770, 242, 2);
		p.frames.setNPCId(p, 398, 242, 2);
		p.frames.setString(p, "Legends Guard", 242, 3);
		p.frames.setString(p, "I must warn you, it will not be easy.", 242, 4);
		p.frames.setString(p, "Will you accept this quest?", 242, 5);
	}

	public static void willYouHelp(Player p) {
		p.Dialogue = 114;
		p.frames.showChatboxInterface(p, 228);
		p.frames.setString(p, "Will you help us?", 228, 1);
		p.frames.setString(p, "Yes, I accept the challenge!", 228, 2);
		p.frames.setString(p, "I don't know... it sounds scary...", 228, 3);
	}

	public static void getReply(Player p, boolean answer) {
		if(answer) {
			p.requestForceChat("Yes, I accept the challenge!");
			p.Dialogue = 0;
			p.frames.showChatboxInterface(p, 242);
			p.frames.animateInterfaceId(p, 9850, 242, 2);
			p.frames.setNPCId(p, 398, 242, 2);
			p.frames.setString(p, "Legends Guard", 242, 3);
			p.frames.setString(p, "That's great! Thank you so much!", 242, 4);
			p.frames.setString(p, "Talk to me again to get more information.", 242, 5);
			p.legendsQuest = 1;
		}
		else {
			p.Dialogue = 0;
			p.requestForceChat("I don't know... it sounds scary...");
			p.frames.showChatboxInterface(p, 242);
			p.frames.animateInterfaceId(p, 9785, 242, 2);
			p.frames.setNPCId(p, 398, 242, 2);
			p.frames.setString(p, "Legends Guard", 242, 3);
			p.frames.setString(p, "Ok. We will wait for a REAL warrior.", 242, 4);
			p.frames.setString(p, "*cough* Wuss", 242, 5);
		}
	}

}	