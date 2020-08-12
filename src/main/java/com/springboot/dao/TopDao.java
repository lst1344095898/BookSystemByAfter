package com.springboot.dao;

import com.springboot.entity.BookTop;
import com.springboot.entity.UserTop;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
@Mapper
public interface TopDao {
    ArrayList<BookTop> getBookTop();
    ArrayList<UserTop> getUserTop();
}
