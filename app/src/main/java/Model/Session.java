package Model;

import android.net.ParseException;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Session implements Serializable {
    public ArrayList<Score> Score;
    public Date DateDebut;

    public Session() {
        Score = new ArrayList<>();
    }
}
