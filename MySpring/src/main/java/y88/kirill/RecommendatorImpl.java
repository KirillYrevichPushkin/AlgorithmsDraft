package y88.kirill;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("whisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from covid-2019, drink " + alcohol);

    }


}
