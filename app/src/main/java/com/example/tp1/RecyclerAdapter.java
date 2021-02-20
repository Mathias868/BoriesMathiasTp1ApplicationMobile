package com.example.tp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.data.Country;
import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private String[] titles = {"France", //plus utile
            "Allemagne",
            "Espagne",
            "Afrique du sud",
            "Etats-Unis",
            "Japon"
    };

    private String[] details = {"Paris", //plus utile
            "Berlin",
            "Madrid",
            "Pretoria",
            "Washington",
            "Tokyo"};

    private int[] images = { R.drawable.ic_flag_of_france_320px,  //plus utile
            R.drawable.ic_flag_of_germany_320px,
            R.drawable.ic_flag_of_spain_320px,
            R.drawable.ic_flag_of_south_africa_320px,
            R.drawable.ic_flag_of_the_united_states_320px,
            R.drawable.ic_flag_of_japan_320px
    };


    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
         Context c = viewHolder.itemImage.getContext();
        viewHolder.itemTitle.setText(Country.countries[i].getName());
        viewHolder.itemDetail.setText(Country.countries[i].getCapital());
        viewHolder.itemImage.setImageDrawable(c.getResources().getDrawable(
                 c.getResources(). getIdentifier (Country.countries[i].getImgUri() , null , c.getPackageName())));
    }


    public int getItemCount() {
        return titles.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.drapeau);
            itemTitle = itemView.findViewById(R.id.nomPays);
            itemDetail = itemView.findViewById(R.id.item_detail);

            int position = getAdapterPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    int position = getAdapterPosition();
                     Snackbar.make(v, "Bienvenue dans votre pays",
                       Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                    //// Implementation with bundle


                   ListFragmentDirections.ActionFirstFragmentToSecondFragment action = ListFragmentDirections.actionFirstFragmentToSecondFragment();
                    action.setCountryId(position);
                    Navigation.findNavController(v).navigate(action);


                }
            });

        }
    }

}
