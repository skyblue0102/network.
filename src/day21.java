import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class day21 {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("www.inha.ac.kr");
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    }

