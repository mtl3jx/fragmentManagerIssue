package fragmenttest.captech.com.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment2, container, false);

        FragmentActivity context = getActivity();

        Log.d("Fragment2", "Fragment Manager: " + getFragmentManager().toString()); // use this one
//        Log.d("Fragment2", "Child Fragment Manager: " + getChildFragmentManager().toString()); // don't use this
        Log.d("Fragment2", "Require Fragment Manager: " + requireFragmentManager().toString()); // best one to use! null safe

//        Log.d("Fragment2", "Activity Fragment Manager: " + context.getFragmentManager().toString()); // don't use this
        Log.d("Fragment2", "Activity Support Fragment Manager: " + context.getSupportFragmentManager().toString()); // can use this one

        return fragmentView;
    }
}
