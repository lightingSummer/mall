package club.lightingsummer.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lightingSummer
 * @date 2019/11/12 0012
 */
@SpringBootApplication
@MapperScan(basePackages = "club.lightingsummer.mall.user.mapper")
public class MallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserServiceApplication.class, args);
    }

}
