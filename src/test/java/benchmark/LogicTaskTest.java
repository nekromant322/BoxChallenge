package benchmark;

import boxes.Box;
import boxes.GeneratedData;
import org.junit.Test;

import static boxes.LogicTasks.getNonNormalBox;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTaskTest {

    @Test
    public void testCorrect() {
        int tries = 0;
        int correct = 0;
        for (int i = 0; i < 12; i++) {
            GeneratedData generatedInfo = Utils.getTwelveBoxesWithOneNonNormalBox(i, 100);
            tries++;

            int position = getNonNormalBox(generatedInfo.getRandomBoxes());
            if (position == generatedInfo.getCorrectBoxPosition()) {
                correct++;
            }
        }
        for (int i = 0; i < 12; i++) {
            GeneratedData generatedInfo = Utils.getTwelveBoxesWithOneNonNormalBox(i, 3);
            tries++;

            int position = getNonNormalBox(generatedInfo.getRandomBoxes());
            if (position == generatedInfo.getCorrectBoxPosition()) {
                correct++;
            }
        }
        assertEquals(tries, correct);
        System.out.println("Total count :" + Box.getCounter());
    }

}
