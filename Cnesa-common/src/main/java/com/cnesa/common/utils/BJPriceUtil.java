package com.cnesa.common.utils;

/**
 * Created by shangpeibao on 16/12/30.
 */
public class BJPriceUtil {

    private static final double low = 0.3658;
    private static final double middle = 0.8595;
    private static final double high = 1.3782;
    private static final double highest = 1.5065;

    public static double getPrice(Integer month, Integer hour, Double electricValue) {
        Integer h = hour - 1;
        if (h < 0 ) {
            h = 23;
        }
        if (month == 7 || month == 8) {
            switch (h) {
                case 0 :
                    return low * electricValue;
                case 1 :
                    return low * electricValue;
                case 2 :
                    return low * electricValue;
                case 3 :
                    return low * electricValue;
                case 4 :
                    return low * electricValue;
                case 5 :
                    return low * electricValue;
                case 6 :
                    return low * electricValue;
                case 7 :
                    return middle * electricValue;
                case 8 :
                    return middle * electricValue;
                case 9 :
                    return middle * electricValue;
                case 10 :
                    return high * electricValue;
                case 11 :
                    return highest * electricValue;
                case 12 :
                    return highest * electricValue;
                case 13 :
                    return high * electricValue;
                case 14 :
                    return high * electricValue;
                case 15 :
                    return middle * electricValue;
                case 16 :
                    return highest * electricValue;
                case 17 :
                    return middle * electricValue;
                case 18 :
                    return high * electricValue;
                case 19 :
                    return high * electricValue;
                case 20 :
                    return high * electricValue;
                case 21 :
                    return middle * electricValue;
                case 22 :
                    return middle * electricValue;
                case 23 :
                    return low * electricValue;
                default:
                    return low * electricValue;
            }
        } else {
            switch (h) {
                case 0 :
                    return low * electricValue;
                case 1 :
                    return low * electricValue;
                case 2 :
                    return low * electricValue;
                case 3 :
                    return low * electricValue;
                case 4 :
                    return low * electricValue;
                case 5 :
                    return low * electricValue;
                case 6 :
                    return low * electricValue;
                case 7 :
                    return middle * electricValue;
                case 8 :
                    return middle * electricValue;
                case 9 :
                    return middle * electricValue;
                case 10 :
                    return high * electricValue;
                case 11 :
                    return high * electricValue;
                case 12 :
                    return high * electricValue;
                case 13 :
                    return high * electricValue;
                case 14 :
                    return high * electricValue;
                case 15 :
                    return middle * electricValue;
                case 16 :
                    return middle * electricValue;
                case 17 :
                    return middle * electricValue;
                case 18 :
                    return high * electricValue;
                case 19 :
                    return high * electricValue;
                case 20 :
                    return high * electricValue;
                case 21 :
                    return middle * electricValue;
                case 22 :
                    return middle * electricValue;
                case 23 :
                    return low * electricValue;
                default:
                    return low * electricValue;
            }
        }
    }
}
