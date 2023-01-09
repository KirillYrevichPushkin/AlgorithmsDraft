package selenium;

import WTG.draft.scriptDB.LocationDTO;
import com.codeborne.selenide.commands.ScrollTo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;


public class MainSelenium {
    public static void main(String[] args) throws InterruptedException , IOException {


        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver.get("https://restaurantguru.ru/restaurant-Krasnodar-t1");

        String title = driver.getTitle();
        System.out.println("title " + title);

        //todo таймер на пролистывание страницы вниз
        for (int i = 0; i < 336; i++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            Thread.sleep(2000);
        }


        List<WebElement> hrefs = driver.findElements(By.className("title_url"));
        List<LocationDTO> locationDTOList = new LinkedList<>();

        File fileHref = new File("src/main/java/selenium/href.txt");
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileHref))){



        for (WebElement w: hrefs ) {
            System.out.println("title: " + w.getAttribute("title") + " href: " + w.getAttribute("href"));
           // Thread.sleep(500);
           // locationDTOList.add(getLocationDTO(w.getAttribute("href")));
            dos.writeUTF(w.getAttribute("href") + "\n");
        }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


        for (LocationDTO l: locationDTOList ) {

            System.out.println( l.toString());
        }







    }

    public static LocationDTO getLocationDTO(String url) throws IOException{
        LocationDTO locationDTO = new LocationDTO();

        Document doc = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("https://www.google.com")
                .get();

        Elements name = doc.select(".title_container > .notranslate > a");
        System.out.println("Название " + name.text()); //название ресторана

//        Elements description = doc.select(".title_container > .notranslate > a");
//        System.out.println("Название " + name.text()); //описание ресторана

        Elements address = doc.select("#info_location > div");
        System.out.println("Адрес " + address.text()); //Адрес ресторана

        Elements workTime = doc.select(".short_info > .days");
  //      System.out.println("Время работы " + workTime.text()); //время работы ресторана

        locationDTO.setLinkSite(url);
        locationDTO.setTitle(name.text());
        locationDTO.setAddress(address.text());

//        String[] timeString = workTime.text().split(" - ");
//        String[] timeStartString = timeString[0].split(":");
//        String[] timeEndString = timeString[1].split(":");
//
//        LocalTime tStart = LocalTime.of(Integer.parseInt(timeStartString[0]),Integer.parseInt(timeStartString[1]));
//        LocalTime tEnd = LocalTime.of(Integer.parseInt(timeEndString[0]),Integer.parseInt(timeEndString[1]));
        //todo переделать тип времени в локациях на localTime
//        locationDTO.setWorkTimeStart(tStart);
//        locationDTO.setWorkTimeEnd(tEnd);

        return locationDTO;
    }


}
