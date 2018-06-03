package life.car.AddCostRegistration;


public interface AddCostRegistrationContract {
    interface View {
        void emptyFormCostRegistration();
        void addCostRegistrationSuccess();
    }

    interface Presenter {
        void attachView(AddCostRegistrationContract.View view);
        void getFormData(String title , String description , String price , String image);
        void emptyFormCostRegistration();
        void addCostRegistrationSuccess();
    }

    interface Model {
        void attachPresenter(AddCostRegistrationContract.Presenter presenter);
        void getFormDataPresenter(String title , String description , String price , String image);
    }
}
