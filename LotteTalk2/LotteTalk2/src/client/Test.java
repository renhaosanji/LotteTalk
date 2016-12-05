package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import client.helper.NetAccessHelper;

import entity.RequestObject;
import entity.ResponseObject;
import entity.TestObj;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    TestObj testObj=new TestObj();
    //
    int i=0;
    
    testObj.setName("sdf");
    testObj.setAge(21);
    testObj.setEmail("sd");
    //2.prepare the envelope
    RequestObject reqtObject=new RequestObject(RequestObject.TEST,testObj);
    
   //process res
    ResponseObject responseObject= NetAccessHelper.sendRequest(reqtObject);//ÉêÃ÷
    
    }
}