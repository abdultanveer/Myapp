package com.next.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {
    LayoutInflater mInflater;
    String[] mCountries;
    Context mContext;
    public CountriesAdapter(Context context, String[] countries) {
        mInflater = LayoutInflater.from(context);
        mCountries = countries;
        mContext = context;

    }

    /**
     * onCreateViewHolder --- job of sai is to buy new wooden planks from shop as and when needed and add it to the box[viewholder]
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public CountriesAdapter.CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_row_woodenplank, parent, false); //bought
        return new CountriesViewHolder(mItemView, this); //added to box
    }

    /**
     * onBindViewHolder -- farhans job is to WRITE the name of dish on the wooden plank which is available in the hotel now
     * the wooden plank which sai bought recently
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.CountriesViewHolder holder, int position) {
        String currentCountry = mCountries[position];
        // Add the data to the view
        holder.countryTextView.setText(currentCountry);

    }

    /**
     * getItemCount -- job of shubam to keep a count of no of dishes available in kitchen[data queried from db]
     * shubam will inform sai about the no of dishes [data rows] to sai.
     * @return
     */
    @Override
    public int getItemCount() {
        return mCountries.length;
    }


    /**
     * ViewHolder -- it is  a box holding the newly bought wooden planks by sai
     */
    public class CountriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView countryTextView;
        ImageView flagImageView;
        public CountriesViewHolder(@NonNull View itemView, CountriesAdapter countriesAdapter) {
            super(itemView);
            countryTextView = itemView.findViewById(R.id.textViewCountry);
            flagImageView = itemView.findViewById(R.id.imageViewflag);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "recycler item clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
