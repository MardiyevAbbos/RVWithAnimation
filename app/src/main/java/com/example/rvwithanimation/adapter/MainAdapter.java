package com.example.rvwithanimation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvwithanimation.R;
import com.example.rvwithanimation.model.Member;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Member> members;

    public MainAdapter(ArrayList<Member> members) {
        this.members = members;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view_member, parent, false);
        return new MainViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof MainViewHolder) {
            ImageView imageView = ((MainViewHolder) holder).image;
            TextView firstName = ((MainViewHolder) holder).firstName;
            TextView lastName = ((MainViewHolder) holder).lastName;

            imageView.setImageResource(member.getImage());
            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }

    }


    public class MainViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView image;
        public TextView firstName;
        public TextView lastName;

        public MainViewHolder(View v) {
            super(v);
            this.view = v;
            image = view.findViewById(R.id.image);
            firstName = view.findViewById(R.id.first_name);
            lastName = view.findViewById(R.id.last_name);
        }
    }


}
