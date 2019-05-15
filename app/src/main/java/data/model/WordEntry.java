package data.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "words")
public class WordEntry {
    @PrimaryKey
    private int id;
    private String barb;
    private String georgian;

    @Ignore
    public WordEntry() {

    }


    public WordEntry(int id, String barb, String georgian) {
        this.id = id;
        this.barb = barb;
        this.georgian = georgian;
    }

    public int getId() {
        return id;
    }

    public String getBarb() {
        return barb;
    }

    public String getGeorgian() {
        return georgian;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBarb(String barb) {
        this.barb = barb;
    }

    public void setGeorgian(String georgian) {
        this.georgian = georgian;
    }
}
