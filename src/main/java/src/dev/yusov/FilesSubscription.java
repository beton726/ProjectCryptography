package src.dev.yusov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public static void getPathFile(String pathFile) throws NoSuchAlgorithmException, IOException, InvalidKeyException, SignatureException {

        DocumentSignature documentSignature = new DocumentSignature("",1,"");
        documentSignature.createElectronicDigSignature(new FileInputStream(pathFile));

    }

}