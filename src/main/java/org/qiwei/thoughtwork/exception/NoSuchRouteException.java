package org.qiwei.thoughtwork.exception;

/**
 * @author qiwei
 * @description NoSuchRouteException
 * 未找到路线异常
 * @date 2018/9/16 10:54
 */
public class NoSuchRouteException extends RuntimeException {

    private final static String NOSUCHROUTE = "NO SUCH ROUTE";

    public NoSuchRouteException() {
        super(NOSUCHROUTE);
    }
}
