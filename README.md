//MYSQL CMD
-> mysql -u root -p
-> aalok25
-> show databases;
-> use libmsystem;
-> desc author; desc user; desc book;


//API's
http://localhost:8081/author/getAuthorData
http://localhost:8081/book/getBook
http://localhost:8081/user/addStudent
{
    "name":"Aalok",
    "phoneNo":"123456789",
    "email":"aalok@gmail.com",
    "address":"India"
}

//Kafka
go to C:/kafka -> Open cmd
start Zookeeper : .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
start Kafka : .\bin\windows\kafka-server-start.bat .\config\server.properties
