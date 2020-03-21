package edu.temple.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CanvasFragment extends Fragment {

    private FrameLayout canvasFragment;
    private View view;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String[] colors_in_english) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        for (int i = 0; i < colors_in_english.length; i++) {
            args.putString(String.valueOf(colors_in_english[i]), colors_in_english[i]);
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_canvas, container, false);
        canvasFragment = (FrameLayout) view.findViewById(R.id.container2);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

    public void changeCanvasColor(String color) {
        canvasFragment.setBackgroundColor(Color.parseColor(color));
    }

}
