package dam.pmdm.tarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;
import android.view.View;
import android.widget.Toast;

public class PersonajeRecyclerViewAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

    private final ArrayList<PersonajeData> personajes;
    private final Context context;

    public PersonajeRecyclerViewAdapter (ArrayList<PersonajeData> personajes, Context context){
        this.personajes = personajes;
        this.context = context;
    }

    // Método que crea el ViewHolder
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonajeCardviewBinding binding = PersonajeCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new PersonajeViewHolder(binding);
    }

    //Método para enlazar datos con el ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        PersonajeData currentPersonaje = this.personajes.get(position);
        holder.bind(currentPersonaje);

//        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentPersonaje, view));
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    /**
     * Click en un personaje.
     * @param currentPersonaje Personaje pulsado.
     * @param view Vista.
     */
    private void itemClicked(PersonajeData currentPersonaje, View view) {
        // Llama a la función personajeClicked de MainActivity, pasando la vista
        ((MainActivity) context).personajeClicked(currentPersonaje, view);
    }
}

