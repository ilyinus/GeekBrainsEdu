package homework02;

public class Main {

    private static int processArray(String[][] array) {

        int fullSize = 0;
        int result = 0;

        for (int i = 0; i < array.length; i++) {

            fullSize += array[i].length;

            if (fullSize > 16)
                throw new MyArraySizeException("Array's size isn't 4x4");

            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Incorrect value \"" + array[i][j] + "\" in cell [" + i + "][" + j + "]");
                }
            }
        }

        if (fullSize < 16)
            throw new MyArraySizeException("Array's size isn't 4x4");

        return result;
    }

    public static void main(String[] args) {
        String[][] array = {{"1" , "2" , "3" , "4"  },
                            {"5" , "6" , "7" , "8"  },
                            {"9" , "10", "11", "12" },
                            {"13", "14", "15", "16"}};

        try {
            System.out.println(processArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

}
