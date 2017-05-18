package com.amazonaws.models.nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "bikeroute-mobilehub-1300880964-ROUTE")

public class ROUTEDO {
    private String _userId;
    private String _routeId;
    private String _date;
    private String _name;
    private String _numberTraveled;
    private String _startLatitude;
    private String _startLongitude;
    private String _stopLatitude;
    private String _stopLongitude;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBRangeKey(attributeName = "routeId")
    @DynamoDBAttribute(attributeName = "routeId")
    public String getRouteId() {
        return _routeId;
    }

    public void setRouteId(final String _routeId) {
        this._routeId = _routeId;
    }
    @DynamoDBAttribute(attributeName = "date")
    public String getDate() {
        return _date;
    }

    public void setDate(final String _date) {
        this._date = _date;
    }
    @DynamoDBIndexHashKey(attributeName = "name", globalSecondaryIndexName = "Names")
    public String getName() {
        return _name;
    }

    public void setName(final String _name) {
        this._name = _name;
    }
    @DynamoDBIndexHashKey(attributeName = "number_traveled", globalSecondaryIndexName = "Popular")
    public String getNumberTraveled() {
        return _numberTraveled;
    }

    public void setNumberTraveled(final String _numberTraveled) {
        this._numberTraveled = _numberTraveled;
    }
    @DynamoDBAttribute(attributeName = "start_latitude")
    public String getStartLatitude() {
        return _startLatitude;
    }

    public void setStartLatitude(final String _startLatitude) {
        this._startLatitude = _startLatitude;
    }
    @DynamoDBAttribute(attributeName = "start_longitude")
    public String getStartLongitude() {
        return _startLongitude;
    }

    public void setStartLongitude(final String _startLongitude) {
        this._startLongitude = _startLongitude;
    }
    @DynamoDBAttribute(attributeName = "stop_latitude")
    public String getStopLatitude() {
        return _stopLatitude;
    }

    public void setStopLatitude(final String _stopLatitude) {
        this._stopLatitude = _stopLatitude;
    }
    @DynamoDBAttribute(attributeName = "stop_longitude")
    public String getStopLongitude() {
        return _stopLongitude;
    }

    public void setStopLongitude(final String _stopLongitude) {
        this._stopLongitude = _stopLongitude;
    }

}
