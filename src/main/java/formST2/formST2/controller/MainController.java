package formST2.formST2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import formST2.formST2.Model.User;
import formST2.formST2.service.UserService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class MainController {

     @Autowired
     UserService userService;

//  public  ArrayList<User> user= new ArrayList<User>();


    @RequestMapping(value = "/mainpage")
    public List getinfo(){
        System.out.println("get request");
        return userService.getallinfo();
    }


    @RequestMapping(method = RequestMethod.POST,value = "/mainpage")
    public  Boolean addValue(@RequestBody String name) throws JsonProcessingException {
        User user = new ObjectMapper().readValue(name,User.class);
        userService.postinfo(user);
        System.out.println(userService.checkUser());
        return userService.checkUser();
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/mainpage" )
    public  void  deleteInfo(@RequestBody String email){
        System.out.println(email);
        userService.deleteInfo(email);
    }

    @RequestMapping(method = RequestMethod.POST, value = "mainpage/search")
    public List search(@RequestBody String searchName){
        List<User> searchedList=userService.searchedUser(searchName);
        return searchedList;
    }





}
