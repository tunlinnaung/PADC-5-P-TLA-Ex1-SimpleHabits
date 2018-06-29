package com.tla.simplehabits.network;

/**
 * Created by eidoshack on 5/23/18.
 */

public interface SimpleHabitsDataAgent {

    void loadCurrentPrograms(String accessToken, int pageNo);

    void loadCategories(String accessToken, int pageNo);

    void loadTopics(String accessToken, int pageNo);
}
