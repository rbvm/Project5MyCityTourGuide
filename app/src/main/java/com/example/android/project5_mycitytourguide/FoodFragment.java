package com.example.android.project5_mycitytourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        //Create an array of info items
        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info(getString(R.string.food_name_1),getString(R.string.food_info_1), getString(R.string.food_address_1), R.drawable.la_ceaun));
        infos.add(new Info(getString(R.string.food_name_2),getString(R.string.food_info_2), getString(R.string.food_address_2), R.drawable.casa_tudor));
        infos.add(new Info(getString(R.string.food_name_3),getString(R.string.food_info_3), getString(R.string.food_address_3), R.drawable.ceasu_rau));
        infos.add(new Info(getString(R.string.food_name_4),getString(R.string.food_info_4), getString(R.string.food_address_4), R.drawable.necs));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        InfoAdapter adapter = new InfoAdapter(getActivity(), infos, R.color.category_food);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }

}
