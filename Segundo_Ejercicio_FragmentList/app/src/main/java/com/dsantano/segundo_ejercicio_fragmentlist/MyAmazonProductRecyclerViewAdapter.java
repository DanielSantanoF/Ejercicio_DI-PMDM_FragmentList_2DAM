package com.dsantano.segundo_ejercicio_fragmentlist;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dsantano.segundo_ejercicio_fragmentlist.dummy.DummyContent.DummyItem;
import com.dsantano.segundo_ejercicio_fragmentlist.models.AmazonProduct;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link com.dsantano.segundo_ejercicio_fragmentlist.models.IAmazonProductListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAmazonProductRecyclerViewAdapter extends RecyclerView.Adapter<MyAmazonProductRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private int layoutPlantilla;
    private List<AmazonProduct> mValues;

    public MyAmazonProductRecyclerViewAdapter(Context ctx, int layoutPlantilla, List<AmazonProduct> mValues) {
        this.ctx = ctx;
        this.layoutPlantilla = layoutPlantilla;
        this.mValues = mValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_amazon_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        String price = "EUR " + String.valueOf(holder.mItem.getPrice());
        String votes = "(" + String.valueOf(holder.mItem.getVotes() + ")");
        holder.tvtTitle.setText(holder.mItem.getTitle());
        holder.tvtPrice.setText(price);
        holder.rbRate.setRating(holder.mItem.getRate());
        holder.tvtVotes.setText(votes);

        if(holder.mItem.isPrime()) {
            holder.ivTick.setVisibility(View.VISIBLE);
        } else {
            holder.ivTick.setVisibility(View.INVISIBLE);
            holder.tvtPrime.setVisibility(View.INVISIBLE);
        }

        if(!holder.mItem.isFree_shipping()) {
            holder.tvtShipping.setText("No disponible");
        }

        Glide.with(ctx).load(holder.mItem.getUrl()).into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivPhoto;
        public final TextView tvtTitle;
        public final TextView tvtPrice;
        public final ImageView ivTick;
        public final TextView tvtPrime;
        public final TextView tvtDate;
        public final TextView tvtShipping;
        public final RatingBar rbRate;
        public final TextView tvtVotes;
        public final TextView mContentView;
        public AmazonProduct mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivPhoto = view.findViewById(R.id.imageViewProduct);
            tvtTitle = view.findViewById(R.id.textViewProductName);
            tvtPrice = view.findViewById(R.id.textViewPrecio);
            ivTick = view.findViewById(R.id.imageView2);
            tvtPrime = view.findViewById(R.id.textViewPrime);
            tvtDate = view.findViewById(R.id.textViewRecibirlo);
            tvtShipping = view.findViewById(R.id.textViewDisponible);
            rbRate = view.findViewById(R.id.ratingBar);
            tvtVotes = view.findViewById(R.id.textViewVotosRating);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
