package co.wangming.nsb.server.command;

import co.wangming.nsb.server.processors.ProtocolProcessor;

import java.util.List;

/**
 * Created By WangMing On 2019-12-11
 **/
public abstract class CommandProxy {

    public static final String PARAMETER_PROCESSORS = "parameterProtocolProcessors";
    public static final String RETURN_PROCESSOR = "returnProtocolProcessor";
    public static final String REQUEST_ID = "requestId";
    public static final String RESPONSE_ID = "responseId";

    private int requestId;
    private int responseId;

    private List<ProtocolProcessor> parameterProtocolProcessors;

    private ProtocolProcessor returnProtocolProcessor;

    public abstract Object invoke(List paramters);

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public void setParameterProtocolProcessors(List<ProtocolProcessor> parameterProtocolProcessors) {
        this.parameterProtocolProcessors = parameterProtocolProcessors;
    }

    public void setReturnProtocolProcessor(ProtocolProcessor returnProtocolProcessor) {
        this.returnProtocolProcessor = returnProtocolProcessor;
    }

    public List<ProtocolProcessor> getParameterProtocolProcessors() {
        return parameterProtocolProcessors;
    }

    public ProtocolProcessor getReturnProtocolProcessor() {
        return returnProtocolProcessor;
    }

    public int getResponseId() {
        return responseId;
    }
}
