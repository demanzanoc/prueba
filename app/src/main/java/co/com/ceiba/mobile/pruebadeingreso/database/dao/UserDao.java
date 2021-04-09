package co.com.ceiba.mobile.pruebadeingreso.database.user;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insertAll(User... users);

}
