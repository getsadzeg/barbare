package data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
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
    UserEntry loadUserStats(String username); //wrap it up with LiveData(?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUserStats(UserEntry user);

    @Delete
    void deleteUser(UserEntry user); //may remove this in the future

}
