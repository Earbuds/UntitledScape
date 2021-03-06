package untitledscape.util;

import untitledscape.Engine;
import untitledscape.Server;
import untitledscape.players.Player;
import untitledscape.players.items.PlayerItems;

public class ShopHandler {

	private Player p;
	private PlayerItems pi = new PlayerItems();
	public int maxItems = 40;
	public int[] shop2 = { 590, 946, 1359, 1275, 12844, 301, 305, 307, 311, 11259 };
	public int[] shop2n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop2p = { 1, 1, 1, 1, 60, 1, 1, 1, 1, 1 };

	public int[] shop3 = { 1135, 1099, 1065, 2499, 2493, 2487, 2501, 2495, 2489, 2503, 2497, 2491, 10382, 10378, 10380, 10376, 10390, 10386, 10388, 10384, 10374, 10370, 10372, 10368, 2581, 2577, -1 };
	public int[] shop3n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop3p = { 10, 10, 10, 25, 25, 25, 40, 40, 40, 65, 65, 65, 80, 80, 80, 80, 30, 80, 80, 80, 80, 80, 80, 80, 95, 95, 0 };

	public int[] shop4 = { 11335, 11283, 11732, 3140, 4087, 1187, 4151, 391, 1305, 4587, 5698, 10828, 1149, 8850, 121, 113, 11758, 4675 };
	public int[] shop4n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop4p = { 1500, 3450, 350, 5000, 2500, 1350, 1600, 50, 95, 100, 100, 350, 500, 250, 35, 35, 500, 1250 };

	public int[] shop5 = { 1321, 1323, 1325, 1327, 1329, 1331, 1333, 1117, 1115, 1119, 1121, 1125, 1123, 1127, 1075, 1067, 1069, 1077, 1071, 1073, 1079, 1155, 1153, 1157, 1165, 1159, 1161, 1163, 1191, 1193, 1195, 1197, 1199, 1201 };
	public int[] shop5n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop5p = { 3, 5, 7, 10, 23, 35, 50, 3, 5, 7, 10, 23, 35, 50, 2, 3, 5, 8, 15, 30, 40, 1, 3, 5, 7, 13, 20, 30, 2, 4, 6, 12, 20, 30 };

	public int[] shop6 = { 1052, 6585, 775, 1837, 2643, 3061, 10075, 10065, 10067, 10069, 10071, 6568, 1704, 10402, 10406, 10748, 10750, 13192, 13190 };
	public int[] shop6n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop6p = { 10, 175, 5, 5, 50, 5, 5, 5, 5, 5, 5, 50, 25, 325, 350, 325, 350, 400, 400 };

	public int[] shop7 = { 1755, 1625, 1627, 1629, 1623, 1621, 1619, 1617, 1631, 6571, 1597, 1592, 1595, 11065, 7536, 7538 };
	public int[] shop7n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop7p = { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 5, 5, 5, 25, 25 };

