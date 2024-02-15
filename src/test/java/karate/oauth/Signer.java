package karate.oauth;

import java.util.*;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

public class Signer {

    public static void sign(String token, Map<String, String> params) {
        List<String> list = new ArrayList<>(); // Creates a new list of strings
        String tokenClientSlat = ""; // Initializes an empty string for the token client salt

        for (Map.Entry<String, String> entry : params.entrySet()) { // Iterates over all entries in the parameter map
            String key = entry.getKey(); // Gets the key of the current entry

            if (key.equals("token_client_salt")) { // Checks if the key is "token_client_salt"
                tokenClientSlat = entry.getValue(); // Assigns the value of the entry to the token client salt
            }

            String paramString = key + "=" + entry.getValue(); // Creates a string in the format "key=value"
            list.add(paramString);
        }
        Collections.sort(list); // Sorts the list alphabetically
        StringBuilder sb = new StringBuilder();

        for (String s : list) { // Iterates over all elements in the sorted list
            sb.append(s); // Appends the current element to the StringBuilder
        }

        sb.append(token); // Appends the token to the StringBuilder
        String sig = md5Hex(sb.toString()); // Calculates the MD5 hash of the contents of the StringBuilder
        String tokenSig = sha256Hex(sig + tokenClientSlat); // Calculates the SHA-256 hash from the MD5 hash and the token client salt
        params.put("sig", sig); // Adds the calculated MD5 hash as a value with key "sig" to the parameter map
        params.put("__NStokensig", tokenSig); // Adds the calculated SHA-256 hash as a value with key "__NStokensig" to the parameter map
    }
}
