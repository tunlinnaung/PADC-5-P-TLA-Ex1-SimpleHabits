package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import adapters.AllTopicsAdapter;
import adapters.EveningMeditationsAdapter;
import adapters.HealthyMindAdapter;
import adapters.MostPopularAdapter;
import adapters.NewHabitAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;

public class SeriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvEvening = findViewById(R.id.rv_evening_meditation);
        rvEvening.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        EveningMeditationsAdapter eveningAdapter = new EveningMeditationsAdapter(getApplicationContext());
        rvEvening.setAdapter(eveningAdapter);

        RecyclerView rvHealthyMind = findViewById(R.id.rv_healthy_mind);
        rvHealthyMind.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        HealthyMindAdapter healthyMindAdapter = new HealthyMindAdapter(getApplicationContext());
        rvHealthyMind.setAdapter(healthyMindAdapter);

        RecyclerView rvNewHabit = findViewById(R.id.rv_new_simple_habit);
        rvNewHabit.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        NewHabitAdapter newHabitAdapter = new NewHabitAdapter(getApplicationContext());
        rvNewHabit.setAdapter(newHabitAdapter);

        RecyclerView rvMostPopular = findViewById(R.id.rv_most_popular);
        rvMostPopular.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        MostPopularAdapter mostPopularAdapter = new MostPopularAdapter(getApplicationContext());
        rvMostPopular.setAdapter(mostPopularAdapter);

        RecyclerView rvAllTopics = findViewById(R.id.rv_all_topics);
        rvAllTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        AllTopicsAdapter allTopicsAdapter = new AllTopicsAdapter(getApplicationContext());
        rvAllTopics.setAdapter(allTopicsAdapter);
    }

}
