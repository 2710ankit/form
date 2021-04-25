package formST2.formST2.service;

import formST2.formST2.Model.User;
import formST2.formST2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List getallinfo() {
        return userRepository.getallinfo();

    }

    public void postinfo(User user) {
        userRepository.postinfo(user);
    }

    public void deleteInfo(String email) {
        userRepository.deleteInfo(email);
    }

    public boolean findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
