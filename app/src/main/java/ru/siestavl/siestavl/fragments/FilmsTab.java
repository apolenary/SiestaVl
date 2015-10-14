package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.adapters.FilmsListAdapter;
import ru.siestavl.siestavl.entity.Film;

/**
 * Created by dmitry on 9/26/15.
 */
public class FilmsTab extends RootFragment {

    ListView list;
    ArrayList<Film> filmsList;
    public FilmsTab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_films_tab, container, false);

//        ArrayAdapter adapter;
//        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.films_list, android.R.layout.simple_list_item_1);
        filmsList = getFilmsList();
        FilmsListAdapter adapter = new FilmsListAdapter(getContext(), filmsList);
        list = (ListView) rootView.findViewById(R.id.films_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterNextFragment(position);
            }
        });
        return rootView;
    }



    private void enterNextFragment(int position) {
        FilmDescription filmDescription = new FilmDescription();

        Bundle bundle = new Bundle();
        bundle.putSerializable("film_key", filmsList.get(position));
        filmDescription.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, filmDescription).commit();
    }

    private ArrayList<Film> getFilmsList() {
        ArrayList<Film> list = new ArrayList<>();
        Film film = new Film();
        film.setName("Побег из Шоушенка");
        film.setDescription("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и " +
                "ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с " +
                "жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает " +
                "в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом " +
                "и доброй душой, отказывается мириться с приговором судьбы и начинает " +
                "разрабатывать невероятно дерзкий план своего освобождения.");
        film.setReserve(false);
        film.setCountry("США");
        film.setIndex(0);
        list.add(film);

        film = new Film();
        film.setName("Леон");
        film.setDescription("Профессиональный убийца Леон, не знающий пощады и жалости, " +
                "знакомится со своей очаровательной соседкой Матильдой, семью которой " +
                "расстреливают полицейские, замешанные в торговле наркотиками. Благодаря этому " +
                "знакомству он впервые испытывает чувство любви, но…");
        film.setReserve(true);
        film.setCountry("Франция");
        film.setIndex(1);
        list.add(film);

        film = new Film();
        film.setName("Зеленая миля");
        film.setDescription("Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке " +
                "смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом " +
                "и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему " +
                "начальника блока Пола Эджкомба, привыкшего исполнять приговор.\n\n" +
                "Гигант удивил всех позже, когда выяснилось, что он обладает невероятной " +
                "магической силой…");
        film.setReserve(false);
        film.setCountry("США");
        film.setIndex(2);
        list.add(film);

        film = new Film();
        film.setName("Форрест Гамп");
        film.setDescription("От лица главного героя Форреста Гампа, слабоумного безобидного " +
                "человека с благородным и открытым сердцем, рассказывается история его " +
                "необыкновенной жизни.\n\nФантастическим образом превращается он в известного " +
                "футболиста, героя войны, преуспевающего бизнесмена. Он становится миллиардером, " +
                "но остается таким же бесхитростным, глупым и добрым. Форреста ждет постоянный " +
                "успех во всем, а он любит девочку, с которой дружил в детстве, но взаимность " +
                "приходит слишком поздно.");
        film.setReserve(false);
        film.setCountry("США");
        film.setIndex(3);
        list.add(film);

        return list;
    }
}