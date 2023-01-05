package WTG.draft;

import java.text.DecimalFormat;

public class Sector {

    private static final int [] longitudeArray = {111321,111303,111254,111170,111052,110901,110716,110497,110245,109960,
                                            109641,109289,108904,108487,108036,107553,107036,106488,105907,105294,
                                            104649,103972,103264,102524,101754,100952,100119,99257,98364,97441,
                                            96488,95506,94495,93455,92386,91290,90165,89013,87834,86628,
                                            85395,84137,82852,81542,80208,78848,77465,76037,74627,73173,
                                            71697,70199,68679,67138,65577,63995,62394,60773,59134,57476,
                                            55801,54108,52399,50674,48933,47176,45403,43621,41522,40011,
                                            38187,36352,34503,32647,30780,28902,27016,25122,23219,21310,
                                            19394,17472,15544,13612,11675,9735,7791,5846,3898,1949,
                                            0};
    private static final int [] latitudeArray = {110576,110577,110578,110579,110582,110585,110588,110593,110598,110604,
                                    110610,110617,110624,110633,110641,110653,110661,110671,110682,110694,
                                    110706,110719,110732,110746,110760,110775,110790,110806,110821,110838,
                                    110854,110871,110889,110906,110924,110943,110961,110980,110998,111017,
                                    111037,111056,111075,111095,111114,111134,111153,111173,111192,111212,
                                    111231,111250,111269,111288,111307,111325,111344,111362,111379,111397,
                                    111414,111431,111447,111463,111479,111494,111509,111524,111538,111551,
                                    111565,111576,111588,111599,111610,111620,111630,111639,111647,111655,
                                    111662,111668,111674,111679,111683,111687,111690,111693,111694,111695,
                                    111696};


    public Sector() {
    }

    public static float[][] getSectorByRadius(float centerLongitude, float centerLatitude, int radius ){
        float [][] sector = new float[2][2];
        int longitudeLength = longitudeArray[(int)centerLatitude];
        int latitudeLength = latitudeArray[(int)centerLatitude];

        System.out.println("longitudeLength =" + longitudeLength);
        System.out.println("latitudeLength =" + latitudeLength);


        sector[0][0] = centerLongitude - ((float) radius)/longitudeArray[(int)centerLatitude];
        sector[0][1] = centerLatitude + ((float) radius)/latitudeArray[(int)centerLatitude];

        sector[1][0] = centerLongitude + ((float) radius)/longitudeArray[(int)centerLatitude];
        sector[1][1] = centerLatitude - ((float) radius)/latitudeArray[(int)centerLatitude];

        return sector;
    }




}
