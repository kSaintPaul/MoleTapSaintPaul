package org.diiage.kevinsaintpaul.moletapsaintpaul;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Score;
import Model.Session;

public class ScoreActivity extends AppCompatActivity {

    private Session session;

    private ListView listScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            session = (Session) getIntent().getSerializableExtra("session");
        }

        listScore = findViewById(R.id.listScore);

        Score score = new Score("ttt");
        score.Score =15;


        session.Score.add(score);
        session.Score.add(score);
        session.Score.add(score);
        session.Score.add(score);

        //ScoreAdapter scoreAdapter = new ScoreAdapter(this, session.Score);
        ScoreAdapter scoreAdapter = new ScoreAdapter(this, session.Score);

        listScore.setAdapter(scoreAdapter);
    }

    public void btnHome_OnClick(View view) {
        this.finish();
    }

    private static class ScoreAdapter extends BaseAdapter {

        Activity context;
        ArrayList<Score> scores;
        ScoreViewHolder scoreViewHolder;

        public ScoreAdapter(Activity context, ArrayList<Score> scores) {
            this.context = context;
            this.scores = scores;
        }

        @Override
        public int getCount() {
            return scores.size();
        }

        @Override
        public Object getItem(int i) {
            return scores.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View v;

            if(view != null){
                v = view;
                scoreViewHolder = (ScoreViewHolder) view.getTag();
            }else {
                LayoutInflater layoutInflater = this.context.getLayoutInflater();

                v = layoutInflater.inflate(R.layout.row_score, viewGroup, false);

                TextView lblName = v.findViewById(R.id.NameText);
                TextView lnlScore = v.findViewById(R.id.ScoreText);

                scoreViewHolder = new ScoreViewHolder(lblName, lnlScore);

                v.setTag(scoreViewHolder);
            }

            Score score = scores.get(position);

            scoreViewHolder.Name.setText(score.NamePlayer);
            scoreViewHolder.Score.setText(String.valueOf(score.Score));

            return v;
        }
    }

    public static class ScoreViewHolder{

        public TextView Name;
        public TextView Score;

        public ScoreViewHolder(TextView name, TextView score) {
            Name = name;
            Score = score;
        }
    }
}
