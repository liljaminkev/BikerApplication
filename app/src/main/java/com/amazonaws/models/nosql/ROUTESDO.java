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

@DynamoDBTable(tableName = "bikeroute-mobilehub-1300880964-ROUTES")

public class ROUTESDO {
    private String _userId;
    private String _routeId;
    private String _date;
    private Double _used;
    private String _endLatitude;
    private String _endLongitude;
    private String _routeName;
    private String _startLatitude;
    private String _startLongitude;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBRangeKey(attributeName = "routeId")
    @DynamoDBIndexHashKey(attributeName = "routeId", globalSecondaryIndexName = "Names")
    public String getRouteId() {
        return _routeId;
    }

    public void setRouteId(final String _routeId) {
        this._routeId = _routeId;
    }
    @DynamoDBAttribute(attributeName = "Date")
    public String getDate() {
        return _date;
    }

    public void setDate(final String _date) {
        this._date = _date;
    }
    @DynamoDBIndexHashKey(attributeName = "Used", globalSecondaryIndexName = "Popular")
    public Double getUsed() {
        return _used;
    }

    public void setUsed(final Double _used) {
        this._used = _used;
    }
    @DynamoDBAttribute(attributeName = "endLatitude")
    public String getEndLatitude() {
        return _endLatitude;
    }

    public void setEndLatitude(final String _endLatitude) {
        this._endLatitude = _endLatitude;
    }
    @DynamoDBAttribute(attributeName = "endLongitude")
    public String getEndLongitude() {
        return _endLongitude;
    }

    public void setEndLongitude(final String _endLongitude) {
        this._endLongitude = _endLongitude;
    }
    @DynamoDBAttribute(attributeName = "routeName")
    public String getRouteName() {
        return _routeName;
    }

    public void setRouteName(final String _routeName) {
        this._routeName = _routeName;
    }
    @DynamoDBAttribute(attributeName = "startLatitude")
    public String getStartLatitude() {
        return _startLatitude;
    }

    public void setStartLatitude(final String _startLatitude) {
        this._startLatitude = _startLatitude;
    }
    @DynamoDBAttribute(attributeName = "startLongitude")
    public String getStartLongitude() {
        return _startLongitude;
    }

    public void setStartLongitude(final String _startLongitude) {
        this._startLongitude = _startLongitude;
    }

}
