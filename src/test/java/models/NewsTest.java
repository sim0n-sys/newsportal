package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NewsTest {
    public News newNews(){
        return  new News("Morning-brew", "At COP26, Climate Change Meets Adam Smith", "Rose", 4);
    }
    @Test
    public void ObjectNewsInstantiatesCorrectly() {
        News news = newNews();
        assertTrue(news instanceof News);
    }

    @Test
    public void getCorrectTitle(){
        News news = newNews();
        assertEquals("Morning-brew", newNews().getHeader());
    }

    @Test
    public void getCorrectContent(){
        News news = newNews();
        assertEquals("At COP26, Climate Change Meets Adam Smith", newNews().getNewsContent());
    }

    @Test
    public void getCorrectAuthor(){
        News news = newNews();
        assertTrue("Rose".equals(newNews().getWriter()));
    }

    @Test
    public void getCorrectID(){
        News news = newNews();
        assertEquals(4, newNews().getDepartmentId());
    }



}