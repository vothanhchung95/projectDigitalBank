package vn.funix.fx17970.java.asm03;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static  String getDivider() {
        return "+----------+-------------------------+----------+";
    }

    // Lấy thời gian và định dạng lại, trả về String
    public static String getDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar. getInstance().getTime();
        return df.format(today);
    }

    // Lấy số dư và định dạng lại, trả về String
    public static String formatBalance(double amount) {
        // Tạo vị trí
        Locale vn = new Locale("vi", "VN");
        // Tạo định dạng
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);

        return vndFormat.format(amount);
    }
}
