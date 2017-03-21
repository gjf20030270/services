package com.cheyipai.platformservice.thirdparty.core.aspect;

import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/2/24.
 */
@ControllerAdvice
public class BusinessExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultMap handleBizExp(HttpServletRequest request, Exception ex){
        LOG.info("Business exception handler  " + ex.getMessage() );
        if(ex instanceof BusinessException){
            BusinessException e = (BusinessException)ex;
            return new ResultMap(e.getStatus(),e.getMessage());
        }else{
            return ResultMap.getResultMap(BusinessStatusEnum.FAIL);
        }
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResultMap requestHandlingNoHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {

        String errorURL = req.getRequestURL().toString();
        return ResultMap.getResultMap(BusinessStatusEnum.PAGE_NOT_FOUND);
    }
}
