import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class json_test {
    private ObjectMapper mapper = new ObjectMapper();
    /*
        1.User对象转json, json转User对象
          json字符串 = {"name":"张三","age":23}
          user对象 = User{name='张三', age=23}
     */
    @Test
public void test1() throws Exception{
    String json = mapper.writeValueAsString(new User("张三", 23));
    System.out.println(json);
    User user = mapper.readValue(json, User.class);
    System.out.println(user);
}
    /*
         2.map<String,String>转json, json转map<String,String>
          json字符串 = {"姓名":"张三","性别":"男"}
          map对象 = {姓名=张三, 性别=男}
     */
    @Test
    public void test2() throws Exception{
        HashMap<String, String> map = new HashMap<>();
        map.put("姓名","张三");
        map.put("性别","男");
        String json = mapper.writeValueAsString(map);
        System.out.println(json);

        HashMap hashMap = mapper.readValue(json, HashMap.class);

        System.out.println(hashMap);
    }
        /*
        3.map<String,User>转json, json转map<String,User>
          json字符串 = {"黑马一班":{"name":"张三","age":23},"黑马二班":{"name":"李四","age":24}}
          map对象 = {黑马一班=User{name='张三', age=23}, 黑马二班=User{name='李四', age=24}}
        */
        @Test
        public void test3() throws IOException {
            HashMap<String, User> map = new HashMap<>();
            map.put("黑马一班",new User("张三",23));
            map.put("黑马二班",new User("李四",24));

            String json = mapper.writeValueAsString(map);
            System.out.println(json);
            HashMap<String,User> map2 = mapper.readValue(json,new TypeReference<HashMap<String,User>>(){});
            System.out.println(map2);
        }

        /*
        4.List<String>转json, json转 List<String>
            json字符串 = ["张三","李四"]
            list对象 = [张三, 李四]*/
        @Test
        public void test4() throws Exception {
            List<String> list = new ArrayList<>();
            list.add("张三");
            list.add("李四");
            String jsom = mapper.writeValueAsString(list);
            System.out.println(jsom);

            List list1 = mapper.readValue(jsom, List.class);
            System.out.println(list1);

        }

        /*
        5.List<User>转json, json转List<User>
          json字符串 = [{"name":"张三","age":23},{"name":"李四","age":24}]
          list对象 = [User{name='张三', age=23}, User{name='李四', age=24}]
     */

    @Test
    public void test5() throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User("张三",23));
        list.add(new User("李四",24));
        String json = mapper.writeValueAsString(list);
        System.out.println(json);

        List<User> list2 = mapper.readValue(json, new TypeReference<List<User>>() {
        });
        System.out.println(list2);
    }

}
