package life.car.CostRegistration;

/**
 * Created by AliReza on 5/30/2018.
 */

public class CostRegistrationModel implements CostRegistrationContract.Model {

    CostRegistrationContract.Presenter presenter;

    @Override
    public void attachPresenter(CostRegistrationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getCost(String cost) {
        if (cost.equals("20")) {
            presenter.onModelReceiveGetCost("Twienty");
        } else {
            presenter.onModelReceiveGetCost("Zero");
        }
    }
}
