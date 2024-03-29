package com.designmode.h_chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 *责任链模式-拦截的类都实现统一接口，每个接收者都包含对下一个接收者的引用。
 * 将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
 */
public class Main {
    /**
     * 在论坛上发表文章
     * 后台要经过信息处理才可以发表或者进入数据库
     */

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好<script>alert('1111')</script>996");

        //处理msg
        /*String r = msg.getMsg();
        r = r.replace('<','[');
        r = r.replace('>',']');
        msg.setMsg(r);*/

        // 再进行处理一次
        /*r = r.replaceAll("996","955");
        msg.setMsg(r);*/

        // 难道以后再添加处理方式都要再后面追加吗
        //new HTMLFilter().doFilter(msg);
        //new SensitiveFilter().doFilter(msg);

        // 如果有新的filter还是需要修改代码
        /*List<Filter> filters = new ArrayList<>();
        filters.add(new HTMLFilter());
        filters.add(new SensitiveFilter());
        for (Filter f : filters){
            f.doFilter(msg);
        }*/

        // 以上代码还没有形成一个链条
        /*FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter());
        fc.add(new SensitiveFilter());
        fc.doFilter(msg);*/

        // 使用链式编程
        FilterChain2 fc = new FilterChain2();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        fc.doFilter(msg);

        // 如果想和另外一个FilterChain连起来该怎么办？
        // 让FilterChain也实现Filter接口


        System.out.println(msg);
    }
}

class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{
    void doFilter(Msg m);
}
class HTMLFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<','[');
        r = r.replace('>',']');
        msg.setMsg(r);

    }
}

class SensitiveFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996","955");
        msg.setMsg(r);
    }
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();

    public void add(Filter f){
        filters.add(f);
    }

    public void doFilter(Msg msg){
        for (Filter f : filters){
            f.doFilter(msg);
        }
    }
}

class FilterChain2{
    List<Filter> filters = new ArrayList<>();

    public FilterChain2 add(Filter f){
        filters.add(f);
        return this;
    }

    public void doFilter(Msg msg){
        for (Filter f : filters){
            f.doFilter(msg);
        }
    }
}

