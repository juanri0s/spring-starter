package com.juanri0s.springstarter.dao;

import com.juanri0s.springstarter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserImpl extends JdbcDaoSupport implements UserDao {
  @Autowired DataSource dataSource;

  @PostConstruct
  private void initialize() {
    setDataSource(dataSource);
  }

  @Override
  public void save(User user) {
    String sql = "INSERT INTO TUSER " + "(firstName, lastName) VALUES (?, ?)";
    assert getJdbcTemplate() != null;
    getJdbcTemplate().update(sql, user.getFirstName(), user.getLastName());
  }

  @Override
  public ArrayList<User> findAll() {
    String sql = "SELECT * FROM TUSER";
    assert getJdbcTemplate() != null;
    List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

    ArrayList<User> result = new ArrayList<>();
    for (Map<String, Object> row : rows) {
      User user = new User();
      user.setFirstName((String) row.get("firstName"));
      user.setLastName((String) row.get("lastName"));
      result.add(user);
    }

    return result;
  }
}
