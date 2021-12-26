package benchmark;

import boxes.Box;
import boxes.GeneratedData;

public class Utils {

    public static GeneratedData getTwelveBoxesWithOneNonNormalBox(int pos, int value) {
        Box[] randomBoxes = new Box[12];
        for (int i = 0; i < 12; i++) {
            randomBoxes[i] = new Box(5);
        }
        randomBoxes[pos] = new Box(value);
        return new GeneratedData(randomBoxes, pos);
    }
}
