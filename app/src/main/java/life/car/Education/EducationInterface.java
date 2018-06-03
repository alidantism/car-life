package life.car.Education;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AliReza on 6/1/2018.
 */

public interface EducationInterface {

    @GET("/jsonData.php")
    Call<List<EducationPOJO>> getArticles();

}
