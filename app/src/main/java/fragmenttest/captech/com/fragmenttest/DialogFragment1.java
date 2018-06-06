package fragmenttest.captech.com.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DialogFragment1 extends DialogFragment {

    TextView tab1;
    TextView tab2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.dialog1, container, false);

        Button closeButton = dialogView.findViewById(R.id.close_button);
        tab1 = dialogView.findViewById(R.id.tab1);
        tab2 = dialogView.findViewById(R.id.tab2);

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubFragment1 tab1Fragment = new SubFragment1();
                showFragment(tab1Fragment);
                setActiveInactive(tab1, tab2);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubFragment2 tab2Fragment = new SubFragment2();
                showFragment(tab2Fragment);
                setActiveInactive(tab2, tab1);
            }
        });

        Log.d("DialogFragment1", "Fragment Manager: " + getFragmentManager().toString()); // use this one
//        Log.d("DialogFragment1", "Child Fragment Manager: " + getChildFragmentManager().toString()); // don't use this one
        Log.d("DialogFragment1", "Require Fragment Manager: " + requireFragmentManager().toString()); // best one to use

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        SubFragment1 tab1Fragment = new SubFragment1();
        showFragment(tab1Fragment);
        setActiveInactive(tab1, tab2);

        return dialogView;
    }


    private void setActiveInactive(TextView active, TextView inactive) {
        active.setBackgroundResource(R.drawable.bg_active);
        inactive.setBackgroundResource(R.drawable.bg_inactive);
        active.setTextColor(getResources().getColor(R.color.tab_active_text));
        inactive.setTextColor(getResources().getColor(R.color.tab_inactive_text));
    }

    private void showFragment(Fragment fragment) {
//      Use this on >25 get the error:     java.lang.IllegalArgumentException: No view found for id 0x7f0d009f (fragmenttest.captech.com.fragmenttest:id/container) for fragment SubFragment1{912e199 #2 id=0x7f0d009f}
//        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit(); // does not work

//        Works for version 25.
//        For >25 get the following error:     java.lang.IllegalStateException: Fragment SubFragment1{abbbb74 #0 id=0x7f0d009f} declared target fragment DialogFragment1{4c4589d #1 dialog} that does not belong to this FragmentManager!
//        getChildFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        fragment.setTargetFragment(DialogFragment1.this, 1);

        FragmentTransaction ft = requireFragmentManager().beginTransaction();
        // requireFragManager better bc it is null safe

        ft.replace(R.id.main_activity_content, fragment)
                .addToBackStack(null)
                .commit();

    }

}
