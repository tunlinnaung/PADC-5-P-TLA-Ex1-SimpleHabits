package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.AllTopicsAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.EveningMeditationsAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.HealthyMindAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.MostPopularAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.NewHabitAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;

public class SeriesActivity extends BaseActivity {

    RecyclerView rvEvening;
    RecyclerView rvHealthyMind;
    RecyclerView rvNewHabit;
    RecyclerView rvMostPopular;
    RecyclerView rvAllTopics;
    EveningMeditationsAdapter eveningAdapter;
    HealthyMindAdapter healthyMindAdapter;
    NewHabitAdapter newHabitAdapter;
    MostPopularAdapter mostPopularAdapter;
    AllTopicsAdapter allTopicsAdapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, SeriesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEvening = findViewById(R.id.rv_evening_meditation);
        rvEvening.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        eveningAdapter = new EveningMeditationsAdapter(getApplicationContext());
        rvEvening.setAdapter(eveningAdapter);

        rvHealthyMind = findViewById(R.id.rv_healthy_mind);
        rvHealthyMind.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        healthyMindAdapter = new HealthyMindAdapter(getApplicationContext());
        rvHealthyMind.setAdapter(healthyMindAdapter);

        rvNewHabit = findViewById(R.id.rv_new_simple_habit);
        rvNewHabit.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        newHabitAdapter = new NewHabitAdapter(getApplicationContext());
        rvNewHabit.setAdapter(newHabitAdapter);

        rvMostPopular = findViewById(R.id.rv_most_popular);
        rvMostPopular.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        mostPopularAdapter = new MostPopularAdapter(getApplicationContext());
        rvMostPopular.setAdapter(mostPopularAdapter);

        rvAllTopics = findViewById(R.id.rv_all_topics);
        rvAllTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        allTopicsAdapter = new AllTopicsAdapter(getApplicationContext());
        rvAllTopics.setAdapter(allTopicsAdapter);

        initBottomNavigation();
    }

    @Override
    void initBottomNavigation() {
        BottomNavigation bottomNavigation=(BottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId){
                    case R.id.tab_home:
                        //Intent mainIntent = SeriesActivity.newIntent(getApplicationContext());
                        //startActivity(mainIntent);
                        break;
                    case R.id.tab_me:
                        Intent myIntent = SeriesActivity.newIntent(getApplicationContext());
                        startActivity(myIntent);
                        break;
                    case R.id.tab_more:
                        Intent moreIntent = SeriesActivity.newIntent(getApplicationContext());
                        startActivity(moreIntent);
                        break;
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurrentProgramsDataLoaded(RestApiEvents.CurrentProgramsDataLoadedEvent event) {
        //mNewsAdapter.appendNewData(event.getLoadNews());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCategoriesDataLoaded(RestApiEvents.CategoriesDataLoadedEvent event) {
        //mNewsAdapter.appendNewData(event.getLoadNews());
        if (event.getLoadCategories() != null
                && event.getLoadCategories().size() > 0) {
            eveningAdapter.appendNewData(event.getLoadCategories().get(0).getPrograms());

            if (event.getLoadCategories().size() > 1) {
                healthyMindAdapter.appendNewData(event.getLoadCategories().get(1).getPrograms());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvEvening, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }

}
