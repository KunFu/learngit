class MyThread extends Thread {
	private int time;
	public MyThread(String name, int time) {
		super(name);
		this.time = time;
	}
	public void run(){
		try{
			Thread.sleep(this.time); //休眠指定时间。
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "线程、休眠"  
			+ this.time + "毫秒");
	} 
}
public class ExecDemo01 {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread("线程A",10000);
		MyThread mt2 = new MyThread("线程B",20000);
		MyThread mt3 = new MyThread("线程C",30000);
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
