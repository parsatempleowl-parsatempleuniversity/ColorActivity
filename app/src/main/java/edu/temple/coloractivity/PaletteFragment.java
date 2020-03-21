package edu.temple.coloractivity;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteFragment extends Fragment {

    private onFragmentInteractionListener listener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(String[] colors_in_english) {
        PaletteFragment fragment = new PaletteFragment();
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

        try {
            listener = (onFragmentInteractionListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement onFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
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
        View view =  inflater.inflate(R.layout.fragment_palette, container, false);
        GridView gridView = view.findViewById(R.id.container1);
        Context context = getActivity();
        String[] colors_in_english = getResources().getStringArray(R.array.colors_in_english);
        ColorAdapter colorAdapter = new ColorAdapter(context, colors_in_english);
        gridView.setAdapter(colorAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                listener.displayNewColor(adapterView.getItemAtPosition(position).toString());
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    interface onFragmentInteractionListener {
        public void displayNewColor(String color);
    }

}
