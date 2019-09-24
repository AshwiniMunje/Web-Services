package com.todo.demo;

import com.todo.demo.Service.NoteServiceHandler;
import com.todo.demo.Service.NoteServiceImplementation;
import com.todo.demo.thrift.gen.NoteServiceThrift;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.servlet.Servlet;

@SpringBootApplication
public class ToDoApplication {

    private NoteServiceHandler noteServiceHandler;

    public ServletRegistrationBean todo() {
        TProcessor processor =
                new NoteServiceThrift.Processor<>(noteServiceHandler);
        TProtocolFactory protocolFactory = new TJSONProtocol.Factory();
        Servlet organizationServlet = new TServlet(processor, protocolFactory);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(organizationServlet, "/todo/notes");
        servletRegistrationBean.setName("TODO notes manager");
        return servletRegistrationBean;
    }
    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }

}

