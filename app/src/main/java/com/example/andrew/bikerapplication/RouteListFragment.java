package com.example.andrew.bikerapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.andrew.bikerapplication.R.id.freq;

/**
 * Created by kevinchan on 5/17/17.
 */

public class RouteListFragment extends Fragment {

    private List<Route> routeList;
    private RecyclerView mRouteRecyclerView;
    private RouteAdapter mAdapter;

    public static RouteListFragment newInstance() {
        Bundle args = new Bundle();
        //args.putSerializable(ARG_USER_ID, userID);

        RouteListFragment fragment = new RouteListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.route_list, container, false);

        mRouteRecyclerView = (RecyclerView) view
                .findViewById(R.id.route_recycler_view);
        mRouteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        return view;
    }

    private void updateUI() {
        RoutesHandler routesHandler = RoutesHandler.get(getActivity());
        List<Route> crimes = routesHandler.getRoutes();

        if (mAdapter == null) {
            mAdapter = new RouteAdapter(crimes);
            mRouteRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setRoutes(crimes);
            mAdapter.notifyDataSetChanged();
        }
    }


    private class RouteHolder extends RecyclerView.ViewHolder{
        private Route mRoute;
        private TextView routeName;
        private TextView startLat;
        private TextView startLong;
        private TextView endLat;
        private TextView endLong;
        private TextView frequency;


        public RouteHolder(LayoutInflater inflater, ViewGroup parent)  {
            super(inflater.inflate(R.layout.list_item_route, parent, false));

            routeName = (TextView) itemView.findViewById(R.id.routeName);
            startLat = (TextView) itemView.findViewById(R.id.startLat);
            startLong = (TextView) itemView.findViewById(R.id.startLong);
            endLat = (TextView) itemView.findViewById(R.id.endLat);
            endLong = (TextView) itemView.findViewById(R.id.endLong);

            final Button enlarge = (Button) itemView.findViewById(R.id.Go);

            enlarge.setClickable(true);
            enlarge.setFocusableInTouchMode(true);
            enlarge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(enlarge.getContext(), "Route Name: " + mRoute.getRouteName() +
                            "\nStart Lat: " + mRoute.getStartLat() + "\nStart Long: " +
                            mRoute.getStartLong() + "\nEnd Lat: " + mRoute.getEndLat() +
                            "\nEnd Long: " + mRoute.getEndLong() + "\nUsage: " +
                            freq, Toast.LENGTH_LONG).show();
                }
            });
        }

        public void bind(Route route){
            mRoute = route;
            routeName.setText(mRoute.getRouteName());
            startLat.setText(mRoute.getStartLat());
            startLong.setText(mRoute.getEndLong());
            endLong.setText(mRoute.getEndLong());
            endLat.setText(mRoute.getEndLat());
            frequency.setText(mRoute.getFrequency());
        }


    }

    private class RouteAdapter extends RecyclerView.Adapter<RouteHolder>{
        private List<Route> mRoutes;

        public RouteAdapter(List<Route> routes){mRoutes = routes;}

        @Override
        public RouteHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RouteHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RouteHolder holder, int position){
            Route route = mRoutes.get(position);
            holder.bind(route);
        }

        @Override
        public int getItemCount() {
            return routeList.size();
        }

        public void setRoutes(List<Route> routes){ mRoutes = routes;}

    }
}
