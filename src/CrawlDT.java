import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlDT {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner=new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String title=scanner.next();
            title=title.replaceAll("\\n+","");
            Pattern p=Pattern.compile("title=\"(.*?)\">(.*?)</a>");
            Matcher m=p.matcher(title);
            while(m.find()){
                System.out.println(m.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
