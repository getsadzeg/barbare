package data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import data.model.UserEntry;

@Dao
public interface UserDAO {
    @Insert
    void addUser(UserEntry user);

    @Query("SELECT * FROM user WHERE username=:username")
    LiveData<UserEntry> loadUserStats(String username);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUserStats(UserEntry user);

}
