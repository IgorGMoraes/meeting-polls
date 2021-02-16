# meeting-polls
This project simulates the backend of a mobile application for managing polls of cooperatives agendas, each member has one vote and decisions are taken in assemblies, by vote.

****
#### Functional Requirements:
This solution must be executed in the cloud and promote the following specifications through a REST API:
 - Register a new poll
 - Open a poll (the poll must be opened for a specific period of time in the opening call request or 1 minute by default)
 - Receive votes from members on polls (votes are only Yes / No)
 - Each associate is identified by a unique id and can vote only once per poll)
 - Count the votes and give the result of the vote on the poll

****
#### Requests:
- Create a poll:
POST /v1/poll/  
Body:
```
{
    "title": "Test"
}
```

- Open a voll:
PUT /v1/poll/{pollId}

- Create a vote:
POST /v1/vote/{pollID}  
Body:
```
{
    "cpf": "00000000000",
    "choice": true
}
```

- List all polls:
GET /v1/poll/

### How to use:
(The docker version will be available soon)
- Download the jar file provided in the [releases page](https://github.com/IgorGMoraes/meeting-polls/releases) 
- Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/tag/v3.8.11
- Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.3\sbin
- Run command rabbitmq-plugins enable rabbitmq_management
- Then run: `java -jar meeting-polls-0.5.jar`
- The application will be available at localhost:8080

***
#### Technologies used:
- Java
- Spring Boot
- RabbitMQ
