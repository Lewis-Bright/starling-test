# starling-test

A React and Spring Rest app that interacts with Starling bank's API to create a new saving goal from the transactions rounded up.

## How to use

Install the dependencies (e.g. `npm install`) and then run `yarn start` or `npm start` in the ui directory. This will start the react project server on port 3000 (it is important that port 3000 is used as this is the only port allowed by the cross origin rule in the backend).

Run `./mvnw spring-boot:run` in the backend directory, to start a spring project on port 8080.

Enter a valid api key for an api customer in the UI, and a request will be made to the backend service. This will handle the calculation of the transactions round up, and will make the relevant requests to Starling's api, before returning the saved value.

You can also trigger the roundup directly in the backend, see the backend/README.md for more info on that.

## More info

To see how this works, the best place to start in the backend is the `RoundupController`. Similarly for the ui, most of the logic happens in `HomePage.jsx` and `Results.jsx`.

This project was created using Spring Boot and the `Spring Initializr`, and `create-react-app` in order to get everything up and working as quickly and efficiently as possible.
