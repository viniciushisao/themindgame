package com.hisao.themindgame;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements YouLoose.OnFragmentInteractionListener, GameRules.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, new YouLoose());
        transaction.addToBackStack(YouLoose.TAG);
        transaction.commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        }
        super.onBackPressed();
    }

    @Override
    public void gameRules_onFragmentInteraction(Uri uri) {
    }

    @Override
    public void youLoose_onFragmentInteraction(Uri uri) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, new GameRules());
        transaction.addToBackStack(GameRules.TAG);
        transaction.commit();
        getSupportFragmentManager().executePendingTransactions();

    }
}