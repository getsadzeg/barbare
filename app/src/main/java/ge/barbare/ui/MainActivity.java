package ge.barbare.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import data.AppDatabase;
import data.DatabaseCopier;
import data.model.UserEntry;
import data.model.WordEntry;
import ge.barbare.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseCopier copier = DatabaseCopier.getInstance(getApplicationContext());
        mDb = copier.getRoomDatabase();
        //System.out.println(mDb.wordsDAO().getEntry(2).getValue().getBarb());
        WordEntry wordEntry;
        wordEntry = mDb.wordsDAO().getEntry(2);
        Log.i(TAG, wordEntry.getBarb());

        UserEntry user = new UserEntry("guri", 0, 0);
        mDb.userDAO().addUser(user);
        System.out.println("Points of guri : " + mDb.userDAO().loadUserStats("guri").getPoints());
    }
}
