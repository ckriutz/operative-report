# operative-report
### Easy (and interesting) demo site for microservice orchestration.

![example of image](docs/example.jpg)

### 🚀 The API
This project contains one API written in dotnet. When you hit the /code endpoint, it will return (as an example):

```
{"Person":"brown","Adjective":"nostalgic","Emoji":"rocket","MachineName":"DESKTOP-8HGRG0Q"}
```

### 🛸 The React front end (web-react)
This project also contains two web-front-ends, one built in React, and one built in Java that will display the results in a visually pleasing way. You can pick this one (the React one), or the Java one, or both!

In order to ensure the web-front-end can communicate to the the API, make sure you set the environment variable.
This will change depending on the IP adress of where it's hosted, and the method may be different depending on how it's hosted.

```
$env:REACT_APP_API_URL="http://localhost:5189/code"
```

### ☕ The Java front end (Spring Boot)
This project also contains two web-front-ends, one built in React, and one built in Java that will display the results in a visually pleasing way. You can pick this one (the Java one), or the React one, or both!

In order for the Java Spring Boot web applicaton to communicate with the API you're going to want to set the enviromnent variable. This will change depending on the IP adress of where it's hosted, and the method may be different depending on how it's hosted.

```
$env:apiURL="http://localhost:5189/code"
```