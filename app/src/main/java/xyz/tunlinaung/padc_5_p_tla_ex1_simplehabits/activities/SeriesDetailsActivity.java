package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.AllSessionsAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models.SimpleHabitsModel;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

/**
 * Created by eidoshack on 5/31/18.
 */

public class SeriesDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_current_program_desc)
    TextView tvCurrentProgramDesc;

    @BindView(R.id.rv_all_sessions)
    RecyclerView rvSessions;

    @BindView(R.id.ctl_details)
    CollapsingToolbarLayout ctlDetails;

    @BindView(R.id.toolbar_details)
    Toolbar toolbar;

    AllSessionsAdapter allSessionsAdapter;

    public static Intent newIntentByCurrentProgram(Context context) {
        Intent intent = new Intent(context, SeriesDetailsActivity.class);
        intent.putExtra("CATEGORY", "CURRENT_PROGRAM");
        return intent;
    }

    public static Intent newIntentByCategory(Context context, String categoryId, String programId) {
        Intent intent = new Intent(context, SeriesDetailsActivity.class);
        intent.putExtra("CATEGORY", "CATEGORY");
        intent.putExtra("category_id", categoryId);
        intent.putExtra("program_id", programId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        rvSessions.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        allSessionsAdapter = new AllSessionsAdapter(getApplicationContext());
        rvSessions.setAdapter(allSessionsAdapter);

        String programData = getIntent().getStringExtra("CATEGORY");
        String categoryId = getIntent().getStringExtra("category_id");
        String programId = getIntent().getStringExtra("program_id");

        if (programData.equalsIgnoreCase("CURRENT_PROGRAM")) {
            CurrentProgramsVO currentProgramsVO = new SimpleHabitsModel().getCurrentProgram();
            bindData(currentProgramsVO);
        } else if (programData.equalsIgnoreCase("CATEGORY")) {
            ProgramsVO programsVO = new SimpleHabitsModel().getCategoryId(categoryId, programId);
            bindData(programsVO);
        }
    }

    private void bindData(CurrentProgramsVO currentProgramsVO) {
        ctlDetails.setTitle(currentProgramsVO.getTitle());
        tvCurrentProgramDesc.setText(currentProgramsVO.getDescription());
        allSessionsAdapter.appendNewData(currentProgramsVO.getSessions());
    }

    private void bindData(ProgramsVO programsVO) {
        ctlDetails.setTitle(programsVO.getTitle());
        tvCurrentProgramDesc.setText(programsVO.getDescription());
        allSessionsAdapter.appendNewData(programsVO.getSessions());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


}
