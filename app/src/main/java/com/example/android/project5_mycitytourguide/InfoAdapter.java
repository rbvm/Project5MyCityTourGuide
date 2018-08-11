package com.example.android.project5_mycitytourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info> {

    /** Resource ID for the background color for this list of items */
    private int mColorResourceId;

    public InfoAdapter(Activity context, ArrayList<Info> infos, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, infos);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Info currentInfo = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get the version name from the current Name object and
        // set this text on the name TextView
        nameTextView.setText(currentInfo.getName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView detailsTextView = listItemView.findViewById(R.id.details_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        detailsTextView.setText(currentInfo.getDetails());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressTextView = listItemView.findViewById(R.id.address_text_view);
        // Check if an image is provided for this word or not
        if (currentInfo.hasAddress()) {
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            addressTextView.setText(currentInfo.getAddress());
            // Make sure the view is visible
            addressTextView.setVisibility(View.VISIBLE);
        } else {
            addressTextView.setVisibility(View.GONE);
        }

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.image);
        // Set the ImageView to the image resource specified in the current Word
        imageView.setImageResource(currentInfo.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
