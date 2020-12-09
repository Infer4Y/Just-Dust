package xavier.just_dust.common.utils;

import java.util.Random;

public class DustGlobalVariables {
    public static final Random RANDOM = new Random();
    public static void resetRandom(){RANDOM.setSeed(0xDEADBEEF);}
}
