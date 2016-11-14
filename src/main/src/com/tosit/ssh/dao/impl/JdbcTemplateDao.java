//package com.tosit.ssh.dao.impl;
//
//import com.tosit.ssh.dao.impl.mapper.UserMapper;
//import com.tosit.ssh.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * 佛祖保佑       永无BUG
// * Created by DELL on 2016/11/2.
// */
//@Component
//public class JdbcTemplateDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public int add(User user){
//     return  jdbcTemplate.update("insert into user(name) values(?)",user.getName());
//    }
//
//    public  int update(User user){
//       return  jdbcTemplate.update("update user set name=? where id=?",user.getName(),user.getId());
//    }
//
//    public User getById(Integer id){
////        User result  = jdbcTemplate.queryForObject("select name from user where id=?",new Object[]{id},User.class);
//        User result  = jdbcTemplate.queryForObject("select id,name from user where id=?", new UserMapper(),id);
//        return result;
//    }
//
//
//    public List<User> getUserList(){
//        List<User> result = jdbcTemplate.query("select * from user", new UserMapper());
//        return  result;
//    }
//
//    public void batchUpdate(List<Integer> ids,List<String> names){
//        jdbcTemplate.batchUpdate("update user set name=? where id = ?", new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                    preparedStatement.setString(1,names.get(i));
//                   preparedStatement.setInt(2,ids.get(i));
//            }
//
//            @Override
//            public int getBatchSize() {
//                return ids.size();
//            }
//        });
//    }
//}
