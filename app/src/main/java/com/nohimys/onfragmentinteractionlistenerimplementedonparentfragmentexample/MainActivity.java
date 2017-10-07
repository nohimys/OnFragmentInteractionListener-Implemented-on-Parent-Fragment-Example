package com.nohimys.onfragmentinteractionlistenerimplementedonparentfragmentexample;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ChildFragment.OnChildFragmentInteractionByActivityListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout_ParentFragmentArea, new ParentFragment());
        ft.commit();
    }

    @Override
    public void onChildFragmentInteraction(Uri uri) {
        //The message will be passed to here from the ChildFragment
        Toast.makeText(getApplicationContext() ,"Message from ChildFragment is passed to MainActivity.",Toast.LENGTH_SHORT).show();
    }
}
