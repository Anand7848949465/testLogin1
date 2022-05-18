package com.example.login.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Model.UserFeatureItem;
import com.example.login.R;

import java.util.ArrayList;
import java.util.List;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {

    List<UserFeatureItem> list = new ArrayList<>();
    Context context;

    public FeatureAdapter(List<UserFeatureItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_layout_feature,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.FeatureNameText.setText(list.get(position).getFeatureName());
        holder.idText.setText(list.get(position).getId());
        if(list.get(position).isActive()){
            holder.ActiveText.setText("Active");
        }
        else {
            holder.ActiveText.setText("Not Active");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText idText,FeatureNameText,ActiveText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idText=itemView.findViewById(R.id.idEditText);
            FeatureNameText=itemView.findViewById(R.id.featureNameEditText);
            ActiveText=itemView.findViewById(R.id.activeEditText);
        }
    }
}
