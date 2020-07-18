package src.dev.yusov;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class Solution {
    public static void main(String[] args) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        // Пока что подписываем только 1 файл
        FilesSubscription.setPathFile("D:\\ElectronicDigitalSignature\\ECPo\\test.csv");


    }
}