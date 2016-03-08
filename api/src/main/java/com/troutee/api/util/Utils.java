package com.troutee.api.util;

import java.text.ParseException;

import com.troutee.domain.Tuser;
import com.troutee.exceptions.ServiceException;
import com.troutee.exceptions.ValidationException;
import com.troutee.model.response.XBaseErrorResponse;
import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vicente on 01/03/16.
 */
public class Utils {

    private static final int EXPIRATION_HOURS=3;
    private static  final SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

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
        DateUtils.addHours(expiration_date,EXPIRATION_HOURS);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id:"+tuser.getId()+"|"+"email:"+tuser.getEmail()+"|"+"expirationDate:"+dateToString(expiration_date));
        return stringBuilder.toString();
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

}
