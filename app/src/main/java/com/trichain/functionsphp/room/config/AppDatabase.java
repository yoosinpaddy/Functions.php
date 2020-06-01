package com.trichain.functionsphp.room.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.trichain.functionsphp.room.daos.PeopleDao;
import com.trichain.functionsphp.room.daos.TeamDao;
import com.trichain.functionsphp.room.tables.PeopleTable;
import com.trichain.functionsphp.room.tables.TeamTable;


@Database(entities = {PeopleTable.class, TeamTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TeamDao teamDao();

    public abstract PeopleDao peopleDao();

}
