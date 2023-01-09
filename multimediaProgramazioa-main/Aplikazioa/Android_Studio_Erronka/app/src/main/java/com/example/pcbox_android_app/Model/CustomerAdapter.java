package com.example.pcbox_android_app.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcbox_android_app.R;

import java.util.ArrayList;

//Bezeroen zerrenda kudeatzeko klasea
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    ArrayList<Bezeroa> bezeroak;
    Context context;

    public CustomerAdapter(ArrayList <Bezeroa> bezeroak, Context activity) {
        this.bezeroak = bezeroak;
        this.context = activity;
    }

    @NonNull
    @Override
    //ViewHolderra sortzean zer layout erabili behar den zehazten du
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_bezeroak,parent,false);
        ViewHolder viewcusHolder = new ViewHolder(view);
        return viewcusHolder;
    }

    @Override
    //ViewHolderreko elementuak betetzeko metodoa
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Bezeroa bezeroakList = bezeroak.get(position);
        holder.textViewName.setText(bezeroakList.getBezeroa());
        holder.textViewDate.setText(bezeroakList.getFetxa().toString());
        /*Uri uriImage = Uri.parse("C:\\Users\\elorza.karmele\\Desktop\\Android_Studio_Erronka\\app\\src\\main\\res\\drawable\\vecerosketa.png");
        holder.movieImage.setImageURI(uriImage);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, bezeroakList.getBezeroa(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //bezeroen zerrendaren tamaina itzultzen du
    public int getItemCount() {
        return bezeroak.size();
    }
    //ViewHolderra ezartzen zaio recyclerView-ean
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageArgazkia);
            textViewName = itemView.findViewById(R.id.txtBezeroa);
            textViewDate = itemView.findViewById(R.id.txtFetxa);
        }
    }
}
