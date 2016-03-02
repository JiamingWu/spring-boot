package hello.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import hello.model.UserData;

@Service
public class SampleService {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<UserData> queryUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from UserData").list();
    }
    
}
