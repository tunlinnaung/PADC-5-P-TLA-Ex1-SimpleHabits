package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models.SimpleHabitsModel;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.MainItemDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.views.MainView;

public class MainPresenter extends BasePresenter<MainView> implements MainItemDelegate {

    public MainPresenter(MainView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHabitsModel.getInstance().startLoadingSimpleHabits();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainScreenLoaded(RestApiEvents.MainScreenLoadedEvent event) {
        if (event.getMainScreenVOS() == null) {
            mView.displayError("Empty Data");
        } else {
            mView.displayMainScreenList(event.getMainScreenVOS());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        mView.displayError(event.getErrorMsg());
    }

    @Override
    public void onTapCurrentProgram(String currentProgramId) {
        mView.launchCurrentProgram(currentProgramId);
    }

    @Override
    public void onTapCategory(String categoryId, String programId) {
        mView.launchCategory(categoryId, programId);
    }

    @Override
    public List<ProgramsVO> getProgramsById(String programId) {
        return SimpleHabitsModel.getInstance().getProgramsById(programId);
    }

    @Override
    public void onTapTopic(String topicId) {

    }
}
