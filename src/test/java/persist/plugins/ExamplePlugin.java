/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package persist.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature( type= Executor.class,  method = "query", args ={
        MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
})})
//@Intercepts({@Signature( type= StatementHandler.class,  method = "update", args ={Statement.class})})
    public class ExamplePlugin implements Interceptor {
        public Object intercept(Invocation invocation) throws Throwable {
            System.out.println("代理");
        Object[] args = invocation.getArgs();
        MappedStatement ms= (MappedStatement) args[0];
        return invocation.proceed();
    }
    // new4大对象的时候调用，所以4大对象都会被代理到Plugin，plugin就是个 invocationHandler，利用jdk动态代理
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    // 加载的时候调用， 设置属性初始化
    public void setProperties(Properties properties) {
        System.out.println(111);
    }
}
