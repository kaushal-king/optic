package com.example.optic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.optic.apiinterface.Api;
import com.example.optic.apiinterface.ApiClient;
import com.example.optic.apiinterface.CommanResponse;
import com.example.optic.apiinterface.responce_get_set.pend_get_set;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pend_adapter extends RecyclerView.Adapter<pend_adapter.ViewHolder> {

    Context mcontex;
    private List<pend_get_set> data;

    public pend_adapter(Context mcontex, List<pend_get_set> data) {
        this.mcontex = mcontex;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlay,null);

        final ViewHolder viewHolder=new ViewHolder(itemview);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mcontex,display.class);
                i.putExtra("name",data.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("mob",data.get(viewHolder.getAdapterPosition()).getMob());
                i.putExtra("l",data.get(viewHolder.getAdapterPosition()).getL());
                i.putExtra("r",data.get(viewHolder.getAdapterPosition()).getR());
                i.putExtra("u",data.get(viewHolder.getAdapterPosition()).getU());
                i.putExtra("ll",data.get(viewHolder.getAdapterPosition()).getLl());
                i.putExtra("lr",data.get(viewHolder.getAdapterPosition()).getLr());
                i.putExtra("lu",data.get(viewHolder.getAdapterPosition()).getLu());
                i.putExtra("gprice",data.get(viewHolder.getAdapterPosition()).getGprice());
                i.putExtra("total",data.get(viewHolder.getAdapterPosition()).getTprice());
                i.putExtra("fprice",data.get(viewHolder.getAdapterPosition()).getFprice());
                i.putExtra("advance",data.get(viewHolder.getAdapterPosition()).getApay());
                mcontex.startActivity(i);
            }
        });






        viewHolder.cmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=data.get(viewHolder.getAdapterPosition()).getId()+"";
                Api api= ApiClient.getClient().create(Api.class);
                Call<CommanResponse> call= api.upd("pentocmp",id);
                call.enqueue(new Callback<CommanResponse>() {
                    @Override
                    public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                        if (response.body().getSuccess()==200) {
                            Toast.makeText(mcontex, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(mcontex, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<CommanResponse> call, Throwable t) {
                        Toast.makeText(mcontex, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        pend_get_set d=data.get(position);

        viewHolder.id.setText(d.getId()+"");
        viewHolder.date.setText(d.getDate());
        viewHolder.name.setText(d.getName());
        viewHolder.to.setText("₹"+d.getTprice());
        viewHolder.ba.setText("₹"+d.getBaki());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
{

    public TextView id,date,name,to,ba;
    Button cmp;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        id=(TextView) itemView.findViewById(R.id.cmp_id);
        date=(TextView) itemView.findViewById(R.id.cmp_date);
        name=(TextView) itemView.findViewById(R.id.cmp_name);
        to=(TextView) itemView.findViewById(R.id.cmp_price);
        ba=(TextView) itemView.findViewById(R.id.cmp_baki);
        cmp=(Button) itemView.findViewById(R.id.cmp_y);


    }
}
}
