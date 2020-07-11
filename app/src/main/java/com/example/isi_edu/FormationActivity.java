package com.example.isi_edu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormationActivity extends Fragment {

    private String [] tabFormation, tabDetails;
    private String formation, details;
    private ListView listFormation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formation_activity, container, false);
        listFormation = view.findViewById(R.id.listFormation);
        //Permet de recuperer la liste des formations au niveau de arrays.
        tabFormation = getResources().getStringArray(R.array.tab_formation);
        tabDetails = getResources().getStringArray(R.array.tab_details);

        // Creation d'un adaptateur pour charger les donnees
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tabFormation);
        listFormation.setAdapter(adapter); // Charge les donnees dans la liste

        // Gestion quand on clique sur un element de la liste
        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On recuperer l'element selection pour afficher ses details
                formation = tabFormation[position];
                details = tabDetails[position];
                // On cree une boite de dialogue pour afficher les details de la formation
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(formation);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.cancel), null);
                dialog.setPositiveButton(getString(R.string.inscription), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // On redirige vers la page Inscription si la personne clique sur Inscription
                        Intent intent = new Intent(getActivity(), InscriptionActivity.class);
                        // On lui passe la formation choisie
                        intent.putExtra("FORMATION", formation);
                        startActivity(intent);
                    }
                });
                dialog.show(); // Pour afficher la boite de dialogue
            }
        });
        return view;
    }
}
