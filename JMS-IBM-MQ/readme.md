https://developer.ibm.com/learningpaths/ibm-mq-badge/create-configure-queue-manager/

docker pull icr.io/ibm-messaging/mq:latest
запуск образа с ibm mq
docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_PASSWORD=passw0rd --env MQ_ADMIN_PASSWORD=passw0rd --name QM1 icr.io/ibm-messaging/mq:latest


https://www.geeksforgeeks.org/spring-boot-annotations-jmslistener-retryable-rsocketmessagemapping-constructorbinding-and-slf4j/
