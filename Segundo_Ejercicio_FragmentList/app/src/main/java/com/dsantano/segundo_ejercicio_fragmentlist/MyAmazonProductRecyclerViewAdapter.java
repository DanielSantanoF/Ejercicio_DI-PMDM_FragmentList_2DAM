package com.dsantano.segundo_ejercicio_fragmentlist;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
                .inflate(R.layout.fragment_amazonproduct, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public AmazonProduct mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
