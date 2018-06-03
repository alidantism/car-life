package life.car;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import life.car.CostRegistration.CostRegistrationFragment;
import life.car.Education.EducationFragment_;
import life.car.Login.LoginFragment_;
import life.car.Offense.OffenseFragment_;
import life.car.Report.ReportFragment_;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new CostRegistrationFragment());
        navigation.getMenu().findItem(R.id.navigation_cost_registration).setChecked(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_cost_registration:
                    fragment = new CostRegistrationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_education:
                    fragment = new EducationFragment_();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_log_in:
                    fragment = new LoginFragment_();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_offense:
                    fragment = new OffenseFragment_();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_report:
                    fragment = new ReportFragment_();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
