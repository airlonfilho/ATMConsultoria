package com.filhoairlon.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->  {

            enviarEmail();

        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servico, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre
                )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        String endereco = "https://www.google.com.br/maps/place/Ilhas+Phi+Phi/@7.6762488,98.76553,3a,75y,328.23h,82.44t/data=!3m11!1e1!3m9!1sAF1QipPn6OVNNdvh0AXJh5rv3Ztgk0qs2inwwp7o8v4D!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPn6OVNNdvh0AXJh5rv3Ztgk0qs2inwwp7o8v4D%3Dw203-h100-k-no-pi-0-ya53.82979-ro-0-fo100!7i8704!8i4352!9m2!1b1!2i38!4m7!3m6!1s0x304e20be764e3d0d:0xbf9db8781a549f71!8m2!3d7.740738!4d98.77841!14m1!1BCgIgARICCAI";
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(endereco));
        Intent intent = new Intent( Intent.ACTION_SEND );
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"filhoairlon@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        // intent.setType("message/rfc822");
        intent.setType("text/plain");

        startActivity(Intent.createChooser( intent, "Comparttilhar"));



    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}