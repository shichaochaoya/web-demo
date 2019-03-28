import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.nio.cs.US_ASCII;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setName("wang");
        user.setAge(20);
        //对象转json {"name":"wang","age":20}  以这种方式组织属性    数组转json  [{"name":"wang","age":20},{"name":"wang","age":20},{"name":"wang","age":20},{"name":"wang","age":20}]

        ObjectMapper mapper = new ObjectMapper();
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        String usersJson = mapper.writeValueAsString(users);
        String userJson = mapper.writeValueAsString(user);
        System.out.println(userJson);
        System.out.println(usersJson);

    }
}