package com.thriftexample.thriftexamplecode;

import com.thriftexample.thriftexamplecode.thrift.gen.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThriftClient
{

    private Hello.Client client;

    @Test
    public void mtest1() throws TException {

        /*
        TTransport transport = new THttpClient("http://localhost:8080/hello");

        TProtocol protocol = protocolFactory.getProtocol(transport);

        Hello.Client client = new Hello.Client(protocol);

        String result = client.hi();
        System.out.println("Return from server: " + result);

         */
        THttpClient tHttpClient = new THttpClient("http://localhost:8080/hello");

        TProtocol protocol = new TJSONProtocol(tHttpClient);

        client = new Hello.Client(protocol);

        String result = client.hi();
        System.out.println("Return from server: " + result);
    }

}
