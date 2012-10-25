package org.projectodd.nodej;

import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.ExecutionContext;
import org.dynjs.runtime.GlobalObject;
import org.junit.Before;

public class NodejTestSupport {

    protected DynJS runtime;
    protected ExecutionContext context;
    protected String[] defaultArgs = { "node", "somearg" };

    @Before
    public void setUp() {
        System.setProperty("dynjs.require.path", System.getProperty("user.dir") + "/src/main/javascript/node/lib");
        runtime = new DynJS();
        context = runtime.getExecutionContext();
        GlobalObject globalObject = context.getGlobalObject();
        globalObject.defineGlobalProperty("process", new Process(globalObject, defaultArgs));
    }

}