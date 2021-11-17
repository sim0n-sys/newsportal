package models;

import java.util.Objects;

public class News {
    private String header;
    private String newsContent;
    private String writer;
    private int departmentId;

    public News(String header, String newsContent, String writer, int departmentId) {
        this.header = header;
        this.newsContent = newsContent;
        this.writer = writer;
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) { this.header = header; }
    public String getNewsContent() {
        return newsContent;
    }
    public void setNewsContent(String newsContent) { this.newsContent = newsContent; }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) { this.writer = writer; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getDepartmentId() == news.getDepartmentId() &&
                Objects.equals(getHeader(), news.getHeader()) &&
                Objects.equals(getNewsContent(), news.getNewsContent()) &&
                Objects.equals(getWriter(), news.getWriter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, newsContent, writer, departmentId);
    }

}
