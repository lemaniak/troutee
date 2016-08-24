package com.troutee.api.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.model.response.XBaseErrorResponse;
import com.troutee.bussiness.util.CryptoUtils;
import com.troutee.domain.Tuser;
import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by vicente on 01/03/16.
 */
public class Utils {

    private static final int EXPIRATION_HOURS=3;
    private static  final SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    private static final String BUCKET_NAME="com.troutee";
    private static final String FILE_NAME_SUFFIX="troutee_img";
    private static final String IMAGE_BASE_URL="https://s3-us-west-2.amazonaws.com/com.troutee/";

    public static ErrorData getErrorData(String message){
        if(!message.contains("|")){
            ErrorData data= new ErrorData(message,0);
            return data;
        }else{
            int index = message.indexOf("|");
            String code= message.substring(index+1);
            message=message.substring(0,index-1);
            ErrorData data= new ErrorData(message,Integer.parseInt(code.trim()));
            return data;
        }
    }

    public static String getMessage(String property,Locale locale) {
        if(locale==null){
            locale = new Locale("en", "US");
        }
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        return messages.getString(property);
    }

    public static String getToken(Tuser tuser){
        Date expiration_date= new Date();
        DateUtils.addHours(expiration_date, EXPIRATION_HOURS);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id:" + tuser.getId() + "|" + "email:" + tuser.getEmail() + "|" + "expirationDate:" + dateToString(expiration_date));
        return CryptoUtils.encrypt(stringBuilder.toString());
    }

    public static boolean isExpiredToken(String token){
        Date date=null;
        String delims = "|";
        if(!token.contains(delims)){
           throw new ValidationException("troutee.error.invalid_token");
        }
        String[] tokens = token.split(delims);
        for(int i =0 ; i<tokens.length; i++){
            if(tokens[i].contains("expirationDate")){
                int index = tokens[i].indexOf(":");
                String expiration_date=tokens[i].substring(index);
                date=stringToDate(expiration_date);
            }
        }

        if(date.after(new Date())){
           return true;
        }else{
           return  false;
        }

    }

    public static String dateToString(Date date){
        return format.format(date);
    }

    public static Date stringToDate(String date){
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new ServiceException("troutee.general.error");
        }

    }

    public static XBaseErrorResponse getErrorResponse(Locale locale, String message_key){
        String msg = Utils.getMessage(message_key,locale);
        ErrorData data = Utils.getErrorData(msg);
        return new XBaseErrorResponse(data.getCode(), data.getError());
    }

    public static XBaseErrorResponse getCustomErrorResponse(Integer code,String message){
        ErrorData data = new ErrorData(message,code);
        return new XBaseErrorResponse(data.getCode(), data.getError());
    }

    public static String getProperty(String key){
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("troutee.properties");
            Properties properties = new Properties();
            properties.load(input);
            return  properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String uploadImage(byte[] data) {
        if(data==null){
            throw new ValidationException("data is required");
        }else{
            try {
                AWSCredentials credentials = new BasicAWSCredentials(Utils.getProperty("aws_access_key_id"),Utils.getProperty("aws_secret_access_key"));
                AmazonS3 s3client = new AmazonS3Client(credentials);
                String fileName =  FILE_NAME_SUFFIX + new Date().getTime()+".jpg";
                String path =  "/home/vicente/Downloads/test/";
                File file= new File(path+fileName);
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data);
                fos.close();
                s3client.putObject(new PutObjectRequest(BUCKET_NAME, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
                return IMAGE_BASE_URL+fileName;
            } catch (Exception e) {
               throw new ServiceException(e.getMessage());
            }
        }
    }


    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        } else if (unit == "MT"){
            dist= dist * 1609.34;
        }

        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
