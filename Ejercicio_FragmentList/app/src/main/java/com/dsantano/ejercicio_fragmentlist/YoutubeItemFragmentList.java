package com.dsantano.ejercicio_fragmentlist;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsantano.ejercicio_fragmentlist.dummy.DummyContent;
import com.dsantano.ejercicio_fragmentlist.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IYoutubeItemListener}
 * interface.
 */
public class YoutubeItemFragmentList extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private IYoutubeItemListener mListener;

    private MyYoutubeItemRecyclerViewAdapter adapter;

    private List<YoutubeItem> youtubeItemList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public YoutubeItemFragmentList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_youtubeitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));

            }
            youtubeItemList = new ArrayList<YoutubeItem>();
            youtubeItemList.add(new YoutubeItem());

            adapter = new MyYoutubeItemRecyclerViewAdapter(
                    context,
                    R.layout.fragment_youtube_items,
                    youtubeItemList);

            recyclerView.setAdapter(adapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IYoutubeItemListener) {
            mListener = (IYoutubeItemListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IYoutubeItemListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
