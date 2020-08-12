package com.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RecallDao {
    int recallAdd(@Param("bookid") int bookid , @Param("userid") int userid, @Param("bookName") String bookName, @Param("startTime") String startTime);
    int delay(@Param("bookid") int bookid, @Param("userid") int userid,@Param("startTime") String startTime);

}
