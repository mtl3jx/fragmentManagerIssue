package fragmenttest.captech.com.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment1, container, false);

        Button button = (Button)fragmentView.findViewById(R.id.launch_dialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                DialogFragment1 dialogFragment1 = new DialogFragment1();
                dialogFragment1.setTargetFragment(Fragment1.this, 1);
                dialogFragment1.show(ft, "dialog");
            }
        });

        return fragmentView;
    }
}
