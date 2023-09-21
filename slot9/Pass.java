//Base64
package Slot9;

import java.util.Base64;

public class Pass {
    public static void main(String[] args) {
        // Mật khẩu gốc
        String password = "my_password";

        // Mã hóa mật khẩu
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        System.out.println("Mật khẩu sau khi mã hóa: " + encodedPassword);

        // Giải mã mật khẩu
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);

        System.out.println("Mật khẩu sau khi giải mã: " + decodedPassword);
    }
}
