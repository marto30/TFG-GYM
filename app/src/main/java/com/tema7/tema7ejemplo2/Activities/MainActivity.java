package com.tema7.tema7ejemplo2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.tema7.tema7ejemplo2.Fragments.AlertsFragment;
import com.tema7.tema7ejemplo2.Fragments.AyudaFragment;
import com.tema7.tema7ejemplo2.Fragments.CerrarSesionFragment;
import com.tema7.tema7ejemplo2.Fragments.ChatFragment;
import com.tema7.tema7ejemplo2.Fragments.ConfiguracionFragment;
import com.tema7.tema7ejemplo2.Fragments.EmailFragment;
import com.tema7.tema7ejemplo2.Fragments.EntrenamientoClienteFragment;
import com.tema7.tema7ejemplo2.Fragments.FavoritoFragment;
import com.tema7.tema7ejemplo2.Fragments.InfoFragment;
import com.tema7.tema7ejemplo2.Fragments.InvitarAmigosFragment;
import com.tema7.tema7ejemplo2.Fragments.PerfilClienteFragment;
import com.tema7.tema7ejemplo2.Fragments.TrabajaConNosotrosFragment;
import com.tema7.tema7ejemplo2.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Switch switch_nav;
    private FloatingActionButton btnAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        btnAlerta= (FloatingActionButton) findViewById(R.id.botonAlerts);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navview);
        switch_nav = (Switch) navigationView.getMenu().findItem(R.id.app_bar_switch).getActionView();
        setFragmentByDefault();

        //Despliegue de menu lateral
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Toast.makeText(MainActivity.this, "Menu lateral abierta", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // Toast.makeText(MainActivity.this, "Menu lateral cerrada", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


//Componentes del meno lateral menu/nav_options con su respectivo fragment
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;
                Activity activity = null;
                //IniciarSesionFragment inicio= new IniciarSesionFragment();

                switch (item.getItemId()) {

                    /*case R.id.menu_IniciarSesion:
                        activity = IniciarSesionActivity();
                        fragmentTransaction = true;
                        break;*/
                    case R.id.menu_mail:
                        fragment = new EmailFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_alert:
                        fragment = new AlertsFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_info:
                        fragment = new InfoFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_perfilCliente:
                        fragment = new PerfilClienteFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_favorito:
                        fragment = new FavoritoFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_entrenamientoCliente:
                        fragment = new EntrenamientoClienteFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_chat:
                        fragment = new ChatFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_trabajaConNosotros:
                        fragment = new TrabajaConNosotrosFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_invitaAmigos:
                        fragment = new InvitarAmigosFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_ayuda:
                        fragment = new AyudaFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_configuracion:
                        fragment = new ConfiguracionFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_cerrarSesion:
                        fragment = new CerrarSesionFragment();
                        fragmentTransaction = true;
                        break;

                    case R.id.app_bar_switch:

                }

                if (fragmentTransaction) {
                    changeFragment(fragment, item);
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        switch_nav.setOnCheckedChangeListener(new OyenteSwitch());

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                //.replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }
    private void setFragmentByDefault() {
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                // abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    class OyenteSwitch implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(MainActivity.this, "El switch del menu esta ACTIVADO", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "El switch del menu esta DESACTIVADO", Toast.LENGTH_LONG).show();
            }
        }
    }
}