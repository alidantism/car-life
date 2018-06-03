package life.car.AddCostRegistration.SugarORM;

import com.orm.SugarRecord;

/**
 * Created by AliReza on 5/31/2018.
 */

public class CarModel extends SugarRecord<CarModel> {

    String title;
    String description;
    String price;
    String image;

    public CarModel(String title, String description, String price, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public CarModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
