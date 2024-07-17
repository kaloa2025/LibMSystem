package com.example.LibMSystem.service;

import com.example.LibMSystem.dto.BookRequest;
import com.example.LibMSystem.dto.UserRequest;
import com.example.LibMSystem.model.*;
import com.example.LibMSystem.repository.AuthorRepo;
import com.example.LibMSystem.repository.BookRepo;
import com.example.LibMSystem.repository.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Log logger= LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepo userRepo;

    @PersistenceContext
    private EntityManager em;

    public User addStudent(UserRequest userRequest)
    {
        User user=userRequest.toUser();
        user.setUserType(UserType.STUDENT);
        return userRepo.save(user);
    }
    public User addAdmin(UserRequest userRequest)
    {
        User user=userRequest.toUser();
        user.setUserType(UserType.ADMIN);
        return userRepo.save(user);
    }
    public User addTeacher(UserRequest userRequest)
    {
        User user=userRequest.toUser();
        user.setUserType(UserType.TEACHER);
        return userRepo.save(user);
    }

    public List<User> filter(String filterBy, String operator, String values) {
        String[] filters=filterBy.split(",");
        String[] operators=operator.split(",");
        String[] value=values.split(",");
        StringBuilder query=new StringBuilder();
        query.append("Select * from user where ");
        for(int i=0;i<operators.length;i++)
        {
            UserFilterType userFilterType=UserFilterType.valueOf(filters[i]);
            Operator operator1=Operator.valueOf(operators[i]);
            String finalvalue=value[i];

            query=query.append(userFilterType).append(operator1.getValue())
                    .append("'").append(finalvalue).append("'").append(" and ");
        }
        logger.info("Query is : "+query.substring(0,query.length()-4));
        Query query1=em.createNativeQuery(query.substring(0,query.length()-4),User.class);
        return query1.getResultList();
    }

    public User getStudentByPhoneNo(String userPhoneNo)
    {
        return userRepo.findByPhoneNoAndUserType(userPhoneNo,UserType.STUDENT);
    }
}
