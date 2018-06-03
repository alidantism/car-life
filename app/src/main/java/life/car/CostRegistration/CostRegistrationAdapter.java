package life.car.CostRegistration;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import life.car.AddCostRegistration.SugarORM.CarModel;
import life.car.R;

/**
 * Created by AliReza on 5/31/2018.
 */

public class CostRegistrationAdapter extends RecyclerView.Adapter<CostRegistrationAdapter.Holder> {

    Context mContext;
    List<CarModel> carModels;

    public CostRegistrationAdapter(Context mContext, List<CarModel> carModels) {
        this.mContext = mContext;
        this.carModels = carModels;
    }

    @Override
    public CostRegistrationAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cost_registartion_item , parent , false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(CostRegistrationAdapter.Holder holder, int position) {
        holder.title.setText(carModels.get(position).getTitle());
        holder.desc.setText(carModels.get(position).getDescription());
        holder.imageCost.setImageBitmap(BitmapFactory
                .decodeFile(carModels.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView title , desc;
        ImageView imageCost;

        public Holder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
            imageCost = (ImageView) itemView.findViewById(R.id.imageCost);
        }
    }
}
