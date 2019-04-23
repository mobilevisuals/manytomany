/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manyreal;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eyvind
 */
public class ManyReal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyRealPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Book book1 = new Book();
   
            Book book2 = new Book();
         

            Authour author1 = new Authour();
    

            Authour author2 = new Authour();
     

            Set authors = new HashSet();
            authors.add(author1);
            authors.add(author2);

            Set books = new HashSet();
            books.add(book1);
            books.add(book2);
book1.setBookAuthors(authors);
       
            author1.setBooks(books);

            em.persist(author1);
            em.persist(book1);
            em.getTransaction().commit();
        } catch (Exception ex){
            System.err.println(ex);
        } finally{
            if (em != null){
                em.close();
            }
        }
        
    }
    
}
