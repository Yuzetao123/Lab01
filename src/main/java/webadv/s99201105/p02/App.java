package webadv.s99201105.p02;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter=new FileWriter("d:\\word.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write("17206129\n");
        bufferedWriter.write(sha256hex("123456"));
        bufferedWriter.close();
        fileWriter.close();

        String useName="";
        String password="";
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入账号：");
        useName=scanner.nextLine();
        System.out.println("请输入密码：");
        password=scanner.nextLine();

        FileReader fileReader=new FileReader("D:\\word.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String TxtUseName=bufferedReader.readLine();
        System.out.println(TxtUseName);
        String Txtpassword=bufferedReader.readLine();
        System.out.println(Txtpassword);

        if(useName.equals(TxtUseName)&&sha256hex(password).equals(Txtpassword)) {
            System.err.println("登陆成功!");

        }
        else {
            System.out.println("登录失败！");
        }

    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}








