package life.car.Education;

import java.util.List;

/**
 * Created by AliReza on 6/1/2018.
 */

public class EducationPresenter implements EducationContract.Presenter {

    EducationModel model;
    EducationContract.View view;

    public EducationPresenter() {
        model = new EducationModel();
        model.attachPresenter(this);
    }

    @Override
    public void attachView(EducationContract.View view) {
        this.view = view;
    }

    @Override
    public void receivedData() {
        model.receivedData();
    }

    @Override
    public void receivedDataSuccess(List<EducationPOJO> pojo) {
        view.showSuccessData(pojo);
        view.onDataLoadingFinish();
    }

    @Override
    public void onFailure(String t) {

    }
}
