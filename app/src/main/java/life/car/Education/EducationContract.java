package life.car.Education;

import java.util.List;

/**
 * Created by AliReza on 6/1/2018.
 */

public interface EducationContract {
    interface View {
        void showSuccessData(List<EducationPOJO> pojo);
        void onDataLoading();
        void onDataLoadingFinish();
    }
    interface Presenter {
        void attachView(View view);
        void receivedData();
        void receivedDataSuccess(List<EducationPOJO> pojo);
        void onFailure(String t);
    }
    interface Model {
        void attachPresenter(Presenter presenter);
        void receivedData();
    }
}
