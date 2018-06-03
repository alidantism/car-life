package life.car.CostRegistration;

/**
 * Created by AliReza on 5/30/2018.
 */

public interface CostRegistrationContract {

    interface View {
        void onPresenterGetCost(String cost);
    }

    interface Presenter {
        void attachView(View view);
        void getCost(String cost);
        void onModelReceiveGetCost(String cost);
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void getCost(String cost);
    }

}
