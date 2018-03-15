package Model;

import java.io.Serializable;
import java.util.ArrayList;


public class Session implements Serializable {
    public ArrayList<Score> Score;

    public Session() {
        Score = new ArrayList<>();
    }

}
