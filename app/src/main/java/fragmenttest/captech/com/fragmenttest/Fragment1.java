package fragmenttest.captech.com.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment1, container, false);

        Button button = fragmentView.findViewById(R.id.launch_dialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentActivity context = getActivity();
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                Log.d("Fragment1", "Fragment Manager: " + getFragmentManager().toString()); // use this one
//                Log.d("Fragment1", "Child Fragment Manager: " + getChildFragmentManager().toString()); // don't use this
                Log.d("Fragment1", "Require Fragment Manager: " + requireFragmentManager().toString()); // should use this -- best!

//                Log.d("Fragment1", "Activity Fragment Manager: " + context.getFragmentManager().toString()); // don't use this
                Log.d("Fragment1", "Activity Support Fragment Manager: " + context.getSupportFragmentManager().toString()); // can use this one

                DialogFragment1 dialogFragment1 = new DialogFragment1();
                dialogFragment1.setTargetFragment(Fragment1.this, 1);
                dialogFragment1.show(ft, "dialog");
            }
        });

        return fragmentView;
    }
}
