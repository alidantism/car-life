package life.car.CostRegistration;

/**
 * Created by AliReza on 5/30/2018.
 */

public class CostRegistrationPresenter implements CostRegistrationContract.Presenter {

    CostRegistrationModel model;
    CostRegistrationContract.View view;

    public CostRegistrationPresenter() {
        model = new CostRegistrationModel();
        model.attachPresenter(this);
    }

    @Override
    public void attachView(CostRegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void getCost(String cost) {
        model.getCost(cost);
    }

    @Override
    public void onModelReceiveGetCost(String cost) {
        view.onPresenterGetCost(cost);
    }
}
