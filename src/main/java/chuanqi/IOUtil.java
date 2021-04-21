package chuanqi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtil {

    public static String getString(InputStream source) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(source));
        String line;

        while ((line = br.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
