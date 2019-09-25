package com.todo.demo;

import com.todo.demo.Service.NoteService;
import com.todo.demo.Service.NoteServiceHandler;
import com.todo.demo.Service.NoteServiceImplementation;
import com.todo.demo.thrift.gen.NoteServiceThrift;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServlet;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ThriftServer {

    @Bean
    public TProtocolFactory tProtocolFactory(){
        return new TJSONProtocol.Factory();
    }

    @Bean
    public ServletRegistrationBean CityServlet(TProtocolFactory protocolFactory, NoteServiceHandler noteServiceHandler){
        TServlet tServlet = new TServlet(new NoteServiceThrift.Processor<>(noteServiceHandler), protocolFactory);
        ServletRegistrationBean bean = new ServletRegistrationBean(tServlet,"/todo/notes");
        bean.setName("todo");
        return bean;
    }
}
