# Backend
## Functionality
This project will make a call to Starling Bank's API and create a savings goal from the transactions over the last 7 days.
It does this by rounding the outbound transactions in the default category up to the nearest pound.

You can run this by doing:
```
./mvnw spring-boot:run
```
to start the project, then:
```
curl -X POST -H "auth: {api_key}" localhost:8080/savings_goal/create
```

## Testing
There are a couple of unit tests and the default spring test that can be run using:
```
./mvnw test  
```
The next step would be to write an integration test to run the whole interaction, mocking Starling's API, but in the
interest of time I haven't added that.