package WTG.draft;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTextParser {
    public static void main(String[] args) {
        String text = "Меню этого ресторана специализируется на грузинской кухне. Многие посетители приходят в Барашков," +
                " чтобы попробовать вкусно приготовленные хинкали, хачапури и шашлык. Попробуйте хорошее вино. " +
                "Попробуйте вкусно приготовленные бургеры и неплохие пироги. Непременно закажите тут хороший стаут. " +
                "В этом баре уютная атмосфера. По мнению гостей, персонал здесь гостеприимный. " +
                "В URBAN PUB КРАСНОДАРЕ впечатляющий сервис. Это место предлагает блюда по адекватным ценам. " +
                "Множество посетителей говорят, что интерьер здесь современный. Клиенты оценивают это заведение на 4.7 на Google." +
                "Обязательно закажите вкусный эспрессо, чай или капучино. " +
                "Удобное расположение Sweet beans позволяет легко добраться до него даже в час пик. " +
                "Посетители утверждают, что бариста в этом месте знающий свое дело. " +
                "Это заведение предлагает блюда по низким ценам. Множество клиентов говорят, что здесь современный интерьер и спокойная атмосфера. " +
                "Гости присвоили Sweet beans рейтинг 4.8 на Google.";

        Pattern p1 = Pattern.compile("кухн");
        Pattern p2 = Pattern.compile("вкус");
        Pattern p3 = Pattern.compile("грузин");
        Pattern p4 = Pattern.compile("итальян");
        Pattern p5 = Pattern.compile("европ");

        List<Pattern> patternsFood = List.of(Pattern.compile("кухн"),Pattern.compile("вкус"));

        Matcher m2;
        int countM2 = 0;

        for (int i = 0; i < patternsFood.size(); i++) {
            m2 = patternsFood.get(i).matcher(text);
            while (m2.find()){
                System.out.println(m2.group());
                countM2++;
            }
        }
        System.out.println("countM2 = " + countM2);








    }
}
