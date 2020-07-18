package src.dev.yusov;

import src.dev.yusov.logic.DocumentSignature;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class FilesSubscription {

    // Определяем сколько файлов в папке
    // Проходим по всем файлам и подписываем их
    public static void getPathWithFiles(String pathFiles) {
        // В данной версии нужно подписывать только 1 файл

    }

    // Создание ЭЦП на документе
    public static void setPathFile(String pathFile) throws NoSuchAlgorithmException, IOException, InvalidKeyException, SignatureException {
        // Три параметра: 1 -
        DocumentSignature documentSignature = new DocumentSignature("RSA",2048,"SHA1WithRSA");
        documentSignature.createElectronicDigSignature(pathFile);

    }

    // Проверка имеется ли ЭЦП на документе
    public static void docVer(String pathFile) {



    }



}