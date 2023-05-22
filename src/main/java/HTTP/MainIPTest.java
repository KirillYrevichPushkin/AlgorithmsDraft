package HTTP;

import com.codeborne.selenide.conditions.webdriver.Url;
import com.google.common.net.InetAddresses;
import lombok.SneakyThrows;
import org.apache.hc.core5.net.InetAddressUtils;
import org.xbill.DNS.Address;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainIPTest {

    @SneakyThrows
    public static void main(String[] args) {


        System.out.println(InetAddress.getByName("google.com"));
        System.out.println("--------------");
        System.out.println(Inet4Address.getByName("google.com"));
        System.out.println(Inet6Address.getByName("google.com"));

       System.out.println(InetAddressUtils.isIPv6Address("2a00:1450:400f:803::200e"));


        InetAddress[] ia = InetAddress.getAllByName("google.com");
        for (InetAddress inetAddress : ia) {
            System.out.println(inetAddress.toString());
        }

        InetAddress addr = Address.getByName("google.com");
        System.out.println("+++ " + addr);


        //https://github.com/Kirill-Y88
        URL url = new URL("https://github.com/Kirill-Y88");
       // URL url = new URL("github.com"); - //выйдет с ошибков
        System.out.println(url);
        System.out.println(url.getHost());




        InetAddress[] ia2 = Address.getAllByName("google.com");
        for (InetAddress inetAddress : ia2) {
            System.out.println(inetAddress.toString());
            System.out.println(InetAddressUtils.isIPv6Address(inetAddress.getHostAddress()));
        }

    }

}
