package WTG.draft;

public class StartSectorMain {

    public static void main(String[] args) {

       // Sector sector = new Sector();

        float [][] arrSector;

        arrSector = Sector.getSectorByRadius(30.453688f, 59.899230f, 750);

        for (int i = 0; i < arrSector.length; i++) {
            for (int j = 0; j < arrSector[i].length; j++) {
                System.out.printf("[%d][%d] = %f ", i, j, arrSector[i][j]);
            }
            System.out.println("\t");
        }


    }

}
