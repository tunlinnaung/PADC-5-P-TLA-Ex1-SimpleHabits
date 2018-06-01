package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
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

    @BindView(R.id.tv_current_program_title)
    TextView tvCurrentProgramTitle;

    @BindView(R.id.tv_current_program_desc)
    TextView tvCurrentProgramDesc;

    @BindView(R.id.rv_all_sessions)
    RecyclerView rvSessions;

    AllSessionsAdapter allSessionsAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SeriesDetailsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_details);
        ButterKnife.bind(this);

        rvSessions.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        allSessionsAdapter = new AllSessionsAdapter(getApplicationContext());
        rvSessions.setAdapter(allSessionsAdapter);

        String programData = getIntent().getStringExtra("CATEGORY");
        String categoryId = getIntent().getStringExtra("category_id");

        if (programData.equalsIgnoreCase("CURRENT_PROGRAM")) {
            CurrentProgramsVO currentProgramsVO = SimpleHabitsModel.getInstance().mCurrentProgram;
            bindData(currentProgramsVO);
        } else if (programData.equalsIgnoreCase("CATEGORY")) {
            ProgramsVO programsVO = SimpleHabitsModel.getInstance().getProgramId(categoryId);
            bindData(programsVO);
        }
    }

    private void bindData(CurrentProgramsVO currentProgramsVO) {
        tvCurrentProgramTitle.setText(currentProgramsVO.getTitle());
        tvCurrentProgramDesc.setText(currentProgramsVO.getDescription());
        allSessionsAdapter.appendNewData(currentProgramsVO.getSessions());
    }

    private void bindData(ProgramsVO programsVO) {
        tvCurrentProgramTitle.setText(programsVO.getTitle());
        tvCurrentProgramDesc.setText(programsVO.getDescription());
        allSessionsAdapter.appendNewData(programsVO.getSessions());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details, menu);
        return true;
    }


}
