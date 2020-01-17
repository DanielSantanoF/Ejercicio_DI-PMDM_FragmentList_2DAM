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

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));

            }
            youtubeItemList = new ArrayList<YoutubeItem>();
            youtubeItemList.add(new YoutubeItem("https://pbs.twimg.com/media/D5Gg3QNWwAEsCaJ.jpg","https://d1yjjnpx0p53s8.cloudfront.net/styles/logo-thumbnail/s3/052014/goikogrill_logo.png?itok=q8fypMXJ", "Preview King Kong 250gr", "Goiko Grill YT", "10:45",6351684));
            youtubeItemList.add(new YoutubeItem("https://cdn02.nintendo-europe.com/media/images/10_share_images/support_9/H2x1_NintendoWii_support_no_logo_image800w.jpg","https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Nintendo_Logo_2017.png/800px-Nintendo_Logo_2017.png", "Preview Wii Hcked Miguel Campos", "Nintendo YT", "55:23",354361));
            youtubeItemList.add(new YoutubeItem("https://maslinux.es/wp-content/uploads/2018/10/linux-vs-windows-featured.jpg", "https://conceptodefinicion.de/wp-content/uploads/2014/10/persona.jpg", "¿Por que es mejor Windows que Linux?", "Windows Lover YT", "30:13",9623));
            youtubeItemList.add(new YoutubeItem("https://quierocuidarme.dkvsalud.es/sites/default/files/styles/vivelasalud_ficha_825x464/public/imagen/2017-10/shutterstock_367741853_0.jpg?itok=0vIQkXY0", "https://www.economiadehoy.es/fotos/8/59785_sanitaslogo.jpg", "Gonzalo y la Fatiga", "Sanitas YT", "15:53", 354891));

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
