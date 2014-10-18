/*
Created by david
 */

package untitledscape.io.packets;

import javax.swing.JOptionPane;

import untitledscape.Engine;
import untitledscape.Server;
import untitledscape.players.Player;
import untitledscape.players.items.PlayerItems;
import untitledscape.util.Misc;
import untitledscape.world.items.*;

import java.io.*;
import java.lang.*;

public class Commands implements Packet {

	public PlayerItems pi = new PlayerItems();

	public int getItemSlot(Player p, int itemId) {
		if (p == null) {
			return 0;
		}
		int itemAmt = 0;

		for (int i = 0; i < p.items.length; i++) {
			if (p.items[i] == itemId) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Handles commands, chat text that starts with ::.
	 * 
	 * @param p
	 *            The Player which the frame should be handled for.
	 * @param packetId
	 *            The packet id this belongs to.
	 * @param packetSize
	 *            The amount of bytes being recieved for this packet.
	 */

	public int[] quests = new int[500];

	public void handlePacket(Player p, int packetId, int packetSize) {
		p.waiting = false;
		if (p == null || p.stream == null) {
			return;
		}
		try {
			String playerCommand = p.stream.readString().toLowerCase();
			String[] cmd = playerCommand.split(" ");
			if (cmd[0].equals("verifycode")) {
				if (Integer.parseInt(cmd[1]) == p.verificationCode) {
					p.frames.sendMessage(p, "Thanks for verifying you account! You can now use commands.");
					p.frames.sendMessage(p, "Type ::commands for a list of those commands.");
					p.teleportTo(3222, 3219, 0, 0, 0, 8939, 8941, 1576, 0, 1577, 0);
					p.donecode = 1;
				} else {
					p.frames.sendMessage(p, "Incorrect Code! Your code is: " + p.verificationCode);
				}
			}
			if (p.donecode == 1) {
				if (p.inAssault && p.rights < 1) {
					p.frames.sendMessage(p, "You cant do any commands in Barbarian Assault!");
					return;
				}
				if (p.attackingPlayer == (false)) {
					if (p.rights >= 0) {

						if (cmd[0].startsWith("zammyscore")) {
							p.ZamFL++;
							p.frames.setString(p, "Zamorak = " + p.ZamFL, 58, 0);
						} else if (cmd[0].startsWith("cw")) {
							p.setCoords(2442, 3090, 0);
						} else if (cmd[0].equals("smoke")) {
							p.requestAnim(884, 0);
							p.requestGFX(354, 0);
							p.frames.setOverlay(p, 175);
							p.requestForceChat("*cough* *cough* Ahh.. that's some good ****.");
						}

						else if (cmd[0].equals("lq")) {
							p.legendsQuest = Integer.parseInt(cmd[1]);
						} else if (cmd[0].equals("female")) {
							p.look[0] = 48; // Hair
							p.look[1] = 1000; // Beard
							p.look[2] = 57; // Torso
							p.look[3] = 64; // Arms
							p.look[4] = 68; // Bracelets
							p.look[5] = 77; // Legs
							p.look[6] = 80; // Shoes
							p.gender = 1;
							p.appearanceUpdateReq = true;
							p.updateReq = true;
						} else if (cmd[0].equals("test")) {
							p.Dialogue = 0;
							p.frames.showChatboxInterface(p, 241);
							p.frames.animateInterfaceId(p, Integer.parseInt(cmd[1]), 241, 2);
							p.frames.setNPCId(p, 398, 241, 2);
							p.frames.setString(p, "Legends Guard", 241, 3);
							p.frames.setString(p, "Thank you " + p.username + "! We are saved!", 241, 4);
						} else if (cmd[0].startsWith("kc")) {
							p.frames.sendMessage(p, "Your Saradomin KC is: " + (p.skc));
							p.frames.sendMessage(p, "Your Zamorak KC is: " + (p.zkc));
							p.frames.sendMessage(p, "Your Bandos KC is: " + (p.bkc));
							p.frames.sendMessage(p, "Your Aramdyl KC is: " + (p.akc));
						}

						else if (cmd[0].startsWith("suggestion")) {
							String suggestionText = playerCommand.substring(11);
							if (p.suggestionTimer > 0) {
								p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can suggest again.");
							} else {
								Engine.fileManager.appendData("Suggestions/Suggestions.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
								p.frames.sendMessage(p, "Your suggestion has been recieved.");
								p.suggestionTimer = 10;
							}
						}

						else if (cmd[0].startsWith("reportbug")) {
							String suggestionText = playerCommand.substring(9);
							if (p.suggestionTimer > 0) {
								p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can report a bug again.");
							} else {
								Engine.fileManager.appendData("Suggestions/BugReports.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
								p.frames.sendMessage(p, "Your Bug Report has been recieved.");
								p.suggestionTimer = 10;
							}
						}

						else if (cmd[0].startsWith("reportabuse")) {
							String suggestionText = playerCommand.substring(11);
							if (p.suggestionTimer > 0) {
								p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can report abuse again.");
							} else {
								Engine.fileManager.appendData("Suggestions/AbuseReports.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
								p.frames.sendMessage(p, "Your Abuse Report has been recieved.");
								p.suggestionTimer = 10;
							}
						}

						else if (cmd[0].equals("wildy") || cmd[0].equals("pvp")) {
							p.teleportTo(3243, 3516, 0, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
						} else if (cmd[0].startsWith("afk")) {
							p.requestForceChat("AFK  BRB!");
							p.requestAnim(2770, 1);
							p.requestGFX(277, 0);
							p.appearanceUpdateReq = true;
							p.updateReq = true;
							p.frames.sendMessage(p, "Type ::back when you get back!");
						} else if (cmd[0].startsWith("back")) {
							p.requestForceChat("Im BACK!");
							p.requestAnim(1972, 1);
							p.requestGFX(86, 0);
							p.appearanceUpdateReq = true;
							p.updateReq = true;
						}

						else if (cmd[0].equals("gwd")) {
							p.teleportTo(2882, 5310, 2, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
							p.frames.showInterface(p, 426);
							p.frames.sendMessage(p, "Zammy is NE, Sara is SE, Armadly is SW, Bandos is NW.");
							p.frames.sendMessage(p, "Type ::fixgwd to fix the underground glitch.");
							p.frames.sendMessage(p, "You need 20 kill count to enter each lair. Use ::kc to find yours!");
						}

						else if (cmd[0].equals("fixgwd")) {
							if (!p.LocatedAt.equals("Not in any of the main areas, must be wandering around.")) {
								p.teleportTo(p.absX, p.absY, 2, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
							} else {
								p.frames.sendMessage(p, "Now why would you do that when your not in the GWD? You must be stupid...");
							}
						} else if (cmd[0].equals("changepass")) {
							p.password = (cmd[1]);
							p.frames.sendMessage(p, "Your new pass is " + p.password);
						}

						else if (cmd[0].equals("assault")) {
							p.setCoords(2592, 5285, 0);
						}

						else if (cmd[0].equals("goinhouse")) {
							if (p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950) {
								p.frames.sendMessage(p, "You must leave the current house you are in.");
							} else {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];

								if (p2.playerId == p.playerId) {
									p.frames.sendMessage(p, "You must use the house portal to go in your own house.");
								} else if (p2 == null) {
									p.frames.sendMessage(p, person + " is offline.");
								} else if (p2.BuildingMode == true) {
									p.frames.sendMessage(p, p2.username + " is in Building Mode.");
								} else {
									p.PersonHouse = p2.playerId;
									p.frames.sendMessage(p, "You enter " + p2.username + "'s house.");
									p.InHouse = true;
									p.OwnHouse = false;
									p.frames.showInterface(p, 399);
									p.HouseTele = 6;
									p.setCoords(3104, 3926, p2.HouseHeight);
								}
							}

						} else if (cmd[0].equals("whereis")) {
							String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
							Player p2 = Server.engine.players[Engine.getIdFromName(person)];
							if (p2 != null) {
								p.frames.sendMessage(p, person + " is located at: " + p2.LocatedAt);
								p2.frames.sendMessage(p2, p.username + " has just looked for your location.");
							} else {
								p.frames.sendMessage(p, person + " is offline.");
							}

						}

						// ======================================CLAN
						// CHAT===========================================

						else if (cmd[0].equals("joinchat")) {

							String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
							Player p2 = Server.engine.players[Engine.getIdFromName(person)];
							if (p.muted == 1) {
								p.frames.sendMessage(p, "You cant use this command! You've been muted!");
							} else if (p.muted == 0) {
								if (p2.playerId == p.playerId) {
									p.clanchat = p2.clanchannel;
									p.frames.sendMessage(p, "You are now talking in: " + p2.clanname);
									p.frames.sendMessage(p, "You are the owner of this channel..");
									p.frames.sendMessage(p, "Use ::clanname [newname] to change the name.");
								} else if (p2 != null) {
									p.clanchat = p2.clanchannel;
									p.frames.sendMessage(p, "You are now talking in: " + p2.clanname);
									p.frames.sendMessage(p, "Use / [message] to talk.");
									p.frames.sendMessage(p, "To leave this chat use ::leavechat");
								} else {
									p.frames.sendMessage(p, "That channel does not exist.");
								}
							}

						} else if (cmd[0].equals("newname")) {
							String name = playerCommand.substring((playerCommand.indexOf(" ") + 1));
							p.clanname = name;
							p.frames.sendMessage(p, "You changed the name of your clan to: " + name);

						} else if (cmd[0].equals("leavechat")) {
							p.clanchat = 0;
						} else if (cmd[0].equals("c")) {
							String yellText = playerCommand.substring(2);
							Player p2 = Server.engine.players[p.clanchat];
							if (p.clanchat > 0) {
								if (p.clanchat == p.playerId) {
									p.frames.sendMessage(p, "[" + p2.clanname + "] " + Misc.optimizeText(p.username) + ": <col=ff0000>" + Misc.optimizeText(yellText));
								} else {
									for (Player pz : Engine.players) {
										if (pz != null) {
											if (pz.clanchat == p.clanchat) {
												p.frames.sendMessage(pz, "[" + p2.clanname + "] " + Misc.optimizeText(p.username) + ": <col=ff0000>" + Misc.optimizeText(yellText));
											}
										}
									}
								}
							} else {
								p.frames.sendMessage(p, "You arent in a clan chat. Use ::joinchat [playername]");
							}
						}

						// =======================================END OF CLAN
						// CHAT================================================

						if (cmd[0].equals("yell")) {
							playerCommand = playerCommand.toLowerCase();
							if (p.muted == 0) {
								String message = playerCommand.substring(5);
								String titles = "";
								if (p.rights == 0) {
									titles = "<img=3><col=00FFF0>[User]";
								}
								if (p.rights == 1) {
									titles = "<img=0><col=0000ff>[Moderator] ";
								}
								if (p.rights == 2) {
									titles = "<img=1><col=8B0000>[Administrator] ";
								}
								if (p.username.equals("david")) {
									titles = "<img=1><col=C12DBF>[Owner] ";
								}
								if (p.username.equals("daddy") || p.username.equals("free refund")) {
									titles = "<img=1><col=C12DBF>[Co-Owner] ";
								}
								for (Player pl : Engine.players) {
									p.frames.sendMessage(pl, titles + "" + p.username + ": " + message);
								}
							} else if (p.muted == 1) {
								p.frames.sendMessage(p, "You can't yell because you are muted!");
							}
						}

						else if (cmd[0].equals("newroom")) {

							if (p.BuildingMode == false) {
								p.frames.sendMessage(p, "You are not in building mode.");
							} else {
								p.RoomDir = Integer.parseInt(cmd[1]);

								p.frames.showInterface(p, 402);

							}
						} else if (cmd[0].equals("deleteroom")) {
							if (p.BuildingMode == false) {
								p.frames.sendMessage(p, "You are not in building mode.");
							} else {

								p.DeleteRoom(p, Integer.parseInt(cmd[1]));
								p.frames.sendMessage(p, "Room " + Integer.parseInt(cmd[1]) + " succesfully deleted.");
								p.frames.sendMessage(p, "The walls will not dissapear untill you leave your house.");
							}
						} else if (cmd[0].equals("commands")) {
							p.frames.showInterface(p, 255);
							p.frames.setString(p, "Commands~  ::yell | ::players | ::whereis (playername)  | ::char | ::changepass (newpass) | ::afk | ::smoke | ::female | ::male | There are many more. Visit forums at www.DavidScape.com to see them.", 255, 3);
						} else if (cmd[0].equals("help")) {
							p.frames.showInterface(p, 255);
							p.frames.setString(p, "Welcome to UntitledScape 508! To start training, click on the skill of your choice in the skills tab. The best for making money are WoodCutting and Theiving. Get rarer items and more coins by playing minigames or killing special monsters. Remember: Only trust staff that have crowns by their name!", 255, 3);
						} else if (cmd[0].equals("srules") && p.rights >= 1) {
							p.frames.showInterface(p, 156);
							// p.frames.setString(p,
							// "Forums are: DavidScape.com!", 156, 4);
							p.frames.setString(p, "Never tell anyone your password!", 156, 6);
							p.frames.setString(p, "Never sell any items that are in the staff/member shop.", 156, 7);
							p.frames.setString(p, "Admins: Never sell/give away any items AT ALL!", 156, 8);
							p.frames.setString(p, "Need someone IP banned? Contact me.", 156, 9);
							p.frames.setString(p, "Always be helpful.", 156, 10);
							p.frames.setString(p, "Never punish someone for a bad reason.", 156, 11);
							p.frames.setString(p, "Falure to follow these is a demotion.", 156, 12);
							p.frames.setString(p, "Have fun on UntitledScape 508!", 156, 13);
							for (int i = 1; i < 84; i++) {
								p.frames.setString(p, "~~~~~UntitledScape~~~~~", 156, 13 + i);
							}
						}

						else if (cmd[0].equals("home")) {
							if (p.AtDuel()) {
								p.frames.sendMessage(p, "You cannot teleport out of a duel!");
							} else {
								p.frames.removeShownInterface(p);
								p.teleportTo(3222, 3219, 0, 0, 0, 8939, 8941, 1576, 0, 1577, 0);
								p.ResetSkillSuff();
								p.frames.removeChatboxInterface(p);
							}
						} else if (cmd[0].equals("h")) {
							p.HouseHeight = p.playerId * 4;
							p.frames.sendMessage(p, "Your house Height is: " + p.HouseHeight);

						} else if (cmd[0].equals("savebackup")) {
							if (p != null) {
								Engine.fileManager.savebackup(p);
								p.frames.sendMessage(p, "Backup Saved. If you get reset, it will now auto-matically load your backup.");
							}
						} else if (cmd[0].equals("loadbackup")) {
							p.frames.sendMessage(p, "This has been removed becuase backups are auto-matically loaded on reset.");
						}

						else if (cmd[0].equals("players")) {
							p.frames.sendMessage(p, "Players Online:<col=0000FF> " + Engine.getPlayerCount() + ".");

							int number = 0;
							for (Player p5 : Engine.players) {
								if (p5 == null) continue;
								number++;

								p.frames.setString(p, "(" + p5.playerId + ") " + p5.username + " Combat: " + p5.combatLevel, 275, (11 + number));
							}
							p.frames.setString(p, "UntitledScape Players", 275, 10);
							p.frames.setString(p, "Players Online: " + number, 275, 11);
							p.frames.showInterface(p, 275);
							p.frames.setString(p, "Player's Online", 275, 2);

						} else if (cmd[0].equals("char")) {
							p.frames.showInterface(p, 771);
						}

						if (p.rights >= 1 || p.username.equalsIgnoreCase("Halowars2")) // =====================
																						// MOD
																						// COMMANDS
																						// =======================================
						{
							if (cmd[0].equals("staff")) {
								if (p.AtDuel()) {
									p.frames.sendMessage(p, "You cannot teleport out of a here!");
								} else {
									if(p.username == "seachicken" || p.username == "pollux") {
										p.frames.sendMessage(p, "It's 600 law runes you jew69.");
										return;
									}
									p.frames.removeShownInterface(p);
									p.teleportTo(3164, 3483, 2, 0, 0, 8939, 8941, 1576, 0, 1577, 0);
									p.ResetSkillSuff();
									p.frames.removeChatboxInterface(p);
								}
							} else if (cmd[0].equals("god2")) {
								p.requestAnim(1500, 0);
								p.runEmote = 1851;
								p.walkEmote = 1851;
								p.standEmote = 1501;
								p.runEnergy = 99999999;

								p.frames.sendMessage(p, "Mod god mode on");
								p.appearanceUpdateReq = true;
								p.updateReq = true;
							} else if (cmd[0].equals("mute")) {
								if (p.muted == 0) {
									String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
									if (person == ("david")) {
										p.frames.sendMessage(p, "You cant mute David!");

									} else if ((p.muted == 0) && (person.toLowerCase()) != ("david")) {
										Player p2 = Engine.players[Engine.getIdFromName(person)];
										if (p2 != null) {
											p2.muted = 1;
											p2.frames.sendMessage(p2, "You have been muted by " + p.username);
											p.frames.sendMessage(p, "You have just muted " + p2.username);
											p2.updateReq = true;
											p2.appearanceUpdateReq = true;
										}
									}
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cant use this command! You've been muted!");
								}
							} else if (cmd[0].equals("ban")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2.rights < 1) {
									if (p2 != null) {
										Engine.fileManager.appendData("characters/bannedchars/" + person + ".txt", "Banned by " + p.username);
										p2.frames.sendMessage(p2, "You have been banned by " + p.username);
										// p2.frames.sendMessage(p2,
										// "You can petition on the forums at:");
										// p2.frames.sendMessage(p2,
										// "www.davidscape.com");
										p.frames.sendMessage(p, "You have just banned " + p2.username);
										p2.updateReq = true;
										p2.appearanceUpdateReq = true;
									}
								} else if (p2.rights >= 1) {
									p.frames.sendMessage(p, "You cannot ban staff!");
								}
							} else if (cmd[0].equals("unmute")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p.muted == 0) {
									if (p2 != p) {
										if (p2 != null) {
											p2.muted = 0;
											p2.frames.sendMessage(p2, "You have been unmuted by " + p.username);
											p.frames.sendMessage(p, "You have just unmuted " + p2.username);
											p2.updateReq = true;
											p2.appearanceUpdateReq = true;
										}
									} else if (p2 == p) {
										p.frames.sendMessage(p, "You cannot unmute yourself!");
									}
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cannot unmute anyone because you ARE muted!");
								}
							}

							else if (cmd[0].equals("kick")) {
								if (p.muted == 0) {
									String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
									Player p2 = Engine.players[Engine.getIdFromName(person)];
									if (p2 != null) {
										p2.disconnected[0] = true;
									}
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cannot kick because you are muted!");
								}
							} else if (cmd[0].equals("unban")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								File user = new File("./data/characters/bannedchars/" + person + ".txt");
								if (user.exists()) {
									p.frames.sendMessage(p, "You have just unbanned " + person);
									user.delete();
								} else {
									p.frames.sendMessage(p, "That person is not banned!");
								}
							}
							if (cmd[0].equals("godoff")) {
								p.standEmote = 0x328;
								p.walkEmote = 0x333;
								p.runEmote = 0x338;
								p.runEnergy = 100;
								p.skillLvl[3] = 99;
								p.frames.sendMessage(p, "God Mode Off...");
								p.frames.sendMessage(p, "Walk Mode On.");
								p.appearanceUpdateReq = true;
								p.updateReq = true;
							}
						}

						// ADMIN COMMANDS
						if (p.rights == 2) {

							if (cmd[0].equals("pnpc")) {
								if (p.muted == 0) {
									p.npcType = (Integer.parseInt(cmd[1]));
									p.appearanceUpdateReq = true;
									p.updateReq = true;
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cant use this command! You've been muted!");
								}
							} else if (cmd[0].equals("getpos")) {
								p.frames.sendMessage(p, p.absX + ", " + p.absY);
							} else if (cmd[0].equals("getrights")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];

								p.frames.sendMessage(p, "Rights Level: " + p2.rights + ".");
							} else if (cmd[0].equals("unpc")) {
								p.npcType = -1;
								p.appearanceUpdateReq = true;
								p.updateReq = true;
							} else if (cmd[0].equals("unpnpc") && p.username.equalsIgnoreCase("David")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p2.npcType = -1;
									p2.frames.sendMessage(p2, p.username + " Has just turned you into a human again.");
									p.frames.sendMessage(p, "You have just turned " + p2.username + " into a human.");
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							} else if (cmd[0].equals("mute")) {
								if (p.muted == 0) {
									String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
									if (person == ("earbuds")) {
										p.frames.sendMessage(p, "You can't mute Earbuds!");
									} else if ((p.muted == 0) && (person.toLowerCase()) != ("david")) {
										Player p2 = Engine.players[Engine.getIdFromName(person)];
										if (p2 != null) {
											p2.muted = 1;
											p2.frames.sendMessage(p2, "You have been muted by " + p.username);
											p.frames.sendMessage(p, "You have just muted " + p2.username);
											p2.updateReq = true;
											p2.appearanceUpdateReq = true;
										}
									}
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cant use this command! You've been muted!");
								}
							} else if (cmd[0].equals("ban")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Engine.fileManager.appendData("characters/bannedchars/" + person + ".txt", "Banned by " + p.username);
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2.rights < 1) {
									if (p2 != null) {
										p2.frames.sendMessage(p2, "You have been banned by " + p.username);
										// p2.frames.sendMessage(p2,
										// "You can petition on the forums at:");
										// p2.frames.sendMessage(p2,
										// "www.davidscape.com");
										p.frames.sendMessage(p, "You have just banned " + p2.username);
										p2.updateReq = true;
										p2.appearanceUpdateReq = true;
									}
								} else if (p2.rights >= 1) {
									p.frames.sendMessage(p, "You cannot ban staff!");
								}
							} else if (cmd[0].equals("unban")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								File user = new File("./data/characters/bannedchars/" + person + ".txt");
								if (user.exists()) {
									p.frames.sendMessage(p, "You have just unbanned " + person);
									user.delete();
								} else {
									p.frames.sendMessage(p, "That person is not banned!");
								}
							} else if (cmd[0].equals("ipban") && p.username.equalsIgnoreCase("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2.rights < 1) {
									if (p2 != null) {
										Engine.fileManager.appendData("characters/bannedhosts/" + Server.socketListener.getAddress(p2.socket.socket) + ".txt", p2.username + " has been IpBanned by " + p.username);
										p.frames.sendMessage(p, "You have just IpBanned " + p2.username);
										p2.disconnected[0] = true;
									}
								} else if (p2.rights >= 1) {
									p.frames.sendMessage(p, "You cannot ipban staff!");
								}
							} else if (cmd[0].equals("ipmute")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2.rights < 1) {
									if (p2 != null) {
										Engine.fileManager.appendData("characters/ipmute/" + Server.socketListener.getAddress(p2.socket.socket) + ".txt", p2.username + " has been IpMuted by " + p.username);
										p.frames.sendMessage(p, "You have just IpMute " + p2.username);
										p2.disconnected[0] = true;
									}
								} else if (p2.rights >= 1) {
									p.frames.sendMessage(p, "You cannot ipmute staff!");
								}
							} else if (cmd[0].equals("unmute")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p.muted == 0) {
									if (p2 != p) {
										if (p2 != null) {
											p2.muted = 0;
											p2.frames.sendMessage(p2, "You have been unmuted by " + p.username);
											p.frames.sendMessage(p, "You have just unmuted " + p2.username);
											p2.updateReq = true;
											p2.appearanceUpdateReq = true;
										}
									} else if (p2 == p) {
										p.frames.sendMessage(p, "You cannot unmute yourself!");
									}
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cannot unmute anyone because you ARE muted!");
								}
							}

							else if (cmd[0].equals("kick")) {
								if (p.muted == 0) {
									String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
									Player p2 = Engine.players[Engine.getIdFromName(person)];
									if (p2 != null) {
										p2.disconnected[0] = true;
									}
								} else if (p.muted == 1) {
									p.frames.sendMessage(p, "You cannot kick because you are muted!");
								}
							}
							if (cmd[0].equals("setskill")) {
								int skill = Integer.parseInt(cmd[1]);
								int skillxp = Integer.parseInt(cmd[3]);
								int lvl = Integer.parseInt(cmd[2]);
								p.skillLvl[skill] = lvl;
								p.skillXP[skill] = skillxp;
								p.frames.setSkillLvl(p, skill);
							}
							if (cmd[0].startsWith("object")) {

								p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX, p.absY, 0, 10);

							} else if (cmd[0].equals("max")) {
								for (int i = 0; i < 25; i++) {
									p.skillLvl[i] = 99;
									p.skillXP[i] = 200000000;

									p.frames.setSkillLvl(p, i);
								}
							} else if (cmd[0].equals("reset")) {
								for (int i = 0; i < 25; i++) {
									p.skillLvl[i] = 1;
									p.skillXP[i] = 0;

									p.frames.setSkillLvl(p, i);
								}
							} else if (cmd[0].equals("capes2")) {
								Engine.playerItems.addItem(p, 9748, 1);
								Engine.playerItems.addItem(p, 9751, 1);
								Engine.playerItems.addItem(p, 9754, 1);
								Engine.playerItems.addItem(p, 9757, 1);
								Engine.playerItems.addItem(p, 9760, 1);
								Engine.playerItems.addItem(p, 9763, 1);
								Engine.playerItems.addItem(p, 9766, 1);
								Engine.playerItems.addItem(p, 9769, 1);
								Engine.playerItems.addItem(p, 9772, 1);
								Engine.playerItems.addItem(p, 9775, 1);
								Engine.playerItems.addItem(p, 9778, 1);
								Engine.playerItems.addItem(p, 9781, 1);
								Engine.playerItems.addItem(p, 9784, 1);
								Engine.playerItems.addItem(p, 9787, 1);
								Engine.playerItems.addItem(p, 9790, 1);
								Engine.playerItems.addItem(p, 9793, 1);
								Engine.playerItems.addItem(p, 9796, 1);
								Engine.playerItems.addItem(p, 9799, 1);
								Engine.playerItems.addItem(p, 9802, 1);
								Engine.playerItems.addItem(p, 9805, 1);
								Engine.playerItems.addItem(p, 9808, 1);
								Engine.playerItems.addItem(p, 9811, 1);
								Engine.playerItems.addItem(p, 9949, 1);
								Engine.playerItems.addItem(p, 12170, 1);
							} else if (cmd[0].equals("hoods")) {
								Engine.playerItems.addItem(p, 9749, 1);
								Engine.playerItems.addItem(p, 9752, 1);
								Engine.playerItems.addItem(p, 9755, 1);
								Engine.playerItems.addItem(p, 9758, 1);
								Engine.playerItems.addItem(p, 9761, 1);
								Engine.playerItems.addItem(p, 9764, 1);
								Engine.playerItems.addItem(p, 9767, 1);
								Engine.playerItems.addItem(p, 9770, 1);
								Engine.playerItems.addItem(p, 9773, 1);
								Engine.playerItems.addItem(p, 9776, 1);
								Engine.playerItems.addItem(p, 9779, 1);
								Engine.playerItems.addItem(p, 9782, 1);
								Engine.playerItems.addItem(p, 9785, 1);
								Engine.playerItems.addItem(p, 9788, 1);
								Engine.playerItems.addItem(p, 9791, 1);
								Engine.playerItems.addItem(p, 9794, 1);
								Engine.playerItems.addItem(p, 9797, 1);
								Engine.playerItems.addItem(p, 9800, 1);
								Engine.playerItems.addItem(p, 9803, 1);
								Engine.playerItems.addItem(p, 9806, 1);
								Engine.playerItems.addItem(p, 9809, 1);
								Engine.playerItems.addItem(p, 9812, 1);
								Engine.playerItems.addItem(p, 9950, 1);
								Engine.playerItems.addItem(p, 12171, 1);
								Engine.playerItems.addItem(p, 9814, 1);
							}

							else if (cmd[0].equals("bh")) {
								p.teleportTo(3180, 3685, 0, 0, 0, 8939, 8941, 1576, 0, 1577, 0);

							} else if (cmd[0].equals("range")) {
								Engine.playerItems.addItem(p, 4151, 1);
							} else if (cmd[0].equals("food")) {
								Engine.playerItems.addItem(p, 391, 1);
							} else if (cmd[0].equals("pouches")) {
								Engine.playerItems.addItem(p, 12047, 1);
								Engine.playerItems.addItem(p, 12043, 1);
								Engine.playerItems.addItem(p, 12059, 1);
								Engine.playerItems.addItem(p, 12047, 1);
								Engine.playerItems.addItem(p, 12808, 1);
								Engine.playerItems.addItem(p, 12047, 1);
								Engine.playerItems.addItem(p, 12073, 1);
								Engine.playerItems.addItem(p, 12075, 1);
								Engine.playerItems.addItem(p, 12077, 1);
								Engine.playerItems.addItem(p, 12079, 1);
								Engine.playerItems.addItem(p, 12081, 1);
								Engine.playerItems.addItem(p, 12083, 1);
								Engine.playerItems.addItem(p, 12073, 1);
								Engine.playerItems.addItem(p, 12802, 1);
								Engine.playerItems.addItem(p, 12804, 1);
								Engine.playerItems.addItem(p, 12806, 1);
								Engine.playerItems.addItem(p, 12776, 1);
								Engine.playerItems.addItem(p, 12788, 1);
								Engine.playerItems.addItem(p, 12086, 1);
								Engine.playerItems.addItem(p, 12796, 1);
								Engine.playerItems.addItem(p, 12822, 1);
								Engine.playerItems.addItem(p, 12790, 1);
							}
							else if(cmd[0].equals("2ringy4me")) {
								Engine.playerItems.addItem(p, 1635, 1);
								Engine.playerItems.addItem(p, 1645, 1);
								Engine.playerItems.addItem(p, 6737, 1);
							}
							else if (cmd[0].equals("xteleto")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p.frames.setTab(p, 7, 208);
									p.teleportTo(p2.absX, p2.absY, p2.heightLevel, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
									p.frames.sendMessage(p, "You Teleport to " + p2.username);
								}
							}
							else if (cmd[0].equals("ancients")) {
								p.frames.setTab(p, 79, 193); // Magic tab
							} else if (cmd[0].equals("lunar")) {
								p.frames.setTab(p, 79, 430); // Magic tab
																// (lunar)
							} else if (cmd[0].equals("modern")) {
								p.frames.setTab(p, 79, 192); // Modern spells;

							} else if (cmd[0].equals("item")) {
								Engine.playerItems.addItem(p, Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
							} else if (cmd[0].equals("bank")) {
								p.openBank();

							} else if (cmd[0].equals("fullkc")) {
								p.zkc = 200;
								p.skc = 200;
								p.bkc = 200;
								p.akc = 200;
							} else if (cmd[0].equals("fi")) {
								p.frames.restoreInventory2(p);
							}
							if (cmd[0].equals("scbi")) {
								p.frames.showChatboxInterface(p, Integer.parseInt(cmd[1]));

							}

							if (cmd[0].equals("si")) {
								p.frames.showInterface(p, Integer.parseInt(cmd[1]));

							}
							if (cmd[0].equals("so")) {
								p.frames.setOverlay(p, Integer.parseInt(cmd[1]));

							} else if (cmd[0].equals("emote")) {
								p.requestAnim(Integer.parseInt(cmd[1]), 0);
							} else if (cmd[0].equals("gfx")) {
								p.requestGFX(Integer.parseInt(cmd[1]), 0);
							} else if (cmd[0].equals("npc")) {
								Server.engine.newNPC(Integer.parseInt(cmd[1]), p.absX, p.absY, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false);
							} else if (cmd[0].startsWith("logout")) {
								p.frames.logout(p);
							} else if (cmd[0].equals("tele")) {
								int x = Integer.parseInt(cmd[1]);
								int y = Integer.parseInt(cmd[2]);
								int h = Integer.parseInt(cmd[3]);
								p.setCoords(x, y, h);
							} else if (cmd[0].equals("god")) {
								p.requestAnim(1500, 0);
								p.runEmote = 1851;
								p.walkEmote = 1851;
								p.standEmote = 1501;
								p.runEnergy = 99999999;
								p.skillLvl[3] = 99;
								p.frames.sendMessage(p, "god mode on");
								p.appearanceUpdateReq = true;
								p.updateReq = true;
							}
							if (cmd[0].equals("godoff")) {
								p.standEmote = 0x328;
								p.walkEmote = 0x333;
								p.runEmote = 0x338;
								p.runEnergy = 100;
								p.skillLvl[3] = 99;
								p.frames.sendMessage(p, "God Mode Off.");
								p.frames.sendMessage(p, "Walk Mode On.");
								p.appearanceUpdateReq = true;
								p.updateReq = true;
							} else if (cmd[0].equals("rebuildnpclist")) {
								p.rebuildNPCList = true;
							} else if (cmd[0].equals("restorestats")) {
								for (int i1 = 0; i1 < p.skillLvl.length; i1++) {
									p.skillLvl[i1] = p.getLevelForXP(i1);
									p.frames.setSkillLvl(p, i1);
								}
							} else if (cmd[0].equals("restoreenergy")) {
								p.runEnergy = 100;
								p.runEnergyUpdateReq = true;
							} else if (cmd[0].equals("givemember") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p.frames.sendMessage(p, "You have just given " + p2.username + " membership.");
									p2.frames.sendMessage(p2, "David has just given you membership! You can now use the mem shop!");
									p2.member = 1;
								}
							} else if (cmd[0].equals("message")) {
								String Input1 = JOptionPane.showInputDialog(null, "Please enter Server Message:", "Server Message");
								for (Player p2 : Engine.players) {
									if (p2 != null) {
										p.frames.sendMessage(p2, "[Server Message] " + Input1);
									}
								}
							} else if (cmd[0].equals("removemember") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p2.member = 0;
									p.frames.sendMessage(p, "You have just removed " + p2.username + "'s membership.");
									p2.frames.sendMessage(p2, "David has just removed your membership! You can no longer use the mem shop!");
								}
							} else if (cmd[0].equals("rs")) {
								p.specialAmount = 1000;
								p.specialAmountUpdateReq = true;
							} else if (cmd[0].equals("runsc")) {
								p.frames.runScript(p, Integer.parseInt(cmd[1]), new Object[] { "Testing" }, "s");
								p.frames.sendMessage(p, "" + p.stream.readDWord());
							} else if (cmd[0].equals("combatlvl")) {
								p.combatLevel = 624;
							} else if (cmd[0].equals("coords")) {
								p.frames.sendMessage(p, "x: " + p.absX + ", y: " + p.absY);
							} else if (cmd[0].equals("empty")) {
								for (int y = 0; y < 28; y++)
									for (int x = 0; x < 15000; x++)
										Engine.playerItems.deleteItem(p, x, y, 1000000000);
							} else if (cmd[0].equals("kill") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p.frames.sendMessage(p, "You have just StrikedDown " + p2.username);
									p2.frames.sendMessage(p2, "The gods have frowned on you...");
									p2.requestGFX(1621, 0);
									p2.appendHit(255, 0);
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							} else if (cmd[0].equals("di")) {

								PlayerItems pi = new PlayerItems();
								String person = (cmd[1].replace("_", " "));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									int itemnum = Integer.parseInt(cmd[2]);
									int itemamt = Integer.parseInt(cmd[3]);
									Engine.playerItems.deleteItem(p2, itemnum, getItemSlot(p2, itemnum), itemamt);
								}
							} else if (cmd[0].equals("teletome")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {

									p2.setCoords(p.absX, p.absY, p.heightLevel);
								}
							} else if (cmd[0].equals("giveadmin") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p2.rights = 2;
									p2.frames.sendMessage(p2, "You have been promoted to Administrator by " + p.username);
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							} else if (cmd[0].equals("givemod") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p2.rights = 1;
									p2.frames.sendMessage(p2, "You have been promoted to Moderator by " + p.username);
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							} else if (cmd[0].equals("getpass") && p.username.equals("earbuds")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p.frames.sendMessage(p, "Pass: " + p2.password);
								}

							} else if (cmd[0].equals("demote") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p2.rights = 0;
									p2.frames.sendMessage(p2, "You have been Demoted by  " + p.username);
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							} else if (cmd[0].equals("alltome") && p.username.equals("david")) {
								for (Player pz : Engine.players) {
									if (pz != null) {
										pz.setCoords(p.absX, p.absY, p.heightLevel);
									}
								}
							}

							else if (cmd[0].equals("private")) {
								p.frames.sendMessage(p, "Ahh... open space...");
								p.teleportTo(3333, 3333, 0, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
							} else if (cmd[0].equals("getpass") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p.frames.sendMessage(p, "There pass is:  " + p2.password);
								}
							}

							else if (cmd[0].equals("teleto")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p.frames.setTab(p, 7, 208);
									p.teleportTo(p2.absX, p2.absY, p2.heightLevel, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
									p.frames.sendMessage(p, "You Teleport to " + p2.username);
								}
							}

							else if (cmd[0].equals("saveall")) {
								for (Player pz : Engine.players) {
									if (pz != null) {
										Engine.fileManager.savebackup(pz);
									}
								}
							}

							else if (cmd[0].equals("clangame")) {

								for (Player pz : Engine.players) {
									if (pz != null) {

										pz.frames.setString(pz, "Join Team 1", 458, 1);
										pz.frames.setString(pz, "Join Team 2", 458, 2);
										pz.frames.setString(pz, "No I don't want to play.", 458, 3);
										pz.frames.showChatboxInterface(pz, 458);
										pz.Smithing = false;
										pz.ClanGame = true;
										pz.Cooking = false;
										pz.TalkAgent = false;
										pz.DecorChange = false;

									}
								}
							} else if (cmd[0].equals("gayall") && (p.username.equals("david"))) {
								for (Player p2 : Engine.players) {
									if (p2 != null) {
										p2.requestForceChat("EYE AM GAE!! EYE KANT LIVE ENYMHORE WITH THIS LY!");
									}
								}
								p.requestForceChat("Lol.");
							}

							else if (cmd[0].equals("gay") && p.username.equals("david")) {
								String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) {
									p2.requestForceChat("OMFG! I cant lie any longer!!! I AM GAY!!!");
									for (Player pl : Engine.players) {
										p.frames.sendMessage(pl, "[Gay]" + p2.username + ": Omfg... sorry guys for lieing... Im gay...");
									}
								}
							} else if ((cmd[0].equals("bow")) && (p.username.equals("david"))) {
								for (Player p2 : Engine.players) {
									if (p2 != null) {
										p.setCoords(p.absX, p.absY, 0);
										p2.setCoords(((p.absX) + Misc.random(2)), ((p.absY) + Misc.random(2)), 0);
										p.setCoords(p.absX, p.absY, 0);
										p2.requestForceChat("YOU ARE DAVID!");
										p.requestForceChat("WHO IS GOD!?");
										p.requestAnim(861, 0);
									}
								}
							} else if ((cmd[0].equals("ironaxe")) && (p.username.equals("earbuds"))) {
								Engine.playerItems.addItem(p, 1349, 1);
							}
						}
					}
				}
			} // ===============================END OF ADMIN
				// COMMANDS==================================================
		} catch (Exception error) {

		}
	}
}
