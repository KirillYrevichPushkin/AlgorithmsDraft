package y88.kirill.jmsibmmq;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.convert.Property;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MsgReader {

  private static final Logger log = LoggerFactory.getLogger(MsgReader.class);

  @Autowired
  MQProperties mqProperties;



  public  void goRead(String receivedMessage){
    String messageFileName;
    String MESSAGE_FOLDER = mqProperties.getMessage_folder();
    Map<String, String> fleetDivisionPairsMap = new HashMap<String, String>();

    try {

      JsonObject receivedJson = new JsonParser().parse(receivedMessage).getAsJsonObject();

      String caption = "Unknown"; // default message type (if "Caption" key is not specified in json)

      String timestamp = Long.toString(System.currentTimeMillis());
      String created = timestamp;
      timestamp = timestamp.substring(timestamp.length() - 4);

      if (receivedJson.has("Caption")) {
        caption = receivedJson.get("Caption").getAsString();
      }
      messageFileName = MESSAGE_FOLDER + (new File(caption + "_t" + created + ".json")).getName();
      PrintWriter savedJson = null;
      try {
        savedJson = new PrintWriter(messageFileName);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      savedJson.print(receivedMessage);
      savedJson.close();

      log.info("File successfully saved to " + messageFileName);

      if (receivedJson.has("Created")) {
        created = receivedJson.get("Created").getAsString();
      }

      String title = "";
      if (receivedJson.has("Title")) {
        title = receivedJson.get("Title").getAsString();
      }

      String description = "";
      if (receivedJson.has("Description")) {
        description = receivedJson.get("Description").getAsString();
      }

      String fleetDivisionKey = "";
      if (receivedJson.has("Division")) {
        fleetDivisionKey = receivedJson.get("Division").getAsString();
      } else {
        log.info("ERROR: Division is not specified in json! File was not imported!");
        return;
      }

      if (fleetDivisionPairsMap.get(fleetDivisionKey) == null) {
        log.info("ERROR: There is no division for fleet: " + fleetDivisionKey);

       // return;
      }

      ////

      ////

    }catch (Exception e){
      log.info("ERROR: Something went wrong!");
      log.error(e.getMessage(), e);
    }

  }

}