	public int[] shop8 = { 4155, 13263, 13290, 7159, 4156, 4158, 4170, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	public int[] shop8n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop8p = { 1, 450, 150, 5, 40, 40, 190, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public int[] shop9 = { 1038, 1040, 1042, 1044, 1046, 1048, 1050, 1057, 1055, 1053, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	public int[] shop9n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop9p = { 990, 990, 990, 990, 990, 990, 990, 990, 990, 990, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public int[] shop10 = { 4708, 4712, 4714, 4710, 4716, 4720, 4722, 4718, 4724, 4728, 4730, 4726, 4730, 4734, 4736, 4732, 4745, 4749, 4751, 4747, 4753, 4757, 4759, 4755, 4740, 7462, 7461 };
	public int[] shop10n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop10p = { 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 2, 75, 40 };

	public int[] shop11 = { 12047, 12043, 12059, 12808, 12073, 12075, 12077, 12079, 12081, 12083, 12802, 12804, 12806, 12776, 12788, 12786, 12796, 12822, 12790, 12469, 12471, 12473, 12475, 12210, 12216, 12219, 12222 };
	public int[] shop11n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop11p = { 1, 2, 2, 3, 4, 4, 4, 5, 5, 7, 7, 8, 8, 9, 11, 12, 12, 12, 15, 700, 700, 700, 700, 100, 250, 500, 1000 };

	public int[] shop12 = { 13614, 13615, 13616, 13617, 13618, 13619, 13620, 13621, 13622, 13623, 13624, 13625, 13626, 13627, 13629, 13630, 13631, 13632, 13633, 13634, 13635, 13636, 13637, 13638, 13639, 13640, 13642 };
	public int[] shop12n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop12p = { 50, 50, 50, 50, 50, 150, 150, 150, 150, 150, 250, 250, 250, 250, 250, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };

	public int[] shop13 = { 7806, 7807, 7808, 7809, 6106, 6107, 6108, 6109, 6110, 6111, 4345, 6856, 6857, 6858, 6859, 6860, 6861, 6862, 6863, 8942, 3101, 1361, 1231, 1337, 4353, 1203, 4331 };
	public int[] shop13n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	public int[] shop13p = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 500, 500, 500, 500, 500, 500, 500 };

	public int[] shop14 = { 4566, 5553, 5554, 5555, 5556, 5557, 2653, 2655, 2657, 2659, 2661, 2663, 2665, 2667, 2669, 2671, 2673, 2675, 3481, 3483, 3486, 3488, 12222, 534, 3101, 1337, 1361 };
	public int[] shop14n = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 1, 5, 5 };
	public int[] shop14p = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100, 100, 500 };

	public int[] shop16 = { 8798, 8799, 8800, 8802, 8803 };
	public int[] shop16n = { 10, 10, 10, 10, 10 };
	public int[] shop16p = { 500, 500, 500, 500, 500 };
	
	public int[] items = new int[maxItems];
	public int[] itemsN = new int[maxItems];
	public int[] maxItemAmount = new int[maxItems];
	int shopid = 0;

	public ShopHandler() {

		for (int i = 0; i < 40; i++) {
			items[i] = -1;

		}

	}

	public long lastRestock = System.currentTimeMillis();

	public void process() {
		if (System.currentTimeMillis() - lastRestock >= 15000) {
			for (int i = 0; i < items.length; i++) {
				if (itemsN[i] < 100) itemsN[i]++;
			}
			lastRestock = System.currentTimeMillis();
		}
	}

	public boolean itemInList(int itemId, Player p) {
	if (itemId < 0) {
			return false;
		}
		switch (p.shopid) {
		case 2:
			for (int i = 0; i < shop2.length; i++) {
				if (shop2[i] != -1 && shop2[i] == itemId) {
					return true;
				}
			}
			break;
		case 3:
			for (int i = 0; i < shop3.length; i++) {
				if (shop3[i] != -1 && shop3[i] == itemId) {
					return true;
				}
			}
			break;
		case 4:
			for (int i = 0; i < shop4.length; i++) {
				if (shop4[i] != -1 && shop4[i] == itemId) {
					return true;
				}
			}
			break;
		case 5:
			for (int i = 0; i < shop5.length; i++) {
				if (shop5[i] != -1 && shop5[i] == itemId) {
					return true;
				}
			}
			break;
		case 6:
			for (int i = 0; i < shop6.length; i++) {
				if (shop6[i] != -1 && shop6[i] == itemId) {
					return true;
				}
			}
			break;
		case 7:
			for (int i = 0; i < shop7.length; i++) {
				if (shop7[i] != -1 && shop7[i] == itemId) {
					return true;
				}
			}
			break;
		case 8:
			for (int i = 0; i < shop8.length; i++) {
				if (shop8[i] != -1 && shop8[i] == itemId) {
					return true;
				}
			}
			break;
		case 9:
			for (int i = 0; i < shop9.length; i++) {
				if (shop9[i] != -1 && shop9[i] == itemId) {
					return true;
				}
			}
			break;
		case 10:
			for (int i = 0; i < shop10.length; i++) {
				if (shop10[i] != -1 && shop10[i] == itemId) {
					return true;
				}
			}
			break;
		case 11:
			for (int i = 0; i < shop11.length; i++) {
				if (shop11[i] != -1 && shop11[i] == itemId) {
					return true;
				}
			}
			break;
		case 12:
			for (int i = 0; i < shop12.length; i++) {
				if (shop12[i] != -1 && shop12[i] == itemId) {
					return true;
				}
			}
			break;
		case 13:
			for (int i = 0; i < shop13.length; i++) {
				if (shop13[i] != -1 && shop13[i] == itemId) {
					return true;
				}
			}
			break;
		case 14:
			for (int i = 0; i < shop14.length; i++) {
				if (shop14[i] != -1 && shop14[i] == itemId) {
					return true;
				}
			}
			break;
		case 16:
			for (int i = 0; i < shop16.length; i++) {
				if (shop16[i] != -1 && shop16[i] == itemId) {
					return true;
				}
			}
		}
		return false;
	}

	public void sell(Player p, int item, int amnt) {
		PlayerItems pi = new PlayerItems();
		boolean shopShouldBuy = isItemOnShop(item) || itemInList(item, p);
		if (!shopShouldBuy) {
			p.frames.sendMessage(p, "You cannot sell this item to this shop.");
			return;
		}
		if (item == 995) {
			p.frames.sendMessage(p, "You can't sell coins to a shop");
			return;
		}
		int free = findFreeSlot();
		if (!isItemOnShop(item)) {
			if (free == -1) {
				p.frames.sendMessage(p, "This shop is full.");
				return;
			}
			items[free] = item;
			itemsN[free] = 0;
		}
		int slot = findItemSlot(item);
		if (amnt <= pi.invItemCount(p, item)) {
			if (itemStacks(item)) {
				items[slot] = item;
				itemsN[slot] += amnt;

				pi.deleteItem(p, item, pi.getItemSlot(p, item), amnt);
				pi.addItem(p, 995, amnt * (int) (itemValue(item, p) * .75));
			} else {
				items[slot] = item;
				for (int notused = amnt; notused > 0; notused--) {
					pi.deleteItem(p, item, pi.getItemSlot(p, item), 1);
					pi.addItem(p, 995, (int) (itemValue(item, p) * .75));
					itemsN[slot]++;

				}
			}
		} else {
			amnt = pi.invItemCount(p, item);
			if (itemStacks(item)) {
				items[slot] = item;
				itemsN[slot] += amnt;
				pi.deleteItem(p, item, pi.getItemSlot(p, item), amnt);
				pi.addItem(p, 995, amnt * (int) (itemValue(item, p) * .75));
			} else {
				items[slot] = item;
				for (int notused = amnt; notused > 0; notused--) {
					pi.deleteItem(p, item, pi.getItemSlot(p, item), 1);
					pi.addItem(p, 995, (int) (itemValue(item, p) * .75));
					itemsN[slot]++;

				}
			}
		}

		sendShopItems(p);
		sendPlayerInventory(p);
	}

	public void buy(Player p, int item, int amnt) {
		clearSlots(p);
		int slot = findItemSlot(item);
		if (slot == -1) {
			return;
		}
		if (itemsN[slot] < amnt) amnt = itemsN[slot];
		if (amnt == 0) {
			itemsN[slot] = 0;

			p.frames.sendMessage(p, "That item's stock has run out.");
			return;
		}
		if (itemStacks(item)) {
			if (pi.freeSlotCount(p) < 1) {
				p.frames.sendMessage(p, "Not enough space on inventory");
				return;
			}
			if (pi.invItemCount(p, 995) < (amnt * itemValue(item, p))) {
				p.frames.sendMessage(p, "Not enough coins to buy that many.");
				return;
			}
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), amnt * itemValue(item, p));
			pi.addItem(p, item, amnt);
			itemsN[slot] -= amnt;

		} else {
			for (int i = amnt; i > 0; i--) {
				int price = itemValue(item, p);
				clearSlots(p);
				if (pi.invItemCount(p, 995) < price) {
					p.frames.sendMessage(p, "Not enough coins to buy that many.");
					break;
				}
				if (pi.findInvSlot(p) == -1) {
					p.frames.sendMessage(p, "Not enough space on inventory");
					break;
				}
				if (itemsN[slot] < 1) {
					clearSlots(p);
					p.frames.sendMessage(p, "The shop has run out of stock from this item!");
					break;
				}
				if (itemsN[slot] == 1) {
					pi.deleteItem(p, 995, pi.getItemSlot(p, 995), price);
					pi.addItem(p, item, 1);
					itemsN[slot] = 0;

					break;
				}
				itemsN[slot]--;

				pi.deleteItem(p, 995, pi.getItemSlot(p, 995), price);
				pi.addItem(p, item, 1);
				clearSlots(p);

			}

		}

