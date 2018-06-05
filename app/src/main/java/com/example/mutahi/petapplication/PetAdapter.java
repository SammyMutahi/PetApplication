package com.example.mutahi.petapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mutahi on 6/4/2018.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    String pet[];

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int LayoutIdForPetItem = R.layout.pet_number;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImediatly = false;
        View view = inflater.inflate(LayoutIdForPetItem, parent, shouldAttachToParentImediatly);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        String petPosition = pet[position];
        holder.mDisplayResult.setText(petPosition);
    }

    @Override
    public int getItemCount() {
        if (pet == null) {
            return 0;
        } else {
            return pet.length;
        }
    }

    public void setPetData(String[] petData) {
        pet = petData;
        notifyDataSetChanged();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder {
        TextView mDisplayResult;

        public PetViewHolder(View itemView) {
            super(itemView);
            mDisplayResult = itemView.findViewById(R.id.display_results);
        }

    }

}


