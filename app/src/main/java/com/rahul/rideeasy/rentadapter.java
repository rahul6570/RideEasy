package com.rahul.rideeasy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class rentadapter extends FirebaseRecyclerAdapter<RentModel,rentadapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public rentadapter(@NonNull FirebaseRecyclerOptions<RentModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull RentModel model) {
            holder.txtrname.setText(model.getName());
            holder.txtrnumber.setText(model.getPhone());
            holder.txtrrate.setText(model.getRate());

        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_item,parent,false);
        return new myviewholder(v);
    }

    class  myviewholder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView txtrrate,txtrnumber,txtrname;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtrname=(TextView)itemView.findViewById(R.id.txtrname);
            txtrnumber=(TextView)itemView.findViewById(R.id.txtrnumber);
            txtrrate=(TextView)itemView.findViewById(R.id.txtrrate);
            img=(CircleImageView)itemView.findViewById(R.id.img1);
        }
    }
}
