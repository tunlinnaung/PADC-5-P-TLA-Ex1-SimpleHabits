package com.tla.simplehabits.network;

import com.tla.simplehabits.network.responses.GetCategoriesResponse;
import com.tla.simplehabits.network.responses.GetCurrentProgramsResponse;
import com.tla.simplehabits.network.responses.GetTopicResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by eidoshack on 5/23/18.
 */

public interface SimpleHabitsAPI {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Observable<GetCurrentProgramsResponse> loadCurrentPrograms(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Observable<GetCategoriesResponse> loadCategories(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getTopics.php")
    Observable<GetTopicResponse> loadTopics(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

}
