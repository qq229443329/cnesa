package base;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.ConfigGenerator;

/**
 * Created by shangpeibao on 16/12/9.
 */
public class MybatisUtils {
    public static void main(String[] args) {
        ConfigGenerator cg = new ConfigGenerator();
        // 配置 MySQL 连接
        cg.setDbDriverName("com.mysql.jdbc.Driver");
        cg.setDbUser("cnesa");
        cg.setDbPassword("eso");
        cg.setDbUrl("jdbc:mysql://121.42.42.69:3306/esman?characterEncoding=utf8");
        // 配置包名
        cg.setEntityPackage("com.cnesa.bos.entity");
//        cg.setMapperPackage("com.cnesa.bos.dao");
//        cg.setServicePackage("com.cnesa.authority.service");
//        cg.setServiceImplPackage("com.cnesa.authority.service.impl");
//        cg.setXmlPackage("mapping");


        // 配置表主键策略
        cg.setIdType(IdType.UUID);

        // 配置保存路径
        cg.setSaveDir("/Users/shangpeibao/Documents/mybatisFile");
        // 其他参数请根据上面的参数说明自行配置，当所有配置完善后，运行AutoGenerator.run()方法生成Code
        // 生成代码
        AutoGenerator.run(cg);
    }
}
