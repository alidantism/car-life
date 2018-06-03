package life.car.AddCostRegistration;


public class AddCostRegistrationPresenter  implements AddCostRegistrationContract.Presenter  {

    AddCostRegistrationModel model;
    AddCostRegistrationContract.View view;

    public AddCostRegistrationPresenter() {
        model = new AddCostRegistrationModel();
        model.attachPresenter(this);
    }

    @Override
    public void attachView(AddCostRegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void getFormData(String title, String description, String price , String image) {
        model.getFormDataPresenter(title , description , price , image);
    }

    @Override
    public void emptyFormCostRegistration() {
        view.emptyFormCostRegistration();
    }

    @Override
    public void addCostRegistrationSuccess() {
        view.addCostRegistrationSuccess();
    }

}
