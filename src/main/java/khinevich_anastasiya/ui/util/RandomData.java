package khinevich_anastasiya.ui.util;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.IBANType;
import net.andreinc.mockneat.types.enums.PassStrengthType;

public class RandomData {
    static MockNeat mock = MockNeat.threadLocal();
    public static String generateRandomName(){
        String name = mock.names().first().val();
        return name;
    }
    public static String generateRandomEmail() {
        String email = mock.emails().val();
        return email;
    }
    public static String generateRandomPassword() {
        String strongPassword = mock.passwords().type(PassStrengthType.STRONG).val();
        return strongPassword;
    }
    public static String generateRandomIIN() {
        String iin = mock.ibans().type(IBANType.BELARUS).val();
        return iin ;
    }
    public static String generateRandomDate() {
        String date = mock.localDates().mapToString().val();
        return date;
    }
}
