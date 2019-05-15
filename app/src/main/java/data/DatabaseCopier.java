package data;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseCopier {
    private static final String TAG = DatabaseCopier.class.getSimpleName();

    private AppDatabase mAppDataBase;
    private static Context appContext;

    private static class Holder {
        private static final DatabaseCopier INSTANCE = new DatabaseCopier();
    }

    public static DatabaseCopier getInstance(Context context) {
        appContext = context;
        return Holder.INSTANCE;
    }

    private DatabaseCopier() {
        //call method that check if database not exists and copy prepopulated file from assets
        copyDatabaseFromAssets(appContext, AppDatabase.DATABASE_NAME, false);
        mAppDataBase = AppDatabase.getInstance(appContext);
    }

    public AppDatabase getRoomDatabase() {
        return mAppDataBase;
    }


    private boolean copyDatabaseFromAssets(Context context, String databaseName , boolean overwrite)  {

        File outputFile = context.getDatabasePath(databaseName);
        if (outputFile.exists() && !overwrite) {
            return true;
        }

        outputFile = context.getDatabasePath(databaseName + ".temp");
        outputFile.getParentFile().mkdirs();

        try {
            InputStream inputStream = context.getAssets().open(databaseName);
            OutputStream outputStream = new FileOutputStream(outputFile);


            // transfer bytes from the input stream into the output stream
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Close the streams
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            outputFile.renameTo(context.getDatabasePath(databaseName));

        } catch (IOException e) {
            if (outputFile.exists()) {
                outputFile.delete();
            }
            return false;
        }

        return true;
    }

}
