package com.example.andrew.bikerapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.mobile.api.CloudLogicAPIConfiguration;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobile.api.CloudLogicAPI;
import com.amazonaws.mobile.api.CloudLogicAPIFactory;
import com.amazonaws.mobilehelper.util.ThreadUtils;
import com.amazonaws.mobileconnectors.apigateway.ApiRequest;
import com.amazonaws.mobileconnectors.apigateway.ApiResponse;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.StringUtils;
import android.widget.EditText;

/**
 * Created by Andrew on 5/14/2017.
 */

public class CreateRouteFragment extends Activity implements View.OnClickListener  {
    public List<Route> routeList = new ArrayList<>();
    public Route route = new Route();
    private RecyclerView recyclerView;
    private BikerRecyclerViewAdapter mAdapter;
    String newRoute = null;
    String newStartLat = null;
    String newStartLong = null;
    String newEndLat = null;
    String newEndLong = null;
    String newFreq = null;


    //default AWS requests
    private static final String DEFAULT_QUERY_STRING = "?lang=en_US";
    private static final String DEFAULT_REQUEST_BODY = "{\n  \"userId\" : \"lynne123\" \n}";

    public static final int DEFAULT_API_INDEX = 0;
    public static final String DEFAULT_PATH = "/getRoutes";
    public static final String DEFAULT_METHOD = "POST";
    private CloudLogicAPIConfiguration apiConfiguration;


    //NEW- setup parameters to make AWS call -use defaults set above
    final int apiIndex = DEFAULT_API_INDEX;            //0
    final String path = DEFAULT_PATH;                  // it is /getRoutes
    final String method = DEFAULT_METHOD;              // it is POST
    final String queryString = DEFAULT_QUERY_STRING;   // sets language US English see above
    final String body = DEFAULT_REQUEST_BODY;          // is JSON object containing data to send in request, see above


    private static String LOG_TAG;

    private EditText mResultField;  //widget where will dump results


