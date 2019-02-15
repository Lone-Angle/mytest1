import com.item.dao.AccountMapper;
import com.item.entity.Account;
import com.item.entity.AccountExample;
import com.item.utils.MySqlSession;

import java.util.List;

public class test {
    public static void main(String[] args) {
        AccountExample accountExample=new AccountExample();
        AccountExample.Criteria criteria1 = accountExample.createCriteria();
             criteria1.andAccountidEqualTo(1);

        AccountMapper mapper = MySqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = mapper.selectByExample(accountExample);
        System.out.println(accounts);
        System.out.println("你好吗");



    }
}
