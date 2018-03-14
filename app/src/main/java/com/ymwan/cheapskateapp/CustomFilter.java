package com.ymwan.cheapskateapp;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;

public class CustomFilter extends Filter{

    DataAdapter adapter;
    List<DataAdapter> filterList;


    public CustomFilter(List<DataAdapter> filterList, DataAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            List<DataAdapter> filteredProduct =new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getProductName().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredProduct.add(filterList.get(i));
                }
            }
            results.count=filteredProduct.size();
            results.values=filteredProduct;
        }
        else
        {
            results.count=filterList.size();
            results.values=filterList;
        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.dataAdapters = (List<DataAdapter>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
