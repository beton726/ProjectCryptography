package src.dev.yusov;

import java.security.*;

/**
 *  Создание ЭЦП
 */
public class MessageSignature {

    private KeyPairGenerator keyPairGenerator;   // Генератор ключевых пар
    private KeyPair keyPair;					 // Пара ключей
    private PrivateKey privateKey;				 // Закрытый ключ
    private PublicKey publicKey;                 // Открытый ключ
    private Signature signature;                 // Цифровая подпсь
    private byte[] realSign;

    /**
     *  Если нет пары ключей, генерируем их.
     *  keyAlg - имя алгоритма шифрования. Пример: RSA и пр.
     *  keyLength - генерация ключей размером например 2048 бит.
     */
    public MessageSignature(String keyAlg, int keyLength, String signAlg) throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(keyAlg);
        keyPairGenerator.initialize(keyLength, new SecureRandom());
        keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();    // Получаем доступ к открытому ключу
        privateKey = keyPair.getPrivate();  // Получаем доступ к закрытому ключу
        signature = Signature.getInstance(signAlg);
    }



}
