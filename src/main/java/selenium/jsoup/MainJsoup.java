package selenium.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainJsoup {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://restaurantguru.ru/1620-Krasnodar")
                //.userAgent("Chrome/4.0.249.0 Safari/532.5")
                .userAgent("Mozilla")
                .referrer("https://www.google.com")
                .get();

        Elements name = doc.select(".title_container > .notranslate > a");
        System.out.println("Название " + name.text()); //название ресторана

        Elements address2 = doc.select("#info_location > div");
        System.out.println("Адрес " + address2.text()); //Адрес ресторана

        Elements workTime = doc.select(".short_info > .days");
        System.out.println("Время работы " + workTime.text()); //время работы ресторана

        Elements description = doc.select(".description > div > p");
        System.out.println("description full " + description.text()); //описание ресторана

//        Elements description1 = doc.select(".description > div > p");
//        System.out.println("description " + description.get(0).text()); //описание ресторана

//        Elements description2 = doc.select(".description > div > p");
//        System.out.println("description 2 " + description.get(1).text()); //описание ресторана

//        String[] timeString = workTime.text().split(" - ");
//        System.out.println("t1 = " + timeString[0] + " t2 " + timeString[1]);
//
//        String[] timeStartString = timeString[0].split(":");
//        String[] timeEndString = timeString[1].split(":");

//        System.out.println("ts1 = " + timeStartString[0] + " ts2 " + timeStartString[1]);
//        System.out.println("te1 = " + timeEndString[0] + " te2 " + timeEndString[1]);
        Elements detected = doc.select("body >div.content > div > p");
        System.out.println("detected " + detected.text().startsWith("Our systems"));


        Elements linkImage = doc.select("div.big_pic.photo_1 > span > img.lazyload");
        //   System.out.println(".collageWrapper  > img " + linkImage.toString());
        System.out.println(".photo-link  > img " + linkImage.attr("src"));

 //       #content > div.columns_wrapper.relative.clear > div.left_column_wrapper.relative.clear > div.left_bottom > div.screens_list_wrap.clear.four_pic > div.big_pic.\31 stphoto.photo_1 > span > img
//        document.querySelector("#content > div.columns_wrapper.relative.clear > div.left_column_wrapper.relative.clear > div.left_bottom > div.screens_list_wrap.clear.four_pic > div.big_pic.\\31 stphoto.photo_1 > span > img")

        Elements linkImage2 = doc.select(".collageWrapper > img");
     //   System.out.println(".collageWrapper  > img " + linkImage.toString());
        System.out.println(".collageWrapper  > img " + linkImage2.attr("src"));
      //  System.out.println(".swiper-slide > img " + linkImage.get(0).text());
     //   System.out.println(".swiper-slide > img " + linkImage.get(1).text());


    }

}
