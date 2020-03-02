Check Status

>> rabbitmqctl status

Queue Types:
1. Reliable - sustains RabbitMQ server restarts
2. Transient - deletes the Queue


Exchanges:
1. Fanout - Delivers messages to all the queues 
2. Direct - Delivers messages to the Queues that matches (Publisher) ROUTING_KEY = BINDING_KEY (Consumer)
3. Topic - * (star) can substitute for exactly one word
		   # (hash) can substitute for zero or more words, like binding_key = "shape.*"/"shape.#"

Fanout vs Direct Exchange
* Fanout Exchange - ALWAYS deliver the messages to binded Queues REGARDLESS of bindings

* Direct Exchange - ONLY deliver messages to binded Queues WHEN routing key MATCHES binding key



To see the Queues in RabbitMQ
>> goto RabbitMQ server directory from command prompt

>> rabbitmqctl list_queues

Timeout: 60.0 seconds ...

Listing queues for vhost / ...

name    messages

hello   8


TO enable management plugin
>> rabbitmq-plugins enable rabbitmq_management

Access management interface using http://localhost:15672
Default credentials: guest/guest

