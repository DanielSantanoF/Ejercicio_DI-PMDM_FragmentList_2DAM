package com.dsantano.ejercicio_fragmentlist;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
                .inflate(R.layout.fragment_youtubeitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getTittle());
        holder.mContentView.setText(mValues.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public YoutubeItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
        }

    }
}
