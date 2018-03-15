package Model;

import java.io.Serializable;


public class Score implements Serializable {
    public String NamePlayer;
    public int Score;

    public Score(String namePlayer) {
        NamePlayer = namePlayer;
    }

    @Override
    public String toString() {
        return "Player = '" + NamePlayer + '\'' + "; Score = " + Score + '}';
    }
}
