package L10_Exam_Preparation_Two.Exam_2020_02_22.P3_Guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        boolean isRemoved = false;
        for (int i = 0; i < roster.size(); i++) {
            Player currentPlaer = roster.get(i);

            if (currentPlaer.getName().equals(name)) {
                roster.remove(i);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public void promotePlayer(String name) {
        for (int i = 0; i < roster.size(); i++) {
            Player currentPlayer = roster.get(i);

            if (currentPlayer.getName().equals(name)) {
                currentPlayer.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (int i = 0; i < roster.size(); i++) {
            Player currentPlayer = roster.get(i);

            if (currentPlayer.getName().equals(name)) {
                currentPlayer.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> newRoster = new ArrayList<>();
        List<Player> removedPlayersList = new ArrayList<>();

        for (int i = 0; i < roster.size(); i++) {
            Player currentPlayer = roster.get(i);

            if (!currentPlayer.getClazz().equals(clazz)) {
                newRoster.add(currentPlayer);
            } else {
                removedPlayersList.add(currentPlayer);
            }
        }

        Player[] removedPlayer = new Player[removedPlayersList.size()];
        for (int i = 0; i < removedPlayersList.size(); i++) {
            removedPlayer[i] = removedPlayersList.get(i);
        }

        roster = newRoster;

        return removedPlayer;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Players in the guild: %s:" ,this.name));
        stringBuilder.append(System.lineSeparator());
        for (Player p : roster) {
            stringBuilder.append(p.toString())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

}
