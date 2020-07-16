package src.dev.yusov;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class DocumentSignature {

    private KeyPairGenerator keyPairGenerator;   // Генератор ключевых пар
    private KeyPair keyPair;					 // Пара ключей
    private PrivateKey privateKey;				 // Закрытый ключ
    private PublicKey publicKey;                 // Открытый ключ
    private Signature signature;                 // Цифровая подпсь
    private String getPathFile;                  // Полный путь к файлу
    private byte[] realSign;

    /**
     *  Если нет пары ключей, генерируем их.
     *  keyAlg - название алгоритма для которого генерируется пара ключей. RSA
     *  keyLength - генерация ключей размером например 2048 бит. 2048
     *  signAlg - алгоритм цифровой подписи. SHA256withRSA
     */
    public DocumentSignature(String keyAlg, int keyLength, String signAlg) throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(keyAlg);
        keyPairGenerator.initialize(keyLength, new SecureRandom());
        keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();    // Получаем доступ к открытому ключу
        privateKey = keyPair.getPrivate();  // Получаем доступ к закрытому ключу
        signature = Signature.getInstance(signAlg);
    }

    /**
     *  Создание ЭЦП
     */
    public void createElectronicDigSignature(FileInputStream message) throws InvalidKeyException, IOException, SignatureException {
        // Инициализация экземпляра подписи
        signature.initSign(privateKey);

        // Данные считываются по 200 байт
        BufferedInputStream bf = new BufferedInputStream(message, 200);
        byte[] data = new byte[bf.available()];
        bf.read(data);
        signature.update(data); // здесь создаётся ЭЦП, подписываются двоичные данные
        bf.close();

        realSign = signature.sign();

        // Подписали эти данные, далее можно удалить этот файл и записать все данные в новый файл с таким же
        // названием.

        // DELETE FAIL

//        FileOutputStream fileOutputStream = new FileOutputStream();
        // Записываем массив байт в файл и заканчиваем.


    }



}
