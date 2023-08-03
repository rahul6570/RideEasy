package com.rahul.rideeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerfueladapter extends RecyclerView.Adapter<recyclerfueladapter.viewholder> {
    Context context;
    ArrayList<recordmodel> arrrecordlist;
     recyclerfueladapter(Context context, ArrayList<recordmodel> arrrecordlist){
         this.context=context;
         this.arrrecordlist=arrrecordlist;
     }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v=  LayoutInflater.from(context).inflate(R.layout.record_row,parent,false);
      viewholder vh=new viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.txtrdate.setText(arrrecordlist.get(position).date);
        holder.txtrprice.setText(arrrecordlist.get(position).price);
    }

    @Override
    public int getItemCount() {
        return arrrecordlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView txtrdate,txtrprice;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtrdate=itemView.findViewById(R.id.txtrdate);
            txtrprice=itemView.findViewById(R.id.txtrprice);
        }
    }

}
