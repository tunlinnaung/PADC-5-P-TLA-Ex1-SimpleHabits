/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tla.simplehabits.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.tla.simplehabits.data.vo.CategoriesVO;
import com.tla.simplehabits.data.vo.CurrentProgramsVO;
import com.tla.simplehabits.data.vo.ProgramsVO;
import com.tla.simplehabits.data.vo.SessionsVO;
import com.tla.simplehabits.data.vo.TopicsVO;

@Database(entities = {
                       CategoriesVO.class, CurrentProgramsVO.class, ProgramsVO.class,
                       SessionsVO.class, TopicsVO.class
                     }, version = 2)
@TypeConverters({ProgramLengthTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "PADC-SH-AC.DB";

    private static AppDatabase INSTANCE;

    public abstract CategoriesDao categoriesDao();

    public abstract CurrentProgramDao currentProgramDao();

    public abstract ProgramDao programDao();

    public abstract SessionDao sessionDao();

    public abstract TopicDao topicDao();

    public static AppDatabase getNewsDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}