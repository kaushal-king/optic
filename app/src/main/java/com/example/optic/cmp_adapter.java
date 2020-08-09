package com.example.optic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.optic.apiinterface.responce_get_set.pend_get_set;

import java.util.List;

public class cmp_adapter extends RecyclerView.Adapter<cmp_adapter.ViewHolder>  {
    Context mcontex;
    private List<pend_get_set> data;

    public cmp_adapter(Context mcontex, List<pend_get_set> data) {
        this.mcontex = mcontex;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlay2,null);

        ViewHolder viewHolder=new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        pend_get_set d=data.get(position);

        viewHolder.id.setText(d.getId()+"");
        viewHolder.date.setText(d.getDate());
        viewHolder.name.setText(d.getName());
        viewHolder.to.setText("₹"+d.getTprice());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView id,date,name,to;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.ped_id);
            date=(TextView) itemView.findViewById(R.id.ped_date);
            name=(TextView) itemView.findViewById(R.id.ped_name);
            to=(TextView) itemView.findViewById(R.id.ped_price);



        }
    }
}
