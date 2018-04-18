import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestXueqiu {
    @Test
    public void testGet(){
        given().header("Cookie","xq_a_token=229a3a53d49b5d0078125899e528279b0e54b5fe; xq_a_token.sig=oI-FfEMvVYbAuj7Ho7Z9mPjGjjI; xq_r_token=8a43eb9046efe1c0a8437476082dc9aac6db2626; xq_r_token.sig=Efl_JMfn071_BmxcpNvmjMmUP40; Hm_lvt_1db88642e346389874251b5a1eded6e3=1523697743; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1523697743; u=251523697743367; __utma=1.2088487029.1523697744.1523697744.1523697744.1; __utmc=1; __utmz=1.1523697744.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=1.1.10.1523697744; device_id=83f5b4098b22180306df31dc80c435b7")
                .queryParam("symbol","SH000001")
                .queryParam("period","1d")
        .when()
                .get("http://xueqiu.com/stock/forchart/stocklist.json")
        .then()
                //.log().all()
                .statusCode(200)
                .body("chartlist.volume",hasItem(560444200));
    }

    @BeforeClass
    public static void login(){
        RestAssured.baseURI="http://xueqiu.com";
        given()//.proxy("127.0.0.1",8888)
                .cookie("Hm_lvt_1db88642e346389874251b5a1eded6e3","1523697743")
                .cookie( "__utmc","1")
                .cookie("__utmz","1.1523697744.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)")
                .cookie("device_id","83f5b4098b22180306df31dc80c435b7")
                .cookie("s","ew12p5zn42")
                .cookie("bid","a0dc1ce4d31b7983e4bbe00df5a95a95_jg0fqx74")
                .cookie("_sid","8gLpivGPvyrRG9VlHPj36QXIoMinzR")
                .cookie("__utma","1.2088487029.1523697744.1523773715.1523777155.4")
                .cookie("__utmt","1")
                .cookie("xq_a_token","229a3a53d49b5d0078125899e528279b0e54b5fe")
                .cookie("xq_a_token.sig","oI-FfEMvVYbAuj7Ho7Z9mPjGjjI")
                .cookie("xq_r_token","8a43eb9046efe1c0a8437476082dc9aac6db2626")
                .cookie("xq_r_token.sig","Efl_JMfn071_BmxcpNvmjMmUP40")
                .cookie("u","891523777315433")
                .cookie("__utmb","1.4.10.1523777155")
                .cookie("Hm_lpvt_1db88642e346389874251b5a1eded6e3","1523777316")
                .formParam("remember_me","true")
                .formParam("username","18201395338")
                .formParam("password","xueqiu1201")
                .formParam("captcha","")
                .formParam("geetest_challenge","bbb5c37ed5a84e5ae8a83c44203440707z")
                .formParam("geetest_validate","b883d8a15448c767b84bd8f8a81da72f")
        .when()
                .post("http://xueqiu.com/snowman/login")
        .then().log().all()
        .extract().response();
    }

    @Test
    public void testView(){
        System.out.println("hi");
    }
}
