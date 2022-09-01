package com.lrm.dto;

import com.lrm.domain.Book;
import com.lrm.util.CustomerBeanUtils;
import org.springframework.beans.BeanUtils;

public interface Convert<S,T> {
    T convert(S s,T t);
    T convert(S s);

}
