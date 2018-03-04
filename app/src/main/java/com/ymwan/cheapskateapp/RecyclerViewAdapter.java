package com.ymwan.cheapskateapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wanyi on 1/3/2018.
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;

    List<DataAdapter> dataAdapters;

    public RecyclerViewAdapter(List<DataAdapter> getDataAdapter, Context context){

        super();

        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        DataAdapter dataAdapter =  dataAdapters.get(position);

        viewHolder.productName.setText(dataAdapter.getProductName());

        viewHolder.productPrice.setText(dataAdapter.getProductPrice());

        viewHolder.productDate.setText(dataAdapter.getProductDate());

        viewHolder.productStore.setText(dataAdapter.getProductStore());



    }

    @Override
    public int getItemCount() {

        return dataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView productName;
        public TextView productPrice;
        public TextView productDate;
        public TextView productStore;



        public ViewHolder(View itemView) {

            super(itemView);

            productName = (TextView) itemView.findViewById(R.id.textView2) ;
            productPrice = (TextView) itemView.findViewById(R.id.textView4) ;
            productDate = (TextView) itemView.findViewById(R.id.textView6) ;
            productStore = (TextView) itemView.findViewById(R.id.textView8) ;


        }
    }
}