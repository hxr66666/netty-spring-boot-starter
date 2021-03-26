package co.wangming.nsb.processors;

import co.wangming.nsb.command.CommandProxy;
import co.wangming.nsb.context.ContextCache;
import co.wangming.nsb.context.ContextWrapper;
import co.wangming.nsb.springboot.register.CommonScannerRegistrar;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 这是一种特殊类型的 #{@link ProtocolProcessor}, 主要是处理未注册解析器的参数, 当前策略时直接返回空.
 *
 * 该解析器不可被Spring扫描到, 手动添加到 #{@link CommandProxy} 中. 详见 #{@link CommonScannerRegistrar#addMessageParser(AbstractBeanDefinition, Method, Map)}
 *
 * Created By WangMing On 2019-12-20
 **/
public class UnknowProtocolProcessor implements ProtocolProcessor<byte[], Object> {

    private Class parameterType;

    @Override
    public void setParameterType(Class parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public Object deserialize(ChannelHandlerContext ctx, byte[] bytes) throws Exception {
        ContextWrapper contextWrapper = ContextCache.get(ctx);
        if (parameterType.isAssignableFrom(contextWrapper.getContextType())) {
            return contextWrapper.getContext();
        }

        if (parameterType.isAssignableFrom(ctx.getClass())) {
            return ctx;
        }

        return null;
    }

    @Override
    public byte[] serialize(ChannelHandlerContext ctx, Object t) throws Exception {
        return t.toString().getBytes();
    }
}
