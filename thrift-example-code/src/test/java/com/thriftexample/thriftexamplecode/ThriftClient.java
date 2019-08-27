package com.thriftexample.thriftexamplecode;

import com.thriftexample.thriftexamplecode.thrift.gen.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient
{

    public static void main(String[] args) throws TException {

        TSocket transport = new TSocket("localhost", 8080);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);

        Hello.Client client = new Hello.Client(protocol);

        String result = client.hi();
        System.out.println("Return from server: " + result);
        transport.close();

    }
}
