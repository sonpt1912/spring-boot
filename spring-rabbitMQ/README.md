<h1>Spring RabbitMQ</h1>

<img src="Screenshot%202023-10-23%20003952.png">

I, install rabitmq with docker

 - document: https://registry.hub.docker.com/_/rabbitmq/
 - dowload: "docker pull rabbitmq"
 - run: docker run -it --rm --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management

II, theo dõi
 
 - truy cập đường link để đến trang quản lý: http://localhost:15672/#/
 - user/pass: guest:guest