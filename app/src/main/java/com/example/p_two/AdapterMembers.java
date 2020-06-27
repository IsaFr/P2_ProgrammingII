package com.example.p_two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMembers
        extends RecyclerView.Adapter<AdapterMembers.ViewHolderMembers>
    implements View.OnClickListener
{

    ArrayList<Member> listMembers;
    private View.OnClickListener listener;

    public AdapterMembers(ArrayList<Member> listMembers) {
        this.listMembers = listMembers;
    }

    @NonNull
    @Override
    public ViewHolderMembers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        if(Utilities.visualización==Utilities.LIST)
        {
            layout = R.layout.item_list_layout;
        }
        else
        {
            layout = R.layout.item_grid_layout;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false);
        view.setOnClickListener(this);
        return new ViewHolderMembers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMembers holder, int position) {
        holder.NameTag.setText(listMembers.get(position).getName());
        if(Utilities.visualización==Utilities.LIST)
        {
            holder.InfoTag.setText(listMembers.get(position).getInfo());
        }
        holder.PhotoTag.setImageResource(listMembers.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return listMembers.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
        {
            listener.onClick(view);
        }


    }

    public class ViewHolderMembers extends RecyclerView.ViewHolder {

        TextView NameTag, InfoTag;
        ImageView PhotoTag;

        public ViewHolderMembers(@NonNull View itemView) {
            super(itemView);
            NameTag = (TextView) itemView.findViewById(R.id.idName);
            if(Utilities.visualización==Utilities.LIST)
            {
                InfoTag = (TextView) itemView.findViewById(R.id.idInfo);
            }
            PhotoTag = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
