package untitledscape.Skills;

import untitledscape.players.Player;
import untitledscape.players.items.PlayerItems;

// import java.io.*; Unused Imports
//import java.util.concurrent.TimeUnit;
//import untitledscape.Engine;

public class Firemaking {

	static int lightWait;
	static int xp;
	static int fireReq;
	static int itemid;
	
	static Player player;
	
	static PlayerItems playeritems;

	public static void makeFire(int XpToAdd, int FireReq, int del, Player p, PlayerItems pi) {
		if (p.skillLvl[11] < FireReq) {
			p.frames.sendMessage(p, "You need an Firemaking level of " + FireReq);
			return;
		}

		xp = XpToAdd;
		fireReq = FireReq;
		itemid = del;
		player = p;
		playeritems = pi;

		lightWait = 15000;
		p.requestAnim(733, 0);
		p.objectX = p.absX;
		p.objectY = p.absY;

		while (lightWait > 0) {
			lightWait--;
			
			if(lightWait == 0) {
				p.fmwalk(0, 1);

				pi.deleteItem(p, itemid, 1);

				p.frames.createGlobalObject(2732, p.heightLevel, p.absX, p.absY, 0, 10);

				p.frames.sendMessage(p, "You set the logs on fire.");

				p.addSkillXP(xp * p.skillLvl[11], 11);

				lightWait = -1;

				p.firedelay = 100;
			}
		}
	}
}
