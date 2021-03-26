package co.wangming.nsb.springboot.register;

import co.wangming.nsb.event.EventRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于扫描 #{@link EventRegister} 注解
 * <p>
 * Created By WangMing On 2019-12-06
 **/
public class CommonScannerRegistrar extends AbstractCommandScannerRegistrar {

    private static List<Class> classes = new ArrayList() {{
        add(EventRegister.class);
    }};

    public List<Class> getAnnotationTypeFilterClass() {
        return classes;
    }

}
