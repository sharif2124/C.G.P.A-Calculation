package com.sharif.cgpakoto.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sharif.cgpakoto.DAO.CourseDao;
import com.sharif.cgpakoto.DAO.SemesterDao;
import com.sharif.cgpakoto.Modelclass.Course;
import com.sharif.cgpakoto.Modelclass.Semester;

@Database(entities = {Course.class, Semester.class}, version = 1, exportSchema = false)
public abstract class GradeDatabase extends RoomDatabase {
    public abstract CourseDao courseDao();
    public abstract SemesterDao semesterDao();
    public static volatile GradeDatabase INSTANCE;

    public static GradeDatabase getDatabase(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    GradeDatabase.class,
                    "GRADEDATABASE")
                    .fallbackToDestructiveMigration().build();

        }
        return INSTANCE;
    }

}
