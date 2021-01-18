package com.xinchen.orm;

import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        MongoClient client = new MongoClient("127.0.0.1", 27017);
        System.out.println(client.listDatabaseNames().first());
    }
}
