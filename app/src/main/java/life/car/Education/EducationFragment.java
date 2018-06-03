package life.car.Education;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import life.car.R;

@EFragment(R.layout.fragment_education)
public class EducationFragment extends Fragment implements EducationContract.View {

    ProgressDialog progressDialog;

    @ViewById
    RecyclerView educationRecycler;

    EducationContract.Presenter presenter = new EducationPresenter();

    @AfterViews
    void initView() {
        presenter.attachView(this);
        presenter.receivedData();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("در حال دریافت اطلاعات");
        progressDialog.setMessage("لطفا منتظر بمانید ...");
        onDataLoading();
    }

    @Override
    public void showSuccessData(List<EducationPOJO> pojo) {
        EducationAdapter adapter = new EducationAdapter(getActivity() , pojo);
        RecyclerView.LayoutManager lm   = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        educationRecycler.setAdapter(adapter);
        educationRecycler.setLayoutManager(lm);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDataLoading() {
        progressDialog.show();
    }

    @Override
    public void onDataLoadingFinish() {
        progressDialog.dismiss();
    }
}
