package ge.barbare.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import data.AppDatabase;
import data.DatabaseCopier;
import ge.barbare.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String INTRO_PREFERENCES = "introPrefs";

    private AppDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if(!sp.getBoolean("first", false)) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("first", true);
            editor.apply();
            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(intent); //SIGNIFICANT delay
            Log.d(TAG, "in 'if' statement, onCreate");

        }*/


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseCopier copier = DatabaseCopier.getInstance(getApplicationContext());
        mDb = copier.getRoomDatabase();
    }
}
