package com.handlers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.model.Employee;
import com.service.NetworkService;

import retrofit2.Call;

import static com.amazon.ask.request.Predicates.intentName;

public class HelloWorldIntentHandler implements RequestHandler {
	
    private List<Employee> employees;

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("HelloWorldIntent"));
	}

	public Optional<Response> handle(HandlerInput input) {
		String speechText = "There are no employees in the database.";
		getAllEmployees();
		if (employees != null) {
			speechText = "There are " + employees.size() + " employees in the database";
		}
		return input.getResponseBuilder()
					.withSpeech(speechText)
					.withSimpleCard("HelloWorld", speechText)
					.build();
	}
	
	private void getAllEmployees() {
        NetworkService networkService = NetworkService.getInstance();
        Call<List<Employee>> callSync = networkService.getJSONApi().getAllEmployees();

        try {
        	retrofit2.Response<List<Employee>> response = callSync.execute();
            employees = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
