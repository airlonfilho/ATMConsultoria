package com.filhoairlon.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filhoairlon.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;


public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "Ta danco certo aqui";

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://atmconsultoria.com.br/")

                .addGroup("Nossas redes sociais")

                .addFacebook("the.medy")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addInstagram("medyo80")

                .create();
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}