package untitledscape.clanchat;

// import java.util.ArrayList; Unused Imports
//import java.util.List;
//import untitledscape.clanchat.ClanMain;
//import untitledscape.players.Player;

public class InChat {

    public String name = "";
    public int status = 0;
    public int chance = 0;
    public InChat(String name) {
	this.name = name;
    }

    public void clear() {
	name = "";
    }

}