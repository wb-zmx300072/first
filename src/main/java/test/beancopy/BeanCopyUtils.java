package test.beancopy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BeanCopyUtils {
    private static String[] baseTypes = {"java.lang.Integer",
            "java.lang.Double",
            "java.lang.Float",
            "java.lang.Long",
            "java.lang.Short",
            "java.lang.Byte",
            "java.lang.Boolean",
            "java.lang.Character",
            "java.lang.String",
            "int", "double", "long", "short", "byte", "boolean", "char", "float"};

    public static void copyBean(Object source, Object target) throws Exception {
        if (source instanceof List && target instanceof List) {
            copyList((List<Object>) source, (List<Object>) target);
        } else if (source instanceof Map && target instanceof Map) {

        } else if(isBaseType(source)){
            target = source;
        }else {

        }
    }

    public static void copyNormalProperties(){

    }
    public static void copyObject(Object source,Object target){
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field f : fields) {
            if(hasGetMethod(f, source.getClass())){
                if (isBaseType(f)) {
                    f.setAccessible(true);
                    copyProperties(f.getName(),source,target);
                }else if(f.getType().equals("java.util.List")){

                }else if(f.getType().equals("java.util.Map")){

                }else{

                }
            }
//                copyBean(obj, targetEle);
        }
    }
    private static Object getValueFromField(Field f,Object source){
        try{

            Method method = source.getClass().getMethod(getGetMethodName("sourceProperties"),null);
            return  method.invoke(source);
        }catch (Exception e){
            print("getValueFromField ...");
        }
        return "";
    }

    public static void copyProperties(Object sourceProperties,Object sourceObj,Object targetObj){
        try {
            Method method = sourceObj.getClass().getMethod(getGetMethodName("sourceProperties"),null);
            Object sourceVal = method.invoke(sourceObj);
            Method targetMethod = sourceObj.getClass().getMethod(getSetMethodName("sourceProperties"),null);
            // set 方法
            Object invoke = targetMethod.invoke(sourceObj, sourceVal);
            doSetMethod(sourceVal,sourceObj,targetMethod,targetMethod);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    private static void doSetMethod(Object sourceVal,Object sourceObj,Object targetObj, Method targetMethod){
        try{
            if (isBaseType(sourceVal)){
                Object invoke = targetMethod.invoke(sourceObj, sourceVal);
            }else if(sourceVal instanceof  List){
                // TODO
            }else{//java bean

            }
        }catch (Exception e){
            print(e);
        }
    }

    public static void copyList(List<?> sourceList, List<Object> targetList) throws Exception {
        for (Object obj : sourceList) {
            Object targetEle = obj.getClass().newInstance();

            targetList.add(targetEle);
        }
    }

    public static void copyHashMap() {

    }

    private static boolean isBaseType(Field f) {
        for(String type :baseTypes){
            if(f.getType().getName().equals(type)){
                return true;
            }
        }
        return false;
    }
    private static String getGetMethodName(String propertiesName){
        StringBuffer sb = new StringBuffer(propertiesName);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        propertiesName = sb.toString();
        return "get"+propertiesName;
    }
    private static String getSetMethodName(String propertiesName){
        StringBuffer sb = new StringBuffer(propertiesName);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        propertiesName = sb.toString();
        return "set"+propertiesName;
    }
    private static boolean isBaseType(Object object) {
        if (object instanceof Integer) {
            return true;
        } else if (object instanceof String) {
            return true;
        } else if (object instanceof Double) {
            return true;
        } else if (object instanceof Float) {
            return true;
        } else if (object instanceof Long) {
            return true;
        } else if (object instanceof Boolean) {
            return true;
        } else if (object instanceof Date || object instanceof  java.sql.Date) {
            return true;
        }
        return false;
    }

    private static boolean hasGetMethod(Field f,Class clz) {
        Method[] methods = clz.getMethods();
        for(Method method:methods){
            return method.getName().equalsIgnoreCase("get"+f.getName());
        }
        return false;
    }

    private static boolean isCanCopy(Field f, Class clz) {

        return false;
    }

    private static  void print(String... str){
    }
    private static  void print(Exception e){
    }
}