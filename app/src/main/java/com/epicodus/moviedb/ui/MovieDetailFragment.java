package com.epicodus.moviedb.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.moviedb.R;
import com.epicodus.moviedb.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailFragment extends Fragment {
    @BindView(R.id.posterImageView)
    ImageView mImageLabel;
    @BindView(R.id.titleTextView)
    TextView mTitleLabel;
    @BindView(R.id.overviewTextView)
    TextView mOverviewLabel;


    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("results", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("results"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getImageUrl()).into(mImageLabel);

        mTitleLabel.setText(mMovie.getTitle());
        mOverviewLabel.setText(mMovie.getOverview());

        return view;
    }


    }
