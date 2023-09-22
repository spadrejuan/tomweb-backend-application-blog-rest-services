package com.padrejuan.blogapi.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
public class ResponseHandler {
//    returns a response entity object when we encounter an error with finding a post.
//    Returns a message, gives a null value alongside the object the user is querying to, and an HTTP status code
    public static ResponseEntity<Object> postNotFound (String message, HttpStatus status, Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("posts", obj);
        return new ResponseEntity<Object>(map,status);
    }
//overloaded method for methods in creating a comment, same functions but with an added parameter for another object
//    displays both posts and comments as null
    public static ResponseEntity<Object> postNotFound (String message, HttpStatus status, Object obj, Object obj2){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("posts", obj);
        map.put("comments", obj2);
        return new ResponseEntity<Object>(map,status);
    }
//    displays a boolean value for successful/!successful deletion, same functionalities as mentioned above
    public static ResponseEntity<Object> postDeleted(String message, HttpStatus status, Boolean flag){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("success", flag);
        return new ResponseEntity<Object>(map,status);
    }
    //    returns a response entity object when we encounter an error with finding a comment.
//    Returns a message, gives a null value alongside the object the user is querying to, and an HTTP status code
    public static ResponseEntity<Object> commentNotFound (String message, HttpStatus status, Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("comment", obj);
        return new ResponseEntity<Object>(map,status);
    }

    //    displays a boolean value for successful/!successful deletion, same functionalities as mentioned above
    public static ResponseEntity<Object> commentDeleted(String message, HttpStatus status, Boolean flag){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("success", flag);
        return new ResponseEntity<Object>(map,status);
    }

//    general error exceptions for error checking. Displays in the JSON response window. Same functionalities
    public static ResponseEntity<Object> genericErrorException (String message, HttpStatus status, Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("comment", obj);
        return new ResponseEntity<Object>(map,status);
    }
}
