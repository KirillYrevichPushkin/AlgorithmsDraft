package y88.kirill;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuater implements Quater {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;


    private String message;

    public TerminatorQuater() {
        System.out.println("Phase one");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase two");
        System.out.println(repeat);
    }


    //@PostProxy
    public void sayQuote(){

        System.out.println("3 фаза");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " +  message);
        }
    }

    





    public void setMessage(String message) {
        this.message = message;
    }
}
