package co.edu.javeriana.securityserver.service.impl;

import co.edu.javeriana.securityserver.configuration.SecurityConfig;
import co.edu.javeriana.securityserver.model.CustomUserDetail;
import co.edu.javeriana.securityserver.model.Roles;
import co.edu.javeriana.securityserver.model.Users;
import co.edu.javeriana.securityserver.repository.UsersRepository;
import co.edu.javeriana.securityserver.service.dao.UsersServicesDao;
import co.edu.javeriana.securityserver.utils.Constants;
import co.edu.javeriana.securityserver.utils.InfoLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("customUserDetailsService")
public class CustomUserDetailServices implements UserDetailsService, UsersServicesDao {

    Logger logger = LoggerFactory.getLogger(CustomUserDetailServices.class);

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = false)
    public void createUser(Users u, List<Roles> roles) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRoles(roles);
        repository.save(u);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isUserAvailable(String username) {
        return repository.isUserAvailable(username) > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Users getUserByUsername(String username) {
        return repository.loadUserByUsername(username);
    }

    @Override
    @Transactional(readOnly = false)
    public Users update(Users u) {
        repository.saveAndFlush(u);
        return u;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Users u) {
        //repository.delete(u.getIdUser());
    }

    @Override
    @Transactional(readOnly = true)
    @InfoLogger(origen = "loadUserByUsername")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repository.loadUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException(String.format(Constants.MSG_ERROR_USUARIO_NO_REGISTRADO, username));
        logger.debug("Usuario : " + username);
        return new User(user.getUsername(),
                        user.getPassword(),
                        Boolean.valueOf(user.getEnable()),
                        Boolean.valueOf(user.getAccountNonExpired()),
                        Boolean.valueOf(user.getCredentialNonExpired()),
                        Boolean.valueOf(user.getAccountNonLocket()),
                        getAuthorities(user.getRoles()));

    }

    @InfoLogger(origen = "getAuthorities")
    public Collection<? extends GrantedAuthority> getAuthorities(List<Roles> role) {
        List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>(2);

        Iterator<Roles> iterRole = role.iterator();

        while (iterRole.hasNext()) {
            Roles rol = iterRole.next();
            authoritiesList.add(new SimpleGrantedAuthority(rol.getRole()));
        }

        return authoritiesList;
    }
}