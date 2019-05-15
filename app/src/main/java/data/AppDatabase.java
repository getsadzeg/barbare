package data;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import data.dao.UserDAO;
import data.dao.WordsDAO;
import data.model.UserEntry;
import data.model.WordEntry;

@Database(entities = {WordEntry.class, UserEntry.class}, version = 2, exportSchema = false)
//set exportSchema to 'true' if we want to export db to folder
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    static final String DATABASE_NAME = "barbare.sqlite";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries() //temporary
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            Log.d(LOG_TAG, "in migrate()"); //doesn't log??
        }
    };

    public abstract WordsDAO wordsDAO();
    public abstract UserDAO userDAO();
}