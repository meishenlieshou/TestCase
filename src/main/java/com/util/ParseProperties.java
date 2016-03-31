package com.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
 private Properties pro = new Properties();
 String value = null;
 
 public ParseProperties( String Propertiespath ){
	 this.loadProperties( Propertiespath );
 }
 
 private void loadProperties(String Propertiespath){
	 try {
		InputStream in = new FileInputStream( Propertiespath );
		 InputStreamReader inr = new InputStreamReader( in );
		 BufferedReader br = new BufferedReader( inr );
		 pro.load(in);
	} catch ( FileNotFoundException e ) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
 }
 
 public String getValue( String keyname ) throws UnsupportedEncodingException{
	 value = pro.getProperty(keyname).trim();
	 value = new String(value.getBytes( "UTF-8" ), "UTF-8" );
	 
	 return value; 
 }
 public static void mian(String[] args){
	 ParseProperties a = new ParseProperties("test.properties");
	 try {
		System.out.println(a.getValue("username"));
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 }
 

