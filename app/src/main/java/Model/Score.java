package Model;

import java.io.Serializable;
import java.util.Date;

//Class de Score
public class Score implements Serializable {
    public String NamePlayer;
    public Date Date;
    public int Score;

    public int NbMoleTap;
    public int TimeReactionMin;
    public int TimeReactionMax;
    public int TimeReactionAVG;

    public Score(String namePlayer) {
        NamePlayer = namePlayer;
    }

    @Override
    public String toString() {
        return "Player = '" + NamePlayer + '\'' + "; Score = " + Score + '}';
    }
}
