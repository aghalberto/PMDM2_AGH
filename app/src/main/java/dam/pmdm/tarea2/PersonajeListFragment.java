package dam.pmdm.tarea2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.tarea2.databinding.ActivityMainBinding;
import dam.pmdm.tarea2.databinding.PersonajeListFragmentBinding;

import java.util.ArrayList;

public class PersonajeListFragment extends Fragment {

    private PersonajeListFragmentBinding binding; // Binding para el layout
    private ArrayList<PersonajeData> personajes; // Lista de juegos
    private PersonajeRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Y si pongo aquí el menú??

        // Inflar el layout utilizando el binding
        binding = PersonajeListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
        //setHasOptionsMenu(true);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadPersonajes(); // Cargar los personajes

        // Configurar el RecyclerView
        adapter = new PersonajeRecyclerViewAdapter(personajes, getActivity());
        binding.personajesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personajesRecyclerview.setAdapter(adapter);


    }

    /**
     * Carga personajes.
     * Método para cargar personajes.
     */
    private void loadPersonajes() {
        personajes = new ArrayList<PersonajeData>();
        // Llenar la lista con datos de videojuegos
        personajes.add(new PersonajeData(
                "https://images.wikidexcdn.net/mwuploads/esssbwiki/c/cb/latest/20220530212008/Mario_Mario_Party_Superstars.png",
                "Mario Mario",
                getResources().getString(R.string.descrip_mario), //"Personaje principal",
                getResources().getString(R.string.skills_mario)
        ));

        personajes.add(new PersonajeData(
                "https://upload.wikimedia.org/wikipedia/en/b/be/Luigi_by_Shigehisa_Nakaue.png", //
                "Luigi Mario",
                getResources().getString(R.string.descrip_luigi),
                getResources().getString(R.string.skills_luigi)
        ));

        personajes.add(new PersonajeData(
                "https://upload.wikimedia.org/wikipedia/commons/7/78/MCM_2013_-_Toad%2C_Luigi_%26_Mario_%288978170431%29_%28cropped%2C_Toad%29.jpg", //
                "Toad",
                getResources().getString(R.string.descrip_toad),
                getResources().getString(R.string.skills_toad)
        ));

        personajes.add(new PersonajeData(
                "https://images.wikidexcdn.net/mwuploads/esssbwiki/thumb/0/04/latest/20180613002304/Wario_SSBU.png/1200px-Wario_SSBU.png", //
                "Wario",
                getResources().getString(R.string.descrip_wario),
                getResources().getString(R.string.skills_wario)
        ));

    }


    @Override
    public void onStart() {

        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_de_personajes);
        }

    } //Fin de onStart

}
