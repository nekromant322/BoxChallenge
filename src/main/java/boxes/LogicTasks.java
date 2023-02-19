package boxes;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static boxes.Box.comparing;

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
        Stream.of("asd", "qwe")
                .map(x -> x + x)
                .filter(x -> x.equals("asd"))
                .collect(Collectors.toList());

        Box[] subBoxes1 = Arrays.copyOfRange(boxes, 0, 4);
        Box[] subBoxes2 = Arrays.copyOfRange(boxes, 4, 8);
        int compare1 = Box.comparing(subBoxes1, subBoxes2);

        if (compare1 == 0) {
            int compare2 = Box.comparing(Arrays.copyOfRange(boxes, 0, 3),
                    Arrays.copyOfRange(boxes, 8, 11));
            if (compare2 == 0) {
                return 11;
            }
            else {
                int compare3 = Box.comparing(boxes[8], boxes[9]);

                if (compare3 == 0) {
                    return 10;
                }
                else if (compare2 > 0) {
                    return compare3 < 0 ? 8 : 9;
                }
                else {
                    return compare3 > 0 ? 8 : 9;
                }
            }
        }
        if (compare1 < 0) {
            int compare2 = Box.comparing(new Box[] {boxes[8], boxes[9], boxes[10], boxes[0]},
                    new Box[] {boxes[1], boxes[2], boxes[3], boxes[4]});

            if (compare1 == compare2) {
                if (Box.comparing(boxes[0], boxes[8]) == 0) {
                    return 4;
                }
                else {
                    return 0;
                }
            }
            else if (compare2 == 0) {
                int compare3 = Box.comparing(boxes[5], boxes[6]);

                if (compare3 == 0) {
                    return 7;
                }
                return compare3 > 0 ? 5 : 6;
            }
            else {
                int compare3 = Box.comparing(boxes[1], boxes[2]);

                if (compare3 == 0) {
                    return 3;
                }
                return compare3 < 0 ? 1 : 2;
            }
        }
        else {
            int compare2 = Box.comparing(new Box[] {boxes[8], boxes[9], boxes[10], boxes[4]},
                    new Box[] {boxes[5], boxes[6], boxes[7], boxes[0]});
            if (compare2 < 0) {
                if (Box.comparing(boxes[4], boxes[8]) == 0) {
                    return 0;
                }
                else {
                    return 4;
                }
            }
            else if (compare2 == 0) {
                int compare3 = Box.comparing(boxes[1], boxes[2]);

                if (compare3 == 0) {
                    return 3;
                }
                return compare3 > 0 ? 1 : 2;
            }
            else {
                int compare3 = Box.comparing(boxes[5], boxes[6]);

                if (compare3 == 0) {
                    return 7;
                }
                return compare3 < 0 ? 5 : 6;
            }
        }
    }
}

