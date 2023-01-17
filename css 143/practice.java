public class practice {
    public static void doubleEachElement(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] *= 2;
        }
    }

    public static void printEachElement(int[] intArr) {
        for (int var: intArr) {
            System.out.println(var);
        }
    }
}