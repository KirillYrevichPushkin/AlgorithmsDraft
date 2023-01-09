package selenium.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainJsoup {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://restaurantguru.ru/Zelenyi-Kot-Krasnodar")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("https://www.google.com")
                .get();

        Elements name = doc.select(".title_container > .notranslate > a");
        System.out.println("Название " + name.text()); //название ресторана

        Elements address2 = doc.select("#info_location > div");
        System.out.println("Адрес " + address2.text()); //Адрес ресторана

        Elements workTime = doc.select(".short_info > .days");
        System.out.println("Время работы " + workTime.text()); //время работы ресторана

        String[] timeString = workTime.text().split(" - ");
        System.out.println("t1 = " + timeString[0] + " t2 " + timeString[1]);

        String[] timeStartString = timeString[0].split(":");
        String[] timeEndString = timeString[1].split(":");

        System.out.println("ts1 = " + timeStartString[0] + " ts2 " + timeStartString[1]);
        System.out.println("te1 = " + timeEndString[0] + " te2 " + timeEndString[1]);

    }

}
