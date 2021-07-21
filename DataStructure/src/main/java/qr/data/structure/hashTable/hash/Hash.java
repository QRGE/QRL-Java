package qr.data.structure.hashTable.hash;

/**
 * @Author: QR
 * @Date: 2021/7/20-21:01
 */
@SuppressWarnings("all")
public class Hash {

    public static int HashValue(float f){
        return Float.floatToIntBits(f);
    }

    public static int HashValue(String s){
        int len = s.length();
        int hashCode = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 等同于 hashCode * 31
            hashCode = (hashCode << 5) - hashCode + c;
        }
        return hashCode;
    }
}
