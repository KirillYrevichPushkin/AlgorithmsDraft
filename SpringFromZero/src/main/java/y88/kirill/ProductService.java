package y88.kirill;


import org.springframework.beans.factory.stereotype.Component;

@Component
public class ProductService {
    private PromotionService promotionService;



    public PromotionService getPromotionsService(){
        return promotionService;
    }

    public void setPromotionsService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
}
