package fragmenttest.captech.com.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.subfragment2, container, false);

        Log.d("SubFragment2", "SubFragment2 Fragment Manager: " + getFragmentManager().toString()); // can also use this one
//        Log.d("SubFragment2", "SubFragment2 Child Fragment Manager: " + getChildFragmentManager().toString()); // do not use
        Log.d("SubFragment2", "SubFragment2 Require Fragment Manager: " + requireFragmentManager().toString()); // this one is best

        return fragmentView;
    }
}
