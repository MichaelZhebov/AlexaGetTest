package com.rest;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

import com.model.Employee;

public interface JSONPlaceHolderApi {

    @GET("/api/v1/employees")
    public Call<List<Employee>> getAllEmployees();

}
