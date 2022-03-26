package com.cst2335.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter<Message> {
    private Context mContext;
    private int mResource;

    public ChatAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Message> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        if (Message.message == 1){
            LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(mResource, parent, false);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView texts = convertView.findViewById(R.id.textView);
            imageView.setImageResource(getItem(position).getImage());
            texts.setText(getItem(position).getDes());


        }
         if (Message.message == 2) {
             LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(mResource, parent, false);

            ImageView imageView2 = convertView.findViewById(R.id.imageView2);
            TextView texts2 = convertView.findViewById(R.id.textView3);
            imageView2.setImageResource(getItem(position).getImage());
            texts2.setText(getItem(position).getDes());

        }

        return convertView;
    }
}
