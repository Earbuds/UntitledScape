/*
 * Class SellOffer
 *
 * Version 1.0
 *
 * Created Wednesday, 23 June, 2010
 * Created by Davidi2
 */

package untitledscape.grandexchange;

public class SellOffer {

	public int itemID;
	public int origAmount;
	public int currAmount;
	public int price;
	public String owner;
	public boolean completed;
	public int currPrice;
	public boolean cancelled = false;
	public int slot;

	public SellOffer(int item, int origAmount, int currAmount, int price, int slot, int completed, String owner) {
		this.itemID = item;
		this.origAmount = origAmount;
		this.currAmount = currAmount;
		this.price = price;
		this.owner = owner;
		if (completed == 1) {
			this.completed = true;
		} else {
			this.completed = false;
		}
		this.slot = slot;
	}

	public void updatePrice(int origAmount, boolean bool) {
		if (bool) {
			if (currAmount == 0) { // type == 0
				currPrice += origAmount * price;
			} else {
				currPrice += origAmount;
			}
		} else {
			currPrice -= origAmount;
		}
	}
}
