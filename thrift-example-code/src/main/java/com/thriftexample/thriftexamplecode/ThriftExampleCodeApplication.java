package com.thriftexample.thriftexamplecode;

import com.thriftexample.thriftexamplecode.Service.ServiceImplementation;
import com.thriftexample.thriftexamplecode.thrift.gen.Hello;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;

@SpringBootApplication
public class ThriftExampleCodeApplication {

    private ServiceImplementation serviceImplementation;

    public ThriftExampleCodeApplication(ServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }
    /*
    @Bean
    public TProtocolFactory tProtocolFactory() {
        //We will use binary protocol, but it's possible to use JSON and few others as well
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public Servlet hello(TProtocolFactory protocolFactory) {
        return new TServlet(new Hello.Processor<>(serviceImplementation), protocolFactory);
    }
*/
    @Bean
    public ServletRegistrationBean hello() {
        TProcessor processor =
                new Hello.Processor<>(serviceImplementation);
        TProtocolFactory protoFactory = new TJSONProtocol.Factory();
        Servlet organizationServlet = new TServlet(processor, protoFactory);
        ServletRegistrationBean servlet = new ServletRegistrationBean(organizationServlet, "/hello");
        servlet.setName("hello");
        return servlet;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThriftExampleCodeApplication.class, args);
    }

}
