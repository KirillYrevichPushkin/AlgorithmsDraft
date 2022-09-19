package CMD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainCMD {
    public static void main(String[] args) {
        try {
            String command = "cmd /c ren \"D:\\testt\\test 2\" test3";
            System.out.println(command);
            //запуск командной строки и выполнение команды переименования файла/каталога
     //       Process process = Runtime.getRuntime().exec("cmd /c ren D:\\testt\\testt2\\ttest2.txt ttest3.txt");
            Process process = Runtime.getRuntime().exec(command);



    //        process.onExit();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
