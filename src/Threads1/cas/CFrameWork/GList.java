package Threads1.cas.CFrameWork;

import static Threads1.cas.util.Sp.sleep;

public class GList implements simpleList{
    private final static int size=5;
    private Object[] list;
    private int index=0;
    GList(){
        list=new Object[size];
        index=0;
    }
    @Override
    public void add(Object o) {
        sleep(100);
        list[index++]=o;
    }

    @Override
    public Object get(int index) {
        return list[index] ;
    }

    @Override
    public String toString() {
        String s = "";
        for(Object o:list){
            s+="["+o+"] ";
        }
        return s;
    }
}