		sendShopItems(p);
		sendPlayerInventory(p);
		clearSlots(p);
	}

	public int findItemSlot(int item) {
		for (int i = 0; i < items.length; i++)
			if (item == items[i]) return i;
		return -1;
	}

	public int findFreeSlot() {
		for (int i = 0; i < items.length; i++)
			if (items[i] == -1) return i;
		return -1;
	}

	public void clearSlots(Player p) {
		for (int i = 0; i < items.length; i++)
			if (items[i] < 1) {
				itemsN[i] = 0;
			} else {
			}

	}

	public int getShopValue(int itemId, Player p) {
		if (itemId < 0) {
			return 0;
		}
		switch (p.shopid) {
		case 2:
			for (int i = 0; i < shop2.length; i++) {
				if (shop2[i] != -1 && shop2[i] == itemId) {
					return (shop2p[i]);
				}
			}
			break;
		case 3:
			for (int i = 0; i < shop3.length; i++) {
				if (shop3[i] != -1 && shop3[i] == itemId) {
					return (shop3p[i]);
				}
			}
			break;
		case 4:
			for (int i = 0; i < shop4.length; i++) {
				if (shop4[i] != -1 && shop4[i] == itemId) {
					return (shop4p[i]);
				}
			}
			break;
		case 5:
			for (int i = 0; i < shop5.length; i++) {
				if (shop5[i] != -1 && shop5[i] == itemId) {
					return (shop5p[i]);
				}
			}
			break;
		case 6:
			for (int i = 0; i < shop6.length; i++) {
				if (shop6[i] != -1 && shop6[i] == itemId) {
					return (shop6p[i]);
				}
			}
			break;
		case 7:
			for (int i = 0; i < shop7.length; i++) {
				if (shop7[i] != -1 && shop7[i] == itemId) {
					return (shop7p[i]);
				}
			}
			break;
		case 8:
			for (int i = 0; i < shop8.length; i++) {
				if (shop8[i] != -1 && shop8[i] == itemId) {
					return (shop8p[i]);
				}
			}
			break;
		case 9:
			for (int i = 0; i < shop9.length; i++) {
				if (shop9[i] != -1 && shop9[i] == itemId) {
					return (shop9p[i]);
				}
			}
			break;
		case 10:
			for (int i = 0; i < shop10.length; i++) {
				if (shop10[i] != -1 && shop10[i] == itemId) {
					return (shop10p[i]);
				}
			}
			break;
		case 11:
			for (int i = 0; i < shop11.length; i++) {
				if (shop11[i] != -1 && shop11[i] == itemId) {
					return (shop11p[i]);
				}
			}
			break;
		case 12:
			for (int i = 0; i < shop12.length; i++) {
				if (shop12[i] != -1 && shop12[i] == itemId) {
					return (shop12p[i]);
				}
			}
			break;
		case 13:
			for (int i = 0; i < shop13.length; i++) {
				if (shop13[i] != -1 && shop13[i] == itemId) {
					return (shop13p[i]);
				}
			}
			break;
		case 14:
			for (int i = 0; i < shop14.length; i++) {
				if (shop14[i] != -1 && shop14[i] == itemId) {
					return (shop14p[i]);
				}
			}
			break;
		case 16:
			for (int i = 0; i < shop16.length; i++) {
				if (shop16[i] != -1 && shop16[i] == itemId) {
					return (shop16p[i]);
				}
			}
		}
		return 2;
	}

	public void sendShopItems(Player p) {
		for (Player p2 : Engine.players) {
			if (p2 != null && p2.interfaceId == p.interfaceId) p2.frames.setItems(p, -1, 64271, 31, items, itemsN);
		}
	}

	public boolean isItemOnShop(int item) {
		return findItemSlot(item) != -1;
	}

	public void sendPlayerInventory(Player p) {
		p.frames.setItems(p, -1, 64209, 93, p.items, p.itemsN);

	}

	public int itemValue(int item, Player p) {
		return getShopValue(item, p);
	}

	public boolean itemStacks(int item) {
		return Engine.items.itemLists[item].itemStackable;
	}

	public void handleoption(Player p, int interfaceId, int buttonId, int buttonId2, int packetId) {
		switch (interfaceId) {
		case 620:
			if (buttonId == 26) {
				p.frames.setInterfaceConfig(p, 620, 23, true);
				p.frames.setInterfaceConfig(p, 620, 24, false);
				p.frames.setInterfaceConfig(p, 620, 29, true);
				p.frames.setInterfaceConfig(p, 620, 25, false);
				p.frames.setInterfaceConfig(p, 620, 27, false);
				p.frames.setInterfaceConfig(p, 620, 26, true);
				p.frames.setAccessMask(p, 1278, 24, 620, 0, 40);
			}
			if (buttonId == 24) {
				int itemid = items[buttonId2];
				switch (packetId) {
				case 233:
					/* Value. */
					p.frames.sendMessage(p, "This item costs " + getShopValue(itemid, p) + " coins.");
					break;
				case 21:
					/* Buy 1. */
					buy(p, itemid, 1);
					break;
				case 169:
					/* Buy 5. */
					buy(p, itemid, 5);
					break;
				case 214:
					/* Buy 10. */
					buy(p, itemid, 10);
					break;
				case 90:
					/* Examine. */
					p.frames.sendMessage(p, Engine.items.getItemDescription(itemid));
					break;
				}

			}
			break;
		case 621:
			if (buttonId == 0) {
				int itemid = p.items[buttonId2];
				switch (packetId) {
				case 233:
					if (p.party) {
						p.partyAdd(itemid);
						return;
					}
					/* Value. */
					p.frames.sendMessage(p, "This item is worth " + (int) (itemValue(itemid, p) * .75) + " coins.");
					break;
				case 21:
					/*
					 * Sell 1.
					 */
					sell(p, itemid, 1);
					break;
				case 169:
					/*
					 * Sell 5.
					 */
					sell(p, itemid, 5);
					break;
				case 214:
					/*
					 * Sell 10.
					 */

					sell(p, itemid, 10);
					break;
				case 90:
					/*
					 * Examine.
					 */
					p.frames.sendMessage(p, Engine.items.getItemDescription(itemid));
					break;
				}
			}
			break;
		}
	}

	public void shopopen(Player p, int shopId) {
		p.frames.removeShownInterface(p);
		p.frames.showInterface(p, 620); // Shop
		p.frames.setInventory(p, 621);
		p.frames.setString(p, "Main Stock", 620, 31); // 31 is right hand side
		p.frames.setString(p, "Closed", 620, 32); // 32 is left
		p.frames.setString(p, "DavidScape 508", 620, 28);
		p.frames.setString(p, "General Store", 620, 22);
		p.frames.setInterfaceConfig(p, 620, 23, true);
		p.frames.setInterfaceConfig(p, 620, 24, false);
		p.frames.setInterfaceConfig(p, 620, 29, true);
		p.frames.setInterfaceConfig(p, 620, 25, false);
		p.frames.setInterfaceConfig(p, 620, 27, false);
		p.frames.setInterfaceConfig(p, 620, 26, true);
		p.frames.setAccessMask(p, 1278, 24, 620, 0, 40);
		shopid = shopId;
		Object[] setshopparams = new Object[] { shopId, 93 };

		int shi = 621 << 16;
		int ship = (620 << 16) + 24;

		Object[] invparams = new Object[] { "", "", "", "", "Sell X", "Sell 10", "Sell 5", "Sell 1", "Value", -1, 0, 7, 4, 93, shi };
		Object[] shopparams = new Object[] { "", "", "", "", "Buy X", "Buy 10", "Buy 5", "Buy 1", "Value", -1, 0, 4, 10, 31, ship };

		p.frames.runScript(p, 25, setshopparams, "vg");// Loads main stock items
		p.frames.runScript(p, 150, invparams, "IviiiIsssssssss");
		p.frames.runScript(p, 150, shopparams, "IviiiIsssssssss");
		p.frames.setAccessMask(p, 1278, 0, 621, 0, 28);
		p.frames.setInterfaceConfig(p, 620, 23, true);
		p.frames.setInterfaceConfig(p, 620, 24, false);
		p.frames.setInterfaceConfig(p, 620, 29, true);
		p.frames.setInterfaceConfig(p, 620, 25, false);
		p.frames.setInterfaceConfig(p, 620, 27, false);
		p.frames.setInterfaceConfig(p, 620, 26, true);
		p.frames.setAccessMask(p, 1278, 24, 620, 0, 40);

	}

	public void openshop(Player p, int shopid) {
		p.party = false;
		switch (shopid) {
		case 2:
			shopopen(p, 868);
			items = shop2;
			itemsN = shop2n;
			break;
		case 3:
			shopopen(p, 868);
			items = shop3;
			itemsN = shop3n;
			break;
		case 4:
			shopopen(p, 868);
			items = shop4;
			itemsN = shop4n;
			break;
		case 5:
			shopopen(p, 868);
			items = shop5;
			itemsN = shop5n;
			break;
		case 6:
			shopopen(p, 868);
			items = shop6;
			itemsN = shop6n;
			break;
		case 7:
			shopopen(p, 868);
			items = shop7;
			itemsN = shop7n;
			break;
		case 8:
			shopopen(p, 868);
			items = shop8;
			itemsN = shop8n;
			break;
		case 9:
			shopopen(p, 868);
			items = shop9;
			itemsN = shop9n;
			break;
		case 10:
			shopopen(p, 868);
			items = shop10;
			itemsN = shop10n;
			break;
		case 11:
			shopopen(p, 868);
			items = shop11;
			itemsN = shop11n;
			break;
		case 12:
			shopopen(p, 868);
			items = shop12;
			itemsN = shop12n;
			break;
		case 13:
			shopopen(p, 868);
			items = shop13;
			itemsN = shop13n;
			break;
		case 14:
			shopopen(p, 868);
			items = shop14;
			itemsN = shop14n;
			break;

		case 16:
			shopopen(p, 868);
			items = shop16;
			itemsN = shop16n;
			break;

		}
		p.frames.setItems(p, -1, 64209, 93, p.items, p.itemsN);
		p.frames.setItems(p, -1, 64271, 31, items, itemsN);

	}
}