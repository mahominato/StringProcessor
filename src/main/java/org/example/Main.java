public class Main {
    public static void main(String[] args) {
        StringProcessor sp = new StringProcessor();


        System.out.println("Is 'StrongP@ss1' a strong password? " + sp.isStrongPassword("StrongP@ss1"));
        System.out.println("Is 'weakpass' a strong password? " + sp.isStrongPassword("weakpass"));

        System.out.println("Number of digits in 'There are 3 apples and 5 oranges': " + sp.calculateDigits("There are 3 apples and 5 oranges."));

        System.out.println("Number of words in 'Hello world this is Java': " + sp.calculateWords("Hello world this is Java"));

        System.out.println("Result of '3 + 4 * 2': " + sp.calculateExpression("3 + 4 * 2"));
    }
}
