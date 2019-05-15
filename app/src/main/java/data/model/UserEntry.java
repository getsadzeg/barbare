package data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntry {
    @PrimaryKey @NonNull
    private String username;
    private int points;
    private int level;

    @Ignore
    public UserEntry() {

    }

    public UserEntry(@NonNull String username, int points, int level) {
        this.username = username;
        this.points = points;
        this.level = level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public int getLevel() {
        return level;
    }
}
