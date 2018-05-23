package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses.GetCategoriesResponse;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses.GetCurrentProgramsResponse;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses.GetTopicResponse;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitsDataAgentImpl implements SimpleHabitsDataAgent {

    private static SimpleHabitsDataAgentImpl objInstance;

    private SimpleHabitsAPI theAPI;

    private SimpleHabitsDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(SimpleHabitsAPI.class);

    }

    public static SimpleHabitsDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new SimpleHabitsDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadCurrentPrograms(String accessToken, int pageNo) {
        Call<GetCurrentProgramsResponse> loadCurrentProgramsCall = theAPI.loadCurrentPrograms(pageNo, accessToken);
        loadCurrentProgramsCall.enqueue(new Callback<GetCurrentProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramsResponse> call, Response<GetCurrentProgramsResponse> response) {
                GetCurrentProgramsResponse getCurrentProgramsResponse = response.body();
                if (getCurrentProgramsResponse != null
                        && getCurrentProgramsResponse.getCurrentProgram() != null) {
                    RestApiEvents.CurrentProgramsDataLoadedEvent currentProgramsDataLoadedEvent = new RestApiEvents.CurrentProgramsDataLoadedEvent(
                            getCurrentProgramsResponse.getCurrentProgram());
                    EventBus.getDefault().post(currentProgramsDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramsResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadCategories(String accessToken, int pageNo) {
        Call<GetCategoriesResponse> loadCategoriesCall = theAPI.loadCategories(pageNo, accessToken);
        loadCategoriesCall.enqueue(new Callback<GetCategoriesResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesResponse> call, Response<GetCategoriesResponse> response) {
                GetCategoriesResponse getCategoriesResponse = response.body();
                if (getCategoriesResponse != null
                        && getCategoriesResponse.getCategoriesPrograms().size() > 0) {
                    RestApiEvents.CategoriesDataLoadedEvent categoriesDataLoadedEvent = new RestApiEvents.CategoriesDataLoadedEvent(
                            getCategoriesResponse.getCategoriesPrograms());
                    EventBus.getDefault().post(categoriesDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadTopics(String accessToken, int pageNo) {
        Call<GetTopicResponse> loadTopicsCall = theAPI.loadTopics(pageNo, accessToken);
        loadTopicsCall.enqueue(new Callback<GetTopicResponse>() {
            @Override
            public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                GetTopicResponse getTopicResponse = response.body();
                if (getTopicResponse != null
                        && getTopicResponse.getTopics().size() > 0) {
                    RestApiEvents.TopicsDataLoadedEvent topicsDataLoadedEvent = new RestApiEvents.TopicsDataLoadedEvent(
                            getTopicResponse.getTopics());
                    EventBus.getDefault().post(topicsDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
