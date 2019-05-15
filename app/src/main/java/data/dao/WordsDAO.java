package data.dao;

import androidx.room.Dao;
import androidx.room.Query;
import data.model.WordEntry;

@Dao
public interface WordsDAO {
    @Query("SELECT * FROM words WHERE id =:id")
    WordEntry getEntry(int id); //wrap it up with LiveData(?)

}
