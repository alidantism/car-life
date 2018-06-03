package life.car.AddCostRegistration;

import life.car.AddCostRegistration.SugarORM.CarModel;

public class AddCostRegistrationModel implements AddCostRegistrationContract.Model {

    AddCostRegistrationContract.Presenter presenter;
    CarModel carModel;

    @Override
    public void attachPresenter(AddCostRegistrationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getFormDataPresenter(String title, String description, String price , String image) {
        carModel = new CarModel();
        carModel.setTitle(title);
        carModel.setDescription(description);
        carModel.setPrice(price);
        carModel.setImage(image);
        carModel.save();
        presenter.emptyFormCostRegistration();
        presenter.addCostRegistrationSuccess();
    }

}
