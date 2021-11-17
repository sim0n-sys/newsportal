package dao;

import models.News;

import java.util.List;

public interface NewsDao {

    void add(News news);

    List<News>  getAll();

    void update(int id, String title, String newsContent, String writtenBy, int departmentId);

    void deleteById(int id);

    void clearAll();

    List<News> getAllNewsByDepartment(int departmentId);
}