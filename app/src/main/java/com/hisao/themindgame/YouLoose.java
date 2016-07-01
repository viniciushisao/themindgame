package com.hisao.themindgame;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class YouLoose extends Fragment {
    public static final String TAG = "MAIN_FRAGMENT";

    private OnFragmentInteractionListener mListener;

    public YouLoose() {
    }

    public static YouLoose newInstance(String param1, String param2) {
        YouLoose fragment = new YouLoose();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View inflate = inflater.inflate(R.layout.fragment_you_loose, container, false);

        TextView txt = (TextView) inflate.findViewById(R.id.txt_read_the_rules);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.youLoose_onFragmentInteraction(null);
            }
        });
        return inflate;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.youLoose_onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void youLoose_onFragmentInteraction(Uri uri);
    }
}
