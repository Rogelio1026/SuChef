package com.mis571_group_d.suchef.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mis571_group_d.suchef.R;
import com.mis571_group_d.suchef.data.model.Ingredient;
import com.mis571_group_d.suchef.data.model.Utensil;

import java.util.ArrayList;

/**
 * Created by abhishek on 12/10/2016.
 */

public class UtensilAdapter extends ArrayAdapter<Utensil>{

    private Context mContext;

    private ArrayList<Utensil> mUtensils;

    public UtensilAdapter(Activity context, ArrayList<Utensil> utensils) {
        super(context, 0, utensils);

        mContext = context;

        mUtensils = utensils;
    }

    @Override
    public long getItemId(int position) {
        return mUtensils.get(position).getId();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listIngredientView  = convertView;

        if(listIngredientView  == null) {
            listIngredientView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_ingredients, parent, false
            );
        }

        //Get current reference ingredient
        Utensil currentUtensil = getItem(position);

        //Setting the ingredient name to the grid
        TextView ingredientName = (TextView) listIngredientView.findViewById(R.id.ingredient_name);
        ingredientName.setText(currentUtensil.getUtensilName());

        //Getting image's resource id
        int resourceId = mContext.getResources().getIdentifier("drawable/"+ currentUtensil.getUtensilImage(), null, mContext.getPackageName());

        //Setting the image to the grid
        ImageView imageView = (ImageView) listIngredientView.findViewById(R.id.ingredient_image);
        imageView.setImageResource(resourceId);

        //returning the Ingredient list
        return listIngredientView;
    }
}
