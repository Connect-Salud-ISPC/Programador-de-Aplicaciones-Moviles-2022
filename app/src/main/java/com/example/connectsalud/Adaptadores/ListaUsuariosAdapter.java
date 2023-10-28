package com.example.connectsalud.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.connectsalud.VerActivity;
import com.example.connectsalud.Entidades.Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaUsuariosAdapter extends RecyclerView.Adapter<ListaUsuariosAdapter.UsuarioViewHolder> {

    ArrayList<Usuarios> listaUsuarios;

    public ListaUsuariosAdapter(ArrayList<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaUsuarios);
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contacto, null, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.viewNombre.setText(listaUsuarios.get(position).getNombre());
        holder.viewTelefono.setText(listaUsuarios.get(position).getTelefono());
        holder.viewCorreo.setText(listaUsuarios.get(position).getCorreo_electornico());
    }

    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaUsuarios.clear();
            listaUsuarios.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Usuarios> collecion = listaUsuarios.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaUsuarios.clear();
                listaUsuarios.addAll(collecion);
            } else {
                for (Usuarios c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaUsuarios.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewCorreo;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaUsuarios.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}