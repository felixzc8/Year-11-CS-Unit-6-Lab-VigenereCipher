import java.util.ArrayList;

public class VigenereCipher {
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String key;
    public VigenereCipher (String key) {
        this.key = key.toLowerCase();
    }

    public String genString(String str, String key) {
        int x = str.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }

        return key;
    }
    public String encode(String str) {
        str = str.toLowerCase();
        String key = genString(str, this.key);
        String encodedText = "";

        System.out.println("key: " + key);
        System.out.println("str: " + str);
        for (int i = 0; i < str.length(); i++)
        {
            if (alphabet.contains(String.valueOf(str.charAt((i))))) {
                int x = (alphabet.indexOf(str.charAt(i)) + alphabet.indexOf(key.charAt(i))) % 26;
                encodedText += alphabet.charAt(x);
                System.out.println(encodedText);
            }
            else
            {
                encodedText += str.charAt(i);
                System.out.println(encodedText);
            }

        }
        System.out.println("out: " + encodedText);
        return encodedText;
    }

    public String decode(String str) {
        str = str.toLowerCase();
        String key = genString(str, this.key);
        String decodedText = "";

        for (int i = 0; i < str.length(); i++)
        {
            if (alphabet.contains(String.valueOf(str.charAt((i))))) {
                int x = (alphabet.indexOf(str.charAt(i)) - alphabet.indexOf(key.charAt(i)) + 26) % 26;
                decodedText += alphabet.charAt(x);
                System.out.println(decodedText);
            }
            else
            {
                decodedText += str.charAt(i);
                System.out.println(decodedText);
            }
        }
        return decodedText;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
