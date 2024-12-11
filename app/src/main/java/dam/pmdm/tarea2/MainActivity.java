package dam.pmdm.tarea2;

import static androidx.core.app.PendingIntentCompat.getActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigatorExtrasKt;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import dam.pmdm.tarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
        implements
            NavigationView.OnNavigationItemSelectedListener,
            DrawerLayout.DrawerListener
{

    private NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Fragment navHostFragment;

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    private Toolbar toolbar;

    private AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Sirve para mostrar la APP de borde a borde
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);

        //Para el setContentView en lugar del Layout usamos su binding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        //nav host fragment (declarado private)
        navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
            NavigationUI.setupWithNavController(binding.toolbar, navController);
        }
        //Listeners
        binding.toolbar.setOnMenuItemClickListener(this::onOptionsItemSelected);
        binding.navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        //Inicializamos la toolbar
        initializeToolbar();

        //SetContentView
        setContentView(binding.getRoot());

        /**
         * Opción con Toolbar:
         * Hay que cambiar el estilo del manifiesto a
         * android:theme="@style/Theme.AppCompat.Light.NoActionBar"
         *
         */
        //Toolbar
        setupToolBar();

        //Drawer
        setupDrawer();

        /*
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(drawerLayout)
                        .build();
        */

        /*
        new AppBarConfiguration.Builder(R.id.nav_back, R.id.nav_home, R.id.nav_about, R.id.nav_settings)
            .setOpenableLayout(drawerLayout)
            .build();
        */


        //Snackbar
        snackbar();

        //Preferencias
        //get_preferences();

} //Fin de onCreate

    private void initializeToolbar() {
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.personajeDetailFragment,
                R.id.personajeListFragment
        ).build();
        //NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void onMenuItemSelected(MenuItem item) {
        //Al pulsar en elementos de opciones
        if (item.getItemId() == R.id.action_aboutus) {
            alerta();
        }
    }

    /**
     * Sobreescribimos los métodos de la clase implementada Drawer
     * @param drawerView The child view that was moved
     * @param slideOffset The new offset of this drawer within its range, from 0-1
     */
    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }


    private void get_preferences(){

    }

    private void show_home(){
        navController.navigate(R.id.personajeListFragment);
    }

    /**
     * Muestra Preferencias
     */
    private void show_preferences(){
        navController.navigate(R.id.preferencesFragment);
        //navController.navigate(R.id.settingsFragment);

    }
    /**
     * Crea la toolbar
     */
    private void setupToolBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(findViewById(R.id.toolbar));
    }

    /**
     * Crea el drawer
     */
    private void setupDrawer() {

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        drawerLayout.addDrawerListener(this);
        setupNavigationView();

        /*
        drawerLayout = findViewById(R.id.drawer_layout);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        navigationView = findViewById(R.id.navigation_view);
        NavigationUI.setupWithNavController(navigationView, navController);

        appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.nav_back, R.id.nav_home, R.id.nav_settings, R.id.nav_about)
                        .setOpenableLayout(drawerLayout)
                        .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        drawerLayout.addDrawerListener(this);
    */
    }

    /**
     * Crea el NavigationView
     */
    private void setupNavigationView() {
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        setDefaultMenuItem();
        setupHeader();
    }

    /**
     * Establece el Item por defecto
     */
    private void setDefaultMenuItem() {
        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);
    }


    /**
     * Establece la cabecera del Drawer.
     * Código comentado, mostraría un toast
     */
    private void setupHeader(){
        View header = navigationView.getHeaderView(0);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean rc = true;
        if (menuItem.getItemId() == R.id.nav_about) {
            alerta();
        } else if (menuItem.getItemId() == R.id.nav_back) {
            //Va al list view o sale; como va a estar en el detail view, va a homeshow_home();
            show_home();
        } else if (menuItem.getItemId() == R.id.nav_settings) { //Muestra settings
            show_preferences();
        } else if (menuItem.getItemId() == R.id.nav_home){
            show_home();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return rc;

    } //Fin onNavigationItemSelected


    /**
     * Muestra un snackbar simple.
     */
    public void snackbar(){

        View v = findViewById(R.id.nav_host_fragment);
        String msg = getResources().getString(R.string.snackbar_msg);
        Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();

    }

    /**
     * Click en un personaje.
     * Método para manejar el clic en un personaje.
     * @param personaje Personaje que se crea
     * @param view le tenemos que pasar la vista
     */
    public void personajeClicked(PersonajeData personaje, View view) {
    //Toast

        Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.char_clicked) + personaje.getName(),
                Toast.LENGTH_SHORT).show();

        // Crear un Bundle para pasar los datos al PersonajeDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", personaje.getName()); // Pasa el nombre del personaje
        bundle.putString("habilities", String.valueOf(personaje.getHabilities()));
        bundle.putString("image", personaje.getImage()); // Pasa la imagen del personaje
        bundle.putString("description", personaje.getDescription()); // Pasa la descripción

        // Navegar al PersonajeDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.personajeDetailFragment, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    /**
     * Creamos el menú
     * @param menu The options menu in which you place your items.
     *
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Al seleccionar elementos del menú
     * @param item The menu item that was selected.
     *
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        /**
         * Para poder usar el switch,
         * hay que añadir a gradle
         * android.nonFinalResIds=false
         * y paso.
         * Este evento se está lanzando en la vista de detalle,
         * pero no en la lista principal
         */

        //About us de la barra de herramientas
        if (item.getItemId() == R.id.action_aboutus) {
            alerta();
            //return true;
        }
        //return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_aboutus) {
            alerta();
            return true;
        } else return false;
    }


    /**
     * Se llama con el evento onClick declarado en el menu.xml
     */
    public void alerta(){

        Activity act = (this);
        AlertDialog.Builder builder = new AlertDialog.Builder(act);

        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title)
                .setIcon(R.drawable.super_mario_ia);

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Alert. Muestra un mensaje de alerta.
     * @param obj Activity or Context
     */
    public void alert_dialog(Activity obj){
        AlertDialog.Builder builder = new AlertDialog.Builder(obj);

        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);

        AlertDialog dialog = builder.create();

    }

}