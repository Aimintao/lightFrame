package code.heitao.small.framework.entity;


import code.heitao.small.framework.util.CastTypeUtil;
import code.heitao.small.framework.util.CollectionUtil;
import code.heitao.small.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: Param
 * @ProjectName lightFrame架构
 * @Description: 封装FileParam 和FormParam请求参数
 * @date 2018/6/26 16:18
 */
public class Param {
    private List<FileParam> fileParamList;

    private List<FormParam> formParamList;


    public Param(List<FileParam> fileParamList) {
        this.fileParamList = fileParamList;
    }

    public Param(List<FileParam> fileParamList, List<FormParam> formParamList) {
        this.fileParamList = fileParamList;
        this.formParamList = formParamList;
    }
    public Map<String, Object> getFieldRequestMap() {
        /**
         * @Description: 获取请求参数对象映射封装到Map中
         * @param []
         * @return java.util.Map<java.lang.String,java.lang.Object>
         * @author Aimin
         * @date 2018/6/28 15:27
         */
        HashMap<String, Object> fieldRequestMap = new HashMap<String, Object>();
        if (CollectionUtil.isNotEmpty(formParamList)){
            for (FormParam formParam:  formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if (fieldRequestMap.containsKey(fieldName)){
                   fieldValue = fieldRequestMap.get(fieldName)+ StringUtil.SEPARATOR+fieldValue;
                }
                fieldRequestMap.put(fieldName,fieldValue);
            }
        }
        return  fieldRequestMap;
    }
    public Map<String, List<FileParam>> getFileRequestMap() {
        /**
         * @Description: 获取上传文件映射
         * @param []
         * @return java.util.Map<java.lang.String,java.util.List<code.heitao.small.framework.entity.FileParam>>
         * @author Aimin
         * @date 2018/6/28 16:08
         */
        Map<String, List<FileParam>> fileRequestMap = new HashMap<String, List<FileParam>>();
        if (CollectionUtil.isNotEmpty(fileParamList)){
            for (FileParam fileParam:fileParamList
                 ) {
                String fieldName = fileParam.getFieldName();
                List<FileParam> fileParamList;
                //通过文件名称字段获取文件的相关属性字段
                if (fileRequestMap.containsKey(fieldName)){
                  fileParamList = fileRequestMap.get(fieldName);
                }else {
                    fileParamList = new ArrayList<FileParam>();
                }
                fileRequestMap.put(fieldName,fileParamList);
            }
        }
        return fileRequestMap;
    }
    public List<FileParam> getAllFileList(String fieldName) {
        /**
         * @Description: 通过文件名获取多个文件上传参数
         * @param [fieldName]
         * @return java.util.List<code.heitao.small.framework.entity.FileParam>
         * @author Aimin
         * @date 2018/6/28 16:10
         */
        return getFileRequestMap().get(fieldName);
    }

    public FileParam getFile(String fieldName) {
        /**
         * @Description: 获取单个上传文件
         * @param [fieldName]
         * @return code.heitao.small.framework.entity.FileParam
         * @author Aimin
         * @date 2018/6/28 16:11
         */
        List<FileParam> fileParamList = getAllFileList(fieldName);
        if (CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1) {
            return fileParamList.get(0);
        }
        return null;
    }

    //其他参数转换
    /**
     * 验证参数是否为空
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
    }

    /**
     * 根据参数名获取 String 型参数值
     */
    public String getString(String name) {
        return CastTypeUtil.castString(getFieldRequestMap().get(name));
    }

    /**
     * 根据参数名获取 double 型参数值
     */
    public double getDouble(String name) {
        return CastTypeUtil.castDouble(getFieldRequestMap().get(name));
    }

    /**
     * 根据参数名获取 long 型参数值
     */
    public long getLong(String name) {
        return CastTypeUtil.castLong(getFieldRequestMap().get(name));
    }

    /**
     * 根据参数名获取 int 型参数值
     */
    public int getInt(String name) {
        return CastTypeUtil.castInt(getFieldRequestMap().get(name));
    }

    /**
     * 根据参数名获取 boolean 型参数值
     */
    public boolean getBoolean(String name) {
        return CastTypeUtil.castBoolean(getFieldRequestMap().get(name));
    }

}
