package life.car.Education;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import life.car.R;

/**
 * Created by AliReza on 6/1/2018.
 */

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.Holder> {

    Context mContext;
    List<EducationPOJO> educationModels;

    public EducationAdapter(Context mContext, List<EducationPOJO> educationModels) {
        this.mContext = mContext;
        this.educationModels = educationModels;
    }

    @Override
    public EducationAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.education_item , parent , false);
        return new EducationAdapter.Holder(v);
    }

    @Override
    public void onBindViewHolder(EducationAdapter.Holder holder, int position) {
        holder.title.setText(educationModels.get(position).getPostTitle());
        holder.desc.setText(educationModels.get(position).getPostContent());
        Picasso.get().load(educationModels.get(position).getImage()).into(holder.imageEdu);
    }

    @Override
    public int getItemCount() {
        return educationModels.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView title , desc;
        ImageView imageEdu;

        public Holder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
            imageEdu = (ImageView) itemView.findViewById(R.id.imageEdu);
        }
    }
}
