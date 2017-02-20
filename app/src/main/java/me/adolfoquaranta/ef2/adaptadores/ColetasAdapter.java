package me.adolfoquaranta.ef2.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.adolfoquaranta.ef2.R;
import me.adolfoquaranta.ef2.modelos.Coleta;

public class ColetasAdapter extends RecyclerView.Adapter<ColetasAdapter.MyViewHolder> {

    private List<Coleta> coletaList = new ArrayList<>();

    public ColetasAdapter(List<Coleta> coletaList) {
        this.coletaList = coletaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coleta_linha_lista, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Coleta coleta = coletaList.get(position);
        holder.nome_Coleta.setText(coleta.getNome_Coleta());
        holder.descricao_Coleta.setText(coleta.getDescricao_Coleta());
        holder.status_Coleta.setText(coleta.getStatus_Coleta());
    }

    @Override
    public int getItemCount() {
        return coletaList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome_Coleta, descricao_Coleta, status_Coleta;

        MyViewHolder(View view) {
            super(view);
            nome_Coleta = (TextView) view.findViewById(R.id.nome_Coleta);
            descricao_Coleta = (TextView) view.findViewById(R.id.descricao_Coleta);
            status_Coleta = (TextView) view.findViewById(R.id.status_Coleta);
        }
    }

}
