package khinevich_anastasiya.ui.util;

import net.andreinc.mockneat.MockNeat;

public class RandomData {
    public static String generateRandomEmail() {
        MockNeat mock = MockNeat.threadLocal();
        String email = mock.emails().val();
        return email;
    }
}
