/*
 * Class Grand Exchange
 *
 * Version 2.0
 *
 * Started Tuesday, 16 June, 2009
 * Finished -----
 * Continued Wednesday,23 June, 2010 (it's been a year since I worked on this, let's see what I can do!)
 * Created by Davidi2
 */

package untitledscape.GrandExchange;

import java.io.*;
import java.util.*;
import untitledscape.players.*;

// import java.lang.*;
// import untitledscape.Engine;
// import untitledscape.io.*;
// import untitledscape.players.items.*;
// import untitledscape.util.*;

public class GE {

	public ArrayList<SellOffer> sellOffers = new ArrayList<SellOffer>();
	public ArrayList<BuyOffer> buyOffers = new ArrayList<BuyOffer>();

	static public String getContents(String fileName) {
		File aFile = new File(fileName);
		StringBuilder contents = new StringBuilder();
		try {
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					contents.append("\n" + line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
		}
		return contents.toString();
	}

	public void writeFile(String fileName, String toWrite) throws Exception {
		File file = new File(fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(toWrite);
		bw.flush();
		bw.close();
	}

	public void initializeGrandExchange() {
		try {
			loadOffers();
		} catch (Exception e) {
			System.out.println("Error loading Offer Lists!");
		}
	}

	public void openGE(Player p) {
		p.frames.setConfig2(p, 563, 4194304);
		p.frames.setConfig(p, 1110, 0);
		p.frames.setConfig(p, 1111, 1);
		p.frames.setConfig(p, 1112, 2);
		p.frames.setConfig(p, 1113, 3);
		p.frames.setConfig(p, 1109, 4);
		p.frames.showInterface(p, 105);
		p.frames.setItems(p, -1, -1327, 93, new int[] {}, new int[] {});
		p.frames.setInterfaceConfig(p, 107, 0, true);
		p.frames.setInterfaceConfig(p, 105, 0, false);
		p.frames.setAccessMask(p, 6, 0, 105, -1, -1);
	}

	public void openSellInterface(int slot, Player p) {
		p.frames.setConfig(p, 1109, -1);
		p.frames.setConfig(p, 1110, 0);
		p.frames.setConfig(p, 1111, 0);
		p.frames.setConfig(p, 1112, slot);
		p.frames.setConfig(p, 1113, 1);
		p.frames.setInventory(p, 107);
		Object[] menu = new Object[] { "", "", "", "", "Offer", -1, 0, 7, 4, 93, 7012370 };
		p.frames.runScript(p, 149, menu, "IviiiIsssss");
		p.frames.setAccessMask(p, 1026, 18, 107, 0, 27);
		p.frames.setItems(p, -1, -1327, 93, p.items, p.itemsN);
		p.frames.setInterfaceConfig(p, 107, 0, false);
	}

	public void openBuyInterface(int slot, Player p) {
		p.frames.setConfig(p, 1109, -1);
		p.frames.setConfig(p, 1110, 0);
		p.frames.setConfig(p, 1111, 0);
		p.frames.setConfig(p, 1112, slot);
		p.frames.setConfig(p, 1113, 1);
		p.frames.setInventory(p, 107);
		Object[] menu = new Object[] { "", "", "", "", "Offer", -1, 0, 7, 4, 93, 7012370 };
		p.frames.runScript(p, 149, menu, "IviiiIsssss");
		p.frames.setAccessMask(p, 1026, 18, 107, 0, 27);
		p.frames.setItems(p, -1, -1327, 93, p.items, p.itemsN);
		p.frames.setInterfaceConfig(p, 107, 0, false);
		Object[] o = new Object[] { "Grand Exchange Item Search" };
		p.frames.setConfig1(p, 1109, -1);
		p.frames.setConfig1(p, 1112, 0);
		p.frames.setConfig1(p, 1113, 0);
		p.frames.setInterface(p, 6, 752, 6, 389);
		p.stream.createFrameVarSizeWord(152);
		p.stream.writeString("s");
		String values = "s";
		int j = 0;
		for (int i = (values.length() - 1); i >= 0; i--) {
			if (values.charAt(i) == 115) {
				p.stream.writeString((String) o[j]);
			} else {
				p.stream.writeDWord((Integer) o[j]);
			}
			j++;
		}
		p.stream.writeDWord(570);
		p.stream.endFrameVarSize();
	}

	public void writeOffers() {
		try {
			writeBothOffers();
		} catch (Exception e) {
			System.out.println("Error writing Offer Lists!");
		}
	}

	public void checkOffers() {
		for (BuyOffer b : buyOffers) {
			for (SellOffer s : sellOffers) {
				if ((b.itemID == s.itemID) && (b.price >= s.price)) {
					compare(s, b);
				}
			}
		}
	}

	public void compare(SellOffer s, BuyOffer b) {
		if (b.price > s.price) { // b.amount and s.amount
			
		} else {
			
		}
	}

	public void loadOffers() throws Exception {
		String buyOfferFile = getContents("./data/GE/BuyOffers.txt");
		String[] buyOfferArray = buyOfferFile.split("\n");
		for (String s : buyOfferArray) {
			String[] thisBuyOffer = s.split("\t");
			buyOffers.add(new BuyOffer(Integer.parseInt(thisBuyOffer[0]), Integer.parseInt(thisBuyOffer[1]), Integer.parseInt(thisBuyOffer[2]), Integer.parseInt(thisBuyOffer[3]), Integer.parseInt(thisBuyOffer[4]), Integer.parseInt(thisBuyOffer[5]), thisBuyOffer[6]));
		}
		String sellOfferFile = getContents("./data/GE/SellOffers.txt");
		String[] sellOfferArray = sellOfferFile.split("\n");
		for (String s : sellOfferArray) {
			String[] thisSellOffer = s.split("\t");
			sellOffers.add(new SellOffer(Integer.parseInt(thisSellOffer[0]), Integer.parseInt(thisSellOffer[1]), Integer.parseInt(thisSellOffer[2]), Integer.parseInt(thisSellOffer[3]), Integer.parseInt(thisSellOffer[4]), Integer.parseInt(thisSellOffer[5]), thisSellOffer[6]));
		}
	}

	public void writeBothOffers() throws Exception {
		String buyOfferFile = "";
		for (BuyOffer b : buyOffers) {
			buyOfferFile += (b.itemID + "\t" + b.origAmount + "\t" + b.currAmount + "\t" + b.price + "\t" + b.slot + "\t" + (b.completed ? "1" : "0") + b.owner + "\n");
		}
		writeFile("./data/GE/BuyOffers.txt", buyOfferFile);
		String sellOfferFile = "";
		for (SellOffer s : sellOffers) {
			sellOfferFile += (s.itemID + "\t" + s.origAmount + "\t" + s.currAmount + "\t" + s.price + "\t" + s.slot + "\t" + (s.completed ? "1" : "0") + s.owner + "\n");
		}
		writeFile("./data/GE/SellOffers.txt", sellOfferFile);
	}

}

/*
 * ///////////////////////////////////////////////////// public void
 * checkOffers(Player p){
 * 
 * //check all sells readBOffers(p); readSOffers(p); int count = 0; for (int i =
 * 0; i < 1001; i++){ for (int j = 0; j < 1001; j++){ if(count >= 4) { return; }
 * if(geSO[i][0] == null || geSO[i][0] == "") { if(geBO[j][0] == null ||
 * geBO[j][0] == "") { count++; continue; } } if(geSO[i][0] != null &&
 * geSO[i][0] != "" && geBO[j][0] != null && geBO[j][0] != "") {
 * if(!geSO[i][0].equals(geBO[j][0])) { continue; }
 * if(geSO[i][0].equals(geBO[j][0])) { if(Integer.parseInt(geBO[j][2]) >=
 * Integer.parseInt(geSO[i][2])) { if(Integer.parseInt(geBO[j][1]) >
 * Integer.parseInt(geSO[i][1])) { File curFile = new
 * File("./data/geoffers/sell/geoffer" + i + ".txt"); File curFile2 = new
 * File("./data/geoffers/buy/geoffer" + j + ".txt"); curFile.delete();
 * curFile2.delete(); addCollect(p, Integer.parseInt(geBO[j][0]),
 * (Integer.parseInt(geBO[j][1]) - Integer.parseInt(geSO[i][1])), geBO[j][3]);
 * addCollect(p, 995, Integer.parseInt(geSO[i][1]) *
 * Integer.parseInt(geSO[i][2]), geSO[i][3]);
 * Engine.fileManager.appendData("/geoffers/buy/geoffer" +j+".txt", geBO[j][0] +
 * " " + (Integer.parseInt(geBO[j][1]) - Integer.parseInt(geSO[i][1]))+ " " +
 * geBO[j][2] + " " + geBO[j][3].replace(" ", "_")); readBOffers(p);
 * readSOffers(p); return; } else if(Integer.parseInt(geBO[j][1]) ==
 * Integer.parseInt(geSO[i][1])) { File curFile = new
 * File("./data/geoffers/sell/geoffer" + i + ".txt"); File curFile2 = new
 * File("./data/geoffers/buy/geoffer" + j + ".txt"); curFile.delete();
 * curFile2.delete(); addCollect(p, Integer.parseInt(geBO[j][0]),
 * Integer.parseInt(geBO[j][1]), geBO[j][3]); addCollect(p, 995,
 * Integer.parseInt(geSO[i][1]) * Integer.parseInt(geSO[i][2]), geSO[i][3]);
 * readBOffers(p); readSOffers(p); return; } else
 * if(Integer.parseInt(geBO[j][1]) < Integer.parseInt(geSO[i][1])) { File
 * curFile = new File("./data/geoffers/sell/geoffer" + i + ".txt"); File
 * curFile2 = new File("./data/geoffers/buy/geoffer" + j + ".txt");
 * curFile.delete(); curFile2.delete(); addCollect(p,
 * Integer.parseInt(geBO[j][0]), (Integer.parseInt(geSO[i][1]) -
 * Integer.parseInt(geBO[j][1])), geBO[j][3]); addCollect(p, 995,
 * Integer.parseInt(geSO[i][1]) * Integer.parseInt(geSO[i][2]), geSO[i][3]);
 * Engine.fileManager.appendData("/geoffers/sell/geoffer" +i+".txt", geSO[i][0]
 * + " " + (Integer.parseInt(geSO[i][1]) - Integer.parseInt(geBO[j][1]))+ " " +
 * geSO[i][2] + " " + geSO[i][3].replace(" ", "_")); readBOffers(p);
 * readSOffers(p); return; } } } } } } //check all sells int count2 = 0;
 * readBOffers(p); readSOffers(p); for (int i = 0; i < 1001; i++){ for (int j =
 * 0; j < 1001; j++){ if(count2 >= 4) { return; } if(geSO[i][0] == null ||
 * geSO[i][0] == "") { if(geBO[j][0] == null || geBO[j][0] == "") { count2++; }
 * } if(geBO[i][0] != null && geBO[i][0] != "" && geSO[j][0] != null &&
 * geSO[j][0] != "") { if(!geSO[i][0].equals(geBO[j][0])) { continue; }
 * if(geBO[i][0].equals(geSO[j][0])) { if(Integer.parseInt(geSO[j][2]) <=
 * Integer.parseInt(geBO[i][2])) { if(Integer.parseInt(geSO[j][1]) >
 * Integer.parseInt(geBO[i][1])) { File curFile = new
 * File("./data/geoffers/buy/geoffer" + i + ".txt"); File curFile2 = new
 * File("./data/geoffers/sell/geoffer" + j + ".txt"); curFile.delete();
 * curFile2.delete(); addCollect(p, Integer.parseInt(geBO[i][0]),
 * (Integer.parseInt(geSO[j][1]) - Integer.parseInt(geBO[i][1])), geBO[i][3]);
 * addCollect(p, 995, Integer.parseInt(geSO[j][1]) *
 * Integer.parseInt(geSO[j][2]), geSO[j][3]);
 * Engine.fileManager.appendData("/geoffers/sell/geoffer" +j+".txt", geSO[j][0]
 * + " " + (Integer.parseInt(geSO[j][1]) - Integer.parseInt(geBO[i][1]))+ " " +
 * geSO[j][2] + " " + geSO[j][3].replace(" ", "_")); readBOffers(p);
 * readSOffers(p); return; } else if(Integer.parseInt(geSO[j][1]) ==
 * Integer.parseInt(geBO[i][1])) { File curFile = new
 * File("./data/geoffers/buy/geoffer" + i + ".txt"); File curFile2 = new
 * File("./data/geoffers/sell/geoffer" + j + ".txt"); curFile.delete();
 * curFile2.delete(); addCollect(p, Integer.parseInt(geBO[i][0]),
 * Integer.parseInt(geBO[i][1]), geBO[i][3]); addCollect(p, 995,
 * Integer.parseInt(geSO[j][1]) * Integer.parseInt(geSO[j][2]), geSO[j][3]);
 * readBOffers(p); readSOffers(p); return; } else
 * if(Integer.parseInt(geSO[j][1]) < Integer.parseInt(geBO[i][1])) { File
 * curFile = new File("./data/geoffers/buy/geoffer" + i + ".txt"); File curFile2
 * = new File("./data/geoffers/sell/geoffer" + j + ".txt"); curFile.delete();
 * curFile2.delete(); addCollect(p, Integer.parseInt(geBO[i][0]),
 * (Integer.parseInt(geBO[i][1]) - Integer.parseInt(geSO[j][1])), geBO[i][3]);
 * addCollect(p, 995, Integer.parseInt(geSO[j][1]) *
 * Integer.parseInt(geSO[j][2]), geSO[j][3]);
 * Engine.fileManager.appendData("/geoffers/buy/geoffer" +i+".txt", geBO[i][0] +
 * " " + (Integer.parseInt(geBO[i][1]) - Integer.parseInt(geSO[j][1]))+ " " +
 * geBO[i][2] + " " + geBO[i][3].replace(" ", "_")); readBOffers(p);
 * readSOffers(p); return; } } } } } } } // end check offers
 * 
 * public void readCollect(Player p) { int a = 0; int count = 0; for (int i = 0;
 * i < 10000; i++) { if (count > 2){ return; } File curFile = new
 * File("./data/geoffers/collect/collect" + i + ".txt"); if (!curFile.exists())
 * { count++; } else if (curFile.exists()) { String currentLine=
 * getContents(curFile); p.collects[i] = currentLine.split(" "); if
 * (p.collects[i][2].replace("_", " ").equalsIgnoreCase(p.username)) {
 * p.collectsf[a][0] = p.collects[i][0]; p.collectsf[a][1] = p.collects[i][1];
 * p.collectsf[a][2] = "" + i; a++; p.hasCollect++; } } } }
 * 
 * public void addCollect(Player p, int itemId, int amt, String username) { for
 * (int i = 0; i < 1001; i++) { File curFile = new
 * File("./data/geoffers/collect/collect" + i + ".txt"); if (curFile.exists()) {
 * } else if (!curFile.exists()) {
 * Engine.fileManager.appendData("/geoffers/collect/collect" +i+".txt", itemId +
 * " " + amt + " " + username.replace(" ", "_")); return; } } }
 * 
 * public void showStatus(Player p) { readBOffers(p); readSOffers(p);
 * checkOffers(p); p.frames.showInterface(p, 384); p.frames.setString(p,
 * "Offer ---- Item ---- Price ---- Status", 384, 1); for (int i = 3; i < 13;
 * i++) { p.frames.setString(p, i-2 +". OPEN SLOT", 384, i); }
 * p.frames.setString(p, "", 384, 2); p.frames.setString(p, "", 384, 13);
 * p.frames.setString(p, " If an offer is not on this list, its been updated!",
 * 384, 14); p.frames.setString(p, " Do ::collect to get your items", 384, 15);
 * p.frames.setString(p, "" + hCD, 384, 16); int i = 0; for (int a = 0; a < 11;
 * a++) { if (p.pgeSO[a][0] != "" && p.pgeSO[a][0] != null) {
 * p.frames.setString(p, "Sell---"+p.pgeSO[a][1]+ " of " +
 * p.pgeSO[a][0]+"---"+p.pgeSO[a][2]+ "gp each---UNSOLD", 384, i+3); i++; } if
 * (p.pgeBO[a][0] != "" && p.pgeBO[a][0] != null) { p.frames.setString(p,
 * "Buy---"+p.pgeBO[a][1]+ " of " + p.pgeBO[a][0]+"---"+p.pgeBO[a][2]+
 * "gp each---UNBOUGHT", 384, i+3); i++; } } }// end show Status
 * 
 * 
 * public void readOffers(Player p) { readBOffers(p); readSOffers(p);
 * showStatus(p); }
 * 
 * public void readBOffers(Player p) { int count = 0; for (int a = 0; a < 11;) {
 * for (int i = 0; i < 1001; i++) { File curFile = new
 * File("./data/geoffers/buy/geoffer" + i + ".txt"); if (!curFile.exists() &&
 * count < 3) { geBO[i][0] = ""; geBO[i][1] = ""; geBO[i][2] = ""; geBO[i][3] =
 * ""; count++;
 * 
 * } else if (!curFile.exists() && count > 2) { count = 0; return; } else if
 * (curFile.exists()) { count = 0; String currentLine= getContents(curFile);
 * String editS = currentLine; geBO[i] = editS.split(" "); if (geBO[i][3] !=
 * null && geBO[i][3] != ("")) { if (geBO[i][3].replace("_",
 * " ").equalsIgnoreCase(p.username)){ p.pgeBO[a] = geBO[i]; a++; } } } } } }
 * //end read offers
 * 
 * public void readSOffers(Player p) { int count = 0; for (int a = 0; a < 11;) {
 * for (int i = 0; i < 1001; i++) { File curFile = new
 * File("./data/geoffers/sell/geoffer" + i + ".txt"); if (!curFile.exists() &&
 * count < 3) { geSO[i][0] = ""; geSO[i][1] = ""; geSO[i][2] = ""; geSO[i][3] =
 * ""; count++;
 * 
 * } else if (!curFile.exists() && count > 2) { count = 0; return; } else if
 * (curFile.exists()) { count = 0; String currentLine= getContents(curFile);
 * String editS = currentLine; geSO[i] = editS.split(" "); if (geSO[i][3] !=
 * null && geSO[i][3] != ("")) { if (geSO[i][3].replace("_",
 * " ").equalsIgnoreCase(p.username)){ p.pgeSO[a] = geSO[i]; a++; } } } } } }
 * //end read offers public void addOffer(Player p, String type){
 * 
 * p.geoffers++; if (type == "buy"){ for (int i = 0; i < 1001; i++) { File
 * curFile = new File("./data/geoffers/buy/geoffer" + i + ".txt"); if
 * (curFile.exists()) { } else if (!curFile.exists()) {
 * Engine.fileManager.appendData("/geoffers/buy/geoffer" +i+".txt", geItemId +
 * " " + amt + " " + price + " " + p.username.replace(" ", "_")); readOffers(p);
 * return; } } } else { for (int i = 0; i < 1001; i++) { File curFile = new
 * File("./data/geoffers/sell/geoffer" + i + ".txt"); if (curFile.exists()) { }
 * else if (!curFile.exists()) {
 * Engine.fileManager.appendData("/geoffers/sell/geoffer" +i+".txt", geItemId +
 * " " + amt + " " + price + " " + p.username.replace(" ", "_")); readOffers(p);
 * return; } } } checkOffers(p);// Makes it check for updated offers only when a
 * new one is posted. Reduces lagg. } //end addoffer
 * 
 * public void sellItem(int itemId, int price, Player p){
 * p.frames.sendMessage(p, "Added Item to GE!");
 * Engine.playerItems.deleteItem(p, geItemId, amt); addOffer(p, "sell"); } //end
 * sellItem
 * 
 * public void buyItem(int itemId, int price, Player p){ p.frames.sendMessage(p,
 * "You offered " + amt*price + " coins to buy " + amt + " of " +
 * Engine.items.getItemName(Engine.GE.geItemId) + " at " + price +
 * " coins each!"); p.frames.sendMessage(p,
 * "If you dont get your items immediatly, dont worry! Someone should sell them soon."
 * ); Engine.playerItems.deleteItem(p, 995, amt*price); addOffer(p, "buy"); }
 * //end buyItem
 * 
 * public void chooseSell(Player p) { if (p.geoffers < 10) { buying = false;
 * p.frames.showChatboxInterface(p, 68); p.frames.setString(p,
 * "Please 'Drop' item to sell:", 68, 4); p.frames.setString(p, "", 68, 3);
 * p.geb = true; } else { p.frames.removeShownInterface(p);
 * p.frames.removeChatboxInterface(p); p.frames.sendMessage(p,
 * "You already have 10 GE offers! Wait until one is updated to add another.");
 * } }//end chooseSell
 * 
 * public void choosePrice(Player p) { p.uinput.request(5, 0); }// end
 * choosePrice
 * 
 * public void chooseBuy(Player p) { if (p.geoffers < 10) { buying = true;
 * p.uinput.request(6, 0); } else { p.frames.removeShownInterface(p);
 * p.frames.removeChatboxInterface(p); p.frames.sendMessage(p,
 * "You already have 10 GE offers! Wait until one is updated to add another.");
 * } }// end chooseBuy
 * 
 * public void checkAmt(Player p) { if ((buying == true) &&
 * !Engine.items.stackable(geItemId) && amt > 28) { p.frames.sendMessage(p,
 * "You cant buy more then 28 of a non-stackable item!");
 * p.frames.sendMessage(p, "Try again with a lower number."); return; } if
 * (((buying == false) && (Engine.playerItems.haveItem(p, geItemId, amt))) ||
 * (buying == true)) { choosePrice(p); } else {
 * p.frames.removeChatboxInterface(p); p.frames.sendMessage(p,
 * "You don't have that many to sell!"); } }// end check amt
 * 
 * public void checkPrice(Player p) { if ((buying == true) &&
 * (Engine.playerItems.haveItem(p, 995, amt*price))) { buyItem(geItemId, price,
 * p); } else if ((buying == true) && (!Engine.playerItems.haveItem(p, 995,
 * amt*price))) { p.frames.removeChatboxInterface(p); p.frames.sendMessage(p,
 * "You don't have enough coins to buy that many!"); p.frames.sendMessage(p,
 * "You need " + amt*price + " coins to buy " + amt + " of those!"); } else if
 * (buying == false) { sellItem(geItemId, price, p); } }// end check price
 * 
 * public void chooseAmt(Player p) { for (int i = 0; i < 24; i++){ if
 * (Misc.getSkillName(i) != null) { if
 * (Engine.items.getItemName(geItemId).toLowerCase
 * ().contains(Misc.getSkillName(i).toLowerCase())) { p.frames.sendMessage(p,
 * "You cannot buy OR sell any Skillcapes!"); return; } } }
 * p.frames.removeChatboxInterface(p); p.frames.removeShownInterface(p);
 * p.uinput.request(4, 0); } // end chooseAmt public String hCD =
 * "Made By Davidi2 for the Moparscape Public.";
 */// //////////////////////////////////////////////////////////////