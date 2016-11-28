import java.io.*;
import java.util.Scanner;

public class StockInformation {
	static int k = 0;
	public static void main(String[] args) throws Exception {
		Stock[] stock = new Stock[100];
		for (int i = 0; i < stock.length; i++)
			stock[i] = new Stock();
		menu(stock);
	}

	static void readfile(String filename,Stock[] s) throws Exception {
		FileReader fr= new FileReader(filename);
		BufferedReader br= new BufferedReader(fr);
		FileWriter fw = new FileWriter(filename, true);
		String str;
		int i = 0;
		while ((str = br.readLine()) != null) {
			String[] info = str.split(" ");
			s[i].num = info[0];
			s[i++].name = info[1];	
		}
		int k = 0;
		while (s[k].num!=null)
		System.out.println(s[k].num + " " + s[k++].name);
		fw.close();
		br.close();
	}

	static void create(String filename,Stock[] s,int i) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fw = new FileWriter(filename, true);
		System.out.println("输入股票代码和名称：");
		String str = br.readLine();
		String[] info = str.split(" ");
		s[i].num = info[0];
		s[i].name = info[1];
		fw.write(s[i].num + " " + s[i].name+"\r\n");
		fw.close(); 
	}
	static void find(String filename,Stock[] s) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入股票代码：");
		String str = br.readLine();
		for (int k = 0;k<s.length;k++)
			if (str.equals(s[k].num))
				System.out.println(s[k].name);
	}
	static void menu(Stock[] s) throws Exception{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.print("1:输入\t");
			System.out.print("2:查询\t");
			System.out.print("3:遍历\n");
			switch(sc.nextInt())
			{
			case 1:create(".\\stock.txt",s,k++);break;
			case 2:find(".\\stock.txt",s);break;
			case 3:readfile(".\\stock.txt", s);break;
			default:System.out.println("输入错误！");break;
			}
		}
	}
}

class Stock {
	String num;
	String name;
}
