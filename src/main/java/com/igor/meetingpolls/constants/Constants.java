package com.igor.meetingpolls.constants;

public interface Constants {

    String QUEUE = "voting_queue";
    String EXCHANGE = "voting_exchange";
    String ROUTING_KEY = "voting_routingKey";

    String CPI_VALIDATOR_URL = "https://user-info.herokuapp.com/users/{cpf}";
    String ABLE_TO_VOTE = "ABLE_TO_VOTE";
}
