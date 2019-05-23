package pl.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dto.RegisterUserDTO;
import pl.model.User;
import pl.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Pair<Boolean, String> canCreate(RegisterUserDTO user){
        if(!user.getPassword().equals(user.getConfirmPassword()))
            return new ImmutablePair<>(false, "passwords are not equals");
        if(userRepository.findByLogin(user.getLogin()).isPresent())
            return new ImmutablePair<>(false, "login already in use");
        return new ImmutablePair<>(true, "");
    }

    public Optional<User> login(User user){
        Optional<User> existUser = userRepository.findByLogin(user.getLogin());
        if(existUser.isPresent() && existUser.get().getPassword().equals(user.getPassword()))
            return existUser;
        return Optional.empty();
    }

    public void add(User user){
        userRepository.save(user);
    }
}
