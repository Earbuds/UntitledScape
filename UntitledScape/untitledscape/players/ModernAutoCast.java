/*
 * Class ModernAutoCast
 *
 * Version 3.0
 *
 * Thursday, 4 December, 2008
 *
 * Created by Prima
 */

package untitledscape.players;

import untitledscape.Engine;
import untitledscape.Server;
import untitledscape.players.*;
import untitledscape.util.Misc;

public class ModernAutoCast {
Player p2 = Server.engine.players[p.enemyIndex];

	/**
	 * Constructor
	 */
	public ModernAutoCast(Player p) {
		this.p = p;
	}

	public void autoCastDamage() {
		
		int mA = getRandom(magicAttack());
		int mD = getRandom(magicDefence());

		if (p == null || p2 == null) {
			resetModernMagic();
			return;
		}

		if (p.modernDamageDelay == 0) {
			switch (p.modernSpell) {

				case 1: // Water strike
					if (mA >= mD) {
						p2.requestGFX(92, 100);
						p2.appendHit(getRandom(2), 0);
						p.frames.playSound(p2, 221, 1, 0);
						p.frames.playSound(p, 221, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 2: // Water strike
					if (mA >= mD) {
						p2.requestGFX(95, 100);
						p2.appendHit(getRandom(4), 0);
						p.frames.playSound(p2, 212, 1, 0);
						p.frames.playSound(p, 212, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 3: // Earth strike
					if (mA >= mD) {
						p2.requestGFX(98, 100);
						p2.appendHit(getRandom(6), 0);
						p.frames.playSound(p2, 133, 1, 0);
						p.frames.playSound(p, 133, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 4: // Fire strike
					if (mA >= mD) {
						p2.requestGFX(101, 100);
						p2.appendHit(getRandom(8), 0);
						p.frames.playSound(p2, 161, 1, 0);
						p.frames.playSound(p, 161, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 5: // Wind bolt
					if (mA >= mD) {
						p2.requestGFX(119, 100);
						p2.appendHit(getRandom(9), 0);
						p.frames.playSound(p2, 219, 1, 0);
						p.frames.playSound(p, 219, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 6: // Water bolt
					if (mA >= mD) {
						p2.requestGFX(122, 100);
						p2.appendHit(getRandom(10), 0);
						p.frames.playSound(p2, 210, 1, 0);
						p.frames.playSound(p, 210, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 7: // Earth bolt
					if (mA >= mD) {
						p2.requestGFX(125, 100);
						p2.appendHit(getRandom(11), 0);
						p.frames.playSound(p2, 131, 1, 0);
						p.frames.playSound(p, 131, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 8: // Fire bolt
					if (mA >= mD) {
						p2.requestGFX(128, 100);
						p2.appendHit(getRandom(12), 0);
						p.frames.playSound(p2, 158, 1, 0);
						p.frames.playSound(p, 158, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 9: // Wind blast
					if (mA >= mD) {
						p2.requestGFX(134, 100);
						p2.appendHit(getRandom(13), 0);
						p.frames.playSound(p2, 217, 1, 0);
						p.frames.playSound(p, 217, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 10: // Water blast
					if (mA >= mD) {
						p2.requestGFX(137, 100);
						p2.appendHit(getRandom(14), 0);
						p.frames.playSound(p2, 208, 1, 0);
						p.frames.playSound(p, 208, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 11: // Earth blast
					if (mA >= mD) {
						p2.requestGFX(140, 100);
						p2.appendHit(getRandom(15), 0);
						p.frames.playSound(p2, 129, 1, 0);
						p.frames.playSound(p, 129, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 12: // Fire blast
					if (mA >= mD) {
						p2.requestGFX(131, 100);
						p2.appendHit(getRandom(16), 0);
						p.frames.playSound(p2, 156, 1, 0);
						p.frames.playSound(p, 156, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 13: // Wind wave
					if (mA >= mD) {
						p2.requestGFX(160, 100);
						p2.appendHit(getRandom(17), 0);
						p.frames.playSound(p2, 223, 1, 0);
						p.frames.playSound(p, 223, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 14: // Water wave
					if (mA >= mD) {
						p2.requestGFX(163, 100);
						p2.appendHit(getRandom(18), 0);
						p.frames.playSound(p2, 214, 1, 0);
						p.frames.playSound(p, 214, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 15: // Earth wave
					if (mA >= mD) {
						p2.requestGFX(166, 100);
						p2.appendHit(getRandom(19), 0);
						p.frames.playSound(p2, 163, 1, 0);
						p.frames.playSound(p, 163, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;

				case 16: // Fire wave
					if (mA >= mD) {
						p2.requestGFX(157, 100);
						p2.appendHit(getRandom(20), 0);
						p.frames.playSound(p2, 163, 1, 0);
						p.frames.playSound(p, 163, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
					} else {
						p2.requestAnim(p2.getBlockAnim1(), 0);
						p.frames.playSound(p2, 227, 1, 0);
						p.frames.playSound(p, 227, 1, 0);
						p2.requestGFX(85, 100);
					}
				break;
			}
			p.modernDamageDelay = -1;
		}
	}

	public void autoCastAttack() {
		

		if (p == null || p2 == null) {
			resetModernMagic();
			return;
		}

		int casterX = p.absX;
		int casterY = p.absY;
		int offsetY = (p.absY - p2.absY) * -1;
		int offsetX = (p.absX - p2.absX) * -1;
		Server.engine.playerMovement.resetWalkingQueue(p);

		if (!Server.engine.wildernessArea(p2.absX, p2.absY) && !p2.duelFight()) {
			sendMessage(p, "You cannot attack other players in this area.");
			resetModernMagic();
			return;
		}
		if (!Server.engine.wildernessArea(p.absX, p.absY) && !p.duelFight()) {
			sendMessage(p, "You cannot attack other players in this area.");
			resetModernMagic();
			return;
		}
		if (Misc.getDistance(p.absX, p.absY, p2.absX, p.absY) > 8)
			return;

		p.requestFaceTo(p2.playerId + 32768);

		switch (p.modernSpell) {

			case 16: //Fire wave Autocasting
                        if (hasItem(p, 565, 1) && hasItem(p, 556, 5) && hasItem(p, 554, 7)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 565, 1, 556, 5, 554, 7);
				p.frames.playSound(p2, 162, 1, 0);
				p.frames.playSound(p, 162, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 1167, 155, 100, 156, 5, p2.playerId, 3);
p2.requestGFX(157, 100);
						p2.appendHit(getRandom(20), 0);
						p.frames.playSound(p2, 163, 1, 0);
						p.frames.playSound(p, 163, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 15: //Earth wave Autocasting
                        if (hasItem(p, 565, 1) && hasItem(p, 556, 5) && hasItem(p, 557, 7)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 565, 1, 556, 5, 557, 7);
				p.frames.playSound(p2, 134, 1, 0);
				p.frames.playSound(p, 134, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 1167, 164, 100, 165, 5, p2.playerId, 3);
p2.requestGFX(166, 100);
						p2.appendHit(getRandom(19), 0);
						p.frames.playSound(p2, 163, 1, 0);
						p.frames.playSound(p, 163, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 14: //Water wave Autocasting
                        if (hasItem(p, 565, 1) && hasItem(p, 556, 5) && hasItem(p, 555, 7)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 565, 1, 556, 5, 554, 7);
				p.frames.playSound(p2, 213, 1, 0);
				p.frames.playSound(p, 213, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 1167, 161, 100, 162, 5, p2.playerId, 3);
p2.requestGFX(163, 100);
						p2.appendHit(getRandom(18), 0);
						p.frames.playSound(p2, 214, 1, 0);
						p.frames.playSound(p, 214, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 13: //Wind wave Autocasting
                        if (hasItem(p, 565, 1) && hasItem(p, 556, 5)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 565, 1, 556, 5);
				p.frames.playSound(p2, 222, 1, 0);
				p.frames.playSound(p, 222, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 1167, 158, 100, 159, 5, p2.playerId, 3);
p2.requestGFX(160, 100);
						p2.appendHit(getRandom(17), 0);
						p.frames.playSound(p2, 223, 1, 0);
						p.frames.playSound(p, 223, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 12: //Fire blast Autocasting
                        if (hasItem(p, 560, 1) && hasItem(p, 556, 4) && hasItem(p, 554, 5)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 560, 1, 556, 4, 554, 5);
				p.frames.playSound(p2, 155, 1, 0);
				p.frames.playSound(p, 155, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 129, 100, 130, 5, p2.playerId, 3);
p2.requestGFX(131, 100);
						p2.appendHit(getRandom(16), 0);
						p.frames.playSound(p2, 156, 1, 0);
						p.frames.playSound(p, 156, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 11: //Earth blast Autocasting
                        if (hasItem(p, 560, 1) && hasItem(p, 556, 3) && hasItem(p, 557, 4)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 560, 1, 556, 3, 557, 4);
				p.frames.playSound(p2, 128, 1, 0);
				p.frames.playSound(p, 128, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 138, 100, 139, 5, p2.playerId, 3);
p2.requestGFX(140, 100);
						p2.appendHit(getRandom(15), 0);
						p.frames.playSound(p2, 129, 1, 0);
						p.frames.playSound(p, 129, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 10: //Water blast Autocasting
                        if (hasItem(p, 560, 1) && hasItem(p, 556, 3) && hasItem(p, 555, 3)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 560, 1, 556, 3, 555, 3);
				p.frames.playSound(p2, 207, 1, 0);
				p.frames.playSound(p, 207, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 135, 100, 136, 5, p2.playerId, 3);
p2.requestGFX(137, 100);
						p2.appendHit(getRandom(14), 0);
						p.frames.playSound(p2, 208, 1, 0);
						p.frames.playSound(p, 208, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 9: //Wind blast Autocasting
                        if (hasItem(p, 560, 1) && hasItem(p, 556, 3)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 560, 1, 556, 3);
				p.frames.playSound(p2, 216, 1, 0);
				p.frames.playSound(p, 216, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 132, 100, 133, 5, p2.playerId, 3);
p2.requestGFX(137, 100);
						p2.appendHit(getRandom(14), 0);
						p.frames.playSound(p2, 208, 1, 0);
						p.frames.playSound(p, 208, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 8: //Fire bolt Autocasting
                        if (hasItem(p, 562, 1) && hasItem(p, 556, 2) && hasItem(p, 554, 3)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 562, 1, 556, 2, 554, 3);
				p.frames.playSound(p2, 157, 1, 0);
				p.frames.playSound(p, 157, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 126, 100, 127, 5, p2.playerId, 3);
p2.requestGFX(128, 100);
						p2.appendHit(getRandom(12), 0);
						p.frames.playSound(p2, 158, 1, 0);
						p.frames.playSound(p, 158, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 7: //Earth bolt Autocasting
                        if (hasItem(p, 562, 1) && hasItem(p, 556, 2) && hasItem(p, 557, 3)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 562, 1, 556, 2, 557, 3);
				p.frames.playSound(p2, 130, 1, 0);
				p.frames.playSound(p, 130, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 123, 100, 124, 5, p2.playerId, 3);
p2.requestGFX(125, 100);
						p2.appendHit(getRandom(11), 0);
						p.frames.playSound(p2, 131, 1, 0);
						p.frames.playSound(p, 131, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 6: //Water bolt Autocasting
                        if (hasItem(p, 562, 1) && hasItem(p, 556, 2) && hasItem(p, 555, 2)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 562, 1, 556, 2, 555, 2);
				p.frames.playSound(p2, 209, 1, 0);
				p.frames.playSound(p, 209, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 120, 100, 121, 5, p2.playerId, 3);
p2.requestGFX(122, 100);
						p2.appendHit(getRandom(10), 0);
						p.frames.playSound(p2, 210, 1, 0);
						p.frames.playSound(p, 210, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 5: //Wind bolt Autocasting
                        if (hasItem(p, 562, 1) && hasItem(p, 556, 2)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 562, 1, 556, 2);
				p.frames.playSound(p2, 218, 1, 0);
				p.frames.playSound(p, 218, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 117, 100, 118, 5, p2.playerId, 3);
p2.requestGFX(119, 100);
						p2.appendHit(getRandom(9), 0);
						p.frames.playSound(p2, 219, 1, 0);
						p.frames.playSound(p, 219, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 4: //Fire strike Autocasting
                        if (hasItem(p, 558, 1) && hasItem(p, 556, 2) && hasItem(p, 554, 3)) {
				p2.requestGFX(101, 100);
						p2.appendHit(getRandom(8), 0);
						p.frames.playSound(p2, 161, 1, 0);
						p.frames.playSound(p, 161, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 556, 2, 558, 1, 554, 3);
				p.frames.playSound(p2, 160, 1, 0);
				p.frames.playSound(p, 160, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 99, 100, 100, 5, p2.playerId, 3);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 3: //Earth strike Autocasting
                        if (hasItem(p, 558, 1) && hasItem(p, 556, 2) && hasItem(p, 557, 2)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 556, 1, 558, 1, 557, 2);
				p.frames.playSound(p2, 132, 1, 0);
				p.frames.playSound(p, 132, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 96, 100, 97, 5, p2.playerId, 3);
p2.requestGFX(98, 100);
						p2.appendHit(getRandom(6), 0);
						p.frames.playSound(p2, 133, 1, 0);
						p.frames.playSound(p, 133, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 2: //Water strike Autocasting
                        if (hasItem(p, 558, 1) && hasItem(p, 556, 1) && hasItem(p, 555, 1)) {
			p2.requestGFX(95, 100);
						p2.appendHit(getRandom(4), 0);
						p.frames.playSound(p2, 212, 1, 0);
						p.frames.playSound(p, 212, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);	
p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 556, 1, 558, 1, 555, 1);
				p.frames.playSound(p2, 211, 1, 0);
				p.frames.playSound(p, 211, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 93, 100, 94, 5, p2.playerId, 3);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

			case 1: //Wind strike Autocasting
                        if (hasItem(p, 558, 1) && hasItem(p, 556, 1)) {
				p.combatDelay = 6;
                                stopMovement(p);
                            	deleteItems(p, 556, 1, 558, 1);
				p.frames.playSound(p2, 220, 1, 0);
				p.frames.playSound(p, 220, 1, 0);
				ModernProjectile(casterX, casterY, offsetX, offsetY, 711, 90, 100, 91, 5, p2.playerId, 3);
p2.requestGFX(92, 100);
						p2.appendHit(getRandom(2), 0);
						p.frames.playSound(p2, 221, 1, 0);
						p.frames.playSound(p, 221, 1, 0);
						p2.requestAnim(p2.getBlockAnim1(), 0);
                        } else {
                            	sendMessage(p, "You dont have the required runes for this spell.");
                        }
			break;

		}
	}


    public static void ModernProjectile(int casterX, int casterY, int offsetX, int offsetY, int anim, int GFX, int graphicHeight,
							int projectileGFX, int delay, int enemyIndex, int damageDelay) {
		p.requestGFX(GFX, graphicHeight);
		p.requestAnim(anim, 0);
		p.modernMagicDelay = delay;
		p.modernDamageDelay = damageDelay;
		p.frames.addProjectile(p, casterY, casterX, offsetY, offsetX, 50, 100, projectileGFX, 46, 31, enemyIndex, true);
    }

    public static void deleteItems(Player p, int item1id, int item1amt, int item2id, int item2amt) {
        Engine.playerItems.deleteItem(p, item1id,
                Engine.playerItems.getItemSlot(p, item1id), item1amt);
        Engine.playerItems.deleteItem(p, item2id,
                Engine.playerItems.getItemSlot(p, item2id), item2amt);
    }

    public static void deleteItems(Player p, int item1id, int item1amt, int item2id, int item2amt, int item3id, int item3amt) {
        Engine.playerItems.deleteItem(p, item1id, Engine.playerItems.getItemSlot(p, item1id), item1amt);
        Engine.playerItems.deleteItem(p, item2id, Engine.playerItems.getItemSlot(p, item2id), item2amt);
        Engine.playerItems.deleteItem(p, item3id, Engine.playerItems.getItemSlot(p, item3id), item3amt);
    }

    public static boolean hasItem(Player p, int ItemId, int amt) {
        return Engine.playerItems.haveItem(p, ItemId, amt);
    }

    public static void sendMessage(Player p, String MSG) {
        p.frames.sendMessage(p, MSG);
    }

    public static void stopMovement(Player p) {
        Server.engine.playerMovement.resetWalkingQueue(p);
    }

    public void resetModernMagic() {
		p.combatDelay = 0;
		p.modernSpell = 0;
		p.usingAutoCast = false;
		p.modernMagicDelay = 0;
    }

    static Player p;

    public int getRandom(int range) {
        	return (int)(Math.random() * (range + 1));
    }

    public int magicAttack() {
	if (p == null) {
		return 0;
	}
	return (p.skillLvl[6] + p.equipmentBonus[3] + p.equipmentBonus[3]);
    }

    public int magicDefence() {
	Player p2 = Server.engine.players[p.enemyIndex];
	    if (p == null) {
		    return 0;
	    }
		    return (int)((p.skillLvl[1] / 2) + (p2.skillLvl[6] / 2) + p.equipmentBonus[8]);
    }
}