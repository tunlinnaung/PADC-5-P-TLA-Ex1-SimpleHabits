package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses.GetCategoriesResponse;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses.GetCurrentProgramsResponse;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses.GetTopicResponse;

/**
 * Created by eidoshack on 5/23/18.
 */

public interface SimpleHabitsAPI {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramsResponse> loadCurrentPrograms(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoriesResponse> loadCategories(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicResponse> loadTopics(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

}
