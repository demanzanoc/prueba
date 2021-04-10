package co.com.ceiba.mobile.pruebadeingreso.model.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("id")
    @Expose
    private String postId;

    @SerializedName("title")
    @Expose
    private String postTitle;

    @SerializedName("body")
    @Expose
    private String postBody;

    public String getUserId() {
        return userId;
    }

    public String getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }
}
