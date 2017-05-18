package com.example.andrew.bikerapplication;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinchan on 5/17/17.
 */

public class RoutesHandler {
    private static RoutesHandler sRouteHandler;

    private List<Route> mRoutes;

    public static RoutesHandler get(Context context){
        if (sRouteHandler == null){
            sRouteHandler = new RoutesHandler(context);
        }
        return sRouteHandler;
    }

    private RoutesHandler(Context context){
        mRoutes = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Route route = new Route();
            route.setRouteName(Integer.toString(i));
            route.setStartLat("100");
            route.setStartLong("22");
            route.setEndLat("3");
            route.setEndLong("4");
            route.setFrequency("1");
            mRoutes.add(route);
        }
    }

    public List<Route> getRoutes() {
        return mRoutes;
    }

    public Route getRoute(String routeName) {
        for (Route route : mRoutes) {
            if (route.getRouteName().equals(routeName)) {
                return route;
            }
        }

        return null;
    }

    public void updateRoute(Route route){

    }


}
