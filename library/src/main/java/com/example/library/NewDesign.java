package com.example.library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewDesign#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewDesign extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewDesign() {
        // Required empty public constructor
    }

    public void login () {
        final EditText userText = (EditText) getActivity().findViewById(R.id.user_edit_text1);
        final EditText passWordText = (EditText) getActivity().findViewById(R.id.pass_edit_text1);
        Button loginButton = (Button) getActivity().findViewById(R.id.login_button1);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateLogin(userText.getText().toString(), passWordText.getText().toString())) {
                    return;
                }
                Toast.makeText(getActivity(), "Success",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateLogin(String user, String pass) {
        if (user.equals("")) {
            Toast.makeText(getActivity(), "Please enter information in the user ",
                    Toast.LENGTH_SHORT).show();
            return false;

        } else if (pass.equals("")) {
            Toast.makeText(getActivity(), "Please enter information in the  ",
                    Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewDesign.
     */
    // TODO: Rename and change types and number of parameters
    public static NewDesign newInstance(String param1, String param2) {
        NewDesign fragment = new NewDesign();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_design, container, false);
    }
}