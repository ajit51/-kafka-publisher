1. start zookeeper.start bat 
zookeeper-server-start.bat D:\kafka_2.13-3.1.0\config\zookeeper.properties

2. start kafka server
kafka-server-start.bat D:\kafka_2.13-3.1.0\config\server.properties
	
3. Create Topic
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic javatechie
kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic jerry - running
4. Show list of topics
kafka-topics.bat --list --bootstrap-server localhost:9092
5. Produce a message
kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic
6. Consume a message
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic --from-beginning
