package cn.tedu.controller;
/*
 * @Controller作用1：标识当前类属于Control层
 * 作用2：配合包扫描使用，在springmvc的配置文件中会配置扫描
 * “cn.tedu.controller”包，在这个包下的类上，并且类上有
 * @Controller注解，那么这个类的对象的创建就会提交给spring
 * 容器负责
 *
 * 当前类为普通类
 * */

import cn.tedu.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  @@Controller作用1：标识当前类属于Controller层
 * 如果Controller类上没有访问路径，当前方法上的访问路径在所有Controller类中不可以重复
 * */
@Controller
//@RequestMapping("hc")
public class HelloController {
    /*
     * @RequestMapping注解：为当前发方法绑定一个请求路径，
     * 如果通过浏览器请求这个注解中的路径，就会执行下面的方法
     * */
    @RequestMapping("/hello")
    public String testHello() {
        System.out.println("testHello方法执行了...Hello Spring SpringMVC");
        //从当前controller可以跳转到某个jsp，这里的return的是jsp名字
        return "home";
    }

    /*
     * 1.测试springmvc的参数绑定--简单的类型绑定
     * http://localhost:8080/springmvc
     * /testParam01?name=张飞&age=2&addr=河北
     * 如何获取请求中name、age、addr的值
     * 可以在方法上声明形参。
     * 要求：形参的名字和请求的名字保持一致
     * */
    @RequestMapping("/testParam01")
    public String testParam01(String name, Integer age, String addr) {
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("addr=" + addr);
        return "home";
    }

    /*
     * 2.测试springmvc的参数绑定--简单的类型绑定
     * http://localhost:8080/springmvc
     * /testParam02?username=刘备&psw=123&addr=荆州&age=20
     * 如何获取请求中name、age、addr的值
     * */
    @RequestMapping("testParam02")
    public String testParam02(String username, String psw, String addr, Integer age) {
        System.out.println("username=" + username);
        System.out.println("psw=" + psw);
        System.out.println("addr=" + addr);
        System.out.println("age=" + age);
        return "test";
    }

    /*
     * 3.包装类型的参数绑定
     * http://localhost:8080/springmvc
     * /testParam03?user=刘德华&age=18&addr=中国香港
     * 如果请求参数过多，或者希望将请求参数的值封装到一个对象，
     * 可以直接在方法上声明一个包装类型的对象，使用包装对象接收请求中的参数值
     * 要求包装对象中存在请求参数名对应的setter方法
     * */
    @RequestMapping("/testParam03")
    public String testParam03(User user) {
        System.out.println("user.name=" + user.getName());
        System.out.println("user.age=" + user.getAge());
        System.out.println("user.addr=" + user.getAddr());
        return "test";
    }

    /* 自定义日期格式转换器
     * 将springmvc默认以斜杠(/)分隔日期改为以横杠分隔(-)
     */
    @InitBinder
    public void InitBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true)
        );
    }

    /*
     * 4.日期类的参数绑定
     * /testParam04?date=2020/06/23 10:51:30
     * /testParam04?date=2020-06-23 10:51:30
     * */
    @RequestMapping("/testParam04")
    public String testParam04(Date date) {
        System.out.println("date=" + date);
        return "test";
    }

    /*
     * 5.测试springmvc实现请求转发
     *  （1）在springmvc中，从controller跳转到jsp,默认就是请求转发
     * 需要通过转发才可以访问WEB-INF目录下的资源
     * 从controller跳转到jsp，地址栏没变化
     * （2）如果是controller中的方法，转发到另一个方法
     * */
    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("testForward方法执行了");
        //从当前方法转发到/toPage
        return "forward:/toPage";
    }

    @RequestMapping("/toPage")
    public String toPage() {
        System.out.println("toPage方法执行了");
        return "test";
    }
    /*
    * 6.测试springmvc实现重定向
    * */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect方法执行了");
        return "redirect:test";
    }

}
