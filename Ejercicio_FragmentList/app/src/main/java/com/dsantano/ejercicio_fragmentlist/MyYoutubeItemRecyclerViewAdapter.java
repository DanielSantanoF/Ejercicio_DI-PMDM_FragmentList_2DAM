package com.dsantano.ejercicio_fragmentlist;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.dsantano.ejercicio_fragmentlist.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link IYoutubeItemListener}.
 */
public class MyYoutubeItemRecyclerViewAdapter extends RecyclerView.Adapter<MyYoutubeItemRecyclerViewAdapter.ViewHolder> {

    private final List<YoutubeItem> mValues;
    private Context ctx;
    private int layout;

    public MyYoutubeItemRecyclerViewAdapter(Context ctx, int layout, List<YoutubeItem> objects) {
        mValues = objects;
        this.ctx = ctx;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_youtube_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtAuthor.setText(holder.mItem.getAuthor());
        holder.txtViews.setText(String.valueOf(holder.mItem.getViews()));
        holder.txtTittle.setText(holder.mItem.getTittle());
        holder.txtDuration.setText(holder.mItem.getDuration());
        Glide
                .with(ctx)
                .load(holder.mItem.getVidUrl())
                .into(holder.ivPhoto);
        Glide
                .with(ctx)
                .load(holder.mItem.getAuthorUrl())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.ivAuthor);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtAuthor;
        public final TextView txtViews;
        public final TextView txtTittle;
        public final ImageView ivAuthor;
        public final ImageView ivPhoto;
        public final TextView txtDuration;
        public YoutubeItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtAuthor = view.findViewById(R.id.textViewAuthor);
            txtViews = view.findViewById(R.id.textViewViews);
            txtTittle = view.findViewById(R.id.textViewTitle);
            ivAuthor = view.findViewById(R.id.imageViewAuthor);
            ivPhoto = view.findViewById(R.id.imageViewPhoto);
            txtDuration = view.findViewById(R.id.textViewDuration);
        }

    }
}
