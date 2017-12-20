package downloader.jobs;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.URL;

public class DownloadImage {

    public static void saveImage(String folderPath, String imageUrl) throws IOException {
        InputStream is;
        String destName;

        URL url = new URL(imageUrl);
        String fileName = url.getFile();
        destName = folderPath + "/" + fileName.substring(fileName.lastIndexOf("/")).split("\\?")[0];
        is = url.openStream();
//        try {
//            URL url = new URL(imageUrl);
//            String fileName = url.getFile();
//            destName = folderPath + "/" + fileName.substring(fileName.lastIndexOf("/")).split("\\?")[0];
//            is = url.openStream();
//        } catch (Exception ex)
//        {
//            destName = folderPath + "/" + "someRandom";
//            is = new FileInputStream(imageUrl);
//        }

        OutputStream os = new FileOutputStream(destName);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }


    public static void main(String[] args) {
        try
        {
//            saveImage("/Users/luis/Desktop/", );
//            System.out.println(base64UrlDecode("data:image/jpeg;base64,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"));
            saveImage("/Users/luis/Desktop", "data:image/jpeg;base64,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");
        } catch (Exception exx)
        {
            exx.printStackTrace();
        }
    }

    public static String base64UrlDecode(String input) {
        String result = null;
        Base64 decoder = new Base64(true);
        byte[] decodedBytes = decoder.decode(input);
        result = new String(decodedBytes);
        return result;
    }

}