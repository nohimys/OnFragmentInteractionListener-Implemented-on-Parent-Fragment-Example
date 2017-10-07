package com.nohimys.onfragmentinteractionlistenerimplementedonparentfragmentexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnChildFragmentInteractionByParentFragmentListener} interface
 * to handle interaction events.
 * Use the {@link ChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnChildFragmentInteractionByParentFragmentListener onChildFragmentInteractionByParentFragmentListener;
    private OnChildFragmentInteractionByActivityListener onChildFragmentInteractionByActivityListener;

    private Button buttonMessageToParentFragment;
    private Button buttonMessageToActivity;

    public ChildFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildFragment newInstance(String param1, String param2) {
        ChildFragment fragment = new ChildFragment();
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
        return inflater.inflate(R.layout.fragment_child, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonMessageToParentFragment = (Button)view.findViewById(R.id.button_messageToParentFragment);
        buttonMessageToActivity = (Button)view.findViewById(R.id.button_messageToActivity);

        buttonMessageToParentFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonMessageToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (onChildFragmentInteractionByParentFragmentListener != null) {
//            onChildFragmentInteractionByParentFragmentListener.onChildFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Check whether the Activity implements this listener interface
        //If it has assign it to the instance variable
        //If it hasn't throw an exception
        if (context instanceof OnChildFragmentInteractionByActivityListener) {
            onChildFragmentInteractionByActivityListener = (OnChildFragmentInteractionByActivityListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " OnChildFragmentInteractionByActivityListener must be implemented by the Activity.");
        }

        //Check whether the Parent Fragment implements this listener interface
        //If it has assign it to the instance variable
        //If it hasn't throw an exception
        if (getParentFragment() instanceof OnChildFragmentInteractionByParentFragmentListener) {
            onChildFragmentInteractionByParentFragmentListener = (OnChildFragmentInteractionByParentFragmentListener) getParentFragment();
        } else {
            throw new RuntimeException(" OnChildFragmentInteractionByParentFragmentListener must be implemented by the Parent Fragment.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onChildFragmentInteractionByParentFragmentListener = null;
    }


    public interface OnChildFragmentInteractionByParentFragmentListener {
        void onChildFragmentInteraction(Uri uri);
    }

    public interface OnChildFragmentInteractionByActivityListener {
        void onChildFragmentInteraction(Uri uri);
    }
}
