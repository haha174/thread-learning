package thread;

import java.util.Random;

public class ThreadScopShareDataThreadLocal {
    public static void main(String[] args){
        for (int i=0;i<2;i++)
        new Thread(new Runnable() {
            public void run() {
               Data data=Data.getInstance();
                data.setAge(new Random().nextInt());
                data.setName(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+" has put data: "+data.toString());
                new A().get();
                new B().get();
            }
        }).start();
    }
    static  class A{
        public void get(){
            System.out.println(Thread.currentThread().getName()+" has A get data: "+Data.getInstance().toString());
        }
    }
    static  class B{
        public void get(){
            System.out.println(Thread.currentThread().getName()+" has B get data: "+Data.getInstance().toString());
        }
    }

}
  class Data{
    private Data(){};
    public static synchronized  Data getInstance(){
        Data instance=map.get();
        if(instance==null){
            instance =new Data();
            map.set(instance);
        }
        return instance;
    }
    // private static Data instance =null;
    private static  ThreadLocal<Data> map=new ThreadLocal<Data>();
    private String name ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
