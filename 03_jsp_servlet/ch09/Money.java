package edu.kosmo.ex.money;

import java.util.ArrayList;
import java.util.HashMap;

public class Money {
	private int money;
	private int cnt_50_000, cnt_10_000, cnt_5_000, cnt_1000, cnt_500, cnt_100;
//	private HashMap<String,Integer> wallet = new HashMap<>();
	private ArrayList<String> billTypeList = new ArrayList<>();
	private ArrayList<Integer> billTypeCount = new ArrayList<>();
	
	public Money(int money) {
		super();
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public ArrayList<String> getMoneyType() {
		return billTypeList;
	}
	public ArrayList<Integer> getMoneyCnt() {
		int remain = money;
//		setCnt_50_000(remain/50_000);	wallet.put("오만원",remain/50_000); 	remain = remain % 50_000;
//		setCnt_10_000(remain/10_000);	wallet.put("만원",remain/10_000);		remain = remain % 10_000;
//		setCnt_5_000(remain/5_000);		wallet.put("오천원",remain/5_000);	remain = remain % 5_000;
//		setCnt_1000(remain/1000);		wallet.put("천원",remain/1000);		remain = remain % 1000;
//		setCnt_500(remain/500);			wallet.put("오백원",remain/500);		remain = remain % 500;
//		setCnt_100(remain/100);			wallet.put("백원",remain/100);		remain = remain % 100;
		
		billTypeList.add("오만원");		billTypeCount.add(remain/50_000);
		setCnt_50_000(remain/50_000);	remain = remain % 50_000;
		
		billTypeList.add("만원");			billTypeCount.add(remain/10_000);
		setCnt_10_000(remain/10_000);	remain = remain % 10_000;
		
		billTypeList.add("오천원");		billTypeCount.add(remain/5_000);
		setCnt_5_000(remain/5_000);		remain = remain % 5_000;
		
		billTypeList.add("천원");			billTypeCount.add(remain/1000);
		setCnt_1000(remain/1000);		remain = remain % 1000;
		
		billTypeList.add("오백원");		billTypeCount.add(remain/500);
		setCnt_500(remain/500);			remain = remain % 500;

		billTypeList.add("백원");			billTypeCount.add(remain/100);
		setCnt_100(remain/100);			remain = remain % 100;
		
		return billTypeCount;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getCnt_50_000() {
		return cnt_50_000;
	}
	public void setCnt_50_000(int cnt_50_000) {
		this.cnt_50_000 = cnt_50_000;
	}
	public int getCnt_10_000() {
		return cnt_10_000;
	}
	public void setCnt_10_000(int cnt_10_000) {
		this.cnt_10_000 = cnt_10_000;
	}
	public int getCnt_5_000() {
		return cnt_5_000;
	}
	public void setCnt_5_000(int cnt_5_000) {
		this.cnt_5_000 = cnt_5_000;
	}
	public int getCnt_1000() {
		return cnt_1000;
	}
	public void setCnt_1000(int cnt_1000) {
		this.cnt_1000 = cnt_1000;
	}
	public int getCnt_500() {
		return cnt_500;
	}
	public void setCnt_500(int cnt_500) {
		this.cnt_500 = cnt_500;
	}
	public int getCnt_100() {
		return cnt_100;
	}
	public void setCnt_100(int cnt_100) {
		this.cnt_100 = cnt_100;
	}
	
	
}
