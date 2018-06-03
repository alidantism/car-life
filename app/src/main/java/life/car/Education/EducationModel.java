package life.car.Education;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AliReza on 6/1/2018.
 */

    public class EducationModel implements EducationContract.Model {

    EducationContract.Presenter presenter;

    @Override
    public void attachPresenter(EducationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void receivedData() {
        API.getClient().create(EducationInterface.class).getArticles().enqueue(new Callback<List<EducationPOJO>>() {
            @Override
            public void onResponse(Call<List<EducationPOJO>> call, Response<List<EducationPOJO>> response) {
                presenter.receivedDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<EducationPOJO>> call, Throwable t) {
                presenter.onFailure(t.toString());
            }
        });
    }
}