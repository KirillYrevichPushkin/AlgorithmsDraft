package y88.kirill.busineslogic.recomendator;

import y88.kirill.annotation.InjectProperty;
import y88.kirill.annotation.Singleton;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("whisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendtor created");
    }

    @Override
    public void reccomend() {
        System.out.println("drink " + alcohol);
    }
}
