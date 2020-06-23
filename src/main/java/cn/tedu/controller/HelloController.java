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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String testHello(){
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
        public String testParam01(String name,Integer age,String addr){
            System.out.println("name="+name);
            System.out.println("age="+age);
            System.out.println("addr="+addr);
            return "home";
        }
        /*
         * 2.测试springmvc的参数绑定--简单的类型绑定
         * http://localhost:8080/springmvc
         * /testParam02?username=刘备&psw=123&addr=荆州&age=20
         * 如何获取请求中name、age、addr的值
         * */
        @RequestMapping("testParam02")
        public String testParam02(String username,String psw,String addr,Integer age){
            System.out.println("username="+username);
            System.out.println("psw="+psw);
            System.out.println("addr="+addr);
            System.out.println("age="+age);
            return "test";
        }
}
