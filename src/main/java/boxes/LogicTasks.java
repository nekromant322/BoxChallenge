package boxes;

import java.util.*;

public class LogicTasks {
    public static void main(String[] args) {
        GeneratedData generatedBoxesInfo = getTwelveBoxesWithOneNonNormalBox();
        int position = getNonNormalBox(generatedBoxesInfo.getRandomBoxes());
        System.out.println(position == generatedBoxesInfo.getCorrectBoxPosition());
    }

    /* Входные параметры для примера теста
     * тут всегда отличается 7 коробка */
    private static GeneratedData getTwelveBoxesWithOneNonNormalBox() {
        Box[] randomBoxes = new Box[12];
        for (int i = 0; i < 12; i++) {
            randomBoxes[i] = new Box(5);
        }
        randomBoxes[7] = new Box(3);
        return new GeneratedData(randomBoxes, 7);
    }

    /* Ваша задача - реализовать этот метод.
       getNonNormalBox должен вернуть позицию коробки в массиве, отличающейся по value от остальных одинаковых коробок.
       для тестов надо сделать public!
     */
    public static int getNonNormalBox(Box[] boxes) {
        return 0;
    }
}

