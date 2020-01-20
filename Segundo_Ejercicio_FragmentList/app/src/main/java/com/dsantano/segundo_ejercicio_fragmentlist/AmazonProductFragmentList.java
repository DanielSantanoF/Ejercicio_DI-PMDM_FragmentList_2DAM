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

import java.util.ArrayList;
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
            listData = new ArrayList<AmazonProduct>();
            listData.add(new AmazonProduct("Sony PlayStation - Consola Classic + 2 mandos", "https://images-na.ssl-images-amazon.com/images/I/71mokVmeoTL._SL1500_.jpg", 39.80, true, "jueves, 30 enero", true, 205, 4f));
            listData.add(new AmazonProduct("Dragon Ball Z: Kakarot", "https://images-na.ssl-images-amazon.com/images/I/812S8JMyKdL._SL1500_.jpg", 59.90, false, "miércoles, 5 febrero", false, 200, 5f));
            listData.add(new AmazonProduct("Apple iMac - Ordenador de 21,5 (Procesador Intel Core i5 de doble núcleo a 2,3 GHz)", "https://images-na.ssl-images-amazon.com/images/I/51WqYDg2pSL._SL1024_.jpg", 1159.90, true, "lunes, 3 febrero", true, 40, 2f));
            listData.add(new AmazonProduct("Sterkowski Peaky Blinders - Gorra de Harris Tweed", "https://images-na.ssl-images-amazon.com/images/I/51TSH9YXlyL.jpg", 64.00, true, "lunes, 3 febrero", true, 35, 3f));


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
