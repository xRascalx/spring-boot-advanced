package com.lrm.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
        private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

        /**
         * 異常處理
         *
         * @param request
         * @param e
         * @return
         */
        @ExceptionHandler({Exception.class})
        public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
            logger.error("Request URL : {}, Exception : {}", request.getRequestURI(), e.getMessage());
            if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
                throw e;
            }
            ModelAndView mav = new ModelAndView();
            mav.addObject("url", request.getRequestURI());
            mav.addObject("exception", e);
            mav.setViewName("error/error");
            return mav;
        }
}
