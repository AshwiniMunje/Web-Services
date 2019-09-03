package com.thriftexample.thriftexamplecode.Service;

import com.thriftexample.thriftexamplecode.thrift.gen.Hello;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplementation implements Hello.Iface {

    @Override
    public String hi() throws TException {
        System.out.println("Running hi() function");
        return "Hello world";
    }
}
