package concordia.comp354.calculator.error;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/04
 **/

public interface CommonError {

    int getErrCode();
    String getErrMsg();
    CommonError setErrMsg(String errMsg);
}
