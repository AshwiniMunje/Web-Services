package com.thriftexample.thriftexamplecode;

import com.thriftexample.thriftexamplecode.Service.ServiceImplementation;
import com.thriftexample.thriftexamplecode.thrift.gen.Hello;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer
{
    public static void main(String[] args)
    {
        try
        {
            TServerSocket serverTransport = new TServerSocket(8080);
            Hello.Processor processor = new Hello.Processor(new ServiceImplementation());
            TServer server = new TThreadPoolServer(
                    new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting server on port 8080 ...");
            server.serve();
        }
        catch (TTransportException e)
        {
            e.printStackTrace();
        }
    }
}