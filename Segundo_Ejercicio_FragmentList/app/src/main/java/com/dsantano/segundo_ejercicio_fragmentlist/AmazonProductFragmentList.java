package com.dsantano.segundo_ejercicio_fragmentlist;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsantano.segundo_ejercicio_fragmentlist.dummy.DummyContent;
import com.dsantano.segundo_ejercicio_fragmentlist.dummy.DummyContent.DummyItem;
import com.dsantano.segundo_ejercicio_fragmentlist.models.AmazonProduct;
import com.dsantano.segundo_ejercicio_fragmentlist.models.IAmazonProductListener;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IAmazonProductListener}
 * interface.
 */
public class AmazonProductFragmentList extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    private List<AmazonProduct> listData;

    private IAmazonProductListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AmazonProductFragmentList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amazonproduct_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }


            MyAmazonProductRecyclerViewAdapter adapter = new MyAmazonProductRecyclerViewAdapter(context,
                    R.layout.fragment_amazon_item, listData);

            recyclerView.setAdapter(adapter);
        }
        
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IAmazonProductListener) {
            mListener = (IAmazonProductListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
