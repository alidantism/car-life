package life.car.Education;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EducationPOJO {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("post_title")
    @Expose
    private String postTitle;
    @SerializedName("post_content")
    @Expose
    private String postContent;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
