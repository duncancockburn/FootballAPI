package football.Mapper;

import football.Model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

@Mapper

public interface UserMapper {


        String GET_ALL__ACTIVE_USERS = "SELECT * FROM `football`.users where isActive = 1";
        String GET_BY_ID = "SELECT * FROM `football`.users where id = #{id}";
        String INSERT_USER = "INSERT INTO `football`.users (first_name, last_name, isActive, apiKey) " +
                "VALUES (#{first_name}, #{last_name}, #{isActive}, #{apiKey})";
        String UPDATE_USER = "UPDATE `football`.users SET first_name = #{first_name}, " +
                "last_name = #{last_name}, isActive = #{isActive} WHERE id = #{id}";
        String DELETE_USER = "UPDATE `football`.users set isActive = 0 WHERE id = #{id}";
        String GET_BY_NAME = "SELECT * FROM `football`.users where first_name = #{first_name}";

        String CHECK_SECTION_EXISTS = "" +
                "select id from `football`.users " +
                "where apiKey = #{apiKey} " +
                "limit 1";

        @Select(GET_BY_NAME)
        public User getByName(String name);

        @Select(GET_ALL__ACTIVE_USERS)
        public ArrayList<User> getAllUsers();

        @Select(GET_BY_ID)
        public User getByID(int id);

        @Select(CHECK_SECTION_EXISTS)
        public int checkIfSectionExists(int id);

        @Insert(INSERT_USER)
        public int insertUser (User user, String key);

        @Update(UPDATE_USER)
        public int updateUser (User user);

        @Delete(DELETE_USER)
        public int deleteUser(int id);

    }

