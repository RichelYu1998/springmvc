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

@Controller
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
}
