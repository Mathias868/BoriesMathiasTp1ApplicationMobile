package com.example.tp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tp1.data.Country;
import com.google.android.material.snackbar.Snackbar;

public class DetailFragment extends Fragment {
    public static final String TAG = "SecondFragment";
    TextView nomPays;
    TextView capital;
    TextView langueOfficiel;
    TextView monnaie;
    TextView population;
    TextView superficie;
    ImageView drapeau;





    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context c = getContext();
        nomPays = view.findViewById(R.id.nomPays);
        capital = view.findViewById(R.id.capital);
        langueOfficiel = view.findViewById(R.id.langueOfficielle);
        monnaie = view.findViewById(R.id.monnaie);
        population = view.findViewById(R.id.population);
        superficie = view.findViewById(R.id.superficie);
        drapeau = view.findViewById(R.id.drapeau);

        //// Implementation with bundle setText(Country.countries[R.id.item_title].getName());
        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());

        nomPays.setText(Country.countries[args.getCountryId()].getName());
        capital.setText(Country.countries[args.getCountryId()].getCapital());
       langueOfficiel.setText(Country.countries[args.getCountryId()].getLanguage());
       monnaie.setText(Country.countries[args.getCountryId()].getCurrency());
        population.setText("" + Country.countries[args.getCountryId()].getPopulation()); //"" à été rajouté sinon ca ne marché pas avec un int
        superficie.setText("" + Country.countries[args.getCountryId()].getArea()+"km2");       //"" à été rajouté sinon ca ne marché pas avec un int
        drapeau.setImageDrawable(c.getResources().getDrawable(
               c.getResources(). getIdentifier (Country.countries[args.getCountryId()].getImgUri() , null , c.getPackageName())));


        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(DetailFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}
