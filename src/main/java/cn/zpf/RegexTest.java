package cn.zpf;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LoseMyself on 2017/3/1.
 */
public class RegexTest {
    public static void main(String[] args) throws IOException {

/*        List<String> list = getMail();

        for(String mail : list){
            System.out.println(mail);
        }*/
        List<String> list2 = getMailInNet("http://blog.csdn.net/xiaoyu411502/article/details/47864969");
        for(String mail : list2){
            System.out.println(mail);
        }

    }

    public static List<String> getMail() throws IOException {
        BufferedReader bufr = new BufferedReader(new FileReader("main.html"));
        String mail_Regex = "\\w+@\\w+(\\.\\w+)+";
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(mail_Regex);
        String line = null;
        while((line = bufr.readLine())!=null){
            Matcher m = p.matcher(line);
            while(m.find()){
                list.add(m.group());
            }
        }
        return list;
    }
    public static List<String> getMailInNet(String str) throws IOException {
        URL url = new URL(str);
        BufferedReader bufr = new BufferedReader(new InputStreamReader(url.openStream()));
        String mail_Regex = "\\w+@\\w+(\\.\\w+)+";
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(mail_Regex);
        String line = null;
        while((line = bufr.readLine())!=null){
            Matcher m = p.matcher(line);
            while(m.find()){
                list.add(m.group());
            }
        }
        return list;
    }

}