    //Class variables representing the request, the CloudLopciAPI to communicate from
    // client to send the request.
    AWSMobileClient awsMobileClient;
    CloudLogicAPI client;
    ApiRequest request;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biker_routes);



        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            newRoute = bundle.getString("routeName");
            newStartLat = bundle.getString("routeStartLat");
            newStartLong = bundle.getString("routeStartLong");
            newEndLat = bundle.getString("routeEndLat");
            newEndLong = bundle.getString("routeEndLong");
            newFreq = bundle.getString("routeUsed");
        }

        recyclerView = (RecyclerView) findViewById(R.id.bike_recycler_view);

        mAdapter = new RouteAdapter(routeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        Button orderButton = (Button) findViewById(R.id.newRoute);
        orderButton.setOnClickListener(this);
        prepareBikeData();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.newRoute:
                Intent intent = new Intent(CreateRouteFragment.this, NewBikeRoute.class);
                startActivity(intent);
                prepareBikeData();
                break;
        }
    }

    private void prepareBikeData() {
        route = new Route("School", "1233.33", "23.333" , "1233.9", "23.49" , "300");
        routeList.add(route);


        if(newRoute == null)
        {
            mAdapter.notifyDataSetChanged();
        }
        else
        {
            addBikeRoute(newRoute, newStartLat, newStartLong, newEndLat, newEndLong, newFreq);
        }
    }

    public void addBikeRoute(String name, String sLat, String sLong, String eLat, String eLong, String freq)
    {
        route = new Route(name, sLat, sLong , eLat, eLong , freq);
        routeList.add(route);
        mAdapter.notifyDataSetChanged();
    }


    private void invokeRequest(){
        //NEW - setup log tag to equal class name
        LOG_TAG = this.getClass().getName();

        //GET APIs: get APIs from CloudLogicAPIFactory
        apiConfiguration = CloudLogicAPIFactory.getAPIs()[apiIndex];
        final String endpoint = apiConfiguration.getEndpoint();

        Log.d(LOG_TAG, "Endpoint : " + endpoint);
        Log.d(LOG_TAG, "Path : " + path);
        Log.d(LOG_TAG, "Method : " + method);

        //AWS SETUP: setup AWS request query string parameters as Map object  -- only sending language type //as US English
        final Map<String, String> parameters = convertQueryStringToParameters(queryString);

        //AWSMobileClient & CloudLogicAPI SETUP: create instance of CloudLogicAPI to send request through to //AWS Lambda code
        AWSMobileClient.initializeMobileClientIfNecessary(this);
        awsMobileClient = AWSMobileClient.defaultMobileClient();
        client = awsMobileClient.createAPIClient(apiConfiguration.getClientClass());

        //DEFINE Variables Related to Request: setup headers for request --initally empty
        final Map<String, String> headers = new HashMap<String, String>();

        //SETUP content based on BODY -- THIS contains data sending in request if POST method type
        final byte[] content = body.getBytes(StringUtils.UTF8);

        //SETUP ApiReqest = HTTP request given path, method, headers, parameters and copy in body if not //empty as content
        ApiRequest tmpRequest =  new ApiRequest(client.getClass().getSimpleName());
        tmpRequest.withPath(path);
        tmpRequest.withHttpMethod(HttpMethodName.valueOf(method));
        tmpRequest.withHeaders(headers);
        tmpRequest.addHeader("Content-Type", "application/json");
        tmpRequest.withParameters(parameters);

        // final ApiRequest request;
        // Only set body if it has content.
        if (body.length() > 0) {
            request = tmpRequest
                    .addHeader("Content-Length", String.valueOf(content.length))
                    .withBody(content);
        } else { request = tmpRequest; }

        // Make network call on background thread
        new Thread(new Runnable() {
            Exception exception = null;

            @Override
            public void run() {
                try {
                    Log.d(LOG_TAG, "Invoking API w/ Request : " + request.getHttpMethod() + ":" + request.getPath());
                    long startTime = System.currentTimeMillis();


                    //THIS EXECUTES THE REQUEST
                    final ApiResponse response = client.execute(request);
                    final long latency = System.currentTimeMillis() - startTime;

                    final InputStream responseContentStream = response.getContent();  //GRAB THE RESPONSE
                    if (responseContentStream != null) {
                        final String responseData = IOUtils.toString(responseContentStream);
                        Log.d(LOG_TAG, "Response : " + responseData);
                        setResponseBodyText(responseData);
                    }

                } catch (final Exception exception) {
                    Log.e(LOG_TAG, exception.getMessage(), exception);
                    exception.printStackTrace();
                    ThreadUtils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                //take response and DISPLAY IT
                            setResponseBodyText(exception.getMessage());
                        }
                    });
                }
            }

        }).start();
    }


    private Map<String,String> convertQueryStringToParameters(String queryStringText) {

        while (queryStringText.startsWith("?") && queryStringText.length() > 1) {

            queryStringText = queryStringText.substring(1);

        }

        final UrlQuerySanitizer sanitizer = new UrlQuerySanitizer();
        sanitizer.setAllowUnregisteredParamaters(true);
        sanitizer.parseQuery(queryStringText);

        final List<UrlQuerySanitizer.ParameterValuePair> pairList = sanitizer.getParameterList();
        final Map<String, String> parameters = new HashMap<>();

        for (final UrlQuerySanitizer.ParameterValuePair pair : pairList) {

            Log.d(LOG_TAG, pair.mParameter + " = " + pair.mValue);
            parameters.put(pair.mParameter, pair.mValue);

        }

        return parameters;


    }

    /**
     * receives the JSON string and dumps it into an EditText widget associated with
     *   class variable mResultField
     * @param text */
    private void setResponseBodyText(final String text) {

        ThreadUtils.runOnUiThread(new Runnable() {

            @Override
            public void run() { mResultField.setText(text);}

        });

    }




    /**
     * display error message
     * @param errorMessage
     */
    public void showError(final String errorMessage) {
        new AlertDialog.Builder(this)
                .setTitle(this.getResources().getString(R.string.app_name) + " AWS error")
                .setMessage(errorMessage)
                .setNegativeButton(this.getResources().getString(R.string.error_dismiss), null)
                .create().show();
    }
}

