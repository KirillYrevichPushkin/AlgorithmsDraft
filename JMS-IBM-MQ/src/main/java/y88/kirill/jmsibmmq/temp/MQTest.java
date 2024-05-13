package y88.kirill.jmsibmmq.temp;

import java.io.IOException;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;
import com.ibm.mq.constants.MQConstants;

public class MQTest {

  public static void main(String[] args) throws MQException, IOException
  {
    // Send a message to the queue
    put();

    // Read messages from the queue
    get();
  }

  static void put() throws MQException, IOException
  {
    // Configure MQ server connection parameters
    MQEnvironment.hostname = "127.0.0.1";
    MQEnvironment.port = 1316;
    MQEnvironment.channel = "JAVA.CLIENT.CHANNEL1";

    // Set the application name to facilitate the server MQ to view the application connection
    MQEnvironment.properties.put(MQConstants.APPNAME_PROPERTY, "MQ Test By Java");

    // Create an instance and connect to the queue manager
    MQQueueManager queueManager = new MQQueueManager("JAVA.QUEUE.MANAGER.1");

    // Access the queue QUEUE1 defined by the queue manager in a writable way, of course you can also create a queue
    MQQueue putQueue = queueManager.accessQueue("QUEUE1", CMQC.MQOO_OUTPUT);

    // Create and send a message to the queue
    MQMessage myMessage = new MQMessage();
    String name = "MePlusPlus's Blog";
    myMessage.writeUTF(name);

    // Use default message options
    MQPutMessageOptions pmo = new MQPutMessageOptions();
    //Send a message
    putQueue.put(myMessage, pmo);
    putQueue.close();

    //Disconnect
    queueManager.disconnect();
  }

  static void get() throws MQException, IOException
  {
    // Configure MQ server connection parameters
    MQEnvironment.hostname = "127.0.0.1";
    MQEnvironment.port = 1316;
    MQEnvironment.channel = "JAVA.CLIENT.CHANNEL1";

    // Set the application name to facilitate the server MQ to view the application connection
    MQEnvironment.properties.put(MQConstants.APPNAME_PROPERTY, "MQ Test By Java");

    // Create an instance and connect to the queue manager
    MQQueueManager queueManager = new MQQueueManager("JAVA.QUEUE.MANAGER.1");

    // Access the queue QUEUE1 defined by the queue manager in a readable way
    MQQueue getQueue = queueManager.accessQueue("QUEUE1", CMQC.MQOO_INPUT_AS_Q_DEF);

    // Read messages from the queue
    MQMessage theMessage = new MQMessage();
    MQGetMessageOptions gmo = new MQGetMessageOptions();
    getQueue.get(theMessage, gmo);

    String name = theMessage.readUTF();

    System.out.println(name);
    getQueue.close();

    //Disconnect
    queueManager.disconnect();
  }
}
