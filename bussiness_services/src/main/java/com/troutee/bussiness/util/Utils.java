package com.troutee.bussiness.util;


import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.domain.Tuser;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by vicente on 01/03/16.
 */
public class Utils {

    private static final int EXPIRATION_HOURS=3;
    private static  final SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    private static  final SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-M-yyyy");

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
          return true;
        }
        String[] tokens = token.split("\\"+delims);
        for(int i =0 ; i<tokens.length; i++){
            if(tokens[i].contains("expirationDate")){
                int index = tokens[i].indexOf(":");
                String expiration_date=tokens[i].substring(index+1);
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

    public static String dateToSimpleString(Date date){
        return simpleFormat.format(date);
    }

    public static Date stringToDate(String date){
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new ServiceException("troutee.general.error");
        }
    }

}
