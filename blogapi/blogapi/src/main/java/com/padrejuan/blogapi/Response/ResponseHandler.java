package com.padrejuan.blogapi.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
public class ResponseHandler {
    public static ResponseEntity<Object> postNotFound (String message, HttpStatus status, Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("posts", obj);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> postNotFound (String message, HttpStatus status, Object obj, Object obj2){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("posts", obj);
        map.put("comments", obj2);
        return new ResponseEntity<Object>(map,status);
    }
    public static ResponseEntity<Object> postDeleted(String message, HttpStatus status, Boolean flag){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("success", flag);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> commentNotFound (String message, HttpStatus status, Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("comment", obj);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> commentDeleted(String message, HttpStatus status, Boolean flag){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("success", flag);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> genericErrorException (String message, HttpStatus status, Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("comment", obj);
        return new ResponseEntity<Object>(map,status);
    }
}
