package app.philm.in.fragments;


import com.google.common.base.Preconditions;

import android.os.Bundle;
import android.text.TextUtils;

import app.philm.in.fragments.base.MovieListFragment;
import app.philm.in.lib.controllers.MovieController;

public class RelatedMoviesFragment extends MovieListFragment implements MovieController.SubUi {

    private static final String KEY_QUERY_MOVIE_ID = "movie_id";

    public static RelatedMoviesFragment create(String movieId) {
        Preconditions.checkArgument(!TextUtils.isEmpty(movieId), "movieId cannot be empty");

        Bundle bundle = new Bundle();
        bundle.putString(KEY_QUERY_MOVIE_ID, movieId);

        RelatedMoviesFragment fragment = new RelatedMoviesFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public MovieController.MovieQueryType getMovieQueryType() {
        return MovieController.MovieQueryType.RELATED;
    }

    @Override
    public String getRequestParameter() {
        return getArguments().getString(KEY_QUERY_MOVIE_ID);
    }

}
