package life.car.CostRegistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import life.car.AddCostRegistration.AddCostRegistrationView_;
import life.car.AddCostRegistration.SugarORM.CarModel;
import life.car.R;

public class CostRegistrationFragment extends Fragment implements CostRegistrationContract.View {

    CostRegistrationPresenter presenter;
    RecyclerView recyclerView;
    ImageView addCost;

    CostRegistrationAdapter adapter;
    List<CarModel> aa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cost_registration, container, false);
        bind(v);
        return v;
    }

    void bind(View v) {
        presenter = new CostRegistrationPresenter();
        presenter.attachView(this);

        recyclerView = (RecyclerView) v.findViewById(R.id.carModels) ;
        aa = CarModel.listAll(CarModel.class);
        adapter = new CostRegistrationAdapter(getActivity(), aa);
        RecyclerView.LayoutManager lm   = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(lm);
        adapter.notifyDataSetChanged();

        addCost = (ImageView) v.findViewById(R.id.addCost);
        addCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(), AddCostRegistrationView_.class);
                getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public void onPresenterGetCost(String cost) {
        Toast.makeText(getActivity(), cost, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!aa.isEmpty()){
            aa.clear();
            aa = CarModel.listAll(CarModel.class);
            adapter = new CostRegistrationAdapter(getActivity(), aa);
            RecyclerView.LayoutManager lm   = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(lm);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(!aa.isEmpty()){
            aa.clear();
            aa = CarModel.listAll(CarModel.class);
            adapter = new CostRegistrationAdapter(getActivity(), aa);
            RecyclerView.LayoutManager lm   = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(lm);
            adapter.notifyDataSetChanged();
        }
    }
}
