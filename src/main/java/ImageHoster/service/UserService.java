package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser)
    {
        userRepository.registerUser(newUser);
    }

    //Since we do not have any user in the database, therefore the user with username 'upgrad'
    // and password 'password' is hard-coded
    //This method returns true if the username is 'upgrad' and password is 'password'

    public User login(User user) {
       User existingUSer =  userRepository.checkUser(user.getUsername() ,user.getPassword());

       if(existingUSer != null){
           return existingUSer;
       }
       else{
           return  null;
       }

    }

}
