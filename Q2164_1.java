package backjoon;
import java.util.*;
public class Q2164_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=123456;
		MyLinkedList[] list=new MyLinkedList[n];
		list[0]=new MyLinkedList(1);
		for(int i=1;i<n;i++) {
			list[i]=new MyLinkedList(i+1,list[i-1]);
		}
		for(int i=0; i<n;i++) {
			if(MyLinkedList.popPoint==MyLinkedList.lastPoint) {
				break;
			}
			MyLinkedList.popPoint.pop();
			MyLinkedList.popPoint.lastIdx();
		}
		System.out.println(MyLinkedList.popPoint.pop());
		
	}
}

class MyLinkedList{
 	int num;    //숫자
	MyLinkedList nex_ref; //다음 주소 담느ㄴ
	static MyLinkedList popPoint=null;
	static MyLinkedList lastPoint=null;
	MyLinkedList(int a){
		num=a;
		nex_ref=null;
		popPoint=this;
		lastPoint=this;
	}
	MyLinkedList(int a,MyLinkedList ac){
		num=a;
		nex_ref=null;
		ac.nex_ref=this;
		lastPoint=this;
	}
	public int pop() {
		popPoint=this.nex_ref;
		return this.num;
	}
	public void lastIdx() {
		if(this.nex_ref==null) {
			return;
		}
		popPoint=this.nex_ref;
		lastPoint.nex_ref=this;
		lastPoint=this;
	}
	
}

