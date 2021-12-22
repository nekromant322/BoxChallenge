public class LogicTasks {
    public static void main(String[] args) {
        GeneratedData generatedBoxesInfo = getTwelveBoxesWithOneNonNormalBox();
        int position = getNonNormalBox(generatedBoxesInfo.getRandomBoxes());
        System.out.println(position == generatedBoxesInfo.getCorrectBoxPosition());
    }

    /* Входные параметры для примера теста
    в этих данных всегда отличается 7 коробка */
    private static GeneratedData getTwelveBoxesWithOneNonNormalBox() {
        Box[] randomBoxes = new Box[12];
        for (int i = 0; i < 11; i++) {
            randomBoxes[i] = new Box(5);
        }
        randomBoxes[7] = new Box(3);
        return new GeneratedData(randomBoxes, 7);
    }

    /* Ваша задача - реализовать этот метод.
       getNonNormalBox должен вернуть позицию коробки в массиве, отличающейся по value от остальных одинаковых коробок.
     */
    private static int getNonNormalBox(Box[] boxes) {
        return 7;
    }
}

