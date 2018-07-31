package football.Mapper;

import football.Model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

@Mapper

public interface UserMapper {


        String GET_ALL__ACTIVE_USERS = "SELECT * FROM `football`.users where isActive = 1";
        String GET_BY_ID = "SELECT * FROM `football`.users where id = #{id}";
        String INSERT_USER = "INSERT INTO `football`.users (first_name, last_name, is_Active, apiKey) " +
                "VALUES (#{first_name}, #{last_name}, #{isActive}, #{apiKey})";
        String UPDATE_USER = "UPDATE `football`.users SET first_name = #{first_name}, " +
                "last_name = #{last_name}, isActive = #{isActive} WHERE id = #{id}";
        String DELETE_USER = "UPDATE `football`.users set isActive = 0 WHERE id = #{id}";
        String GET_BY_APIKEY = "SELECT * FROM `football`.users where apiKey = #{apiKey}";

        String CHECK_SECTION_EXISTS = "" +
                "select id from `football`.users " +
                "where id = #{id} " +
                "limit 1";
    String CHECK_IF_APIKEY_EXISTS = "" +
            "select id from `football`.users " +
            "where apikey = #{apikey} " +
            "limit 1";

        @Select(GET_BY_APIKEY)
        public User getByAPIKey(String apiKey);

        @Select(GET_ALL__ACTIVE_USERS)
        public ArrayList<User> getAllUsers();

        @Select(GET_BY_ID)
        public User getByID(int id);

        @Select(CHECK_SECTION_EXISTS)
        public int checkIfSectionExists(int id);

        @Select(CHECK_IF_APIKEY_EXISTS)
        public int checkIfAPIKeyExists(String apiKey);

        @Insert(INSERT_USER)
        public int insertUser (User user);

        @Update(UPDATE_USER)
        public int updateUser (User user);

        @Delete(DELETE_USER)
        public int deleteUser(int id);

}

