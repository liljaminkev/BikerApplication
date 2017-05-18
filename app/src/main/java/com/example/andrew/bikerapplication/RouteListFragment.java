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

/**
 * Created by kevinchan on 5/17/17.
 */

public class RouteListFragment extends Fragment {

    private List<Route> routeList;
    private RecyclerView mRouteRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.route_list, container, false);

        mRouteRecyclerView = (RecyclerView) view
                .findViewById(R.id.);
        mRouteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }

        updateUI();

        return view;
    }


    private class RouteHolder extends RecyclerView.ViewHolder{
        private Route mRoute;
        private TextView routeName;
        private TextView startLat;
        private TextView startLong;
        private TextView endLat;
        private TextView endLong;
        private TextView frequency;


        public RouteHolder(View view) {
            super(View.inflate(R.layout.list_item_route, parent, false));

            routeName = (TextView) view.findViewById(R.id.routeName);
            startLat = (TextView) view.findViewById(R.id.startLat);
            startLong = (TextView) view.findViewById(R.id.startLong);
            endLat = (TextView) view.findViewById(R.id.endLat);
            endLong = (TextView) view.findViewById(R.id.endLong);

            final Button enlarge = (Button) view.findViewById(R.id.Go);

            enlarge.setClickable(true);
            enlarge.setFocusableInTouchMode(true);
            enlarge.setId(counter);
            enlarge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int index = v.getId();
                    route = routeList.get(0);
                    freq = Integer.parseInt(route.getFrequency());
                    freq = freq + 1;
                    Toast.makeText(enlarge.getContext(), "Route Name: " + route.getRouteName().toString() +
                            "\nStart Lat: " + route.getStartLat().toString() + "\nStart Long: " +
                            route.getStartLong().toString() + "\nEnd Lat: " + route.getEndLat().toString() +
                            "\nEnd Long: " + route.getEndLong().toString() + "\nUsage: " +
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
            LayoutInflater layoutInflater = LayoutInflater.from(Activity());
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
