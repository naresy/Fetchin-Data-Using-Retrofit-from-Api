package com.example.app.retrofit;

import com.example.app.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    Call<List<Contact>> getContact(
            @Query("item_type") String item_type,
            @Query("key") String keyword
    );
}
