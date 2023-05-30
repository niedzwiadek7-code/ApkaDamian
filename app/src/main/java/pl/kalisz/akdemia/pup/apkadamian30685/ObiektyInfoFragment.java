package pl.kalisz.akdemia.pup.apkadamian30685;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ObiektyInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObiektyInfoFragment extends Fragment {
    private long obiektId;

    public ObiektyInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ObiektyInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObiektyInfoFragment newInstance(String param1, String param2) {
        ObiektyInfoFragment fragment = new ObiektyInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView obiektNazwa = (TextView) view.findViewById(R.id.nazwa);
            Obiekt obiekt = Obiekt.obiekty[(int) obiektId];
            obiektNazwa.setText(obiekt.getNazwa());
            TextView obiektOpis = (TextView) view.findViewById(R.id.opis);
            obiektOpis.setText(obiekt.getOpis());
            ImageView obiektFoto = (ImageView) view.findViewById(R.id.foto);
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), obiekt.getFotoId());
            obiektFoto.setImageDrawable(drawable);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            obiektId = savedInstanceState.getLong("obiektId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_obiekty_info, container, false);
    }

    public void setObiekt (long id) {
        this.obiektId = id;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong("obiektId", obiektId);
    }
}