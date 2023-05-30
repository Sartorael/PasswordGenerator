package generator;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest extends PasswordGenerator {

    @org.junit.jupiter.api.Test
    void testGenerate() {
        PasswordGenerator pasGen = new PasswordGenerator();
        int length = (int) (Math.random() * 100) + 1;
        String result = pasGen.generate(length);
        assertEquals(length, result.length());

    }
    @org.junit.jupiter.api.Test
    void testMassGenerate(){
        PasswordGenerator pasGen = new PasswordGenerator();
        int[] lengths = new int[101];
        for (int i = 0; i < 10000; i++) {
            int length = (int) (Math.random() * 100) + 1;
            String result = pasGen.generate(length);
            assertEquals(length, result.length());
            lengths[length]++;
        }
        for (int i = 1; i <= 100; i++) {
            System.out.printf("Password length %d: %d\n", i, lengths[i]);
        }
    }
}