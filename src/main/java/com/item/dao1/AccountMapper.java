package com.item.dao1;

import com.item.entity1.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountid);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}