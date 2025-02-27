package com.example.api_facture.security;

import com.example.api_facture.dao.UserDAO;
import com.example.api_facture.pojo.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    private UserEntity userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Dentro de loadUserByUsername {}", username);
        userDetail = userDAO.findByEmail(username);

        if (!Objects.isNull(userDetail)){
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    public UserEntity getUserDetail(){
        return userDetail;
    }
}
