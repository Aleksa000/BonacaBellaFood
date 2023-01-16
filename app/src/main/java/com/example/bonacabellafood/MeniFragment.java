package com.example.bonacabellafood;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;


public class MeniFragment extends ListFragment {

    private OnFragmentInteractionListener listener;

    String[] Hrana = new String[] {"Burgeri", "Pizza", "Pomfrit", "HotDog"};
    String[] Kategorija = new String[] {"Hamburger,\nCheeseburger,\nDupli Hamburger, \nDupli Cheeseburger", "Capricciosa, Margherita, Quattro Stagioni", "Sa kačkavaljem", "Američki HotDog"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, Hrana);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException("Nije implementiran odgovorajuci interfejs u " + context.toString());
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        getListView().setSelector(android.R.color.holo_orange_dark);
        if (listener != null){
            listener.menuItemSelected(Hrana[position], Kategorija[position]);
        }
    }

    public interface OnFragmentInteractionListener {
        void menuItemSelected(String os, String version);
    }
}