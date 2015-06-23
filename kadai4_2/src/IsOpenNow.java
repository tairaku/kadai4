import java.util.*;
import java.io.*;

/*
 opentime.txtを読み込み、営業時間であるかを調べるプログラム。
 
 ＜方針＞
 ファイルから各曜日の営業時間を読み込み、それぞれリストに格納。
 (昼だけの曜日、昼と夜の営業、朝と昼と夜の営業を考慮してリストに格納。)
 それぞれの曜日が定休日でないかを判断するため、配列を用意。(int[] close)
 これらを使い、営業しているかを調査。
 */

public class IsOpenNow {

	
	public static boolean isOpenNow(int dayOfWeek, int hour) {
		ArrayList<Integer> mon = new ArrayList<Integer>(); //月曜
		ArrayList<Integer> tue = new ArrayList<Integer>(); //火曜
		ArrayList<Integer> wed = new ArrayList<Integer>(); //水曜
		ArrayList<Integer> thu = new ArrayList<Integer>(); //木曜
		ArrayList<Integer> fri = new ArrayList<Integer>(); //金曜
		ArrayList<Integer> sat = new ArrayList<Integer>(); //土曜
		ArrayList<Integer> sun = new ArrayList<Integer>(); //日曜
		
		int[] close = {1,1,1,1,1,1,1}; //日、月、…、土でcloseしているか(しているなら１)
		
		//ファイル読み込み
		String FileName = "data/opentime.txt";
		try{
			BufferedReader br = new BufferedReader(new FileReader(FileName));
			
			/*1行ずつ読み込み*/
			String line="";
			line=br.readLine();
			String[] str1;
			
			line=br.readLine();
			str1=line.split("\t");
			if(str1[1].equals("close")!=true){ //月曜
				close[1]=0;
				for(int i=1;i<str1.length;i++){
					mon.add(Integer.parseInt(str1[i])/100);
				}
			}
			line=br.readLine();
			str1=line.split("\t");
			if(str1[1].equals("close")!=true){	//火曜
				close[2]=0;
				for(int i=1;i<str1.length;i++){
					tue.add(Integer.parseInt(str1[i])/100);
				}
			}
			line=br.readLine();
			str1=line.split("\t");
			//System.out.println(str1[1]);
			if(str1[1].equals("close")!=true){	//水曜
				close[3]=0;
				for(int i=1;i<str1.length;i++){
					wed.add(Integer.parseInt(str1[i])/100);
				}
			}
			line=br.readLine();
			str1=line.split("\t");
			if(str1[1].equals("close")!=true){ //木曜
				close[4]=0;
				for(int i=1;i<str1.length;i++){
					thu.add(Integer.parseInt(str1[i])/100);
				}
			}
			line=br.readLine();
			str1=line.split("\t");
			if(str1[1].equals("close")!=true){	//金曜
				close[5]=0;
				for(int i=1;i<str1.length;i++){
					fri.add(Integer.parseInt(str1[i])/100);
				}
			}
			line=br.readLine();
			str1=line.split("\t");
			if(str1[1].equals("close")!=true){	//土曜
				close[6]=0;
				for(int i=1;i<str1.length;i++){
					sat.add(Integer.parseInt(str1[i])/100);
				}
			}
			line=br.readLine();
			str1=line.split("\t");
			if(str1[1].equals("close")!=true){	//日曜
				close[0]=0;
				for(int i=1;i<str1.length;i++){
					sun.add(Integer.parseInt(str1[i])/100);
				}
			}
			
			
			br.close();
			
			if (close[dayOfWeek-1]==1 ){ //その曜日がcloseのとき
				return false;
			}else{
			if(dayOfWeek == Calendar.MONDAY){ //月曜
				for(int j=0;j<mon.size()/2;j++){
					if(mon.get(j*2) <= hour && hour <= mon.get(j*2+1))return true;				
				}
				return false;
			}
			if(dayOfWeek == Calendar.TUESDAY){ //火曜
				for(int j=0;j<tue.size()/2;j++){
					if(tue.get(j*2) <= hour && hour <= tue.get(j*2+1))return true;				
				}
				return false;
			}
			if(dayOfWeek == Calendar.WEDNESDAY){ //水曜
				for(int j=0;j<wed.size()/2;j++){
					if(wed.get(j*2) <= hour && hour <= wed.get(j*2+1))return true;				
				}
				return false; 
			}
			if(dayOfWeek == Calendar.THURSDAY){ //木曜
				for(int j=0;j<thu.size()/2;j++){
					if(thu.get(j*2) <= hour && hour <= thu.get(j*2+1))return true;				
				}
				return false;
			}
			if(dayOfWeek == Calendar.FRIDAY){ //金曜
				for(int j=0;j<fri.size()/2;j++){
					if(fri.get(j*2) <= hour && hour <= fri.get(j*2+1))return true;				
				}
				return false;
			}
			if(dayOfWeek == Calendar.SATURDAY){ //土曜
				for(int j=0;j<sat.size()/2;j++){
					if(sat.get(j*2) <= hour && hour <= sat.get(j*2+1))return true;				
				}
				return false;
			}
			if(dayOfWeek == Calendar.SUNDAY){ //日曜
				for(int j=0;j<sun.size()/2;j++){
					if(sun.get(j*2) <= hour && hour <= sun.get(j*2+1))return true;				
				}
				return false;
			}
			return true;
			}
			
		}catch(IOException e){
			System.out.println("Error");
			return false;
		}
		
		
		
	}
	
	public static boolean isOpenNow() {
			Calendar calendar = Calendar.getInstance();
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); 
			int hour = calendar.get(Calendar.HOUR_OF_DAY); 
			return isOpenNow(dayOfWeek, hour);
	}
}
