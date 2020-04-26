package bernie.software.utils.misc;

import java.util.Random;

public class ForcedRandom extends Random {
    int toGet=0;

    public ForcedRandom(int toGet) {
        this.toGet = toGet;
    }

    @Override
    public int nextInt() {
        return toGet;
    }

    @Override
    public int nextInt(int bound) {
        if (bound<toGet) {
            throw new RuntimeException(new IndexOutOfBoundsException("Attempting to get an invalid cube:"+toGet+" is greater than "+bound)) {};
        } else if (toGet<0) {
            throw new RuntimeException(new IndexOutOfBoundsException("Attempting to get an invalid cube:"+toGet+" is less than "+0)) {};
        }
        return toGet;
    }
}
