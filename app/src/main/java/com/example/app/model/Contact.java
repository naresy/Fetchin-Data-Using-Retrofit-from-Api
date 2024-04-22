package com.example.app.model;

import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("shop_id") private String Id;
    @SerializedName("shop_name") private String Name;
    @SerializedName("shop_city")private String intial_price;
    @SerializedName("shop_phone")private String final_price;
    @SerializedName("shop_image") private String Email;
    @SerializedName("shop_latitude")private String latitude;
    @SerializedName("shop_longitude") private String longitude;
    @SerializedName("start_date") private String start_date;

public String getIntial_price()
{
    return intial_price;
}
public String getFinal_price()
{
    return  final_price;
}
    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public String getStart_date() {
        return start_date;
    }

}
