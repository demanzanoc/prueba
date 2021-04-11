package co.com.ceiba.mobile.pruebadeingreso.model.user;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String userId;

    @SerializedName("name")
    @Expose
    private String userName;

    @SerializedName("email")
    @Expose
    private String userEmail;

    @SerializedName("phone")
    @Expose
    private String userPhone;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }
}
