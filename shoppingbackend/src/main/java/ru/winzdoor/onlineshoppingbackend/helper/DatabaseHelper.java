package ru.winzdoor.onlineshoppingbackend.helper;

import org.hibernate.SessionFactory;

public class DatabaseHelper {
    public static boolean add(SessionFactory sessionFactory, Object object){
        try{
            sessionFactory.getCurrentSession().persist(object);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean update(SessionFactory sessionFactory, Object object){
        try{
            sessionFactory.getCurrentSession().update(object);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
