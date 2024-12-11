package dam.pmdm.tarea2;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final PersonajeCardviewBinding binding;

    public PersonajeViewHolder(PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (PersonajeData personaje){
        Picasso.get()
                .load(personaje.getImage())
                .into(binding.image);
        binding.name.setText(personaje.getName());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}

