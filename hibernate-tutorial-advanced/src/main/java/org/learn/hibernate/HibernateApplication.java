package org.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.learn.hibernate.datasource.DataSource;
import org.learn.hibernate.domain.Employee;
import org.learn.hibernate.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {

        Session session = DataSource.getSessionFactory().openSession();
        session.getTransaction().begin();

        /*Store store = new Store("Walmart- Black","College Park,MD");
        Employee employee1 = new Employee("John Silver");
        Employee employee2 = new Employee("David Blain");

        employee1.setStore(store);
        employee2.setStore(store);

        List<Employee> emps = new ArrayList<>();
        emps.add(employee1);
        emps.add(employee2);


        store.setEmployees(emps);

        session.persist(store);
        //session.save(store);
        //session.save(employee1);
        //session.save(employee2);*/

        //List<Store> stores = session.createQuery("FROM Store", Store.class).getResultList();

     /*   for (Store s : stores){
            System.out.println(s.getName()+ "\t" + s.getLocation());  //\t means a tab button on keyboard
            for (Employee e : s.getEmployees()){
                System.out.println("\t" + e.getName());
            }
        }*/


        /* System.out.println("-----Printing result------");
        System.out.println(stores.get(1).getName());
        System.out.println(stores.get(1).getEmployees().get(0).getName()
        );*/

        /*Employee employee = session.createQuery("FROM Employee where id = 2", Employee.class).getSingleResult();
        System.out.println(employee.getName() + "\t" + employee.getStore().getName());
*/

       /* List<Store> listOfStores = session.createNamedQuery("selectAll", Store.class).getResultList();

        for (Store s: listOfStores){
            System.out.println(s.getName() + s.getLocation());
        }*/

        List<Store> ss = session.createNamedStoredProcedureQuery("selectAll").getResultList();
        for (Store s : ss){
            System.out.println(s.getName() + s.getLocation());
        }

        session.getTransaction().commit();
        session.close();

        /* Employee employee = session.createQuery("FROM Employee where id = 2", Employee.class).getSingleResult();
        System.out.println(employee.getName() + "\t" + employee.getStore().getName());*/


        DataSource.closeSessionFactory();

    }
}
