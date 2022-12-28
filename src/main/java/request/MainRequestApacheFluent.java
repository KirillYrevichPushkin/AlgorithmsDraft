package request;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

public class MainRequestApacheFluent {

    public static void main(String[] args) throws IOException {
  //      final Content getResult = Request.Get("http://jsonplaceholder.typicode.com/posts?_limit=10")
        final Content getResult = Request.Get("https://api.hh.ru/vacancies?text=java&page=1&per_pege=100")
                .execute().returnContent();
        System.out.println(getResult.asString());

//        final Collection<NameValuePair> params = new ArrayList<>();
//        params.add(new BasicNameValuePair("title", "foo"));
//        params.add(new BasicNameValuePair("body", "bar"));
//        params.add(new BasicNameValuePair("userId", "1"));
//
//        final Content postResultForm = Request.Post("http://jsonplaceholder.typicode.com/posts")
//                .bodyForm(params, Charset.defaultCharset())
//                .execute().returnContent();
//        System.out.println(postResultForm.asString());



    }

}
